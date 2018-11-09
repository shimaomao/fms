package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.postbiz.service.ContactsChangeService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ContactsChangeRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.pojo.postbiz.vo.contactschange.ContactsChangeVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeSaveVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeModifyVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeDeleteVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeService
 * @Description: 联系人信息变更业务实现层
 * @date 2018-09-01
 */
@Service
public class ContactsChangeServiceImpl implements ContactsChangeService {

    /**
     * @Fields  : 联系人信息变更repository
     */
    @Autowired
    private ContactsChangeRepository contactsChangeRepository;

    /**
     * @Title:
     * @Description: 分页查询联系人信息变更
     * @param contactsChangeVo
     * @return PageInfoExtend<ContactsChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public PageInfoExtend<ContactsChange> findContactsChangesByPage(ContactsChangeVo contactsChangeVo){
        Example example = SqlUtil.newExample(ContactsChange.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContactsChange> pageInfo = contactsChangeRepository.selectListByExamplePage(example,contactsChangeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存联系人信息变更
     * @param contactsChangeSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public void saveContactsChange(ContactsChangeSaveVo contactsChangeSaveVo){
        contactsChangeRepository.insertData(contactsChangeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改联系人信息变更
     * @param contactsChangeModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public void modifyContactsChange(ContactsChangeModifyVo contactsChangeModifyVo){
        contactsChangeRepository.updateByPrimaryKeySelectiveData(contactsChangeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contactsChangeId删除联系人信息变更
     * @param contactsChangeDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public void deleteContactsChange(ContactsChangeDeleteVo contactsChangeDeleteVo){
        contactsChangeRepository.deleteData(contactsChangeDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contactsChangeId集合删除联系人信息变更
     * @param contactsChangeDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public void deleteContactsChangesByContactsChangeIds(ContactsChangeDeleteListVo contactsChangeDeleteListVo){
        contactsChangeRepository.deleteDataList(contactsChangeDeleteListVo.getContactsChangeIds(),contactsChangeDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contactsChangeId获取联系人信息变更
     * @param contactsChangeId
     * @return ContactsChange
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public ContactsChange findContactsChangeByContactsChangeId(String contactsChangeId){
        return contactsChangeRepository.selectByPrimaryKey(contactsChangeId);
    }

}
