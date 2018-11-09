package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContractCancelRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.CONTRACT_NUM_TYPE;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

/**
 * Created by yanfengbo
 * 融资合同取消
 */
@Service
public class ContractCancelServiceImpl implements ContractCancelService {
    /*
        融资申请合同repository
     */
    @Autowired
    private ContractCancelRepository contractCancelRepository;


    /*
        合同信息service
     */
    @Autowired
    private ContractService contractService;

    //日志
    @Autowired
    private WorkflowLogService workflowLogService;

    //业务状态管理
    @Autowired
    private BizActStatusService bizActStatusService;

    public PageInfoExtend<ContractCancelVo> findContractCancelsByPage(ContractCancelVo contractCancelVo, SysUser sysUser) {


        //当前登录用户
        if (StringUtils.isTrimBlank(sysUser))
            contractCancelVo.setLoginUser(null);
        else
            contractCancelVo.setLoginUser(sysUser.getUser());

        //合同编号
        if (StringUtils.isTrimBlank(contractCancelVo.getContNo()))
            contractCancelVo.setContNo(null);
        else
            contractCancelVo.setContNo(contractCancelVo.getContNo());

        //申请姓名
        if (StringUtils.isTrimBlank(contractCancelVo.getName()))
            contractCancelVo.setName(null);
        else
            contractCancelVo.setName(SqlUtil.likePattern(contractCancelVo.getName()));

        //合同申请状态
        if (StringUtils.isTrimBlank(contractCancelVo.getBizStatus()))
            contractCancelVo.setBizStatus(null);
        else
            contractCancelVo.setBizStatus(contractCancelVo.getBizStatus());

        PageInfoExtend<ContractCancelVo> pageInfo = contractCancelRepository.selectListVoByPage("selectContractCancelByPage", contractCancelVo, contractCancelVo.getPageQuery());

        for (ContractCancelVo contractCancelVo1 : pageInfo.getData()) {

            //申请姓名
            if (StringUtils.isNotTrimBlank(contractCancelVo1.getPersonName())) {
                contractCancelVo1.setName(contractCancelVo1.getPersonName());
            }

            if (StringUtils.isNotTrimBlank(contractCancelVo1.getCompanyName())) {
                contractCancelVo1.setName(contractCancelVo1.getCompanyName());
            }

            //证件号码
            if (StringUtils.isNotTrimBlank(contractCancelVo1.getPersonCertifNo())) {
                contractCancelVo1.setCertifNo(contractCancelVo1.getPersonCertifNo());
            }

            if (StringUtils.isNotTrimBlank(contractCancelVo1.getCompanyCertifNo())) {
                contractCancelVo1.setCertifNo(contractCancelVo1.getCompanyCertifNo());
            }
        }
        return pageInfo;
    }

    /**
     * @param contNo
     * @return ContractCancelVo
     * @throws
     * @Title:
     * @Description: 根据contNo获取融资合同取消
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ContractCancelVo findContractCancelVoByContNo(String contNo) {
        if (StringUtils.isTrimBlank(contNo))
            contNo = null;
        else
            contNo = contNo;
        ContractCancelVo contractCancelVo = contractCancelRepository.selectContractCancelVoByContNo(contNo);

        //申请姓名
        if (StringUtils.isNotTrimBlank(contractCancelVo.getPersonName())) {
            contractCancelVo.setName(contractCancelVo.getPersonName());
        }

        if (StringUtils.isNotTrimBlank(contractCancelVo.getCompanyName())) {
            contractCancelVo.setName(contractCancelVo.getCompanyName());
        }

        return contractCancelVo;
    }


    /**
     * @param contractCancelVo
     * @return
     * @throws
     * @Title:
     * @Description: 融资合同取消, 并插入日志
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Transactional
    public void modifyContractCancel(ContractCancelVo contractCancelVo, SysUser sysUser) {
        //根据合同编号取得合同信息
        Contract contract = contractService.findContractByContractNo(contractCancelVo.getContNo());
        if(contract == null){
            throw new FmsServiceException( "合同信息不存在");
        }
        if(StringUtils.isNotTrimBlank(contractCancelVo.getBizStatus()) && StringUtils.notEquals(contract.getBizStatus(),contractCancelVo.getBizStatus())){
            throw new FmsServiceException( "合同状态已变更，您已无权操作");
        }

        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.applyContCancel(contractCancelVo.getApplyNo(), contractCancelVo.getContNo());

        //更新合同状态
        String contractBizStatusUpd = BizStatusEnums.CONTRACT_CANCEL.getType();
        contract.setBizStatus(contractBizStatusUpd);
        contract.setPresentUser(actRuTaskVo.getNextAssignee());
        contractService.updateContractByContractId(contract,contract.getContractId());

        //审批日志插入
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        //订单编号apply_no
        workflowLog.setWfLogNo(contractCancelVo.getApplyNo());
        //合同编号cont_no
        workflowLog.setWfLogSubNo(contractCancelVo.getContNo());
        //操作人账号user
        workflowLog.setUser(sysUser.getUser());
        //操作act_widget_id
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        //操作分类act_type
        workflowLog.setActType(ActTypeEnums.CANCEL.getType());
        //操作后状态status
        workflowLog.setStatus(contractBizStatusUpd);
        //备注分类类型1 code_type1
        workflowLog.setCodeType1(contractCancelVo.getContractCancelReasonKey());
        //备注分类值1 code_value1
        workflowLog.setCodeValue1(contractCancelVo.getContractCancelReason());
        //备注内容1 remark1
        workflowLog.setRemark1(contractCancelVo.getCancelRemark());
        workflowLogService.insertWorkFlowLog(workflowLog);

//        throw new FmsServiceException("111");
    }
}
