package cn.com.leadu.fms.postbiz.service.impl;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.APPROVAL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

import cn.com.leadu.fms.business.common.util.activiti.ActBasicChangeUtils;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.SolveTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.BasicChangeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.CompanyBasicChangeRepository;
import cn.com.leadu.fms.data.postbiz.repository.ContactsChangeRepository;
import cn.com.leadu.fms.data.prebiz.repository.CrmCompanyRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmCompanyRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmContactRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.CompanyBasicChange;
import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangeVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.BasicChangeTaskService;
import cn.com.leadu.fms.postbiz.service.CompanyBasicChangeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeService
 * @Description: 企业基本信息变更业务实现层
 * @date 2018-09-01
 */
@Service
public class CompanyBasicChangeServiceImpl implements CompanyBasicChangeService {

    /**
     * @Fields  : 企业基本信息变更repository
     */
    @Autowired
    private CompanyBasicChangeRepository companyBasicChangeRepository;
    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private BasicChangeTaskRepository basicChangeTaskRepository;
    @Autowired
    private CstmContactRepository cstmContactRepository;
    @Autowired
    private ContactsChangeRepository contactsChangeRepository;
    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;
    @Autowired
    private CrmCompanyRepository crmCompanyRepository;
    @Autowired
    private BasicChangeTaskService basicChangeTaskService;

    /**
     * @Title:
     * @Description: 保存企业基本信息变更
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    @Transactional
    public void saveCompanyBasicChange(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser){
        if (StringUtils.isNotTrimBlank(companyBasicChangePostVo.getTaskId())){
            String applyNo = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getApplyNo();
            //退回重新发起
            ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(companyBasicChangePostVo.getTaskId());
            //更新基本信息变更任务表
            updateBasicChangeTask(companyBasicChangePostVo, actRuTaskVo);
            //更新企业变更信息表
            companyBasicChangeRepository.updateByPrimaryKeySelectiveData(companyBasicChangePostVo.getNewCompanyBasicChangeVo().getEntity());

            Example example = SqlUtil.newExample(ContactsChange.class);
            example.createCriteria().andEqualTo("contactsTaskNo", companyBasicChangePostVo.getBasicTaskNo()).andEqualTo("solveType", SolveTypeEnums.AFTER_MODIFY.getType());
            // 删除上次提交保存的新增联系人信息
            contactsChangeRepository.deleteExampleData(example, new ContactsChange());

            //获取需要保存的新增联系人信息
            List<ContactsChange> contactsChangeInsertList = getContactsChangeInsertList(companyBasicChangePostVo, applyNo, companyBasicChangePostVo.getBasicTaskNo());
            if (ArrayUtils.isNotNullAndLengthNotZero(contactsChangeInsertList)){
                //重新插入联系人信息表
                contactsChangeRepository.insertDataList(contactsChangeInsertList);
            }
            // 保存流程日志
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), companyBasicChangePostVo.getBasicTaskNo()
                    , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
        } else {
            String applyNo = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getApplyNo();
            basicChangeTaskService.checkBasicChangeTask(applyNo);//校验是否存在进行中的任务
            String applyType = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getApplyType();
            //生成变更任务号
            String basicChangeTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.BASIC_CHANGE.getType());

            Map<String, Object> paramVariables = new HashedMap();
            paramVariables.put("applyNo", applyNo);
            paramVariables.put("applyType", applyType);
            paramVariables.put("basicChangeTaskNo", basicChangeTaskNo);
            // 开启工作流
            ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.startBasicChangeApply(basicChangeTaskNo,
                    ApplyTypeEnums.COMPANY.getType(),
                    companyBasicChangePostVo.getNewCompanyBasicChangeVo().getName(),
                    paramVariables);

            // 登录基本信息变更任务表
            insertBasicChangeTask(sysUser, applyNo, applyType, basicChangeTaskNo, actRuTaskVo, companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark());

            //登录个人基本信息变更表
            //变更前
            companyBasicChangePostVo.getOldCompanyBasicChangeVo().setCompanyTaskNo(basicChangeTaskNo);
            companyBasicChangePostVo.getOldCompanyBasicChangeVo().setSolveType(SolveTypeEnums.BEFORE_MODIFY.getType());
            companyBasicChangeRepository.insertData(companyBasicChangePostVo.getOldCompanyBasicChangeVo().getEntity());
            //变更后
            companyBasicChangePostVo.getNewCompanyBasicChangeVo().setCompanyTaskNo(basicChangeTaskNo);
            companyBasicChangePostVo.getNewCompanyBasicChangeVo().setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());
            companyBasicChangeRepository.insertData(companyBasicChangePostVo.getNewCompanyBasicChangeVo().getEntity());

            List<ContactsChange> contactsChangeInsertList = getAllContactsChangeInsertList(companyBasicChangePostVo, applyNo, basicChangeTaskNo);
            //登录联系人信息变更表
            if (ArrayUtils.isNotNullAndLengthNotZero(contactsChangeInsertList)){
                contactsChangeRepository.insertDataList(contactsChangeInsertList);
            }
            // 登录日志信息
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), basicChangeTaskNo
                    , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
        }
    }

    /**
     * 登录基本信息变更任务表
     * @param sysUser
     * @param applyNo
     * @param applyType
     * @param basicChangeTaskNo
     * @param actRuTaskVo
     * @param remark
     */
    private void insertBasicChangeTask(SysUser sysUser, String applyNo, String applyType, String basicChangeTaskNo, ActRuTaskVo actRuTaskVo, String remark) {
        BasicChangeTask basicChangeTask = new BasicChangeTask();
        basicChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点操作人
        basicChangeTask.setApplyNo(applyNo);//申请编号
        basicChangeTask.setApplyType(applyType);
        basicChangeTask.setBasicTaskStatus(actRuTaskVo.getTaskCode());
        basicChangeTask.setBasicTaskNo(basicChangeTaskNo);//任务号
        basicChangeTask.setSubmitUser(sysUser.getUser());//任务提交人
        basicChangeTask.setSubmitDate(DateUtils.getNowDate());//任务提交时间
        basicChangeTask.setRemark(remark);
        //登录基本信息变更任务表
        basicChangeTaskRepository.insertData(basicChangeTask);
    }

