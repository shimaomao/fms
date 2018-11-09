package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.rpc.prebiz.ContFinDetailRpc;
import cn.com.leadu.fms.asset.rpc.system.SysParamRpc;
import cn.com.leadu.fms.asset.service.EquMorApplyService;
import cn.com.leadu.fms.asset.service.EquMorChargeService;
import cn.com.leadu.fms.asset.service.EquMorDetailService;
import cn.com.leadu.fms.asset.service.EquMorTaskService;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorOtherApplyVo;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorSeaWingApplyVo;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgageFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActEquMortgagePayFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.util.CommonPdfUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActEquMorUtils;
import cn.com.leadu.fms.business.common.util.prebiz.ContFinDetailUtils;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.CommonPropertyConstants;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.asset.*;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.data.asset.repository.EquMorChargeRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingPrintVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmortask.EquMorTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorApplyServiceImpl
 * @Description: 资方抵押申请service
 * @date 2018/5/31
 */
@Slf4j
@Service
public class EquMorApplyServiceImpl implements EquMorApplyService {

    /**
     * @Fields  : 资方抵押费用明细 rep,因为申请没有rep层，sql查询寄存于 equMorChargeRepository中
     * @author qiaomengnan
     */
    @Autowired
    private EquMorChargeRepository equMorChargeRepository;

    /**
     * @Fields  : 合同明细rpc
     * @author qiaomengnan
     */
    @Autowired
    private ContFinDetailRpc contFinDetailRpc;

    /**
     * @Fields  : 资方抵押任务service
     * @author qiaomengnan
     */
    @Autowired
    private EquMorTaskService equMorTaskService;

    /**
     * @Fields  : 资方抵押任务详情service
     * @author qiaomengnan
     */
    @Autowired
    private EquMorDetailService equMorDetailService;

    /**
     * @Fields  : 系统参数rpc
     * @author qiaomengnan
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 流程业务号service
     * @author qiaomengnan
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 通用pdfservice
     * @author qiaomengnan
     */
    @Autowired
    private CommonPdfService commonPdfService;

    @Autowired
    private EquMorChargeService equMorChargeService;

    /**
     * @Title:
     * @Description: 查询资方抵押申请模板下载详情
     * @param contNos
     * @return  List<EquMorOtherApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    public PageInfoExtend<EquMorApplyVo> exportEquMorApplyVos(List<String> contNos){
        if(ArrayUtils.isNotNullAndLengthNotZero(contNos)){
            EquMorApplyVo equMorApplyVo = new EquMorApplyVo();
            equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
            equMorApplyVo.setContNos(contNos);
            equMorApplyVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
            List<EquMorApplyVo> equMorApplyVos = equMorChargeRepository.selectExportEquMorApplyVos(equMorApplyVo);
            if(ArrayUtils.isNotNullAndLengthNotZero(equMorApplyVos)) {
                equMorApplyVos.forEach(applyVo -> applyVo.init());
                PageInfoExtend<EquMorApplyVo> pageInfoExtend = PageInfoExtendUtils.getPageInfoExtend(equMorApplyVos, (long) equMorApplyVos.size(), equMorApplyVo.getPageQuery(), EquMorApplyVo.class);
                return pageInfoExtend;
            }
        }else
            throw new FmsServiceException("请选择需要下载的合同");
        return null;
    }

    /**
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @Title:
     * @Description: 保存海翼申请
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @Transactional
    public void saveEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo) {
        //check每期租金
        if(equMorSeaWingApplyVo.getEquMorDetailVo()!=null){
            EquMorDetailVo equMorDetailVoA = new EquMorDetailVo();
            equMorDetailVoA.setContAmount(equMorSeaWingApplyVo.getEquMorDetailVo().getContAmount());
            equMorDetailVoA.setBalanceAmount(equMorSeaWingApplyVo.getEquMorDetailVo().getBalanceAmount());
            equMorDetailVoA.setPlanRepaymentPeriod(equMorSeaWingApplyVo.getEquMorDetailVo().getPlanRepaymentPeriod());
            equMorDetailVoA.setBalanceAnnualRate(equMorSeaWingApplyVo.getEquMorDetailVo().getBalanceAnnualRate());
            equMorDetailVoA.setRepayDay(equMorSeaWingApplyVo.getRepayDay());
            equMorDetailVoA.setRentPayMode(equMorSeaWingApplyVo.getRentPayMode());
            if(BigDecimalUtils.notEqual(findRent(equMorDetailVoA),equMorSeaWingApplyVo.getEquMorDetailVo().getRent())){
                throw new FmsServiceException("每期租金计算有误,请重新计算!");
            }
        }
        //获取合同相关的详情
        EquMorApplyVo equMorApplyVo = findEquMorApplyVoByContNo(equMorSeaWingApplyVo.getContNo());
        //判断该单是否已经抵押
        checkEquMorStatus(equMorApplyVo);
        //任务明细
        EquMorDetail equMorDetail = equMorSeaWingApplyVo.getEquMorDetailVo().getEntity();
        //金额对比错误提示
        String amountErrorInfo = validationAmount(equMorDetail,equMorApplyVo);
        //如果有错误抛出
        if(StringUtils.isNotTrimBlank(amountErrorInfo.toString()))
            throw new FmsServiceException(amountErrorInfo.toString());
        //申请任务
        EquMorTask equMorTask = equMorSeaWingApplyVo.getEquMorTaskVo().getEntity();
        //业务名称
        String serviceName = getServiceName(equMorTask);
        //默认设置为海翼资方
        equMorTask.setManagement(ManagementEnums.SEA_WING.getType());
        //新增设置任务号
        equMorTask.setEquMorTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.EQU_MOR_TASK_NUM_TYPE.getType()));
        //赋上默认值
        setEquMorDetailValue(equMorDetail, equMorApplyVo,equMorTask.getEquMorTaskNo());
        //保存抵押任务
        equMorTaskService.saveEquMorTask(equMorTask);
        //保存抵押任务详情
        equMorDetailService.saveEquMorDetail(equMorDetail);
        //启动工作流
        startProcess(equMorTask.getEquMorTaskNo(), EquMorTypeEnums.SEA_WING.getType(), serviceName,equMorTask.getMortgageProcess(),equMorDetail.getMemo(),true);
    }

    /**
     * @Title:
     * @Description: 验证是否已经被抵押
     * @param:  equMorApplyVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/12 0012 19:46
     */
    private void checkEquMorStatus(EquMorApplyVo equMorApplyVo){
        //判断该单是否已经抵押
        if(StringUtils.isNotTrimBlank(equMorApplyVo.getEquMorTaskNo()))
            throw new FmsServiceException("合同号:" + equMorApplyVo.getContNo() + ",已抵押,不可再次进行抵押");
    }

