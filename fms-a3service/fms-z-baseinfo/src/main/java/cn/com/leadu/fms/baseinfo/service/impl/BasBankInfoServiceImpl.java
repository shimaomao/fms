package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasBankInfoService;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoSaveVo;
import cn.com.leadu.fms.business.common.util.activiti.ActBasBankInfoUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasBankInfoRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoService
 * @Description: 银行账号维护业务实现层
 * @date 2018-03-26
 */
@Service
public class BasBankInfoServiceImpl implements BasBankInfoService {

    /**
     * @Fields  : 银行账号维护repository
     */
    @Autowired
    private BasBankInfoRepository basBankInfoRepository;

    /**
     * @Fields : 业务编号管理业务service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields : 日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 分页查询银行账号维护
     * @param basBankInfoVo
     * @return PageInfoExtend<BasBankInfo>
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public PageInfoExtend<BasBankInfoVo> findBasBankInfosByPage(BasBankInfoVo basBankInfoVo){
        //开户行
        if (StringUtils.isTrimBlank(basBankInfoVo.getAccBank()))
            basBankInfoVo.setAccBank(null);
        else
            basBankInfoVo.setAccBank(SqlUtil.likePattern(basBankInfoVo.getAccBank()));

        //开户名
        if (StringUtils.isTrimBlank(basBankInfoVo.getAccountName()))
            basBankInfoVo.setAccountName(null);
        else
            basBankInfoVo.setAccountName(SqlUtil.likePattern(basBankInfoVo.getAccountName()));

        //银行账号
        if (StringUtils.isTrimBlank(basBankInfoVo.getAccountNo()))
            basBankInfoVo.setAccountNo(null);
        else
            basBankInfoVo.setAccountNo(SqlUtil.likePattern(basBankInfoVo.getAccountNo()));

        //开户支行
        if (StringUtils.isTrimBlank(basBankInfoVo.getAccBranchBank()))
            basBankInfoVo.setAccBranchBank(null);
        else
            basBankInfoVo.setAccBranchBank(SqlUtil.likePattern(basBankInfoVo.getAccBranchBank()));

        //机构代码
        if (StringUtils.isTrimBlank(basBankInfoVo.getGroupCode()))
            basBankInfoVo.setGroupCode(null);
        else
            basBankInfoVo.setGroupCode(basBankInfoVo.getGroupCode());

        //机构类型
        if (StringUtils.isTrimBlank(basBankInfoVo.getOrganizationType()))
            basBankInfoVo.setOrganizationType(null);
        else
            basBankInfoVo.setOrganizationType(basBankInfoVo.getOrganizationType());

        //启用标志
        if (StringUtils.isTrimBlank(basBankInfoVo.getEnableFlag()))
            basBankInfoVo.setEnableFlag(null);
        else
            basBankInfoVo.setEnableFlag(basBankInfoVo.getEnableFlag());
        //审核状态(是否通过)
        if (StringUtils.isTrimBlank(basBankInfoVo.getAccountNoStatus()))
            basBankInfoVo.setAccountNoStatus(null);
        else
            basBankInfoVo.setAccountNoStatus(basBankInfoVo.getAccountNoStatus());
        PageInfoExtend<BasBankInfoVo> pageInfo = basBankInfoRepository.selectListVoByPage("selectBasBankInfoFromSysGroupByPage", basBankInfoVo, basBankInfoVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存银行账号维护
     * @param basBankInfoSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Transactional
    public void saveBasBankInfo(BasBankInfoSaveVo basBankInfoSaveVo,SysUser sysUser){

        //设置银行账号序号
        if(StringUtils.isTrimBlank(basBankInfoSaveVo.getGroupBankNo())){
            basBankInfoSaveVo.setGroupBankNo(UUIDUtils.getUUID());
        }
        basBankInfoSaveVo.setGroupCode(sysUser.getGroupCode());
        //取任务号
        String bankTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.BAS_BANK_INFO_NUM_TYPE.getType());
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActBasBankInfoUtils.startBasBankInfo(bankTaskNo, "1", "银行账号维护");
        //更新银行账号状态
        basBankInfoSaveVo.setAccountNoStatus(actRuTaskVo.getTaskCode());
        //当前节点用户
        basBankInfoSaveVo.setPresentUser(actRuTaskVo.getNextAssignee());
        //录入采番的银行账号维护任务号
        basBankInfoSaveVo.setBankTaskNo(bankTaskNo);
        //"机构类型"为用户组,实际销售方,经销商,收车机构时做如下操作,其它四种情况录入字典值
        if(basBankInfoSaveVo.getOrganizationType().equals(BankOrganizationTypeEnums.USER_GROUP.getType())||
                basBankInfoSaveVo.getOrganizationType().equals(BankOrganizationTypeEnums.BAS_SALES.getType())||
                basBankInfoSaveVo.getOrganizationType().equals(BankOrganizationTypeEnums.BAS_PARTNER.getType())||
                basBankInfoSaveVo.getOrganizationType().equals(BankOrganizationTypeEnums.CAR_COLLECT_COMP.getType())){
            //因为需求中"机构信息"要求保存的是代码,所以这里把原来机构信息中保存的名字重新赋值成代码
            basBankInfoSaveVo.setOrganizationId(basBankInfoSaveVo.getOrganizationIdCode());
        }
        //生成uuid作为新增账号的id,同时作为银行账号维护附件code
        String uuid = UUIDUtils.getUUID();
        basBankInfoSaveVo.setBankId(uuid);

        //保存附件信息
        bizFilesService.modifyBizFilesList(basBankInfoSaveVo.getBizFilesList(),uuid,
                BizCodeTypeEnums.BAS_BANK_INFO_FILE.getCodeType());
        basBankInfoRepository.insertData(basBankInfoSaveVo.getEntity());
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(bankTaskNo);
        workflowLog.setWfLogType(BizTypeEnums.BAS_BANK_INFO.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        //workflowLog.setRemark1(basBankInfoSaveVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 修改银行账号维护
     * @param basBankInfoModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Transactional
    public void modifyBasBankInfo(BasBankInfoModifyVo basBankInfoModifyVo,SysUser sysUser){
        ActRuTaskVo actRuTaskVo = null;
        //如果taskId不为空则说明是退回再提交,否则是第一次提交
        if(StringUtils.isNotTrimBlank(basBankInfoModifyVo.getTaskId())&&!basBankInfoModifyVo.getTaskId().equals("undefined")){
            //流程引擎
            actRuTaskVo = ActBasBankInfoUtils.approvalAgree(basBankInfoModifyVo.getTaskId());
        }else {
            //工作流引擎
            actRuTaskVo = ActBasBankInfoUtils.startBasBankInfo(basBankInfoModifyVo.getBankTaskNo(), "1", "银行账号维护");
        }
        //更新银行账号状态状态
        if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
            basBankInfoModifyVo.setAccountNoStatus(actRuTaskVo.getTaskCode());
        }else {
            throw new FmsServiceException("无法获取银行账号状态");
        }
        //当前节点用户
        basBankInfoModifyVo.setPresentUser(actRuTaskVo.getNextAssignee());
        //"机构类型"为用户组,实际销售方,经销商,收车机构时做如下操作,其它四种情况录入字典值
        if(basBankInfoModifyVo.getOrganizationType().equals(BankOrganizationTypeEnums.USER_GROUP.getType())||
                basBankInfoModifyVo.getOrganizationType().equals(BankOrganizationTypeEnums.BAS_SALES.getType())||
                basBankInfoModifyVo.getOrganizationType().equals(BankOrganizationTypeEnums.BAS_PARTNER.getType())||
                basBankInfoModifyVo.getOrganizationType().equals(BankOrganizationTypeEnums.CAR_COLLECT_COMP.getType())){
            //因为需求中"机构信息"要求保存的是代码,所以这里把原来机构信息中保存的名字重新赋值成代码
            basBankInfoModifyVo.setOrganizationId(basBankInfoModifyVo.getOrganizationIdCode());
        }
        //保存附件信息
        bizFilesService.modifyBizFilesList(basBankInfoModifyVo.getBizFilesList(),basBankInfoModifyVo.getBankId(),
                BizCodeTypeEnums.BAS_BANK_INFO_FILE.getCodeType());
        basBankInfoRepository.updateByPrimaryKeySelectiveData(basBankInfoModifyVo.getEntity());
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basBankInfoModifyVo.getBankTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_BANK_INFO.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basBankInfoModifyVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description:  通过bankId删除银行账号维护
     * @param basBankInfoDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public void deleteBasBankInfo(BasBankInfoDeleteVo basBankInfoDeleteVo){
        basBankInfoRepository.deleteData(basBankInfoDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过bankId集合删除银行账号维护
     * @param basBankInfoDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public void deleteBasBankInfosByBankIds(BasBankInfoDeleteListVo basBankInfoDeleteListVo){
        basBankInfoRepository.deleteDataList(basBankInfoDeleteListVo.getBankIds(),basBankInfoDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据bankId获取银行账号维护
     * @param bankId
     * @return BasBankInfo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public BasBankInfoVo findBasBankInfoByBankId(String bankId,String serviceId){
        //如果serviceId不为空则说明是从我的任务中点过来的,否则是从一览过来的
        if(StringUtils.isNotTrimBlank(serviceId)&&!serviceId.equals("undefined")){
            Example example = SqlUtil.newExample(BasBankInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("bankTaskNo",serviceId);
            BasBankInfo basBankInfo = basBankInfoRepository.selectOneByExample(example);
            BasBankInfoVo basBankInfoVo = basBankInfoRepository.selectBasBankInfoFromSysGroupById(basBankInfo.getBankId());
            //查询附件
            basBankInfoVo.setBizFilesList(bizFilesService.findBizFilesList(basBankInfo.getBankId(), BizCodeTypeEnums.BAS_BANK_INFO_FILE.getCodeType()));
            return basBankInfoVo;
        }else {
            BasBankInfoVo basBankInfoVo = basBankInfoRepository.selectBasBankInfoFromSysGroupById(bankId);
            //查询附件
            basBankInfoVo.setBizFilesList(bizFilesService.findBizFilesList(bankId, BizCodeTypeEnums.BAS_BANK_INFO_FILE.getCodeType()));
            return basBankInfoVo;
        }
    }

    /**
     * @Title:
     * @Description: 银行账号维护审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void approval(BasBankInfoVo basBankInfoVo,SysUser sysUser){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActBasBankInfoUtils.approvalAgree(basBankInfoVo.getTaskId());

        if(actRuTaskVo!=null){
            //状态更新银行账号状态
            basBankInfoVo.setAccountNoStatus(actRuTaskVo.getTaskCode());
            //当前节点用户
            basBankInfoVo.setPresentUser(actRuTaskVo.getNextAssignee());
            //因为需求中"机构信息"要求保存的是代码,将此字段设为null,则仍保留为代码,不会更新
            basBankInfoVo.setOrganizationId(null);
            basBankInfoRepository.updateByPrimaryKeySelectiveData(basBankInfoVo.getEntity());
        }
        auditPass(basBankInfoVo,actRuTaskVo,sysUser);
    }

    /**
     * @Title:
     * @Description: 银行账号审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void sendBack(BasBankInfoVo basBankInfoVo,SysUser sysUser){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActBasBankInfoUtils.approvalReturnSuperior(basBankInfoVo.getTaskId());
        if(actRuTaskVo!=null) {
            //更新银行账号状态
            basBankInfoVo.setAccountNoStatus(actRuTaskVo.getTaskCode());
            //当前节点用户
            basBankInfoVo.setPresentUser(actRuTaskVo.getNextAssignee());
            //因为需求中"机构信息"要求保存的是代码,将此字段设为null,则仍保留为代码,不会更新
            basBankInfoVo.setOrganizationId(null);
            basBankInfoRepository.updateByPrimaryKeySelectiveData(basBankInfoVo.getEntity());
        }
        auditSendBack(basBankInfoVo,actRuTaskVo,sysUser);

    }

    /**
     * @Title:
     * @Description: 根据机构获取银行账号维护
     * @param
     * @return
     * @throws
     * @author liujinge
     * @date
     */
    @Override
    public BasBankInfo findBasBankInfoByOrg(String organizationType, String organizationId) {
        Example example = SqlUtil.newExample(BasBankInfo.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("organizationType",organizationType);
        criteria.andEqualTo("organizationId",organizationId);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        List<BasBankInfo> basBankInfoList = basBankInfoRepository.selectListByExample(example);
        if(ArrayUtils.isNotNullAndLengthNotZero(basBankInfoList)){
            for(BasBankInfo basBankInfo : basBankInfoList){
                if(true)
                    return basBankInfo;
            }
            return basBankInfoList.get(0);
        }else{
            return new BasBankInfo();
        }
    }

    /**
     * @Description: 根据银行账号获取财务科目代码
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/1 11:57
     */
    @Override
    public String findFinassSubjectCd(String accountNo) {
        if(StringUtils.isTrimBlank(accountNo)){
            throw new FmsServiceException("银行账号不能为空");
        }
        Example example = SqlUtil.newExample(BasBankInfo.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("accountNo",accountNo);
        BasBankInfo basBankInfo = basBankInfoRepository.selectOneByExample(example);
        if(basBankInfo != null){
            return basBankInfo.getFinassSubjectCd();
        }
        return null;
    }

    /**
     * @Description: 根据银行账号获取银行信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/10 13:52
     */
    @Override
    public BasBankInfo findBasBankInfoByAccountNo(String accountNo) {
        if(StringUtils.isTrimBlank(accountNo)){
            throw new FmsServiceException("银行账号不能为空");
        }
        Example example = SqlUtil.newExample(BasBankInfo.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("accountNo",accountNo);
        BasBankInfo basBankInfo = basBankInfoRepository.selectOneByExample(example);
        return basBankInfo;
    }


    /**
     * @Title:
     * @Description: 审核通过共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditPass(BasBankInfoVo basBankInfoVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basBankInfoVo.getBankTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_BANK_INFO.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basBankInfoVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(APPROVAL.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 审核退回共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditSendBack(BasBankInfoVo basBankInfoVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basBankInfoVo.getBankTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_BANK_INFO.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basBankInfoVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SENDBACK.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
