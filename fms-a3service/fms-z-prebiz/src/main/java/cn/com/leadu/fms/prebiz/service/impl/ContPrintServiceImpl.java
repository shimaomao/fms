package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contprint.ContPrintVo;
import cn.com.leadu.fms.prebiz.service.ContPrintService;
import cn.com.leadu.fms.prebiz.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同生成前确认业务实现层
 * @date 2018-03-23
 */
@Service
public class ContPrintServiceImpl implements ContPrintService {

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

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:  
     * @Description: 打印完成
     * @param: contPrintVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/4/17  21:35
     */
    @Override
    @Transactional
    public void print(ContPrintVo contPrintVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contPrintVo.getTaskId());

        contPrintCommon(contPrintVo, SUBMIT.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param:  contPrintVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:35
     */
    @Override
    @Transactional
    public void sendBack(ContPrintVo contPrintVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contPrintVo.getTaskId());

        contPrintCommon(contPrintVo, SENDBACK.getType(),actRuTaskVo);
    }

    /*
     *风控审核共通操作：更新订单状态、审批日志录入
     */
    private void contPrintCommon(ContPrintVo contPrintVo, String act, ActRuTaskVo actRuTaskVo) {
        //根据合同编号更新合同状态
        String contNo = contPrintVo.getContNo();

        //根据合同编号取得订单信息
        Contract contract = contractService.findContractByContractNo(contPrintVo.getContNo());
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
        if(SUBMIT.getType().equals(act)){
            contractUpd.setContractPrintDate(DateUtils.getNowDate());
        }
        contractService.updateContractByContractId(contractUpd, contract.getContractId());

        //审批日志登录
        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contPrintVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contPrintVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contPrintVo.getApplyNo());
        workflowLog.setWfLogSubNo(contPrintVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * 获取合同打印附件列表
     * @param contNo
     * @return
     */
    @Override
    public CommonBizFilesVo getContPrintFileList(String contNo){
        Contract contract = contractService.findContractByContractNo(contNo);
        if(StringUtils.isTrimBlank(contract.getContractFileType())){
            throw new FmsServiceException("未获取到合同模板类型!");
        }
        return bizFilesService.findBizFilesByBizCode(contNo, contract.getContractFileType());
    }
}