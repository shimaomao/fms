package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CrmPersonDao;
import cn.com.leadu.fms.data.prebiz.repository.CrmPersonRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonRepositoryImpl
 * @Description: CRM个人信息Repository 实现层
 * @date 2018-05-23
 */
@Repository
public class CrmPersonRepositoryImpl extends AbstractBaseRepository<CrmPersonDao, CrmPerson> implements CrmPersonRepository {

    /**
     * @Title:
     * @Description: 新增CRM个人信息
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int insertData(CrmPerson crmPerson) {
        return super.insert(crmPerson);
    }

    /**
     * @Title:
     * @Description: 批量保存CRM个人信息
     * @param crmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int insertDataList(List<CrmPerson> crmPersons){
        return super.insertListByJdbcTemplate(crmPersons);
    }

    /**
     * @Title:
     * @Description: 修改CRM个人信息
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int updateByPrimaryKeyData(CrmPerson crmPerson) {
        return super.updateByPrimaryKey(crmPerson);
    }

    /**
     * @Title:
     * @Description: 批量修改CRM个人信息
     * @param crmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CrmPerson> crmPersons){
        return super.updateListByPrimaryKey(crmPersons);
    }

    /**
     * @Title:
     * @Description: 动态修改CRM个人信息
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CrmPerson crmPerson) {
        return super.updateByPrimaryKeySelective(crmPerson);
    }

    /**
     * @Title:
     * @Description: 批量动态修改CRM个人信息
     * @param crmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public int updateByPrimaryKeySelectiveDataList(List<CrmPerson> crmPersons) {
        return super.updateListByPrimaryKeySelective(crmPersons);
    }

    /**
     * @Title:
     * @Description: 根据条件修改CRM个人信息
     * @param crmPerson
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int updateByExampleData(CrmPerson crmPerson, Example example) {
        return super.updateByExample(crmPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改CRM个人信息
     * @param crmPerson
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int updateByExampleSelectiveData(CrmPerson crmPerson, Example example){
        return super.updateByExampleSelective(crmPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据personId删除CRM个人信息
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public int deleteData(CrmPerson crmPerson) {
        return super.delete(crmPerson);
    }

    /**
     * @Title:
     * @Description: 根据personId集合批量删除CRM个人信息
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public int deleteDataList(List personIds,CrmPerson crmPerson){
        return super.deleteByIds(personIds,crmPerson);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除CRM个人信息
     * @param example
     * @param crmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public int deleteExampleData(Example example,CrmPerson crmPerson){
        return super.deleteByExample(example,crmPerson);
    }

    /**
     * @Title:
     * @Description: 查询全部CRM个人信息
     * @return List<CrmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public List<CrmPerson> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个CRM个人信息
     * @param example
     * @return CrmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public CrmPerson selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询CRM个人信息
     * @param example
     * @return List<CrmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public List<CrmPerson> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过personId查询CRM个人信息
     * @param personId
     * @return CrmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public CrmPerson selectByPrimaryKey(Object personId) {
        return super.selectByPrimaryKey(personId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询CRM个人信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CrmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @Override
    public PageInfoExtend<CrmPerson> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询CRM个人信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
