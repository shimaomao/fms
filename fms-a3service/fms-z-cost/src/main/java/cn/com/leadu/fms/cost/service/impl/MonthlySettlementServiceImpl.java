package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActGpsMonthlyUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.cost.SettleStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.service.MonthlySettlementApproveService;
import cn.com.leadu.fms.cost.service.MonthlySettlementService;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteListVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementModifyVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.GpsDispatchRepository;
import cn.com.leadu.fms.data.cost.repository.MonthlySettlementRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlement.MonthlySettlementVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementService
 * @Description: gps月结任务表业务实现层
 * @date 2018-05-28
 */
@Service
public class MonthlySettlementServiceImpl implements MonthlySettlementService {

    /**
     * @Fields  : gps月结审批业务层
     */
    @Autowired
    private MonthlySettlementApproveService monthlySettlementApproveService;

    /**
     * @Fields  : 业务编号管理
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : gps月结任务表repository
     */
    @Autowired
    private MonthlySettlementRepository monthlySettlementRepository;

    /**
     * @Fields  : 派单信息repository
     */
    @Autowired
    private GpsDispatchRepository gpsDispatchRepository;

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询gps月结任务表
     * @param monthlySettlementVo
     * @return PageInfoExtend<MonthlySettlement>
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public PageInfoExtend<MonthlySettlement> findMonthlySettlementsByPage(MonthlySettlementVo monthlySettlementVo){
        Example example = SqlUtil.newExample(MonthlySettlement.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<MonthlySettlement> pageInfo = monthlySettlementRepository.selectListByExamplePage(example,monthlySettlementVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存gps月结任务表
     * @param monthlySettlementSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public void saveMonthlySettlement(MonthlySettlementSaveVo monthlySettlementSaveVo){
        monthlySettlementRepository.insertData(monthlySettlementSaveVo.getEntity());
    }

    /**
     * @param monthlySettlementVo
     * @Description: 保存月结申请
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/29 10:16
     */
    @Override
    @Transactional
    public void saveMonthlySettlementWithGps(MonthlySettlementVo monthlySettlementVo) {
        MonthlySettlement monthlySettlement = new MonthlySettlement();

        if (StringUtils.isTrimBlank(monthlySettlementVo.getMonthlySettlementNo())) {//如果月结号不存在
            //获取新的月结号
            String newMonthlySettlementNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.MONTHLY_SETTLEMENT_NUM_TYPE.getType());
            monthlySettlement.setMonthlySettlementNo(newMonthlySettlementNo);
            //保存附件信息
            bizFilesService.modifyBizFilesList(monthlySettlementVo.getBizFilesList(),newMonthlySettlementNo,
                    BizCodeTypeEnums.GPS_DISPATCH_MONTHLY_FILE.getCodeType());
        }else{
            //设置月结号
            monthlySettlement.setMonthlySettlementNo(monthlySettlementVo.getMonthlySettlementNo());
            //保存附件信息
            bizFilesService.modifyBizFilesList(monthlySettlementVo.getBizFilesList(),monthlySettlementVo.getMonthlySettlementNo(),
                    BizCodeTypeEnums.GPS_DISPATCH_MONTHLY_FILE.getCodeType());
        }
        //计算月结总金额
        BigDecimal totalCost = new BigDecimal("0");
        for(GpsDispatch gpsDispatch:monthlySettlementVo.getGpsDispatches()){
            gpsDispatch.setSettleStatus(SettleStatusEnums.MID_MONTH_KNOT.getStatus());//月结中
            //为明细设置月结号
            gpsDispatch.setMonthlySettlementNo(monthlySettlement.getMonthlySettlementNo());
            //计算明细账单总金额
            BigDecimal billTotalCost = gpsDispatch.getEquipmentCost().add(gpsDispatch.getInstallationCost().add(gpsDispatch.getChangeCost()));
            if (billTotalCost.compareTo(gpsDispatch.getBillTotalCost()) != 0) {
                throw new FmsServiceException("账单总金额计算有误！");
            }
            gpsDispatch.setBillTotalCost(billTotalCost );
            totalCost = totalCost.add(gpsDispatch.getBillTotalCost());
        }
        if (totalCost.compareTo(monthlySettlementVo.getTotalCost()) != 0) {
            throw new FmsServiceException("月结总金额计算有误！");
        }
        monthlySettlement.setTotalCost(totalCost);

        if (StringUtils.isTrimBlank(monthlySettlementVo.getMonthlySettlementNo())) {//如果月结号不存在
            //插入月结数据
            monthlySettlementRepository.insertData(monthlySettlement);
        }else{
            //更新月结数据
            Example example = SqlUtil.newExample(MonthlySettlement.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("monthlySettlementNo",monthlySettlement.getMonthlySettlementNo());
            monthlySettlementRepository.updateByExampleSelectiveData(monthlySettlement,example);
        }

        //保存gps月结明细数据
        gpsDispatchRepository.updateByPrimaryKeySelectiveDataList(monthlySettlementVo.getGpsDispatches());

        //保存财务付款表
        ContPay contPay = new ContPay();
        contPay.setPaymentType(BizTypeEnums.GPS_MONTHLY.getType());//gps月结
        contPay.setBizCode(monthlySettlement.getMonthlySettlementNo());
        contPay.setPayStatus(PayStatusEnums.CONFIRM.getType());//待付款
        contPay.setPayAmount(totalCost);
        contPay.setPayFund(PayFundNameEnums.GPS_COST.getType());//款项名称
        contPay.setRecAccBank(monthlySettlementVo.getRecAccBank());
        contPay.setRecAccBranch(monthlySettlementVo.getRecAccBranch());
        contPay.setRecAccountName(monthlySettlementVo.getRecAccountName());
        contPay.setRecAccountNo(monthlySettlementVo.getRecAccountNo());
        contPay.setRecEleBankNo(monthlySettlementVo.getRecEleBankNo());
        if (StringUtils.isTrimBlank(monthlySettlementVo.getMonthlySettlementNo())) {//如果月结号不存在
            //插入付款数据
            contPayRepository.insertData(contPay);
        }else{
            //更新付款数据
            Example example = SqlUtil.newExample(ContPay.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("bizCode",monthlySettlement.getMonthlySettlementNo());
            criteria.andEqualTo("paymentType",BizTypeEnums.GPS_MONTHLY.getType());
            contPayRepository.updateByExampleSelectiveData(contPay,example);
        }

        //工作流引擎
        ActRuTaskVo actRuTaskVo = null;
        if(StringUtils.isTrimBlank(monthlySettlementVo.getTaskId())){//任务id为空，新开始工作流
            //工作流引擎
            actRuTaskVo =ActGpsMonthlyUtils.startMonthlyAndSubmit(monthlySettlement.getMonthlySettlementNo(),"1","gps月结");
        }else{//任务id不为空，继续工作流
            //流程引擎
            actRuTaskVo = ActGpsMonthlyUtils.approvalAgree(monthlySettlementVo.getTaskId());
        }
        //日志记录,状态记录
        MonthlySettlementApproveVo monthlySettlementApproveVo = new MonthlySettlementApproveVo();
        monthlySettlementApproveVo.setMonthlySettlementNo(monthlySettlement.getMonthlySettlementNo());
        monthlySettlementApproveVo.setUser(monthlySettlementVo.getPresentUser());
        monthlySettlementApproveService.approveCommon(monthlySettlementApproveVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);

    }

    /**
     * @Title:
     * @Description: 修改gps月结任务表
     * @param monthlySettlementModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public void modifyMonthlySettlement(MonthlySettlementModifyVo monthlySettlementModifyVo){
        monthlySettlementRepository.updateByPrimaryKeySelectiveData(monthlySettlementModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过monthlySettlementId删除gps月结任务表
     * @param monthlySettlementDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public void deleteMonthlySettlement(MonthlySettlementDeleteVo monthlySettlementDeleteVo){
        monthlySettlementRepository.deleteData(monthlySettlementDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过monthlySettlementId集合删除gps月结任务表
     * @param monthlySettlementDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public void deleteMonthlySettlementsByMonthlySettlementIds(MonthlySettlementDeleteListVo monthlySettlementDeleteListVo){
        monthlySettlementRepository.deleteDataList(monthlySettlementDeleteListVo.getMonthlySettlementIds(),monthlySettlementDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据monthlySettlementId获取gps月结任务表
     * @param monthlySettlementId
     * @return MonthlySettlement
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public MonthlySettlement findMonthlySettlementByMonthlySettlementId(String monthlySettlementId){
        return monthlySettlementRepository.selectByPrimaryKey(monthlySettlementId);
    }

    /**
     * @param monthlySettlementNo
     * @return MonthlySettlement
     * @throws
     * @Title:
     * @Description: 根据monthlySettlementNo获取gps月结任务表
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public MonthlySettlement findMonthlySettlementBySettlementNo(String monthlySettlementNo) {
        Example example = SqlUtil.newExample(MonthlySettlement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlySettlementNo",monthlySettlementNo);
        return monthlySettlementRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据monthlySettlementNo获取gps月结任务表(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public MonthlySettlementVo findMonthlySettlementVoBySettlementNo(String monthlySettlementNo) {
        Example example = SqlUtil.newExample(MonthlySettlement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlySettlementNo",monthlySettlementNo);
        MonthlySettlement monthlySettlement = monthlySettlementRepository.selectOneByExample(example);
        MonthlySettlementVo monthlySettlementVo = EntityUtils.getEntity(monthlySettlement, new MonthlySettlementVo());
        //查询附件
        monthlySettlementVo.setBizFilesList(bizFilesService.findBizFilesList(monthlySettlementVo.getMonthlySettlementNo(), BizCodeTypeEnums.GPS_DISPATCH_MONTHLY_FILE.getCodeType()));
        return monthlySettlementVo;
    }
}
