package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.ContactsChangeDao;
import cn.com.leadu.fms.data.postbiz.repository.ContactsChangeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeRepositoryImpl
 * @Description: 联系人信息变更Repository 实现层
 * @date 2018-09-01
 */
@Repository
public class ContactsChangeRepositoryImpl extends AbstractBaseRepository<ContactsChangeDao, ContactsChange> implements ContactsChangeRepository {

    /**
     * @Title:
     * @Description: 新增联系人信息变更
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int insertData(ContactsChange contactsChange) {
        return super.insert(contactsChange);
    }

    /**
     * @Title:
     * @Description: 批量保存联系人信息变更
     * @param contactsChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int insertDataList(List<ContactsChange> contactsChanges){
        return super.insertListByJdbcTemplate(contactsChanges);
    }

    /**
     * @Title:
     * @Description: 修改联系人信息变更
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeyData(ContactsChange contactsChange) {
        return super.updateByPrimaryKey(contactsChange);
    }

    /**
     * @Title:
     * @Description: 批量修改联系人信息变更
     * @param contactsChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContactsChange> contactsChanges){
        return super.updateListByPrimaryKey(contactsChanges);
    }

    /**
     * @Title:
     * @Description: 动态修改联系人信息变更
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContactsChange contactsChange) {
        return super.updateByPrimaryKeySelective(contactsChange);
    }

    /**
     * @Title:
     * @Description: 批量动态修改联系人信息变更
     * @param contactsChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContactsChange> contactsChanges) {
        return super.updateListByPrimaryKeySelective(contactsChanges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改联系人信息变更
     * @param contactsChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByExampleData(ContactsChange contactsChange, Example example) {
        return super.updateByExample(contactsChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改联系人信息变更
     * @param contactsChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByExampleSelectiveData(ContactsChange contactsChange, Example example){
        return super.updateByExampleSelective(contactsChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contactsChangeId删除联系人信息变更
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int deleteData(ContactsChange contactsChange) {
        return super.delete(contactsChange);
    }

    /**
     * @Title:
     * @Description: 根据contactsChangeId集合批量删除联系人信息变更
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int deleteDataList(List contactsChangeIds,ContactsChange contactsChange){
        return super.deleteByIds(contactsChangeIds,contactsChange);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除联系人信息变更
     * @param example
     * @param contactsChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int deleteExampleData(Example example,ContactsChange contactsChange){
        return super.deleteByExample(example,contactsChange);
    }

    /**
     * @Title:
     * @Description: 查询全部联系人信息变更
     * @return List<ContactsChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public List<ContactsChange> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个联系人信息变更
     * @param example
     * @return ContactsChange
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public ContactsChange selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询联系人信息变更
     * @param example
     * @return List<ContactsChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public List<ContactsChange> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contactsChangeId查询联系人信息变更
     * @param contactsChangeId
     * @return ContactsChange
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public ContactsChange selectByPrimaryKey(Object contactsChangeId) {
        return super.selectByPrimaryKey(contactsChangeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询联系人信息变更
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContactsChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public PageInfoExtend<ContactsChange> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询联系人信息变更vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改联系人信息变更
     * @param contactsChange,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeyData(ContactsChange contactsChange,boolean exclusive) {
        return super.updateByPrimaryKey(contactsChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改联系人信息变更,并进行排他
     * @param contactsChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContactsChange> contactsChanges,boolean exclusive){
        return super.updateListByPrimaryKey(contactsChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改联系人信息变更,并进行排他
     * @param contactsChange
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContactsChange contactsChange,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contactsChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改联系人信息变更,并进行排他
     * @param contactsChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContactsChange> contactsChanges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contactsChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改联系人信息变更,并进行排他
     * @param contactsChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByExampleData(ContactsChange contactsChange, Example example,boolean exclusive) {
        return super.updateByExample(contactsChange,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改联系人信息变更,并进行排他
     * @param contactsChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:19:21
     */
    @Override
    public int updateByExampleSelectiveData(ContactsChange contactsChange, Example example,boolean exclusive){
        return super.updateByExampleSelective(contactsChange,example,exclusive);
    }

}
