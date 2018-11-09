package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContPrepaymentUtils;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.service.ContPrepaymentAutoJobService;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentModifyVo;
import cn.com.leadu.fms.data.cost.repository.ContPrepaymentRepository;
import cn.com.leadu.fms.data.prebiz.repository.WorkflowLogRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: fms
 * @description: 提前还款自动任务service
 * @author: yangyiquan
 * @create: 2018-10-24 16:37
 **/
@Slf4j
@Service
public class ContPrepaymentAutoJobServiceImpl implements ContPrepaymentAutoJobService{
    /**
     * @Fields  : 提前还款repository
     */
    @Autowired
    private ContPrepaymentRepository contPrepaymentRepository;

    /**
     * @Fields  : 审批日志Repository层
     */
    @Autowired
    private WorkflowLogRepository workflowLogRepository;

    /**
    * @Description: 提前还款自动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/24 16:38
    */
    @Override
    @Transactional
    public void autoCancelPrepayment() {
        List<ContPrepaymentVo> contPrepaymentVoList =
                contPrepaymentRepository.selectInValidContPrepayment(PaymentStsEnums.UNCLEARED.getType(), BizStatusEnums.CONT_PREPAYMENT_INVALID.getType(),BizStatusEnums.PREPAYMENT_VALID.getType());
        cancelContPrepayment(contPrepaymentVoList,"提前还款超时自动取消");

    }

    /**
    * @Description: 提前还款手动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 17:59
    */
    @Override
    @Transactional
    public void manualCancelPrepayment(ContPrepaymentVo contPrepaymentVo) {
        if (StringUtils.isTrimBlank(contPrepaymentVo.getContPrepaymentId())) {
            throw new FmsServiceException("未获取到id，无法取消");
        }
        if (StringUtils.isTrimBlank(contPrepaymentVo.getContPrepaymentNo())) {
            throw new FmsServiceException("未获取到提前还款任务号，无法取消");
        }
        List<ContPrepaymentVo> contPrepaymentVoList = new ArrayList<>();
        contPrepaymentVoList.add(contPrepaymentVo);
        cancelContPrepayment(contPrepaymentVoList,contPrepaymentVo.getMemo());
    }

    /**
    * @Description: 提前还款取消
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 15:57
    */
    private void cancelContPrepayment(List<ContPrepaymentVo> contPrepaymentVoList,String remark) {
        if (ArrayUtils.isNotNullAndLengthNotZero(contPrepaymentVoList)) {
            List<ContPrepayment> contPrepaymentList = new ArrayList<>();
            List<WorkflowLog> workflowLogList = new ArrayList<>();
            for (ContPrepaymentVo contPrepaymentVo : contPrepaymentVoList) {
                //调用工作流结束流程
                ActRuTaskVo actRuTaskVo = ActContPrepaymentUtils.overInstances(contPrepaymentVo.getContPrepaymentNo(),remark);
                //更新状态
                ContPrepayment contPrepayment = new ContPrepayment();
                contPrepayment.setContPrepaymentId(contPrepaymentVo.getContPrepaymentId());
                //状态=作废
                contPrepayment.setPrepaymentSts(BizStatusEnums.CONT_PREPAYMENT_INVALID.getType());
                //当前节点用户
                contPrepayment.setPresentUser(actRuTaskVo.getNextAssignee());
                //当前更新时间
                contPrepayment.setUpdateTime(contPrepaymentVo.getUpdateTime());
                contPrepaymentList.add(contPrepayment);
                //审批日志登录
                WorkflowLog workflowLog = new WorkflowLog();
                workflowLog.setUser(contPrepaymentVo.getUser());
                workflowLog.setActWidgetId(RequestUtils.getRequestUri());
                workflowLog.setRemark1(remark);
                workflowLog.setWfLogType(BizTypeEnums.PREPAYMENT.getType());
                workflowLog.setWfLogNo(contPrepaymentVo.getContPrepaymentNo());
                workflowLog.setStatus(BizStatusEnums.CONT_PREPAYMENT_INVALID.getType());
                workflowLog.setActType(ActTypeEnums.CANCEL.getType());
                workflowLogList.add(workflowLog);
            }
            contPrepaymentRepository.updateByPrimaryKeySelectiveDataList(contPrepaymentList,true);
            workflowLogRepository.insertDataList(workflowLogList);
        }
    }
}