    /**
     * 获取需要登录的联系人信息
     * @param companyBasicChangePostVo
     * @param applyNo
     * @param basicChangeTaskNo
     * @return
     */
    private List<ContactsChange> getAllContactsChangeInsertList(CompanyBasicChangePostVo companyBasicChangePostVo, String applyNo, String basicChangeTaskNo){
        List<CstmContact> newCstmContactList = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getCstmContactList();
        // 获取新增的变更联系人信息
        List<ContactsChange> contactsChangeInsertList = getNewContactsChangeList(applyNo, basicChangeTaskNo, newCstmContactList);
        ContactsChange contactsChange;
        List<CstmContact> oldCstmContactList = companyBasicChangePostVo.getOldCompanyBasicChangeVo().getCstmContactList();
        if (ArrayUtils.isNotNullAndLengthNotZero(oldCstmContactList)){
            for (CstmContact cstmContact : oldCstmContactList){
                contactsChange = new ContactsChange();
                BeanUtils.copyProperties(cstmContact, contactsChange);
                contactsChange.setContactsTaskNo(basicChangeTaskNo);
                contactsChange.setSolveType(SolveTypeEnums.BEFORE_MODIFY.getType());
                contactsChangeInsertList.add(contactsChange);
            }
        }
        return contactsChangeInsertList;
    }

