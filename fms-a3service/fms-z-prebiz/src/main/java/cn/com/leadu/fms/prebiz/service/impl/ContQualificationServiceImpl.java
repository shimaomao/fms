package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by yyq on 2018/5/24.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.contQualification.ContQualificationVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.prebiz.service.ContQualificationService;
import cn.com.leadu.fms.prebiz.service.ContractService;
import cn.com.leadu.fms.prebiz.service.ContractVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;

/**
 * @program: fms
 * @description: 合同资管审批核查
 * @author: yangyiquan
 * @create: 2018-05-24 16:06
 **/
@Slf4j
@Service
public class ContQualificationServiceImpl implements ContQualificationService {



    /**
     * @Fields  : 合同信息业务层
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  : 审批日志业务层
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 客户还款计划表Repository层
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 合同融资信息Repository层
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : 合同车辆业务层
     */
    @Autowired
    private ContractVehicleService contractVehicleService;

    /**
     * pdf模板service
     */
    @Autowired
    private CommonPdfService commonPdfService;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @param contQualificationVo
     * @Description: 合同资管审批通过
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/24 16:06
     */
    @Override
    @Transactional
    public void approve(ContQualificationVo contQualificationVo) {
        //删除原先还款计划表
//        Example example = SqlUtil.newExample(ContRepaySked.class);
//        example.createCriteria().andEqualTo("contNo", contQualificationVo.getContNo());
//        contRepaySkedRepository.deleteExampleData(example,new ContRepaySked());
        //生成还款计划表
//        List<ContRepaySked> contRepaySkedList = this.saveContRepaySked(contQualificationVo.getContNo());

        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contQualificationVo.getTaskId());
        //共通操作
        contPrintCommon(contQualificationVo, ActTypeEnums.APPROVAL.getType(),actRuTaskVo);

    }

    /**
     * @param contQualificationVo
     * @Description: 合同资管审批退回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/24 16:07
     */
    @Override
    @Transactional
    public void sendBack(ContQualificationVo contQualificationVo) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contQualificationVo.getTaskId());
        //共通操作
        contPrintCommon(contQualificationVo, SENDBACK.getType(),actRuTaskVo);
    }


    /*
     *风控审核共通操作：更新订单状态、审批日志录入
     */
    private void contPrintCommon(ContQualificationVo contQualificationVo, String act, ActRuTaskVo actRuTaskVo) {
        //获取合同编号
        String contNo = contQualificationVo.getContNo();

        //根据合同编号取得订单信息
        Contract contract = contractService.findContractByContractNo(contNo);
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        //更新合同状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        Contract contractUpd = new Contract();
        //当前节点用户
        contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        contractUpd.setBizStatus(contractBizStatusUpd);
        contractService.updateContractByContractId(contractUpd, contract.getContractId());

        //审批日志登录
        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contQualificationVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contQualificationVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(contQualificationVo.getApplyNo());
        workflowLog.setWfLogSubNo(contQualificationVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLog.setCodeType1(contQualificationVo.getBackReasonKey());
        workflowLog.setCodeValue1(contQualificationVo.getBackReason());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