    /**
     * @Title:
     * @Description: 验证是否已经被抵押
     * @param:  equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/12 0012 19:46
     */
    private void checkEquMorStatus(List<EquMorApplyVo> equMorApplyVos){
        for(EquMorApplyVo equMorApplyVo : equMorApplyVos)
            checkEquMorStatus(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description:   海翼申请 二次提交
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 03:27:58
     */
    @Transactional
    public void modifyEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo){
        //check每期租金
        if(equMorSeaWingApplyVo.getEquMorDetailVo()!=null){
            EquMorDetailVo equMorDetailVoA = new EquMorDetailVo();
            equMorDetailVoA.setContAmount(equMorSeaWingApplyVo.getEquMorDetailVo().getContAmount());
            equMorDetailVoA.setBalanceAmount(equMorSeaWingApplyVo.getEquMorDetailVo().getBalanceAmount());
            equMorDetailVoA.setPlanRepaymentPeriod(equMorSeaWingApplyVo.getEquMorDetailVo().getPlanRepaymentPeriod());
            equMorDetailVoA.setBalanceAnnualRate(equMorSeaWingApplyVo.getEquMorDetailVo().getBalanceAnnualRate());
            equMorDetailVoA.setRepayDay(equMorSeaWingApplyVo.getRepayDay());
            equMorDetailVoA.setRentPayMode(equMorSeaWingApplyVo.getRentPayMode());
            if(BigDecimalUtils.notEqual(findRent(equMorDetailVoA),equMorSeaWingApplyVo.getEquMorDetailVo().getRent())){
                throw new FmsServiceException("每期租金计算有误,请重新计算!");
            }
        }
        //获取合同相关的详情
        EquMorApplyVo equMorApplyVo = findEquMorApplyVoByContNo(equMorSeaWingApplyVo.getContNo());
        //抵押任务
        EquMorTask equMorTask = equMorSeaWingApplyVo.getEquMorTaskVo().getEntity();
        equMorTask.setEquMorTaskId(equMorApplyVo.getEquMorTaskId());
        equMorTask.setUpdateTime(equMorApplyVo.getEquMorTaskUpdateTime());
        if(StringUtils.isTrimBlank(equMorTask.getEquMorTaskId()))
            throw new FmsServiceException("抵押任务id不存在");
        //任务明细
        EquMorDetail equMorDetail = equMorSeaWingApplyVo.getEquMorDetailVo().getEntity();
        equMorDetail.setEquMorDetailId(equMorApplyVo.getEquMorDetailId());
        equMorDetail.setUpdateTime(equMorApplyVo.getEquMorDetailUpdateTime());
        if(StringUtils.isTrimBlank(equMorDetail.getEquMorDetailId()))
            throw new FmsServiceException("抵押任务明细id不存在");
        //金额对比错误提示
        String amountErrorInfo =  validationAmount(equMorDetail,equMorApplyVo);
        //如果有错误抛出异常
        if(StringUtils.isNotTrimBlank(amountErrorInfo.toString()))
            throw new FmsServiceException(amountErrorInfo.toString());
        //默认设置为海翼资方
        equMorTask.setManagement(ManagementEnums.SEA_WING.getType());
        //赋上默认值
        setEquMorDetailValue(equMorDetail, equMorApplyVo,equMorTask.getEquMorTaskNo());
        //修改抵押任务
        equMorTaskService.modifyEquMorTask(equMorTask);
        //修改抵押任务明细
        equMorDetailService.modifyEquMorDetail(equMorDetail);
        //二次提交
        ActEquMorUtils.approvalAgree(equMorSeaWingApplyVo.getTaskId(),equMorSeaWingApplyVo.getTaskDefinitionKey()
        ,equMorDetail.getMemo(),equMorApplyVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   暂存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 05:49:03
     */
    @Transactional
    public EquMorApplyVo storageEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo) {
        ActRuTaskVo actRuTaskVo = null;
        EquMorApplyVo equMorApplyVo = findEquMorApplyVoByContNo(equMorSeaWingApplyVo.getContNo());
        //申请任务
        EquMorTask equMorTask = equMorSeaWingApplyVo.getEquMorTaskVo().getEntity();
        //暂存也需要选择抵押流程
        if(StringUtils.isTrimBlank(equMorTask.getMortgageProcess()))
            throw new FmsServiceException("请选择抵押流程");
        //任务明细
        EquMorDetail equMorDetail = equMorSeaWingApplyVo.getEquMorDetailVo().getEntity();
        //金额对比错误提示
        String amountErrorInfo = storageValidationAmount(equMorDetail,equMorApplyVo);
        //如果有错误抛出
        if(StringUtils.isNotTrimBlank(amountErrorInfo.toString()))
            throw new FmsServiceException(amountErrorInfo.toString());
        //赋上默认值
        equMorTask.setManagement(ManagementEnums.SEA_WING.getType());
        //如果抵押任务号为空,并且db中同条合同所对应的资方抵押任务表和资方抵押明细表的id都为空时,说明是第一次暂存,要做存值处理
        if(StringUtils.isTrimBlank(equMorApplyVo.getEquMorTaskNo()) && StringUtils.isTrimBlank(equMorApplyVo.getEquMorTaskId()) && StringUtils.isTrimBlank(equMorApplyVo.getEquMorDetailId())) {
            //判断该单是否已经抵押
            checkEquMorStatus(equMorApplyVo);
            //设置任务号
            equMorTask.setEquMorTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.EQU_MOR_TASK_NUM_TYPE.getType()));
            //赋上默认值
            setEquMorDetailValue(equMorDetail, equMorApplyVo,equMorTask.getEquMorTaskNo());
            //保存抵押任务
            equMorTaskService.saveEquMorTask(equMorTask);
            //保存抵押任务明细
            equMorDetailService.saveEquMorDetail(equMorDetail);
            //业务名称
            String serviceName = getServiceName(equMorTask);
            //启动暂存工作流
            actRuTaskVo = startProcess(equMorTask.getEquMorTaskNo(), EquMorTypeEnums.SEA_WING.getType(), serviceName, equMorTask.getMortgageProcess(), equMorDetail.getMemo(), false);
        }else{
            //赋上默认值
            setEquMorDetailValue(equMorDetail, equMorApplyVo,equMorTask.getEquMorTaskNo());
            //不为空,更新
            //修改抵押任务
//            if(StringUtils.isTrimBlank(equMorTask.getEquMorTaskId()))
            if(StringUtils.isTrimBlank(equMorApplyVo.getEquMorTaskId()))
                throw new FmsServiceException("抵押任务id不存在");
            equMorTask.setEquMorTaskId(equMorApplyVo.getEquMorTaskId());
            equMorTask.setUpdateTime(equMorApplyVo.getEquMorTaskUpdateTime());
            equMorTaskService.modifyEquMorTask(equMorTask);
            //修改抵押任务明细
//            if(StringUtils.isTrimBlank(equMorDetail.getEquMorDetailId()))
            if(StringUtils.isTrimBlank(equMorApplyVo.getEquMorDetailId()))
                throw new FmsServiceException("抵押任务明细id不存在");
            equMorDetail.setEquMorDetailId(equMorApplyVo.getEquMorDetailId());
            equMorDetail.setUpdateTime(equMorApplyVo.getEquMorDetailUpdateTime());
            equMorDetailService.modifyEquMorDetail(equMorDetail);
            equMorTask.setEquMorTaskNo(equMorApplyVo.getEquMorTaskNo());
        }
        equMorApplyVo.setEquMorTaskVo(EntityUtils.getEntity(equMorTask,new EquMorTaskVo()));
        equMorApplyVo.setEquMorDetailVo(EntityUtils.getEntity(equMorDetail,new EquMorDetailVo()));
        if(actRuTaskVo != null){
            equMorApplyVo.setTaskId(actRuTaskVo.getId());
            equMorApplyVo.setTaskDefinitionKey(actRuTaskVo.getTaskDefinitionKey());
        }
        return equMorApplyVo;
    }

