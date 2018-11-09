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
import cn.com.leadu.fms.data.postbiz.repository.ContactsChangeRepository;
import cn.com.leadu.fms.data.postbiz.repository.PersonBasicChangeRepository;
import cn.com.leadu.fms.data.prebiz.repository.CrmPersonRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmContactRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersAddrRepository;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersonRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangeVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.BasicChangeTaskService;
import cn.com.leadu.fms.postbiz.service.PersonBasicChangeService;
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
 * @ClassName: PersonBasicChangeService
 * @Description: 个人基本信息变更表业务实现层
 * @date 2018-08-31
 */
@Service
public class PersonBasicChangeServiceImpl implements PersonBasicChangeService {

    /**
     * @Fields  : 个人基本信息变更表repository
     */
    @Autowired
    private PersonBasicChangeRepository personBasicChangeRepository;
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
    private CstmPersonRepository cstmPersonRepository;
    @Autowired
    private CstmPersAddrRepository cstmPersAddrRepository;
    @Autowired
    private CrmPersonRepository crmPersonRepository;
    @Autowired
    private BasicChangeTaskService basicChangeTaskService;

    /**
     * @Title:
     * @Description: 保存个人基本信息变更表
     * @param personBasicChangePostVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    @Transactional
    public void savePersonBasicChange(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser){
        if (StringUtils.isNotTrimBlank(personBasicChangePostVo.getTaskId())){
            String applyNo = personBasicChangePostVo.getNewPersonBasicChangeVo().getApplyNo();
            //退回重新发起
            ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(personBasicChangePostVo.getTaskId());

            // 更新基本信息变更任务表
            updateBasicChangeTask(personBasicChangePostVo, actRuTaskVo);

            //更新基本信息变更表-个人
            personBasicChangeRepository.updateByPrimaryKeySelectiveData(personBasicChangePostVo.getNewPersonBasicChangeVo().getEntity());

            Example example = SqlUtil.newExample(ContactsChange.class);
            example.createCriteria().andEqualTo("contactsTaskNo", personBasicChangePostVo.getPersonTaskNo()).andEqualTo("solveType", SolveTypeEnums.AFTER_MODIFY.getType());
            // 删除上次提交新增的联系人信息
            contactsChangeRepository.deleteExampleData(example, new ContactsChange());

            // 获取需要保存的新增联系人信息
            List<ContactsChange> contactsChangeInsertList = getContactsChangeInsertList(personBasicChangePostVo, applyNo, personBasicChangePostVo.getPersonTaskNo());
            if (ArrayUtils.isNotNullAndLengthNotZero(contactsChangeInsertList)){
                //重新插入联系人信息表
                contactsChangeRepository.insertDataList(contactsChangeInsertList);
            }
            // 保存流程日志
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), personBasicChangePostVo.getPersonTaskNo()
                    , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
        }else{
            //首次发起
            String applyNo = personBasicChangePostVo.getNewPersonBasicChangeVo().getApplyNo();
            //校验是否存在进行中的任务
            basicChangeTaskService.checkBasicChangeTask(applyNo);
            String applyType = personBasicChangePostVo.getNewPersonBasicChangeVo().getApplyType();
            // 生成变更任务号
            String basicChangeTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.BASIC_CHANGE.getType());

            Map<String, Object> paramVariables = new HashedMap();
            paramVariables.put("applyNo", applyNo);
            paramVariables.put("applyType", applyType);
            paramVariables.put("basicChangeTaskNo", basicChangeTaskNo);
            // 开启工作流
            ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.startBasicChangeApply(basicChangeTaskNo,
                  ApplyTypeEnums.PERSON.getType(),
                  personBasicChangePostVo.getNewPersonBasicChangeVo().getName(),
                  paramVariables);

            // 登录基本信息变更任务表
            insertBasicChangeTask(sysUser, applyNo, applyType, basicChangeTaskNo, actRuTaskVo, personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark());

            //登录个人基本信息变更表
            //变更前
            personBasicChangePostVo.getOldPersonBasicChangeVo().setPersonTaskNo(basicChangeTaskNo);
            personBasicChangePostVo.getOldPersonBasicChangeVo().setSolveType(SolveTypeEnums.BEFORE_MODIFY.getType());
            personBasicChangeRepository.insertData(personBasicChangePostVo.getOldPersonBasicChangeVo().getEntity());
            //变更后
            personBasicChangePostVo.getNewPersonBasicChangeVo().setPersonTaskNo(basicChangeTaskNo);
            personBasicChangePostVo.getNewPersonBasicChangeVo().setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());
            personBasicChangeRepository.insertData(personBasicChangePostVo.getNewPersonBasicChangeVo().getEntity());

            // 获取本次新增的与旧的联系人数据
            List<ContactsChange> contactsChangeInsertList = getAllContactsChangeInsertList(personBasicChangePostVo, applyNo, basicChangeTaskNo);
            if (ArrayUtils.isNotNullAndLengthNotZero(contactsChangeInsertList)){
                //插入联系人信息表
                contactsChangeRepository.insertDataList(contactsChangeInsertList);
            }
            // 保存流程日志信息
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), basicChangeTaskNo
                    , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
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
        basicChangeTask.setBasicTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        basicChangeTask.setApplyType(applyType);//申请类型
        basicChangeTask.setBasicTaskNo(basicChangeTaskNo);//任务号
        basicChangeTask.setSubmitUser(sysUser.getUser());//任务提交人
        basicChangeTask.setSubmitDate(DateUtils.getNowDate());//任务提交时间
        basicChangeTask.setRemark(remark);//备注
        //登录基本信息变更任务表
        basicChangeTaskRepository.insertData(basicChangeTask);
    }

    /**
     * 获取变更前后的联系人信息
     * @param personBasicChangePostVo
     * @param applyNo
     * @param basicChangeTaskNo
     * @return
     */
    private List<ContactsChange> getAllContactsChangeInsertList(PersonBasicChangePostVo personBasicChangePostVo, String applyNo, String basicChangeTaskNo){
        // 获取本次新增的联系人信息
        List<CstmContact> newCstmContactList = personBasicChangePostVo.getNewPersonBasicChangeVo().getCstmContactList();
        // 获取旧的联系人信息
        List<CstmContact> oldCstmContactList = personBasicChangePostVo.getOldPersonBasicChangeVo().getCstmContactList();
        List<ContactsChange> contactsChangeInsertList = getContactsChangeInsertList(applyNo, basicChangeTaskNo, newCstmContactList);
        ContactsChange contactsChange;
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
     * 新增的联系人信息转化成联系人变更信息List
     * @param personBasicChangePostVo
     * @param applyNo
     * @param basicChangeTaskNo
     * @return
     */
    private List<ContactsChange> getContactsChangeInsertList(PersonBasicChangePostVo personBasicChangePostVo, String applyNo, String basicChangeTaskNo){
        // 获取本次新增的联系人信息
        List<CstmContact> newCstmContactList = personBasicChangePostVo.getNewPersonBasicChangeVo().getCstmContactList();
        List<ContactsChange> contactsChangeInsertList = getContactsChangeInsertList(applyNo, basicChangeTaskNo, newCstmContactList);

        return contactsChangeInsertList;
    }

    /**
     * 获取新增的联系人信息
     * @param applyNo
     * @param basicChangeTaskNo
     * @param newCstmContactList
     * @return
     */
    private List<ContactsChange> getContactsChangeInsertList(String applyNo, String basicChangeTaskNo, List<CstmContact> newCstmContactList) {
        // 初始化新增变更联系人信息返回List
        List<ContactsChange> contactsChangeInsertList =new ArrayList<>();
        ContactsChange contactsChange ;
        if (ArrayUtils.isNotNullAndLengthNotZero(newCstmContactList)){
            for (CstmContact cstmContact : newCstmContactList){
                contactsChange = new ContactsChange();
                BeanUtils.copyProperties(cstmContact, contactsChange);//数据映射
                contactsChange.setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());//数据来源
                contactsChange.setApplyNo(applyNo);// 申请编号
                contactsChange.setContactsTaskNo(basicChangeTaskNo);// 任务号
                contactsChangeInsertList.add(contactsChange);
            }
        }
        return contactsChangeInsertList;
    }

