package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.prebiz.repository.ApplyFinDetailRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.finance.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.finance.rpc.baseinfo.BasRepayRuleRpc;
import cn.com.leadu.fms.finance.rpc.system.SysParamRpc;
import cn.com.leadu.fms.finance.service.ContPaymentService;
import cn.com.leadu.fms.finance.service.FinBackfillService;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同生成前确认业务实现层
 * @date 2018-03-23
 */
@Service
public class ContPaymentServiceImpl implements ContPaymentService {
    /**
     * @Fields  :
     */
    @Autowired
    private BizActStatusService bizActStatusService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;
    /**
     * @Fields  :
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  :
     */
    @Autowired
    private BasRepayRuleRpc basRepayRuleRpc;

    /**
     * @Fields  :资料邮寄附件Repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  :资料邮寄附件详情Repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  :合同Repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  :融资费用明细信息Repository
     */
    @Autowired
    private ApplyFinDetailRepository applyFinDetailRepository;

    /**
     * @Fields  :融资回填明细信息Repository
     */
    @Autowired
    private FinBackfillDetailRepository finBackfillDetailRepository;

    /**
     * @Fields  :融资回填信息Repository
     */
    @Autowired
    private FinBackfillRepository finBackfillRepository;

    /**
     * @Fields  :系统常量rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  :系统常量rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    /**
     * @Fields  :
     */
    @Autowired
    private FinBackfillService finBackfillService;

    /*
    *
    *
    *
    * */
    @Override
    @Transactional
    public void submit(ContPaymentVo contPaymentVo){
        //生成还款计划表
//        saveContRepaySked(contPaymentVo.getContNo());

        //保存邮寄附件信息
//        saveOrigFile(contPaymentVo);

        //生成待回填数据
//        saveBackFill(contPaymentVo);

        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(contPaymentVo.getTaskId());

        contPaymentCommon(contPaymentVo, ActTypeEnums.SUBMIT.getType(), actRuTaskVo);
    }


    /**
     * @Title:
     * @Description: 退回
     * @param: contPaymentVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:40
     */
    @Override
    @Transactional
    public void sendBack(ContPaymentVo contPaymentVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(contPaymentVo.getTaskId());

        contPaymentCommon(contPaymentVo, ActTypeEnums.SENDBACK.getType(), actRuTaskVo);

    }

    /*
     *风控审核共通操作：更新订单状态、审批日志录入
     */
    @Transactional
    private void contPaymentCommon(ContPaymentVo contPaymentVo, String act, ActRuTaskVo actRuTaskVo) {
        //根据合同编号更新合同状态
        String contNo = contPaymentVo.getContNo();

        //根据合同编号取得订单信息
        Example example = SqlUtil.newExample(Contract.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        Contract contract = contractRepository.selectOneByExample(example);

        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        //更新合同状态
        String contractBizStatusUpd = bizActStatusService.getAftStsByActIdAndBef(
                RequestUtils.getRequestUri(), contract.getBizStatus(), CONTRACT_NUM_TYPE.getType());
        if(StringUtils.isTrimBlank(contractBizStatusUpd)){
            throw new FmsServiceException( "合同状态取得失败");
        }
        Contract contractUpd = new Contract();
        contractUpd.setContractId(contract.getContractId());
        contractUpd.setBizStatus(contractBizStatusUpd);
        contractUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        contractUpd.setContractValidDate(DateUtils.getNowDate());
        if(ActTypeEnums.SUBMIT.getType().equals(act)){
            contractUpd.setContractValidDate(DateUtils.getNowDate());
        }
        contractRepository.updateByPrimaryKeySelectiveData(contractUpd);

        //审批日志登录
        //合同日志录入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(contPaymentVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contPaymentVo.getRemark1());
        workflowLog.setWfLogNo(contPaymentVo.getApplyNo());
        workflowLog.setWfLogSubNo(contPaymentVo.getContNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLog.setCodeType1(contPaymentVo.getContPaymentReasonKey());
        workflowLog.setCodeValue1(contPaymentVo.getContPaymentReason());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}