package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.CollectionPersonDao;
import cn.com.leadu.fms.data.postbiz.repository.CollectionPersonRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonRepositoryImpl
 * @Description: 催收组员Repository 实现层
 */
@Repository
public class CollectionPersonRepositoryImpl extends AbstractBaseRepository<CollectionPersonDao, CollectionPerson> implements CollectionPersonRepository {

    /**
     * @Title:
     * @Description: 新增催收组员
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int insertData(CollectionPerson collectionPerson) {
        return super.insert(collectionPerson);
    }

    /**
     * @Title:
     * @Description: 批量保存催收组员
     * @param collectionPersons
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int insertDataList(List<CollectionPerson> collectionPersons){
        return super.insertListByJdbcTemplate(collectionPersons);
    }

    /**
     * @Title:
     * @Description: 修改催收组员
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeyData(CollectionPerson collectionPerson) {
        return super.updateByPrimaryKey(collectionPerson);
    }

    /**
     * @Title:
     * @Description: 批量修改催收组员
     * @param collectionPersons
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CollectionPerson> collectionPersons){
        return super.updateListByPrimaryKey(collectionPersons);
    }

    /**
     * @Title:
     * @Description: 动态修改催收组员
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CollectionPerson collectionPerson) {
        return super.updateByPrimaryKeySelective(collectionPerson);
    }

    /**
     * @Title:
     * @Description: 批量动态修改催收组员
     * @param collectionPersons
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CollectionPerson> collectionPersons) {
        return super.updateListByPrimaryKeySelective(collectionPersons);
    }

    /**
     * @Title:
     * @Description: 根据条件修改催收组员
     * @param collectionPerson
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByExampleData(CollectionPerson collectionPerson, Example example) {
        return super.updateByExample(collectionPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改催收组员
     * @param collectionPerson
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByExampleSelectiveData(CollectionPerson collectionPerson, Example example){
        return super.updateByExampleSelective(collectionPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据collectionPersonId删除催收组员
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int deleteData(CollectionPerson collectionPerson) {
        return super.delete(collectionPerson);
    }

    /**
     * @Title:
     * @Description: 根据collectionPersonId集合批量删除催收组员
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int deleteDataList(List collectionPersonIds,CollectionPerson collectionPerson){
        return super.deleteByIds(collectionPersonIds,collectionPerson);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除催收组员
     * @param example
     * @param collectionPerson
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int deleteExampleData(Example example,CollectionPerson collectionPerson){
        return super.deleteByExample(example,collectionPerson);
    }

    /**
     * @Title:
     * @Description: 查询全部催收组员
     * @return List<CollectionPerson>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public List<CollectionPerson> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个催收组员
     * @param example
     * @return CollectionPerson
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public CollectionPerson selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询催收组员
     * @param example
     * @return List<CollectionPerson>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public List<CollectionPerson> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过collectionPersonId查询催收组员
     * @param collectionPersonId
     * @return CollectionPerson
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public CollectionPerson selectByPrimaryKey(Object collectionPersonId) {
        return super.selectByPrimaryKey(collectionPersonId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询催收组员
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CollectionPerson>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public PageInfoExtend<CollectionPerson> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询催收组员vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改催收组员
     * @param collectionPerson,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeyData(CollectionPerson collectionPerson,boolean exclusive) {
        return super.updateByPrimaryKey(collectionPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改催收组员,并进行排他
     * @param collectionPersons
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CollectionPerson> collectionPersons,boolean exclusive){
        return super.updateListByPrimaryKey(collectionPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改催收组员,并进行排他
     * @param collectionPerson
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CollectionPerson collectionPerson,boolean exclusive) {
        return super.updateByPrimaryKeySelective(collectionPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改催收组员,并进行排他
     * @param collectionPersons
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CollectionPerson> collectionPersons,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(collectionPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改催收组员,并进行排他
     * @param collectionPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByExampleData(CollectionPerson collectionPerson, Example example,boolean exclusive) {
        return super.updateByExample(collectionPerson,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改催收组员,并进行排他
     * @param collectionPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public int updateByExampleSelectiveData(CollectionPerson collectionPerson, Example example,boolean exclusive){
        return super.updateByExampleSelective(collectionPerson,example,exclusive);
    }

}