    /**
     * @Title:
     * @Description: 根据personTaskNo获取个人基本信息变更表
     * @param personTaskNo
     * @return PersonBasicChangePostVo
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public PersonBasicChangePostVo findCstmPersonByTaskNo(String personTaskNo) {
        if (StringUtils.isTrimBlank(personTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取个人基本信息变更前后返回Vo实体
        PersonBasicChangePostVo personBasicChangePostVo = getPersonBasicChangePostVo(personTaskNo);

        // 获取申请编号
        String applyNo = personBasicChangePostVo.getNewPersonBasicChangeVo().getApplyNo();
        if (StringUtils.isNotTrimBlank(applyNo)){

            Example example = SqlUtil.newExample(ContactsChange.class);
            example.createCriteria().andEqualTo("contactsTaskNo", personTaskNo);
            // 获取变更记录表中新的联系人记录
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
            personBasicChangePostVo.getOldPersonBasicChangeVo().setCstmContactList(cstmContactList);
            // 设定新的联系人信息
            personBasicChangePostVo.getNewPersonBasicChangeVo().setCstmContactList(newCstmContactList);
        }
        return personBasicChangePostVo;
    }

    /**
     * 获取个人变更前后信息实体Vo
     * @param personTaskNo
     * @return
     */
    private PersonBasicChangePostVo getPersonBasicChangePostVo(String personTaskNo) {

        PersonBasicChangePostVo personBasicChangePostVo = new PersonBasicChangePostVo();
        Example example = SqlUtil.newExample(PersonBasicChange.class);
        example.createCriteria().andEqualTo("personTaskNo", personTaskNo);
        // 获取个人基本信息变更List
        List<PersonBasicChange> personBasicChangeList = personBasicChangeRepository.selectListByExample(example);
        PersonBasicChangeVo personBasicChangeVo;
        if (ArrayUtils.isNotNullAndLengthNotZero(personBasicChangeList)){
            for (PersonBasicChange personBasicChange : personBasicChangeList){
                if (StringUtils.equals(personBasicChange.getSolveType(), SolveTypeEnums.BEFORE_MODIFY.getType())){
                    personBasicChangeVo = new PersonBasicChangeVo();
                    BeanUtils.copyProperties(personBasicChange, personBasicChangeVo);
                    // 设定变更前的数据
                    personBasicChangePostVo.setOldPersonBasicChangeVo(personBasicChangeVo);
                } else {
                    personBasicChangeVo = new PersonBasicChangeVo();
                    BeanUtils.copyProperties(personBasicChange, personBasicChangeVo);
                    // 设定变更后的数据
                    personBasicChangePostVo.setNewPersonBasicChangeVo(personBasicChangeVo);
                }
            }
        }
        return personBasicChangePostVo;
    }

