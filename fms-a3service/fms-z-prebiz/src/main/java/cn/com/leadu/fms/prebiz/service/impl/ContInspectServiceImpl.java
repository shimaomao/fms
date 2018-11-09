package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PaymentTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.continspect.ContInspectVo;
import cn.com.leadu.fms.prebiz.service.ContInspectService;
import cn.com.leadu.fms.prebiz.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同文件核查业务实现层
 * @date 2018-03-23
 */
@Service
public class ContInspectServiceImpl implements ContInspectService {

    /**
     * @Fields  :
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  :
     */
    @Autowired
    private BizActStatusService bizActStatusService;

    /**
     * @Fields  :
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  :
     */
    @Autowired
    private ContPayServiceImpl contPayService;

    /**
     * @Title:
     * @Description: 文件审核通过
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:39
     */
    @Override
    @Transactional
    public void approval(ContInspectVo contInspectVo){

        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contInspectVo.getTaskId());

        //生成财务待付款数据
        contInspectCommon(contInspectVo, APPROVAL.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  contInspectVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:38
     */
    @Override
    @Transactional
    public void sendBack(ContInspectVo contInspectVo){

        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contInspectVo.getTaskId());

        contInspectCommon(contInspectVo, SENDBACK.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 退回经销商
     * @param:  contInspectVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:38
     */
    @Override
    @Transactional
    public void sendBackTop(ContInspectVo contInspectVo){
        contInspectCommon(contInspectVo, SENDBACKTOP.getType(), null);
        //流程引擎
    }

    /*
     *风控审核共通操作：更新订单状态、审批日志录入
     */
    @Transactional
    private void contInspectCommon(ContInspectVo contInspectVo, String act, ActRuTaskVo actRuTaskVo) {
        //根据合同编号更新合同状态
        String contNo = contInspectVo.getContNo();
        if(APPROVAL.getType().equals(act)){
            //保存财务付款信息
            ContPay contPay = new ContPay();
            contPay.setBizCode(contInspectVo.getContNo());
            contPay.setPaymentType(PaymentTypeEnums.CONTREQUEST.getType());
            contPay.setPayStatus(PayStatusEnums.CONFIRM.getType());
            contPayService.updateContPayByBizCodeAndPaymentType(contPay);
        }

        //根据合同编号取得订单信息
        Contract contract = contractService.findContractByContractNo(contInspectVo.getContNo());
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        //更新合同状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(contractBizStatusUpd)){
            throw new FmsServiceException( "合同状态取得失败");
        }
        Contract contractUpd = new Contract();
        contractUpd.setBizStatus(contractBizStatusUpd);
        contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        contractService.updateContractByContractId(contractUpd, contract.getContractId());

        //审批日志登录
        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contInspectVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInspectVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contInspectVo.getApplyNo());
        workflowLog.setWfLogSubNo(contInspectVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLog.setCodeType1(contInspectVo.getContInspectReasonKey());
        workflowLog.setCodeValue1(contInspectVo.getContInspectReason());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
}