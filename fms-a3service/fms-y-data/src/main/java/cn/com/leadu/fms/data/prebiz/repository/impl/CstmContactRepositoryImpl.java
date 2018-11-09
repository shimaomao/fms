package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmContactDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmContactRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactRepositoryImpl
 * @Description: 客户联系人信息Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class CstmContactRepositoryImpl extends AbstractBaseRepository<CstmContactDao, CstmContact> implements CstmContactRepository {

    /**
     * @Title:
     * @Description: 新增客户联系人信息
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int insertData(CstmContact cstmContact) {
        return super.insert(cstmContact);
    }

    /**
     * @Title:
     * @Description: 批量保存客户联系人信息
     * @param cstmContacts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int insertDataList(List<CstmContact> cstmContacts){
        return super.insertListByJdbcTemplate(cstmContacts);
    }

    /**
     * @Title:
     * @Description: 修改客户联系人信息
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int updateByPrimaryKeyData(CstmContact cstmContact) {
        return super.updateByPrimaryKey(cstmContact);
    }

    /**
     * @Title:
     * @Description: 批量修改客户联系人信息
     * @param cstmContacts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmContact> cstmContacts){
        return super.updateListByPrimaryKey(cstmContacts);
    }

    /**
     * @Title:
     * @Description: 动态修改客户联系人信息
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmContact cstmContact) {
        return super.updateByPrimaryKeySelective(cstmContact);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户联系人信息
     * @param cstmContacts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmContact> cstmContacts) {
        return super.updateListByPrimaryKeySelective(cstmContacts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户联系人信息
     * @param cstmContact
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int updateByExampleData(CstmContact cstmContact, Example example) {
        return super.updateByExample(cstmContact,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户联系人信息
     * @param cstmContact
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int updateByExampleSelectiveData(CstmContact cstmContact, Example example){
        return super.updateByExampleSelective(cstmContact,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contactId删除客户联系人信息
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public int deleteData(CstmContact cstmContact) {
        return super.delete(cstmContact);
    }

    /**
     * @Title:
     * @Description: 根据contactId集合批量删除客户联系人信息
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    public int deleteDataList(List contactIds,CstmContact cstmContact){
        return super.deleteByIds(contactIds,cstmContact);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户联系人信息
     * @param example
     * @param cstmContact
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    public int deleteExampleData(Example example,CstmContact cstmContact){
        return super.deleteByExample(example,cstmContact);
    }

    /**
     * @Title:
     * @Description: 查询全部客户联系人信息
     * @return List<CstmContact>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public List<CstmContact> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户联系人信息
     * @param example
     * @return CstmContact
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public CstmContact selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户联系人信息
     * @param example
     * @return List<CstmContact>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public List<CstmContact> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contactId查询客户联系人信息
     * @param contactId
     * @return CstmContact
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public CstmContact selectByPrimaryKey(Object contactId) {
        return super.selectByPrimaryKey(contactId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户联系人信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmContact>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @Override
    public PageInfoExtend<CstmContact> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户联系人信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmContact>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    public PageInfoExtend<CstmContact> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
