package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.EquMorChargeService;
import cn.com.leadu.fms.asset.service.EquMorDetailService;
import cn.com.leadu.fms.asset.service.EquMorRepayService;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorApplyFinReceiptVo;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgagePayFlagEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActEquMorUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.asset.ContDetailFlagEnums;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.asset.repository.EquMorChargeRepository;
import cn.com.leadu.fms.data.asset.repository.EquMorDetailRepository;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayDetailRepository;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyApproveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeImportVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepay.EquMorRepayVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeService
 * @Description: 资方抵押费用业务实现层
 * @date 2018-05-30
 */
@Slf4j
@Service
public class EquMorChargeServiceImpl implements EquMorChargeService {

    /**
     * @Fields  : 资方抵押费用repository
     * @author qiaomengnan
     */
    @Autowired
    private EquMorChargeRepository equMorChargeRepository;

    /**
     * @Fields  : excel通用service
     * @author qiaomengnan
     */
    @Autowired
    private CommonExcelService commonExcelService;

    /**
     * @Fields  : 还款计划service
     * @author qiaomengnan
     */
    @Autowired
    private EquMorRepayService equMorRepayService;

    /**
     * @Fields  : 资方抵押还款计划明细表repository
     * @author qiaomengnan
     */
    @Autowired
    private EquMorRepayDetailRepository equMorRepayDetailRepository;

    /**
     * @Fields  : 抵押明细service
     * @author qiaomengnan
     */
    @Autowired
    private EquMorDetailService equMorDetailService;