    /**
     * @Title:
     * @Description:   保存其他资方抵押
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 10:10:01
     */
    @Transactional
    public void saveEquMorOtherApply(EquMorOtherApplyVo equMorOtherApplyVo){
        if(ManagementEnums.SEA_WING.getType().equals(equMorOtherApplyVo.getManagement()))
            throw new FmsServiceException("其他资方抵押资金方不可以是海翼");
        List<EquMorApplyVo> equMorApplyVos = findEquMorChargeApplyVosByContNos(equMorOtherApplyVo.getContNos());
        //判断该单是否已经抵押
        checkEquMorStatus(equMorApplyVos);
        //申请任务
        EquMorTask equMorTask = equMorOtherApplyVo.getEntity();
        String serviceName = getServiceName(equMorTask);
        equMorTask.setEquMorTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.EQU_MOR_TASK_NUM_TYPE.getType()));
        if(ArrayUtils.isNotNullAndLengthNotZero(equMorApplyVos)){
            List<EquMorDetail> equMorDetails = new ArrayList<>();
            for(EquMorApplyVo equMorApplyVo : equMorApplyVos){
                EquMorDetail equMorDetail = new EquMorDetail();
                setEquMorDetailValue(equMorDetail, equMorApplyVo,equMorTask.getEquMorTaskNo());
                equMorDetails.add(equMorDetail);
            }
            equMorDetailService.saveEquMorDetails(equMorDetails);
        }else
            throw new FmsServiceException("请选择需要申请的合同");
        equMorTaskService.saveEquMorTask(equMorTask);
        //启动工作流
        startProcess(equMorTask.getEquMorTaskNo(), EquMorTypeEnums.OTHER.getType(), serviceName,equMorTask.getMortgageProcess(),equMorOtherApplyVo.getMemo(),true);
    }

    /**
     * @Title:
     * @Description:   修改其他资方抵押 (二次提交)
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 10:10:01
     */
    @Transactional
    public void modifyEquMorOtherApply(EquMorOtherApplyVo equMorOtherApplyVo){
        if(StringUtils.isTrimBlank(equMorOtherApplyVo.getEquMorTaskId()))
            throw new FmsServiceException("抵押任务明细id不存在");
        if(StringUtils.isTrimBlank(equMorOtherApplyVo.getEquMorTaskNo()))
            throw new FmsServiceException("抵押任务号不存在");
        if(ManagementEnums.SEA_WING.getType().equals(equMorOtherApplyVo.getManagement()))
            throw new FmsServiceException("其他资方抵押资金方不可以是海翼");
        //申请任务
        EquMorTask equMorTask = new EquMorTask();
        equMorTask.setEquMorTaskId(equMorOtherApplyVo.getEquMorTaskId());
        equMorTask.setEquMorTaskNo(equMorOtherApplyVo.getEquMorTaskNo());
        equMorTask.setManagement(equMorOtherApplyVo.getManagement());
        equMorTask.setUpdateTime(equMorOtherApplyVo.getUpdateTime());
        equMorTaskService.modifyEquMorTask(equMorTask);
        //二次提交
        ActEquMorUtils.approvalAgree(equMorOtherApplyVo.getTaskId(),equMorOtherApplyVo.getTaskDefinitionKey()
                ,equMorOtherApplyVo.getMemo(),equMorTask.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   打印海翼申请合同
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 01:48:00
     */
    public String printEquMorChargeSeaWingApply(String equMorTaskNo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
        Example example = SqlUtil.newExample(EquMorDetail.class);
        example.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        EquMorDetail equMorDetail = equMorDetailService.findEquMorDetailByEquMorTaskNo(equMorTaskNo);
        if(equMorDetail == null)
            throw new FmsServiceException("未查询到抵押任务详情");
        //获取合同相关的详情
        EquMorApplyVo equMorApplyVo = findEquMorApplyVoByContNo(equMorDetail.getMainContNo());
        //终端客户业务每期租金
        equMorApplyVo.setContFinRent(equMorApplyVo.getRent());
        //海翼每期租金
        equMorApplyVo.setEquMorRent(equMorDetail.getRent());
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(equMorApplyVo,equMorDetail);
        if(pdfVariables == null)
            throw new FmsServiceException("取值错误,生成合同文件失败");
        //费用合计
        BigDecimal finTotalAmount = new BigDecimal("0");
        //保险费合计
        BigDecimal fin05Amount = new BigDecimal("0");
        int flag=0;
        //其他费用(合计-pdf中显示的所有融资项的和)
        BigDecimal otherFees = new BigDecimal("0");
        int flag2=0;
        for(ContFinDetailVo contFinDetailVo : equMorApplyVo.getContFinDetailVos()){
            pdfVariables.put(contFinDetailVo.getFinItem()+"Name",contFinDetailVo.getFinItemName());
            pdfVariables.put(contFinDetailVo.getFinItem()+"Value",contFinDetailVo.getFinAmount().toString());
            /*finTotalAmount = finTotalAmount.add(contFinDetailVo.getFinAmount());*/
            //合计
            finTotalAmount = contFinDetailVo.getFinAmount();
            /*得到保险费*/
            //保险费
            if(FinItemEnums.INSURANCE.getCode().equals(contFinDetailVo.getFinItem())){
                fin05Amount = fin05Amount.add(contFinDetailVo.getFinAmount());
                flag=1;
            }

            /*得到其他费*/
            //车费
            if(FinItemEnums.CARPRICE.getCode().equals(contFinDetailVo.getFinItem())){
                otherFees = otherFees.add(contFinDetailVo.getFinAmount());
            }
            //购置税
            if(FinItemEnums.PURTAX.getCode().equals(contFinDetailVo.getFinItem())){
                otherFees = otherFees.add(contFinDetailVo.getFinAmount());
            }
            //精品/家装费
            if(FinItemEnums.EXTRA.getCode().equals(contFinDetailVo.getFinItem())){
                otherFees = otherFees.add(contFinDetailVo.getFinAmount());
            }
            //上牌费
            if(FinItemEnums.LICENSE.getCode().equals(contFinDetailVo.getFinItem())){
                otherFees = otherFees.add(contFinDetailVo.getFinAmount());
            }
            //Gps费
            if(FinItemEnums.GPS.getCode().equals(contFinDetailVo.getFinItem())){
                otherFees = otherFees.add(contFinDetailVo.getFinAmount());
            }
            //其他费
            if(FinItemEnums.OTHERS.getCode().equals(contFinDetailVo.getFinItem())){
                flag2=1;
            }
        }
        pdfVariables.put(CommonPropertyConstants.FIN_TOTAL_AMOUNT,finTotalAmount.toString());
        pdfVariables.put(FinItemEnums.INSURANCE.getCode() + "Name",FinItemEnums.INSURANCE.getDesc());
        //保险费
        if(flag==1){
            pdfVariables.put(FinItemEnums.INSURANCE.getCode() + "Value",fin05Amount.toString());
            otherFees = otherFees.add(fin05Amount);
        }else {
            pdfVariables.put(FinItemEnums.INSURANCE.getCode() + "Value","");
        }
        //其他费(合计-pdf中显示的所有融资项的和)
        otherFees = finTotalAmount.subtract(otherFees);
        if(flag2==1){
            pdfVariables.put(FinItemEnums.OTHERS.getCode() + "Value",otherFees.toString());
        }else {
            pdfVariables.put(FinItemEnums.OTHERS.getCode() + "Value","");
        }
        pdfVariables.put(CommonPropertyConstants.NOW_DATE,DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMdd));
        //终端客户尾款比例四位小数保留两位小数然后加上%
        if(equMorApplyVo.getFinalPerc()!=null){
            pdfVariables.put("finalPerc",BigDecimalUtils.getValueDoublePreToStr(equMorApplyVo.getFinalPerc())+"%");
        }
        //合同保证金比例,年利率,尾款比例加上%
        if(equMorDetail.getContractMarginRatio()!=null){
            pdfVariables.put("contractMarginRatio",equMorDetail.getContractMarginRatio().toString()+"%");
        }
        if (equMorDetail.getBalanceAnnualRate()!=null){
            pdfVariables.put("balanceAnnualRate",equMorDetail.getBalanceAnnualRate().toString()+"%");
        }
        if(equMorDetail.getBalanceRatio()!=null){
            pdfVariables.put("balanceRatio",equMorDetail.getBalanceRatio().toString()+"%");
        }
        //输出pdf
        String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.EQU_MOR_SEA_WING_APPLY.getType(), CommonPdfUtils.getEquMorSeaWingApplyCodeValues());
        return filePath;
    }

    /**
     * @Title:
     * @Description:   查询海翼申请明细
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 02:53:02
     */
    public EquMorApplyVo findEquMorApplyVoByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("抵押任务号不能为空");
        EquMorTask equMorTask = equMorTaskService.findEquMorTaskByEquMorTaskNo(equMorTaskNo);
        if(equMorTask == null)
            throw new FmsServiceException("未获取到抵押任务");
        EquMorDetail equMorDetail = equMorDetailService.findEquMorDetailByEquMorTaskNo(equMorTaskNo);
        EquMorApplyVo equMorApplyVo = findEquMorApplyVoByContNo(equMorDetail.getMainContNo());
        equMorApplyVo.setEquMorTaskVo(EntityUtils.getEntity(equMorTask,new EquMorTaskVo()));
        equMorApplyVo.setEquMorDetailVo(EntityUtils.getEntity(equMorDetail,new EquMorDetailVo()));
        return equMorApplyVo;
    }

    private void setEquMorDetailValue(EquMorDetail equMorDetail, EquMorApplyVo equMorApplyVo, String equMorTaskNo){
        //资产抵押任务号
        equMorDetail.setEquMorTaskNo(equMorTaskNo);
        //发动机号
        equMorDetail.setEngineNo(equMorApplyVo.getEngineNo());
        //车架号
        equMorDetail.setVinNo(equMorApplyVo.getVinNo());
        //车牌号
        equMorDetail.setVehicleLicenseNo(equMorApplyVo.getVehicleLicenseNo());
        /*//业务类别
        equMorDetail.setServiceCategory(equMorApplyVo.getLicenseAttr());*/
        //主合同编号
        equMorDetail.setMainContNo(equMorApplyVo.getContNo());
        //初始状态
        equMorDetail.setMortgageStatus(MortgageStatusEnums.EQU_MOR.getStatus());
    }

    /**
     * @Title:  
     * @Description:   验证金额
     * @param equMorDetail
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/06/13 02:07:51
     */
    private String validationAmount(EquMorDetail equMorDetail, EquMorApplyVo equMorApplyVo){
        //金额对比错误提示
        StringBuffer amountErrorInfo = new StringBuffer();

        //计算对比合同保证金
        BigDecimal contMargin = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getContractMarginRatio());
        if(BigDecimalUtils.notEqual(contMargin,equMorDetail.getContMargin()))
            amountErrorInfo.append("合同保证金计算错误,传入" + equMorDetail.getContMargin().toString() + ",后台计算" + contMargin.toString() + ".");

       /* //计算对比合同利息总额
        BigDecimal totalContInterest = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getRegularProgramRate());
        if(BigDecimalUtils.notEqual(totalContInterest,equMorDetail.getTotalContInterest()))
            amountErrorInfo.append("合同利息总额计算错误,传入" + equMorDetail.getTotalContInterest().toString() + ",后台计算" + totalContInterest.toString() + ".");*/

        //计算对比尾款金额
        BigDecimal balanceAmount = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getBalanceRatio());
        if(BigDecimalUtils.notEqual(balanceAmount,equMorDetail.getBalanceAmount()))
            amountErrorInfo.append("尾款金额计算错误,传入" + equMorDetail.getBalanceAmount().toString() + ",后台计算" + balanceAmount.toString() + ".");


        //计算对比每期租金
        BigDecimal rent = getRent(
                equMorDetail.getContAmount(),equMorDetail.getBalanceAmount(),equMorDetail.getPlanRepaymentPeriod()
                ,equMorDetail.getBalanceAnnualRate(),equMorApplyVo.getRepayDay(),equMorApplyVo.getRentPayMode()
        );
        if(BigDecimalUtils.notEqual(rent,equMorDetail.getRent()))
            amountErrorInfo.append("每期租金计算错误,传入" + equMorDetail.getRent().toString() + ",后台计算" + rent.toString() + ".");

        return amountErrorInfo.toString();
    }

    /**
     * @Title:
     * @Description:   暂存验证金额 宽松,没传值则不验证
     * @param equMorDetail
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:07:51
     */
    private String storageValidationAmount(EquMorDetail equMorDetail, EquMorApplyVo equMorApplyVo){

        //金额对比错误提示
        StringBuffer amountErrorInfo = new StringBuffer();
        if(!ObjectUtils.containNull(equMorDetail.getContAmount(), equMorDetail.getContractMarginRatio())) {
            //计算对比合同保证金
            BigDecimal contMargin = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getContractMarginRatio());
            if (BigDecimalUtils.notEqual(contMargin, equMorDetail.getContMargin()))
                amountErrorInfo.append("合同保证金计算错误,传入" + equMorDetail.getContMargin().toString() + ",后台计算" + contMargin.toString() + ".");
        }

       /* if(!ObjectUtils.containNull(equMorDetail.getContAmount(), equMorDetail.getRegularProgramRate())) {
            //计算对比合同利息总额
            BigDecimal totalContInterest = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getRegularProgramRate());
            if (BigDecimalUtils.notEqual(totalContInterest, equMorDetail.getTotalContInterest()))
                amountErrorInfo.append("合同利息总额计算错误,传入" + equMorDetail.getTotalContInterest().toString() + ",后台计算" + totalContInterest.toString() + ".");
        }*/

        if(!ObjectUtils.containNull(equMorDetail.getContAmount(), equMorDetail.getBalanceRatio())) {
            //计算对比尾款金额
            BigDecimal balanceAmount = BigDecimalUtils.multiplyRoundUp(equMorDetail.getContAmount(), equMorDetail.getBalanceRatio());
            if (BigDecimalUtils.notEqual(balanceAmount, equMorDetail.getBalanceAmount()))
                amountErrorInfo.append("尾款金额计算错误,传入" + equMorDetail.getBalanceAmount().toString() + ",后台计算" + balanceAmount.toString() + ".");
        }

        if(!ObjectUtils.containNull(equMorDetail.getRent(),equMorDetail.getContAmount(),equMorDetail.getBalanceAmount(),equMorDetail.getPlanRepaymentPeriod()
                ,equMorDetail.getBalanceAnnualRate())  && equMorDetail.getPlanRepaymentPeriod() > 0 ) {
            //计算对比每期租金
            BigDecimal rent = getRent(
                    equMorDetail.getContAmount(), equMorDetail.getBalanceAmount(), equMorDetail.getPlanRepaymentPeriod()
                    , equMorDetail.getBalanceAnnualRate(), equMorApplyVo.getRepayDay(), equMorApplyVo.getRentPayMode()
            );
            if (BigDecimalUtils.notEqual(rent, equMorDetail.getRent()))
                amountErrorInfo.append("每期租金计算错误,传入" + equMorDetail.getRent().toString() + ",后台计算" + rent.toString() + ".");
        }

        return amountErrorInfo.toString();
    }


    /**
     * @Title:
     * @Description:   返回serviceName
     * @param equMorTask
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:04:07
     */
    private String getServiceName(EquMorTask equMorTask){
        String serviceName = null;
        if(MortgageProcessEnums.EQU_MOR.getType().equals(equMorTask.getMortgageProcess()))
            serviceName = MortgageProcessEnums.EQU_MOR.getDesc();
        else if(MortgageProcessEnums.EQU_MOR_PAY.getType().equals(equMorTask.getMortgageProcess()))
            serviceName = MortgageProcessEnums.EQU_MOR_PAY.getDesc();
        else
            throw new FmsServiceException("抵押流程错误");
        return serviceName;
    }

    /**
     * @Title:
     * @Description:   启动流程
     * @param serviceId 业务id
     * @param serviceType 业务类型
     * @param serviceName 业务名称
     * @param mortgageProcess 流程类型
     * @param submit 是否提交
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:03:27
     */
    private ActRuTaskVo startProcess(String serviceId,String serviceType,String serviceName,String mortgageProcess,String memo,boolean submit){
        //启动工作流
        if(MortgageProcessEnums.EQU_MOR.getType().equals(mortgageProcess)) {
            ActRuTaskVo actRuTaskVo = ActEquMorUtils.start(serviceId, serviceType, serviceName, ActProcessInstanceKeyEnums.EQU_MORTGAGE.getKey(), memo, submit);
            return actRuTaskVo;
        }
        else if(MortgageProcessEnums.EQU_MOR_PAY.getType().equals(mortgageProcess)) {
            ActRuTaskVo actRuTaskVo = ActEquMorUtils.start(serviceId, serviceType, serviceName, ActProcessInstanceKeyEnums.EQU_MORTGAGE_PAY.getKey(), memo, submit);
            return actRuTaskVo;
        }
        else
            throw new FmsServiceException("不存在该流程");

    }



    /**
     * @param equMorApplyVo
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @Title:
     * @Description: 分页查询资方抵押申请vos
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    public PageInfoExtend<EquMorApplyVo> findEquMorApplyVosByPage(EquMorApplyVo equMorApplyVo) {
        equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        equMorApplyVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMddHHmmss));
        if(StringUtils.isNotTrimBlank(equMorApplyVo.getContNo()))
            equMorApplyVo.setContNo(SqlUtil.likePattern(equMorApplyVo.getContNo()));
        else
            equMorApplyVo.setContNo(null);
        //车架号
        if(StringUtils.isNotTrimBlank(equMorApplyVo.getVinNo()))
            equMorApplyVo.setVinNo(SqlUtil.likePattern(equMorApplyVo.getVinNo()));
        else
            equMorApplyVo.setVinNo(null);

        //承租人
        if(StringUtils.isTrimBlank(equMorApplyVo.getLessee()))
            equMorApplyVo.setLessee(null);
        else
            equMorApplyVo.setLessee(SqlUtil.likePattern(equMorApplyVo.getLessee()));

        //出租人区域
        if(StringUtils.isTrimBlank(equMorApplyVo.getGroupDistrict()))
            equMorApplyVo.setGroupDistrict(null);
        else
            equMorApplyVo.setGroupDistrict(SqlUtil.likePattern(equMorApplyVo.getGroupDistrict()));

        //融资期限
        if(StringUtils.isTrimBlank(equMorApplyVo.getFinPeriodType()))
            equMorApplyVo.setFinPeriodType(null);
        else
            equMorApplyVo.setFinPeriodType(equMorApplyVo.getFinPeriodType());

        //申请类型
        if(StringUtils.isTrimBlank(equMorApplyVo.getCompanyType1()))
            equMorApplyVo.setCompanyType1(null);
        else
            equMorApplyVo.setCompanyType1(equMorApplyVo.getCompanyType1());

        //抵押状态
        if(StringUtils.isTrimBlank(equMorApplyVo.getMortgageStatus()))
            equMorApplyVo.setMortgageStatus(null);
        else
            equMorApplyVo.setMortgageStatus(equMorApplyVo.getMortgageStatus());

        //资方
        if(StringUtils.isTrimBlank(equMorApplyVo.getManagement()))
            equMorApplyVo.setManagement(null);
        else
            equMorApplyVo.setManagement(equMorApplyVo.getManagement());
        
        //合同生效日期区间(起始)
        if(StringUtils.isTrimBlank(equMorApplyVo.getValidStartTime()))
            equMorApplyVo.setValidStartTime(null);
        else
            equMorApplyVo.setValidStartTime(equMorApplyVo.getValidStartTime());
        //合同生效日期区间(结束)
        if(StringUtils.isTrimBlank(equMorApplyVo.getValidEndTime()))
            equMorApplyVo.setValidEndTime(null);
        else
            equMorApplyVo.setValidEndTime(equMorApplyVo.getValidEndTime());
        PageInfoExtend<EquMorApplyVo> pageInfo = equMorChargeRepository.selectListVoByPage("selectEquMorApplyVos", equMorApplyVo, equMorApplyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 根据任务号返回资方抵押申请列表
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 14:55
     */
    public EquMorTaskVo findEquMorTaskVoByEquMorTaskNo(String equMorTaskNo){
        if(StringUtils.isNotTrimBlank(equMorTaskNo)){
            EquMorTask equMorTask = equMorTaskService.findEquMorTaskByEquMorTaskNo(equMorTaskNo);
            if(equMorTask != null){
                EquMorTaskVo equMorTaskVo = EntityUtils.getEntity(equMorTask,new EquMorTaskVo());
                EquMorApplyVo equMorApplyVo = new EquMorApplyVo();
                equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
                equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
                equMorApplyVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
                /*equMorApplyVo.setMortgageStatus(MortgageStatusEnums.CANCEL.getStatus());*/
                equMorApplyVo.setEquMorTaskNo(equMorTaskNo);
                equMorTaskVo.setEquMorApplyVos(equMorChargeRepository.selectEquMorApplyVos(equMorApplyVo));
                return equMorTaskVo;
            }
        }
        return null;
    }

    /**
     * @param contNo
     * @return
     * @throws
     * @Title:
     * @Description: 根据合同号 查询资方抵押合同详细信息
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    public EquMorApplyVo findEquMorApplyVoByContNo(String contNo) {
        if (StringUtils.isNotTrimBlank(contNo)) {
            EquMorApplyVo equMorApplyVo = new EquMorApplyVo();
            //扣款状态为待扣款
            equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            //申请类型，个人，用于判断
            equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
            //抵押状态不能为取消
            equMorApplyVo.setMortgageStatus(MortgageStatusEnums.CANCEL.getStatus());
            //合同号
            equMorApplyVo.setContNo(contNo);
            //还款日期应当大于当日
            equMorApplyVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
            //查询
            equMorApplyVo = equMorChargeRepository.selectEquMorApplyVoByContNo(equMorApplyVo);
            if (equMorApplyVo != null) {
                //查询合同融资项目
                List<ContFinDetailVo> contFinDetailVos = null;
                try {
                    contFinDetailVos = ResponseEntityUtils.getRestResponseData(contFinDetailRpc.findContFinDetailVosByContNo(contNo));
                } catch (FmsRpcException e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                    throw new FmsServiceException("查询合同融资项目信息失败");
                }
                if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetailVos)) {
                    //计算合计,并存入集合中
                    BigDecimal finTotalAmount = ContFinDetailUtils.getFinTotalAmount(contFinDetailVos);
                    if (finTotalAmount != null) {
                        ContFinDetailVo contFinDetailVo = new ContFinDetailVo();
                        contFinDetailVo.setFinItemName(CommonPropertyConstants.TOTAL_CHINESE);
                        contFinDetailVo.setFinAmount(finTotalAmount);
                        contFinDetailVos.add(contFinDetailVo);
                    }
                    equMorApplyVo.setContFinDetailVos(contFinDetailVos);
                }
            }
            return equMorApplyVo;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   根据合同号集合 查询详细信息列表
     * @param contNos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 10:31:47
     */
    public List<EquMorApplyVo> findEquMorChargeApplyVosByContNos(List<String> contNos){
        if(ArrayUtils.isNotNullAndLengthNotZero(contNos)){
            EquMorApplyVo equMorApplyVo = new EquMorApplyVo();
            equMorApplyVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
            equMorApplyVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
            equMorApplyVo.setMortgageStatus(MortgageStatusEnums.CANCEL.getStatus());
            equMorApplyVo.setContNos(contNos);
            equMorApplyVo.setRepayDateStr(DateUtils.getNowDateStr(DateUtils.formatStr_yyyyMMdd));
            List<EquMorApplyVo> equMorApplyVos = equMorChargeRepository.selectEquMorApplyVosByContNos(equMorApplyVo);
            return equMorApplyVos;
        }
        return null;
    }

    /**
     * @param equMorDetailVo 抵押明细 提供给前台使用
     * @return
     * @throws
     * @Title:
     * @Description: 返回每期租金
     * @author qiaomengnan
     * @date 2018/06/04 04:04:08
     */
    public BigDecimal findRent(EquMorDetailVo equMorDetailVo) {
        return getRent(equMorDetailVo.getContAmount(),
                equMorDetailVo.getBalanceAmount(),equMorDetailVo.getPlanRepaymentPeriod()
                ,equMorDetailVo.getBalanceAnnualRate()
                ,equMorDetailVo.getRepayDay(),equMorDetailVo.getRentPayMode());
    }



    /**
     * @Title:
     * @Description: 计算每日租金
     * @param contAmount 合同金额
     * @param balanceAmount 尾款金额
     * @param planRepaymentPeriod 计划还款期次
     * @param balanceAnnualRate  尾款年利率
     * @param repayDay    还款日
     * @param rentPayMode 租金支付模式
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 02:25:42
     */
    private BigDecimal getRent(BigDecimal contAmount,BigDecimal balanceAmount,
                               Integer planRepaymentPeriod,BigDecimal balanceAnnualRate,String repayDay,String rentPayMode){
        if(planRepaymentPeriod == null || planRepaymentPeriod == 0)
            return BigDecimal.ZERO;
        //还款频率
        String repayRate = null;
        //还款方式
        String repayMode = null;
        try {
            repayRate = ResponseEntityUtils.getRestResponseData(sysParamRpc.findSysParamByParamKey(CommonParamConstants.REPAY_RATE));
            repayMode = ResponseEntityUtils.getRestResponseData(sysParamRpc.findSysParamByParamKey(CommonParamConstants.REPAY_MODE));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("系统常量取值失败");
        }
        if (StringUtils.isNotTrimBlank(repayRate, repayMode)) {
            if (!ObjectUtils.containNull(contAmount, balanceAmount, planRepaymentPeriod, balanceAnnualRate)
                    && StringUtils.isNotTrimBlank(repayRate, repayMode, repayDay, rentPayMode)
                    ) {
                String[][] result = Financials.findmyrepaymentplan(contAmount, balanceAmount, planRepaymentPeriod + "", repayRate, BigDecimalUtils.dividePercent(balanceAnnualRate) , repayMode, repayDay, rentPayMode);
                if (result != null && ArrayUtils.isNotNullAndLengthNotZero(result) && ArrayUtils.isNotNullAndLengthNotZero(result[0]))
                    return new BigDecimal(result[0][0]).setScale(0, BigDecimal.ROUND_UP);
            }
        }
        return null;
    }



    /**
     * @Title:
     * @Description:   退回操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @Transactional
    public void equMorApplyReturn(EquMorApplyTaskVo equMorApplyTaskVo){
        ActEquMorUtils.approvalReturnSuperior(equMorApplyTaskVo.getTaskId(),
                equMorApplyTaskVo.getTaskDefinitionKey(),
                equMorApplyTaskVo.getMemo(),
                equMorApplyTaskVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   通过操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @Transactional
    public void equMorApplyAgree(EquMorApplyTaskVo equMorApplyTaskVo){
        ActEquMorUtils.approvalAgree(equMorApplyTaskVo.getTaskId(),
                equMorApplyTaskVo.getTaskDefinitionKey(),
                equMorApplyTaskVo.getMemo(),
                equMorApplyTaskVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description:   取消操作
     * @param EquMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @Transactional
    public void equMorApplyCancel(EquMorApplyTaskVo EquMorApplyTaskVo){
        //将归档明细抵押状态设置为取消
        equMorDetailService.modifyCancelStatusByEquMorTaskNo(EquMorApplyTaskVo.getEquMorTaskNo());
        //工作流取消
        ActEquMorUtils.approvalCancel(EquMorApplyTaskVo.getTaskId(),
                EquMorApplyTaskVo.getTaskDefinitionKey(),
                EquMorApplyTaskVo.getMemo(),
                EquMorApplyTaskVo.getEquMorTaskNo());
    }

    /**
     * @Title:
     * @Description: 资方抵押付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public String printEquMor(EquMorChargeFinTouchingPrintVo equMorChargeFinTouchingPrintVo){
        if(equMorChargeFinTouchingPrintVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(equMorChargeFinTouchingPrintVo.getBasBankInfoVo() == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(equMorChargeFinTouchingPrintVo.getEquMorCharge() == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(equMorChargeFinTouchingPrintVo.getEquMorDetailVos() == null){
            throw new FmsServiceException("未找到相关数据");
        }
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(equMorChargeFinTouchingPrintVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        //付款金额合计
        if(equMorChargeFinTouchingPrintVo.getEquMorCharge().getTotalShouldPay()!=null){
            pdfVariables.put("totalShouldPay", StringUtils.defaultString(equMorChargeFinTouchingPrintVo.getEquMorCharge().getTotalShouldPay().toString()));
        }
        //收款金额合计
        if(equMorChargeFinTouchingPrintVo.getEquMorCharge().getFinShouldReceive()!=null){
            pdfVariables.put("finShouldReceive", StringUtils.defaultString(equMorChargeFinTouchingPrintVo.getEquMorCharge().getFinShouldReceive().toString()));
        }

        pdfVariables.put("accountName", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccountName());
        pdfVariables.put("accountNo", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccountNo());
        if(equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccBankName()!=null&&equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccBranchBank()!=null){
            pdfVariables.put("accBranchBank", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccBankName()+" "+equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getAccBranchBank());
        }
        pdfVariables.put("recAccBranch", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getRecAccEquBank()+" "+equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getRecAccBank());
        pdfVariables.put("recAccountName", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getRecAccountName());
        pdfVariables.put("recAccountNo", equMorChargeFinTouchingPrintVo.getBasBankInfoVo().getRecAccountNo());

        //pdfVo封装pdf附件中客户相关信息
        PdfCreateVo pdfCreateVo=new PdfCreateVo();
        //pdf附件每页显示客户信息条数
        pdfCreateVo.setPageSize(30);
        // 附件信息(客户信息相关键值对)
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < equMorChargeFinTouchingPrintVo.getEquMorDetailVos().size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no", i + 1);
            jsonObject.put("chuzu", equMorChargeFinTouchingPrintVo.getEquMorDetailVos().get(i).getLessor());
            jsonObject.put("chengzu", equMorChargeFinTouchingPrintVo.getEquMorDetailVos().get(i).getLessee());
            jsonObject.put("chejiahao", equMorChargeFinTouchingPrintVo.getEquMorDetailVos().get(i).getVinNo());
            jsonArray.add(jsonObject);
        }
        pdfCreateVo.setFjDataArray(jsonArray);
        //输出pdf
        String filePath = commonPdfService.createWithFj(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_EQU_MOR.getType(),TplTypeKeyEnums.WL_PAYMENT_FJ.getType(),pdfCreateVo);
        return filePath;
    }
}