    /**
     * @param applyNo
     * @param personTaskNo
     * @return PersonBasicChangePostVo
     * @throws
     * @Title:
     * @Description: 根据personTaskNo获取个人基本信息变更表
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public PersonBasicChangePostVo findApplyCstmPersonByApplyNo(String applyNo, String personTaskNo) {

        if (StringUtils.isNotTrimBlank(personTaskNo)){
            //退回进入提交页面获取初始化数据
            PersonBasicChangePostVo personBasicChangePostVo = findCstmPersonByTaskNo(personTaskNo);
            return personBasicChangePostVo;
        } else {
            //首次进入提交页面获取初始化数据
            if(StringUtils.isTrimBlank(applyNo)){
                throw new FmsServiceException("申请编号不能为空");
            }
            PersonBasicChangePostVo personBasicChangePostVo = new PersonBasicChangePostVo();

            PersonBasicChangeVo oldPersonBasicChangeVo = new PersonBasicChangeVo();
            PersonBasicChangeVo newPersonBasicChangeVo = new PersonBasicChangeVo();
            // 根据申请编号获取个人基本信息
            PersonBasicChangeVo personBasicChangeVo = personBasicChangeRepository.selectPersonBasicChangeByApplyNo(applyNo);
            BeanUtils.copyProperties(personBasicChangeVo, oldPersonBasicChangeVo);// 变更前基本信息映射
            BeanUtils.copyProperties(personBasicChangeVo, newPersonBasicChangeVo);// 变更后基本信息映射

            // 初始化客户联系人表Example
            Example example = SqlUtil.newExample(CstmContact.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            //获取客户联系人信息
            List<CstmContact> cstmContactList = cstmContactRepository.selectListByExample(example);
            if (ArrayUtils.isNotNullAndLengthNotZero(cstmContactList)){
                // 设定变更前客户联系人信息
                oldPersonBasicChangeVo.setCstmContactList(cstmContactList);
            }
            personBasicChangePostVo.setOldPersonBasicChangeVo(oldPersonBasicChangeVo);//变更前的信息
            personBasicChangePostVo.setNewPersonBasicChangeVo(newPersonBasicChangeVo);//变更后的信息
            return personBasicChangePostVo;
        }
    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    @Transactional
    public void personBasicChangeApproval(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(personBasicChangePostVo.getTaskId());
        updateBasicChangeTask(personBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), APPROVAL.getType(), personBasicChangePostVo.getPersonTaskNo()
                , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * 更新基本信息变更任务表
     * @param personBasicChangePostVo
     * @param actRuTaskVo
     */
    private void updateBasicChangeTask(PersonBasicChangePostVo personBasicChangePostVo, ActRuTaskVo actRuTaskVo){

        Example example = SqlUtil.newExample(BasicChangeTask.class);
        example.createCriteria().andEqualTo("basicTaskNo", personBasicChangePostVo.getPersonTaskNo());
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
     * @Description: 资管审核退回
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    @Transactional
    public void personBasicChangeBack(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalReturnSuperior(personBasicChangePostVo.getTaskId());
        updateBasicChangeTask(personBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), SENDBACK.getType(), personBasicChangePostVo.getPersonTaskNo()
                , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    @Transactional
    public void personBasicChangeReview(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalAgree(personBasicChangePostVo.getTaskId());
        PersonBasicChangeVo personBasicChangeVo = personBasicChangePostVo.getNewPersonBasicChangeVo();

        updateBasicChangeTask(personBasicChangePostVo, actRuTaskVo);

        //更新个人基本信息
        Example example = SqlUtil.newExample(CstmPerson.class);
        example.createCriteria().andEqualTo("applyNo", personBasicChangeVo.getApplyNo());
        CstmPerson cstmPersonResult = cstmPersonRepository.selectOneByExample(example);
        CstmPerson cstmPerson = new CstmPerson();
        BeanUtils.copyProperties(personBasicChangeVo, cstmPerson);
        cstmPersonRepository.updateByExampleSelectiveData(cstmPerson, example);

        //更新Crm信息
        example = SqlUtil.newExample(CrmPerson.class);
        example.createCriteria().andEqualTo("certifNo", cstmPersonResult.getCertifNo());
        CrmPerson crmPerson = new CrmPerson();
        BeanUtils.copyProperties(personBasicChangeVo, crmPerson);
        crmPersonRepository.updateByExampleSelectiveData(crmPerson, example);

        //更新个人地址信息
        example = SqlUtil.newExample(CstmPersAddr.class);
        example.createCriteria().andEqualTo("applyNo", personBasicChangeVo.getApplyNo());
        CstmPersAddr cstmPersAddr = new CstmPersAddr();
        BeanUtils.copyProperties(personBasicChangeVo, cstmPersAddr);
        cstmPersAddrRepository.updateByExampleSelectiveData(cstmPersAddr, example);

        //登录客户联系人信息
        List<CstmContact> cstmContactList = personBasicChangeVo.getCstmContactList();
        if (ArrayUtils.isNotNullAndLengthNotZero(cstmContactList)){
            cstmContactRepository.insertDataList(cstmContactList);
        }
        saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), personBasicChangePostVo.getPersonTaskNo()
                , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param personBasicChangePostVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    @Transactional
    public void personBasicChangeReviewBack(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActBasicChangeUtils.approvalReturnSuperior(personBasicChangePostVo.getTaskId());
        updateBasicChangeTask(personBasicChangePostVo, actRuTaskVo);
        saveWorkFlowLog(sysUser.getUser(), SENDBACK.getType(), personBasicChangePostVo.getPersonTaskNo()
                , personBasicChangePostVo.getNewPersonBasicChangeVo().getRemark(), actRuTaskVo.getTaskCode());
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