    /**
     * @Fields  : 财务待收款repository
     * @author qiaomengnan
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Fields  : 财务付款repository
     * @author qiaomengnan
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 财务收款repository
     * @author qiaomengnan
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务勾稽repository
     * @author qiaomengnan
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 附件service
     * @author qiaomengnan
     */
    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private EquMorDetailRepository equMorDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询资方抵押费用
     * @param equMorChargeVo
     * @return PageInfoExtend<EquMorCharge>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    public PageInfoExtend<EquMorCharge> findEquMorChargesByPage(EquMorChargeVo equMorChargeVo){
        Example example = SqlUtil.newExample(EquMorCharge.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<EquMorCharge> pageInfo = equMorChargeRepository.selectListByExamplePage(example,equMorChargeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据equMorChargeId获取资方抵押费用
     * @param equMorChargeId
     * @return EquMorCharge
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    public EquMorCharge findEquMorChargeByEquMorChargeId(String equMorChargeId){
        return equMorChargeRepository.selectByPrimaryKey(equMorChargeId);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押申请vos
     * @param equMorApplyVo
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    public PageInfoExtend<EquMorApplyVo> findEquMorChargeApplyVosByPage(EquMorApplyVo equMorApplyVo){
        equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        PageInfoExtend<EquMorApplyVo> pageInfo = equMorChargeRepository.selectListVoByPage("selectEquMorApplyVosByPage", equMorApplyVo, equMorApplyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:   解析excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    public List<EquMorChargeVo> parseEquMorChargeVoExcel(String filePath){
        List<EquMorChargeVo> equMorChargeVos = commonExcelService.importExcelToData(filePath,EquMorChargeVo.class);
        return equMorChargeVos;
    }

    /**
     * @Title:
     * @Description:   导入费用,为防止是二次提交,所以之前要删除相关表信息
     * @param equMorChargeImportVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 03:52:43
     */
    @Transactional
    public void  equMorChargeImport(EquMorChargeImportVo equMorChargeImportVo){

        String equMorTaskNo = equMorChargeImportVo.getEquMorTaskNo();
        //check抵押任务号
        checkEquMorTaskNo(equMorTaskNo);
        //检查抵押费用表和还款计划表中有没有一样的车架号
        checkImportChargeVinNos(equMorChargeImportVo.getEquMorChargeVos(),equMorChargeImportVo.getEquMorRepayVos(),equMorTaskNo);
        //还原导入时做的操作
        restoreEquMorChargeImportInfo(equMorTaskNo);
        //保存抵押费用并返回财务应收合计
        BigDecimal totalFinShouldReceive = saveEquMorCharge(equMorChargeImportVo.getEquMorChargeVos(),equMorTaskNo);
        //保存还款计划,并返回还款信息中存在的车架号
        Map<String,String> equMorRepayVinNos = saveEquMorRepay(equMorChargeImportVo.getEquMorRepayVos(),equMorTaskNo);
        //匹配客户还款计划中不存在的任务明细状态为无效
        modifyEquMorDetailsStatusByInvalid(equMorRepayVinNos,equMorTaskNo);
        //保存财务信息
        saveFinanceInfo(equMorChargeImportVo.getEquMorTaskNo(),totalFinShouldReceive,equMorChargeImportVo.getBasBankInfoVo());
        //保存附件信息
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorChargeImportVo.getBizFilesList())) {
            //防止附件还原后不再保存
            equMorChargeImportVo.getBizFilesList().forEach(bizFiles -> {
                bizFiles.setFileId(null);
            });
            bizFilesService.modifyBizFilesList(equMorChargeImportVo.getBizFilesList(), equMorTaskNo, BizCodeTypeEnums.EQU_MOR_CHARGE_FILE.getCodeType());
        }
        //完成工作流
        ActEquMorUtils.approvalAgree(equMorChargeImportVo.getTaskId(),
                equMorChargeImportVo.getTaskDefinitionKey(),
                equMorChargeImportVo.getMemo(),
                equMorChargeImportVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description: 检查抵押费用表和还款计划表中有没有一样的车架号
     * @param:  equMorRepayVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/20 0020 13:50
     */
    public void checkImportChargeVinNos(List<EquMorChargeVo> equMorChargeVos,List<EquMorRepayVo> equMorRepayVos,String equMorTaskNo){
        //检查起租日、到期日是否为空

        //检查抵押费用是否有重复车架号
        Map<String,String> exitsChargeVinNos = new HashMap<>();
        for(EquMorChargeVo equMorChargeVo : equMorChargeVos){
            if ((equMorChargeVo.getEquEndDate()==null || equMorChargeVo.getEquStartDate() == null) && equMorChargeVo.getVinNo() != null){
                throw new FmsServiceException("起租日或到期日不能为空");
            }
            if(exitsChargeVinNos.get(equMorChargeVo.getVinNo()) != null)
                throw new FmsServiceException("请检查抵押费用表文件,不能存在相同的车架号");
            else
                exitsChargeVinNos.put(equMorChargeVo.getVinNo(),equMorChargeVo.getVinNo());


        }
        //检查还款计划是否有重复车架号
        Map<String,String> exitsRepayVinNos = new HashMap<>();
        for(EquMorRepayVo equMorRepayVo : equMorRepayVos){
            if(exitsRepayVinNos.get(equMorRepayVo.getVinNo()) != null)
                throw new FmsServiceException("请检查还款计划表文件,不能存在相同的车架号");
            else
                exitsRepayVinNos.put(equMorRepayVo.getVinNo(),equMorRepayVo.getVinNo());
        }
        //查询任务明细列表 用于检查抵押费用 和 还款计划中是否有匹配的车架号
        List<EquMorDetail> equMorDetails = equMorDetailService.findEquMorDetailsByEquMorTaskNo(equMorTaskNo);
        if(ArrayUtils.isNullOrLengthZero(equMorDetails))
            throw new FmsServiceException("未查询到相关的任务明细信息");

        //还款计划是否一条没有匹配到
        boolean notExitsRepay = true;
        //循环判读
        for(EquMorDetail equMorDetail : equMorDetails){
            //还款计划如果匹配到了一条车机号,那么该车机号的费用信息也必须匹配到
            if(exitsRepayVinNos.get(equMorDetail.getVinNo()) != null){
                notExitsRepay = false;
                if(exitsChargeVinNos.get(equMorDetail.getVinNo()) == null)
                    throw new FmsServiceException("车架号："+ equMorDetail.getVinNo() + "没有相关的费用信息");
            }
        }
        //如果
        if(notExitsRepay)
            throw new FmsServiceException("导入还款计划表中没有匹配到有效的车架号信息,请检查文件");
    }

    /**
     * @Title:
     * @Description:   导入费用退回
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @Transactional
    public void equMorChargeImportReturn(EquMorApplyTaskVo equMorApplyTaskVo){
        ActEquMorUtils.approvalReturnSuperior(equMorApplyTaskVo.getTaskId(),
                equMorApplyTaskVo.getTaskDefinitionKey(),
                equMorApplyTaskVo.getMemo(),
                equMorApplyTaskVo.getEquMorTaskNo());
        //还原之前录入的财务等信息
        restoreEquMorChargeImportInfo(equMorApplyTaskVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description: 还原导入时做的操作
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/17 0017 19:34
     */
    @Transactional
    public void restoreEquMorChargeImportInfo(String equMorTaskNo){
        //check抵押任务号
        checkEquMorTaskNo(equMorTaskNo);
        //删除抵押费用信息
        deleteEquMorChargeByEquMorTaskNo(equMorTaskNo);
        //删除还款计划
        equMorRepayService.deleteEquMorRepayByEquMorTaskNo(equMorTaskNo);
        //还原抵押任务状态到抵押中状态
        equMorDetailService.modifyEquMorStatusByEquMorTaskNo(equMorTaskNo);
        //删除相关财务信息
        deleteFinanceInfo(equMorTaskNo);
        //删除附件信息
        bizFilesService.deleteBizFilesByBizCode(equMorTaskNo, BizCodeTypeEnums.EQU_MOR_CHARGE_FILE.getCodeType());
    }

    /**
     * @Title:
     * @Description: 匹配客户还款计划中不存在的任务明细状态为无效
     * @param:  equMorRepayVinNos
     * @param:  equMorDetails
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 18:47
     */
    private void modifyEquMorDetailsStatusByInvalid(Map<String,String> equMorRepayVinNos, String equMorTaskNo){
        //查询任务明细列表
        List<EquMorDetail> equMorDetails = equMorDetailService.findEquMorDetailsByEquMorTaskNo(equMorTaskNo);
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetails)) {
            //如果最终状态为true,说明一条都没有匹配到
            boolean invalid = true;
            //无效状态的对象
            List<EquMorDetail> invalidEquMorDetails = new ArrayList<>();
            //更新融资期限对象
            List<EquMorDetail> updateEquMorDetails = new ArrayList<>();
            for (EquMorDetail equMorDetail : equMorDetails) {
                //如果客户还款计划中没有明细对应的车架号,则本条明细状态设置为无效
                if (equMorRepayVinNos.get(equMorDetail.getVinNo()) == null) {
                    equMorDetail.setMortgageStatus(MortgageStatusEnums.INVALID.getStatus());
                    invalidEquMorDetails.add(equMorDetail);
                }else{
                    invalid =false;
                    /*equMorDetail.setLeasePeriod(equMorRepayVinNos.get(equMorDetail.getVinNo()));
                    updateEquMorDetails.add(equMorDetail);*/
                }

            }
            if(invalid)
                throw new FmsServiceException("导入的信息中没有匹配到有效的车架号信息,请检查文件");
            equMorDetailService.modifyEquMorDetails(invalidEquMorDetails);
            equMorDetailService.modifyEquMorDetails(updateEquMorDetails);
        }else
            throw new FmsServiceException("没有查询到任务明细数据");
    }

    /**
     * @Title:  
     * @Description: 保存还款计划
     * @param:  equMorRepayVos
     * @param:  equMorTaskNo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 18:43
     */
    private Map<String,String> saveEquMorRepay(List<EquMorRepayVo> equMorRepayVos,String equMorTaskNo){
        //还款信息中存在的车架号
        Map<String,String> equMorRepayVinNos = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorRepayVos)){
            List<EquMorRepay> equMorRepays = new ArrayList<>();
            for(EquMorRepayVo equMorRepayVo : equMorRepayVos){
                // 根据车架号和抵押任务号取得 合同号
                if(StringUtils.isNotTrimBlank(equMorRepayVo.getVinNo()) && StringUtils.isNotTrimBlank(equMorTaskNo)){
                    Example example = SqlUtil.newExample(EquMorDetail.class);
                    example.createCriteria().andEqualTo("vinNo",equMorRepayVo.getVinNo()).andEqualTo("equMorTaskNo",equMorTaskNo);
                    EquMorDetail equMorDetail = equMorDetailRepository.selectOneByExample(example);
                    if(equMorDetail != null){
                        equMorRepayVo.setClientContNo(equMorDetail.getMainContNo());
                    }
                }
                equMorRepayVo.setEquMorTaskNo(equMorTaskNo);
                equMorRepayVo.setEquMorRepayId(null);
                equMorRepays.add(equMorRepayVo.getEntity());
                equMorRepayVinNos.put(equMorRepayVo.getVinNo(),equMorRepayVo.getLeasePeriod());   //
            }
            equMorRepayService.saveEquMorRepay(equMorRepays);
        }
        return equMorRepayVinNos;
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号删除抵押费用
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 18:39
     */
    private void deleteEquMorChargeByEquMorTaskNo(String equMorTaskNo){
        Example equMorChargeExample = SqlUtil.newExample(EquMorCharge.class);
        equMorChargeExample.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        equMorChargeRepository.deleteExampleData(equMorChargeExample,new EquMorCharge());
    }

    /**
     * @Title:
     * @Description: 保存费用明细信息
     * @param: equMorChargeVos
     * @param: equMorTaskNo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 18:29
     */
    private BigDecimal saveEquMorCharge(List<EquMorChargeVo> equMorChargeVos,String equMorTaskNo){
        BigDecimal totalFinShouldReceive = null;
        //保存录入的费用明细数据
        if (equMorChargeVos != null && equMorChargeVos.size() >= 2) {
            List<EquMorCharge> equMorCharges = new ArrayList<>();
            List<EquMorDetail> equMorDetails = new ArrayList<>();
            for(int i = 0;i < equMorChargeVos.size();i++ ){
                EquMorChargeVo equMorChargeVo = equMorChargeVos.get(i);
                if(equMorChargeVo != null) {
                    //第一条说明是合计数据
                    if (i == 0) {
                        equMorChargeVo.setContDetailFlag(ContDetailFlagEnums.TOTAL.getFlag());
                        totalFinShouldReceive = equMorChargeVo.getFinShouldReceive();
                    } else
                         equMorChargeVo.setContDetailFlag(ContDetailFlagEnums.DETAIL.getFlag());
                         equMorChargeVo.setEquMorTaskNo(equMorTaskNo);
                         equMorChargeVo.setEquMorChargeId(null);
                         Example example = SqlUtil.newExample(EquMorDetail.class);
                         if(StringUtils.isNotTrimBlank(equMorChargeVo.getVinNo()) && StringUtils.isNotTrimBlank(equMorTaskNo)){
                             example.createCriteria().andEqualTo("vinNo",equMorChargeVo.getVinNo()).andEqualTo("equMorTaskNo",equMorTaskNo);
                             EquMorDetail equMorDetail = equMorDetailRepository.selectOneByExample(example);
                             if(equMorDetail != null){
                                 equMorChargeVo.setClientContNo(equMorDetail.getMainContNo());
                                 equMorDetail.setMortgageContNo(equMorChargeVo.getEquContNo());
                                 equMorDetails.add(equMorDetail);
                             }
                        }
                        equMorCharges.add(equMorChargeVo.getEntity());
                }
            }
            if(equMorCharges.size() < 2)
                throw new FmsServiceException("费用信息有误,请检查是否录入了合计与明细信息");
            equMorChargeRepository.insertDataList(equMorCharges);
            if(ArrayUtils.isNotNullAndLengthNotZero(equMorDetails))
                equMorDetailRepository.updateByPrimaryKeySelectiveDataList(equMorDetails);
        }else{
            throw new FmsServiceException("费用信息有误,请检查是否录入了合计与明细信息");
        }
        if(totalFinShouldReceive == null)
            throw new FmsServiceException("财务应收合计信息不能为空");
        return totalFinShouldReceive;
    }

    /**
     * @Title:
     * @Description: 保存财务信息
     * @param:  equMorChargeImportVo
     * @param:  totalFinShouldReceive
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 18:20
     */
    private void saveFinanceInfo(String equMorTaskNo,BigDecimal totalFinShouldReceive,BasBankInfoVo basBankInfoVo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
        if(totalFinShouldReceive == null)
            throw new FmsServiceException("财务应收合计不能为空");
        if(basBankInfoVo == null || StringUtils.isContainTrimBlank(basBankInfoVo.getAccBankName(),basBankInfoVo.getAccountNo(),basBankInfoVo.getAccountName()))
            throw new FmsServiceException("财务付款银行信息有误");
        //生成财务付款和待收款
        //财务待收款表
        ContCharge contCharge  = new ContCharge();
        contCharge.setChargeBizType(BizTypeEnums.EQU_MORTGAGE.getType());
        contCharge.setChargeFund(PayFundNameEnums.EQU_MOR_CHARGE_IMPORT.getType());
        contCharge.setChargeStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        contCharge.setChargeBizId(equMorTaskNo);
        contCharge.setChargeAmount(totalFinShouldReceive);
        contChargeRepository.insertData(contCharge);
        //财务付款表
        ContPay contPay = new ContPay();
        contPay.setPaymentType(BizTypeEnums.EQU_MORTGAGE.getType());
        contPay.setPayFund(PayFundNameEnums.EQU_MOR_CHARGE_IMPORT.getType());
        contPay.setPayStatus(PayStatusEnums.CONFIRM.getType());
        contPay.setBizCode(equMorTaskNo);
        contPay.setPayAmount(totalFinShouldReceive);
        contPay.setRecAccBank(basBankInfoVo.getAccBankName());
        contPay.setRecAccBranch(basBankInfoVo.getAccBranchBank());
        contPay.setRecAccountNo(basBankInfoVo.getAccountNo());
        contPay.setRecAccountName(basBankInfoVo.getAccountName());
        contPay.setRecEleBankNo(basBankInfoVo.getEleAccountNo());
        contPayRepository.insertData(contPay);
    }

    /**
     * @Title:
     * @Description: 删除抵押任务号相关财务信息
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 18:11
     */
    private void deleteFinanceInfo(String equMorTaskNo){
        //删除之前录入的财务信息
        Example contChargeExample = SqlUtil.newExample(ContCharge.class);
        contChargeExample.createCriteria().andEqualTo("chargeBizType",BizTypeEnums.EQU_MORTGAGE.getType()) //业务类型
                .andEqualTo("chargeBizId",equMorTaskNo); //业务id
        contChargeRepository.deleteExampleData(contChargeExample,new ContCharge());
        Example contPayExample = SqlUtil.newExample(ContPay.class);
        contPayExample.createCriteria().andEqualTo("paymentType",BizTypeEnums.EQU_MORTGAGE.getType()) //业务类型
                .andEqualTo("bizCode",equMorTaskNo); //业务id
        contPayRepository.deleteExampleData(contPayExample,new ContPay());
    }


    /**
     * @Title:
     * @Description:   抵押费用导入模板下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 11:12:06
     */
    public void downloadEquMorChargeImportTemplate(HttpServletResponse httpServletResponse){
        try {
            ResponseUtils.outExcel(httpServletResponse,"费用导入模板");
            commonExcelService.exportList("费用导入模板",getImportTemplateData(),EquMorChargeVo.class,httpServletResponse.getOutputStream(),ExcelTypeConstants.ONE);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("抵押费用导入模板生成失败");
        }
    }

    /**
     * @Title:
     * @Description: 返回模板中的数据
     * @return
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 10:40
     */
    private List<EquMorChargeVo> getImportTemplateData(){
        List<EquMorChargeVo> equMorChargeVos = new ArrayList<>();
        //合计数据
        EquMorChargeVo equMorChargeVo1 = new EquMorChargeVo();
        equMorChargeVo1.setManagementName("(费用合计行)");
        equMorChargeVo1.setEquFinAmount(new BigDecimal("10000"));
        equMorChargeVo1.setMargin(new BigDecimal("2000"));
        equMorChargeVo1.setFactorge(new BigDecimal("2000"));
        equMorChargeVo1.setManagementCharge(new BigDecimal("2000"));
        equMorChargeVo1.setServiceCharge(new BigDecimal("2000"));
        equMorChargeVo1.setOneTimeInterest(new BigDecimal("2000"));
        equMorChargeVo1.setRetentionPrice(new BigDecimal("2000"));
        equMorChargeVo1.setTotalShouldPay(new BigDecimal("12000"));
        equMorChargeVo1.setFinShouldReceive(new BigDecimal("12000"));
        equMorChargeVos.add(equMorChargeVo1);
        //明细数据
        EquMorChargeVo equMorChargeVo = new EquMorChargeVo();
        equMorChargeVo.setManagementName("海尔");
        equMorChargeVo.setEquContNo("ANSKA11333222111111");
        equMorChargeVo.setVinNo("SSAAA12331212111");
        equMorChargeVo.setEquStartDate(new Date());
        equMorChargeVo.setEquEndDate(new Date());
        equMorChargeVo.setEquFinAmount(new BigDecimal("10000"));
        equMorChargeVo.setMargin(new BigDecimal("2000"));
        equMorChargeVo.setFactorge(new BigDecimal("2000"));
        equMorChargeVo.setManagementCharge(new BigDecimal("2000"));
        equMorChargeVo.setServiceCharge(new BigDecimal("2000"));
        equMorChargeVo.setOneTimeInterest(new BigDecimal("2000"));
        equMorChargeVo.setRetentionPrice(new BigDecimal("2000"));
        equMorChargeVo.setTotalShouldPay(new BigDecimal("12000"));
        equMorChargeVo.setFinShouldReceive(new BigDecimal("12000"));
        equMorChargeVos.add(equMorChargeVo);
        return equMorChargeVos;
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号查询费用导入详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:15:25
     */
    public EquMorChargeImportVo findEquMorChargeImportVo(String equMorTaskNo){
        checkEquMorTaskNo(equMorTaskNo);
        EquMorChargeImportVo equMorChargeImportVo = new EquMorChargeImportVo();
        //获取抵押费用列表
        equMorChargeImportVo.setEquMorCharges(findEquMorChargesByEquMorTaskNo(equMorTaskNo));
        //收款银行
        equMorChargeImportVo.setBasBankInfoVo(getRecBasBankInfoVo(equMorTaskNo));
        //客户还款计划表
        equMorChargeImportVo.setEquMorRepays(equMorRepayService.findEquMorRepayByEquMorTaskNo(equMorTaskNo));
        //附件信息
//        equMorChargeImportVo.setBizFilesList(bizFilesService.findBizFilesList(equMorTaskNo,BizCodeTypeEnums.EQU_MOR_CHARGE_FILE.getCodeType()));

        //抵押费用附件信息
        equMorChargeImportVo.setEquMorChargeFileList(bizFilesService.findBizFilesList(equMorTaskNo,BizCodeTypeEnums.EQU_MOR_CHARGE_FILE.getCodeType()));
        return equMorChargeImportVo;
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号获取抵押费用列表
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 21:43
     */
    public List<EquMorCharge> findEquMorChargesByEquMorTaskNo(String equMorTaskNo){
        checkEquMorTaskNo(equMorTaskNo);
        //付款信息
        Example equMorChargeExample = SqlUtil.newExample(EquMorCharge.class);
        equMorChargeExample.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        equMorChargeExample.orderBy("contDetailFlag").asc();
        return equMorChargeRepository.selectListByExample(equMorChargeExample);
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号获取费用合计信息
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/6 0006 17:48
     */
    private EquMorCharge findTotalEquMorCharge(String equMorTaskNo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
        Example example = SqlUtil.newExample(EquMorCharge.class);
        example.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo)
                .andEqualTo("contDetailFlag",ContDetailFlagEnums.TOTAL.getFlag());
        List<EquMorCharge> equMorCharges = equMorChargeRepository.selectListByExample(example);
        if(ArrayUtils.isNullOrLengthZero(equMorCharges))
            throw new FmsServiceException("未查询到费用合计信息");
        else if(equMorCharges.size() > 1)
            throw new FmsServiceException("数据错误,查到多条费用合计信息");
        else
            return equMorCharges.get(0);
    }

    /**
     * @Title:
     * @Description:   查询制单详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:45:53
     */
    public EquMorChargeFinTouchingDetailVo findFinanceTouchingVo(String equMorTaskNo){
        checkEquMorTaskNo(equMorTaskNo);
        EquMorChargeFinTouchingDetailVo equMorChargeFinTouchingDetailVo = new EquMorChargeFinTouchingDetailVo();
        //费用合同
        equMorChargeFinTouchingDetailVo.setEquMorCharge(findTotalEquMorCharge(equMorTaskNo));
        //抵押明细列表
        equMorChargeFinTouchingDetailVo.setEquMorDetailVos(equMorDetailService.findEquMorDetailVosByEquMorTaskNo(equMorTaskNo));
        //制单付款银行
        equMorChargeFinTouchingDetailVo.setBasBankInfoVo(getPayBasBankInfoVo(equMorTaskNo));
        //费用附件
        equMorChargeFinTouchingDetailVo.setBizFilesList(bizFilesService.findBizFilesList(equMorTaskNo,BizCodeTypeEnums.EQU_MOR_CHARGE_FILE.getCodeType()));
        return equMorChargeFinTouchingDetailVo;
    }


    /**
     * @Title:
     * @Description:   财务制单
     * @param equMorChargeFinTouchingVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/07 02:39:02
     */
    @Transactional
    public void financeTouching(EquMorChargeFinTouchingVo equMorChargeFinTouchingVo){
        ContPay contPay = getContPay(equMorChargeFinTouchingVo.getEquMorTaskNo());
        if(contPay == null)
            throw new FmsServiceException("未查询到相应付款信息");
        contPay.setPayAccBank(equMorChargeFinTouchingVo.getBasBankInfoVo().getAccBankName());
        contPay.setPayAccBranch(equMorChargeFinTouchingVo.getBasBankInfoVo().getAccBranchBank());
        contPay.setPayAccountNo(equMorChargeFinTouchingVo.getBasBankInfoVo().getAccountNo());
        contPay.setPayAccountName(equMorChargeFinTouchingVo.getBasBankInfoVo().getAccountName());
        contPay.setPayEleBankNo(equMorChargeFinTouchingVo.getBasBankInfoVo().getEleAccountNo());
        contPayRepository.updateByPrimaryKeySelectiveData(contPay,true);
        ActEquMorUtils.approvalAgree(equMorChargeFinTouchingVo.getTaskId(),
                equMorChargeFinTouchingVo.getTaskDefinitionKey(),
                equMorChargeFinTouchingVo.getMemo(),
                equMorChargeFinTouchingVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   财务付款
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/07 02:39:41
     */
    @Transactional
    public void financePay(EquMorApplyTaskVo equMorApplyTaskVo){
        ContPay contPay = getContPay(equMorApplyTaskVo.getEquMorTaskNo());
        if(contPay == null)
            throw new FmsServiceException("未查询到相应付款信息");
        EquMorCharge equMorCharge =  findEquMorChargeTotalByEquMorTaskNo(equMorApplyTaskVo.getEquMorTaskNo());
        if(equMorCharge == null)
            throw new FmsServiceException("未查询到相应的费用信息");
        contPay.setPayStatus(PayStatusEnums.WITHDRAWING.getType());
        contPayRepository.updateByPrimaryKeySelectiveData(contPay,true);
        ActEquMorUtils.approvalAgree(equMorApplyTaskVo.getTaskId(),
                equMorApplyTaskVo.getTaskDefinitionKey(),
                equMorApplyTaskVo.getMemo(),
                equMorApplyTaskVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号获取费用合计
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:45:53
     */
    public EquMorCharge findEquMorChargeTotalByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo)) {
            Example example = SqlUtil.newExample(EquMorCharge.class);
            example.createCriteria().andEqualTo("equMorTaskNo", equMorTaskNo);
            return equMorChargeRepository.selectOneByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   财务收款
     * @param equMorApplyFinReceiptVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/07 02:40:01
     */
    @Transactional
    public void financeReceipt(EquMorApplyFinReceiptVo equMorApplyFinReceiptVo){
        //资方抵押任务号
        String equMorTaskNo = equMorApplyFinReceiptVo.getEquMorTaskNo();
        checkEquMorTaskNo(equMorTaskNo);
        //查出财务代收款明细
        Example example = SqlUtil.newExample(ContCharge.class);
        example.createCriteria().andEqualTo("chargeBizId", equMorApplyFinReceiptVo.getEquMorTaskNo()).andEqualTo("chargeBizType",BizTypeEnums.EQU_MORTGAGE.getType());
        ContCharge contCharge = contChargeRepository.selectOneByExample(example);
        if(contCharge == null)
            throw new FmsServiceException("未获取到待收款数据");
        //财务收款合计
        List<ContReceipt> contReceipts = new ArrayList<>();
        //财务勾稽
        List<ContReceiptExam> contReceiptExams = new ArrayList<>();
        //银行卡信息
        for(ContReceiptVo contReceiptVo : equMorApplyFinReceiptVo.getContReceiptVos()){
            contReceiptVo.setInputMode(InputModeEnums.INPUT.getType());
            contReceiptVo.setContReceiptId(UUIDUtils.getUUID());
            contReceipts.add(contReceiptVo.getEntity());

            ContReceiptExam contReceiptExam  =  new ContReceiptExam();
            contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType()); //款项类型 财务代收款
            contReceiptExam.setReceiptBizId(contCharge.getContChargeId());//
            contReceiptExam.setContReceiptId(contReceiptVo.getContReceiptId());
            contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());   //勾稽类型 财务收款
            contReceiptExam.setReceiptExamAmount(contReceiptVo.getReceiptAmount());
            contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType()); //勾稽状态  已勾稽
            contReceiptExams.add(contReceiptExam);
        }
        //录入财务收款表
        contReceiptRepository.insertDataList(contReceipts);
        //录入财务勾稽表
        contReceiptExamRepository.insertDataList(contReceiptExams);

        //完成任务
        ActRuTaskVo actRuTaskVo = ActEquMorUtils.approvalAgree(equMorApplyFinReceiptVo.getTaskId(),
                equMorApplyFinReceiptVo.getTaskDefinitionKey(),
                equMorApplyFinReceiptVo.getMemo(),
                equMorTaskNo);
        //如果完成了流程,需要将抵押状态修改成已抵押
        if(actRuTaskVo.getEndFlag())
            equMorDetailService.modifyEquMorSuccessStatusByEquMorTaskNo(equMorTaskNo);
            equMorDetailService.insertEquMorRepayDetailList(equMorTaskNo);

    }
    /**
     * @Title:
     * @Description:   费用导入review
     * @param equMorApplyApproveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/12 10:12:45
     */
    @Transactional
    public void equMorChargeImportReview(EquMorApplyApproveVo equMorApplyApproveVo){
        ActEquMorUtils.approvalAgree(equMorApplyApproveVo.getTaskId(),
                equMorApplyApproveVo.getTaskDefinitionKey(),
                equMorApplyApproveVo.getMemo(),
                equMorApplyApproveVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description: check抵押任务号
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 18:32
     */
    private void checkEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号返回付款实体
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 20:59
     */
    private ContPay getContPay(String equMorTaskNo){
        checkEquMorTaskNo(equMorTaskNo);
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("paymentType",BizTypeEnums.EQU_MORTGAGE.getType())
                .andEqualTo("bizCode",equMorTaskNo);
        ContPay contPay = contPayRepository.selectOneByExample(example);
        return contPay;
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号返回财务付款银行信息
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 21:03
     */
    private BasBankInfoVo getPayBasBankInfoVo(String equMorTaskNo){
        ContPay contPay = getContPay(equMorTaskNo);
        if(contPay != null && (StringUtils.isNotTrimBlank(contPay.getPayAccBank()) || StringUtils.isNotTrimBlank(contPay.getRecAccBank()))){
            BasBankInfoVo basBankInfoVo = new BasBankInfoVo();
            basBankInfoVo.setAccBankName(contPay.getPayAccBank());
            basBankInfoVo.setAccBranchBank(contPay.getPayAccBranch());
            basBankInfoVo.setAccountName(contPay.getPayAccountName());
            basBankInfoVo.setAccountNo(contPay.getPayAccountNo());
            basBankInfoVo.setEleAccountNo(contPay.getPayEleBankNo());

            basBankInfoVo.setRecAccBank(contPay.getRecAccBranch());//收款银行分行
            basBankInfoVo.setRecAccEquBank(contPay.getRecAccBank());//收款银行
            basBankInfoVo.setRecAccountName(contPay.getRecAccountName());
            basBankInfoVo.setRecAccountNo(contPay.getRecAccountNo());
            basBankInfoVo.setRecEleBankNo(contPay.getRecEleBankNo());
            return basBankInfoVo;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 根据抵押任务号返回财务收款银行信息
     * @param:  equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 21:03
     */
    private BasBankInfoVo getRecBasBankInfoVo(String equMorTaskNo){
        ContPay contPay = getContPay(equMorTaskNo);
        if(contPay != null && StringUtils.isNotTrimBlank(contPay.getRecAccBank())){
            BasBankInfoVo basBankInfoVo = new BasBankInfoVo();
            basBankInfoVo.setAccBankName(contPay.getRecAccBank());
            basBankInfoVo.setAccBranchBank(contPay.getRecAccBranch());
            basBankInfoVo.setAccountName(contPay.getRecAccountName());
            basBankInfoVo.setAccountNo(contPay.getRecAccountNo());
            basBankInfoVo.setEleAccountNo(contPay.getRecEleBankNo());
            return basBankInfoVo;
        }
        return null;
    }

}
