package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyCancelRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyCancelService;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;
import static cn.com.leadu.fms.common.constant.enums.NumTypeEnums.APPLY_NUM_TYPE;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
@Service
public class ApplyCancelServiceImpl implements ApplyCancelService {
    /*
        融资申请取消repository
     */
    @Autowired
    private ApplyCancelRepository applyCancelRepository;

    /*
        申请信息service
     */
    @Autowired
    private ApplyService applyService;

    //日志
    @Autowired
    private WorkflowLogService workflowLogService;

    //业务状态管理
    @Autowired
    private BizActStatusService bizActStatusService;

    public PageInfoExtend<ApplyCancelVo> findApplyCancelsByPage(ApplyCancelVo applyCancelVo, SysUser sysUser) {
        //用当前登录用户匹配申请信息表中的订单提出账号得到申请信息表
        /*ApplyVo applyVo = applyService.findApplyVoByApplyUser(sysUser.getUser());*/

        //当前登录用户
        if (StringUtils.isTrimBlank(sysUser))
            applyCancelVo.setLoginUser(null);
        else
            applyCancelVo.setLoginUser(sysUser.getUser());

        //订单编号
        if (StringUtils.isTrimBlank(applyCancelVo.getApplyNo()))
            applyCancelVo.setApplyNo(null);
        else
            applyCancelVo.setApplyNo(applyCancelVo.getApplyNo());

        //申请姓名
        if (StringUtils.isTrimBlank(applyCancelVo.getName()))
            applyCancelVo.setName(null);
        else
            applyCancelVo.setName(SqlUtil.likePattern(applyCancelVo.getName()));

        //订单状态
        if (StringUtils.isTrimBlank(applyCancelVo.getBizStatus()))
            applyCancelVo.setBizStatus(null);
        else
            applyCancelVo.setBizStatus(applyCancelVo.getBizStatus());

        PageInfoExtend<ApplyCancelVo> pageInfo = applyCancelRepository.selectListVoByPage("selectApplyCancelByPage", applyCancelVo, applyCancelVo.getPageQuery());

        for (ApplyCancelVo applyCancelVo1 : pageInfo.getData()) {

            //申请姓名
            if (StringUtils.isNotTrimBlank(applyCancelVo1.getPersonName())) {
                applyCancelVo1.setName(applyCancelVo1.getPersonName());
            }

            if (StringUtils.isNotTrimBlank(applyCancelVo1.getCompanyName())) {
                applyCancelVo1.setName(applyCancelVo1.getCompanyName());
            }

            //证件号码
            if (StringUtils.isNotTrimBlank(applyCancelVo1.getPersonCertifNo())) {
                applyCancelVo1.setCertifNo(applyCancelVo1.getPersonCertifNo());
            }

            if (StringUtils.isNotTrimBlank(applyCancelVo1.getCompanyCertifNo())) {
                applyCancelVo1.setCertifNo(applyCancelVo1.getCompanyCertifNo());
            }
        }

      /*  //获取当前登录用户

        try {
            SysUserVo sysUserVo = ResponseEntityUtils.getRestResponseData(sysUserRpc.findSysUserDetail());
        } catch (FmsRpcException e) {
            e.printStackTrace();
        }*/
        return pageInfo;
    }

    /**
     * @param applyNo
     * @return ApplyCancelVo
     * @throws
     * @Title:
     * @Description: 根据applyNo获取融资申请取消
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ApplyCancelVo findApplyCancelVoByApplyNo(String applyNo) {
        /*return basBankInfoRepository.selectByPrimaryKey(applyNo);*/
        if (StringUtils.isTrimBlank(applyNo))
            applyNo = null;
        else
            applyNo = applyNo;
        ApplyCancelVo applyCancelVo = applyCancelRepository.selectApplyCancelVoByApplyNo(applyNo);

        //申请姓名
        if (StringUtils.isNotTrimBlank(applyCancelVo.getPersonName())) {
            applyCancelVo.setName(applyCancelVo.getPersonName());
        }

        if (StringUtils.isNotTrimBlank(applyCancelVo.getCompanyName())) {
            applyCancelVo.setName(applyCancelVo.getCompanyName());
        }

        return applyCancelVo;
    }


    /**
     * @param applyCancelVo
     * @return
     * @throws
     * @Title:
     * @Description: 融资申请取消, 并插入日志
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Transactional
    public void modifyApplyCancel(ApplyCancelVo applyCancelVo, SysUser sysUser) {

        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyCancelVo.getApplyNo());
        if (apply == null) {
            throw new FmsServiceException("订单信息不存在");
        }
        //如果taskid为空，表明从取消页面申请，需检测申请状态
        if(StringUtils.isTrimBlank(applyCancelVo.getTaskId()) && StringUtils.notEquals(apply.getBizStatus(),applyCancelVo.getBizStatus())){
            throw new FmsServiceException( "订单状态已变更，您已无权操作");
        }
        //工作流引擎
        ActRuTaskVo actRuTaskVo;
        if(StringUtils.isNotTrimBlank(applyCancelVo.getTaskId())) {
            actRuTaskVo = ActContractGenerationUtils.approvalRefuse(applyCancelVo.getTaskId());
        } else {
            actRuTaskVo = ActContractGenerationUtils.applyCancel(applyCancelVo.getApplyNo());
        }

        //更新订单状态
        String applyBizStatusUpd = BizStatusEnums.APPLY_CANCEL.getType();//取消申请，状态统一为取消

        Apply applyUpd = new Apply();
        applyUpd.setApplyId(apply.getApplyId());
        applyUpd.setBizStatus(applyBizStatusUpd);
        applyUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        applyService.updateApplyBizStsByApplyId(applyUpd);

        //审批日志插入
        WorkflowLog workflowLog = new WorkflowLog();
        //订单编号apply_no
        workflowLog.setWfLogNo(applyCancelVo.getApplyNo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        //操作人账号user
        workflowLog.setUser(sysUser.getUser());
        //操作act_widget_id
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        //操作分类act_type
        workflowLog.setActType(ActTypeEnums.CANCEL.getType());
        //操作后状态status
        workflowLog.setStatus(applyBizStatusUpd);
        //备注分类类型1 code_type1
        workflowLog.setCodeType1(applyCancelVo.getCancelReasonKey());
        //备注分类值1 code_value1
        workflowLog.setCodeValue1(applyCancelVo.getCancelReason());
        //备注内容1 remark1
        workflowLog.setRemark1(applyCancelVo.getCancelRemark());
        workflowLogService.insertWorkFlowLog(workflowLog);
//        throw new FmsServiceException("111");

    }
}