    /**
     * 获取新增的联系人信息
     * @param applyNo
     * @param basicChangeTaskNo
     * @param newCstmContactList
     * @return
     */
    private List<ContactsChange> getNewContactsChangeList(String applyNo, String basicChangeTaskNo, List<CstmContact> newCstmContactList) {
        List<ContactsChange> contactsChangeInsertList =new ArrayList<>();
        ContactsChange contactsChange ;
        if (ArrayUtils.isNotNullAndLengthNotZero(newCstmContactList)){
            for (CstmContact cstmContact : newCstmContactList){
                contactsChange = new ContactsChange();
                BeanUtils.copyProperties(cstmContact, contactsChange);//数据映射
                contactsChange.setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());
                contactsChange.setApplyNo(applyNo);
                contactsChange.setContactsTaskNo(basicChangeTaskNo);
                contactsChangeInsertList.add(contactsChange);
            }
        }
        return contactsChangeInsertList;
    }

    /**
     * 新增的联系人信息转化成联系人变更信息List
     * @param companyBasicChangePostVo
     * @param applyNo
     * @param basicChangeTaskNo
     * @return
     */
    private List<ContactsChange> getContactsChangeInsertList(CompanyBasicChangePostVo companyBasicChangePostVo, String applyNo, String basicChangeTaskNo){
        List<CstmContact> newCstmContactList = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getCstmContactList();
        // 获取新增的变更联系人信息
        List<ContactsChange> contactsChangeInsertList = getNewContactsChangeList(applyNo, basicChangeTaskNo, newCstmContactList);
        return contactsChangeInsertList;
    }

    /**
     * @Title:
     * @Description: 根据companyTaskNo获取企业基本信息变更
     * @param companyTaskNo
     * @return CompanyBasicChangePostVo
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public CompanyBasicChangePostVo findCstmCompanyByTaskNo(String companyTaskNo) {
        if (StringUtils.isTrimBlank(companyTaskNo)){
            throw new FmsServiceException("参数不正确");
        }

        // 获取企业基本信息变更前后返回Vo实体
        CompanyBasicChangePostVo companyBasicChangePostVo = getCompanyBasicChangePostVo(companyTaskNo);
        String applyNo = companyBasicChangePostVo.getNewCompanyBasicChangeVo().getApplyNo();
        if (StringUtils.isNotTrimBlank(applyNo)){


            Example example = SqlUtil.newExample(ContactsChange.class);
            example.createCriteria().andEqualTo("contactsTaskNo", companyTaskNo);
            // 获取变更记录表中的联系人记录
            List<ContactsChange> contactsChangeList = contactsChangeRepository.selectListByExample(example);
            // 新增联系人List初始化
            List<CstmContact> newCstmContactList = new ArrayList<>();
            // 旧的联系人信息List初始化
            List<CstmContact> cstmContactList = new ArrayList<>();
            if (ArrayUtils.isNotNullAndLengthNotZero(contactsChangeList)){
                CstmContact cstmContact ;
                for (ContactsChange contactsChange : contactsChangeList){
                    if (StringUtils.isNotTrimBlank(contactsChange.getSolveType())
                            && StringUtils.equals(SolveTypeEnums.BEFORE_MODIFY.getType(),contactsChange.getSolveType())){
                        cstmContact = new CstmContact();
                        BeanUtils.copyProperties(contactsChange, cstmContact);
                        // 设定变更前的联系人信息
                        cstmContactList.add(cstmContact);
                    } else {
                        cstmContact = new CstmContact();
                        BeanUtils.copyProperties(contactsChange, cstmContact);
                        // 设定变更前的联系人信息
                        newCstmContactList.add(cstmContact);
                    }
                }
            }
            // 设定旧的联系人信息
            companyBasicChangePostVo.getOldCompanyBasicChangeVo().setCstmContactList(cstmContactList);
            // 设定新的联系人信息
            companyBasicChangePostVo.getNewCompanyBasicChangeVo().setCstmContactList(newCstmContactList);
        }
        return companyBasicChangePostVo;
    }

    /**
     * 获取企业变更前后信息实体Vo
     * @param companyTaskNo
     * @return
     */
    private CompanyBasicChangePostVo getCompanyBasicChangePostVo(String companyTaskNo) {
        CompanyBasicChangePostVo companyBasicChangePostVo = new CompanyBasicChangePostVo();
        Example example = SqlUtil.newExample(CompanyBasicChange.class);
        example.createCriteria().andEqualTo("companyTaskNo", companyTaskNo);
        // 获取企业基本变更信息List
        List<CompanyBasicChange> companyBasicChangeList = companyBasicChangeRepository.selectListByExample(example);
        CompanyBasicChangeVo companyBasicChangeVo;
        if (ArrayUtils.isNotNullAndLengthNotZero(companyBasicChangeList)){
            for (CompanyBasicChange companyBasicChange : companyBasicChangeList){
                if (StringUtils.equals(companyBasicChange.getSolveType(), SolveTypeEnums.BEFORE_MODIFY.getType())){
                    companyBasicChangeVo = new CompanyBasicChangeVo();
                    BeanUtils.copyProperties(companyBasicChange, companyBasicChangeVo);
                    // 设定变更前的企业信息
                    companyBasicChangePostVo.setOldCompanyBasicChangeVo(companyBasicChangeVo);
                } else {
                    companyBasicChangeVo = new CompanyBasicChangeVo();
                    BeanUtils.copyProperties(companyBasicChange, companyBasicChangeVo);
                    // 设定变更后的企业信息
                    companyBasicChangePostVo.setNewCompanyBasicChangeVo(companyBasicChangeVo);
                }
            }
        }
        return companyBasicChangePostVo;
    }

    /**
     * @param applyNo
     * @param companyTaskNo
     * @return CompanyBasicChangePostVo
     * @throws
     * @Title:
     * @Description: 根据companyTaskNo获取企业基本信息变更
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public CompanyBasicChangePostVo findApplyCstmPersonByApplyNo(String applyNo, String companyTaskNo) {

        if (StringUtils.isNotTrimBlank(companyTaskNo)){
            //退回进入提交页面获取初始化数据
            CompanyBasicChangePostVo companyBasicChangePostVo = findCstmCompanyByTaskNo(companyTaskNo);
            return companyBasicChangePostVo;
        } else {
            //首次进入提交页面获取初始化数据
            CompanyBasicChangePostVo companyBasicChangePostVo = new CompanyBasicChangePostVo();
            CompanyBasicChangeVo oldCompanyBasicChangeVo = new CompanyBasicChangeVo();
            CompanyBasicChangeVo newCompanyBasicChangeVo = new CompanyBasicChangeVo();

            Example example =  SqlUtil.newExample(CstmCompany.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            //获取企业基本信息
            CstmCompany cstmCompany = cstmCompanyRepository.selectOneByExample(example);
            BeanUtils.copyProperties(cstmCompany, oldCompanyBasicChangeVo);
            BeanUtils.copyProperties(cstmCompany, newCompanyBasicChangeVo);

            example = SqlUtil.newExample(CstmContact.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            //获取客户联系人信息
            List<CstmContact> cstmContactList = cstmContactRepository.selectListByExample(example);
            oldCompanyBasicChangeVo.setCstmContactList(cstmContactList);
            companyBasicChangePostVo.setOldCompanyBasicChangeVo(oldCompanyBasicChangeVo);
            companyBasicChangePostVo.setNewCompanyBasicChangeVo(newCompanyBasicChangeVo);
            return companyBasicChangePostVo;
        }

    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    @Transactional
    public void companyBasicChangeApproval(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(companyBasicChangePostVo.getTaskId());
        updateBasicChangeTask(companyBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), APPROVAL.getType(), companyBasicChangePostVo.getBasicTaskNo()
                , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    @Transactional
    public void companyBasicChangeBack(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalReturnSuperior(companyBasicChangePostVo.getTaskId());
        updateBasicChangeTask(companyBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), SENDBACK.getType(), companyBasicChangePostVo.getBasicTaskNo()
                , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * 更新基本信息变更任务表
     * @param companyBasicChangePostVo
     * @param actRuTaskVo
     */
    private void updateBasicChangeTask(CompanyBasicChangePostVo companyBasicChangePostVo, ActRuTaskVo actRuTaskVo){

        Example example = SqlUtil.newExample(BasicChangeTask.class);
        example.createCriteria().andEqualTo("basicTaskNo", companyBasicChangePostVo.getBasicTaskNo());
        BasicChangeTask basicChangeTask = basicChangeTaskRepository.selectOneByExample(example);
        if (basicChangeTask == null){
            throw new FmsServiceException("变更任务不存在");
        }
        basicChangeTask.setBasicTaskStatus(actRuTaskVo.getTaskCode());
        basicChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点操作人
        //更新任务表
        basicChangeTaskRepository.updateByPrimaryKeySelectiveData(basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    @Transactional
    public void companyBasicChangeReview(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(companyBasicChangePostVo.getTaskId());
        CompanyBasicChangeVo companyBasicChangeVo = companyBasicChangePostVo.getNewCompanyBasicChangeVo();
        Example example = SqlUtil.newExample(CstmCompany.class);
        example.createCriteria().andEqualTo("applyNo", companyBasicChangeVo.getApplyNo());
        CstmCompany cstmCompanyResult = cstmCompanyRepository.selectOneByExample(example);
        CstmCompany cstmCompany = new CstmCompany();
        BeanUtils.copyProperties(companyBasicChangeVo, cstmCompany);
        //更新企业基本信息表
        cstmCompanyRepository.updateByExampleSelectiveData(cstmCompany, example);

        // 更新企业Crm信息
        CrmCompany crmCompany = new CrmCompany();
        BeanUtils.copyProperties(companyBasicChangeVo, crmCompany);
        example = SqlUtil.newExample(CrmCompany.class);
        example.createCriteria().andEqualTo("socialCertifNo", cstmCompanyResult.getSocialCertifNo());
        crmCompanyRepository.updateByExampleSelectiveData(crmCompany, example);

        //登录客户联系人信息
        List<CstmContact> cstmContactList = companyBasicChangeVo.getCstmContactList();
        if (ArrayUtils.isNotNullAndLengthNotZero(cstmContactList)){
            cstmContactRepository.insertDataList(cstmContactList);
        }

        // 更新变更任务表
        updateBasicChangeTask(companyBasicChangePostVo, actRuTaskVo);
        // 保存流程日志
        saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), companyBasicChangePostVo.getBasicTaskNo()
                , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param companyBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    @Transactional
    public void companyBasicChangeReviewBack(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalReturnSuperior(companyBasicChangePostVo.getTaskId());
        updateBasicChangeTask(companyBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), SENDBACK.getType(), companyBasicChangePostVo.getBasicTaskNo()
                , companyBasicChangePostVo.getNewCompanyBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * 保存流程日志信息
     * @param user
     * @param actType
     * @param wfLogNo
     * @param remark
     * @param status
     */
    private void saveWorkFlowLog(String user, String actType, String wfLogNo, String remark, String status) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(BizTypeEnums.BASIC_CHANGE.getType());
        workflowLog.setWfLogNo(wfLogNo);
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(status);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
}
