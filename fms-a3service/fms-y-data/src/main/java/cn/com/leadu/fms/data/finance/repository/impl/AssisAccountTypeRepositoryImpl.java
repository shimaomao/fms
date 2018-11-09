package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.AssisAccountTypeDao;
import cn.com.leadu.fms.data.finance.repository.AssisAccountTypeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeRepositoryImpl
 * @Description: 辅助核算类型管理Repository 实现层
 * @date 2018-06-23
 */
@Repository
public class AssisAccountTypeRepositoryImpl extends AbstractBaseRepository<AssisAccountTypeDao, AssisAccountType> implements AssisAccountTypeRepository {

    /**
     * @Title:
     * @Description: 新增辅助核算类型管理
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int insertData(AssisAccountType assisAccountType) {
        return super.insert(assisAccountType);
    }

    /**
     * @Title:
     * @Description: 批量保存辅助核算类型管理
     * @param assisAccountTypes
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int insertDataList(List<AssisAccountType> assisAccountTypes){
        return super.insertListByJdbcTemplate(assisAccountTypes);
    }

    /**
     * @Title:
     * @Description: 修改辅助核算类型管理
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeyData(AssisAccountType assisAccountType) {
        return super.updateByPrimaryKey(assisAccountType);
    }

    /**
     * @Title:
     * @Description: 批量修改辅助核算类型管理
     * @param assisAccountTypes
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AssisAccountType> assisAccountTypes){
        return super.updateListByPrimaryKey(assisAccountTypes);
    }

    /**
     * @Title:
     * @Description: 动态修改辅助核算类型管理
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AssisAccountType assisAccountType) {
        return super.updateByPrimaryKeySelective(assisAccountType);
    }

    /**
     * @Title:
     * @Description: 批量动态修改辅助核算类型管理
     * @param assisAccountTypes
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AssisAccountType> assisAccountTypes) {
        return super.updateListByPrimaryKeySelective(assisAccountTypes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改辅助核算类型管理
     * @param assisAccountType
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByExampleData(AssisAccountType assisAccountType, Example example) {
        return super.updateByExample(assisAccountType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改辅助核算类型管理
     * @param assisAccountType
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByExampleSelectiveData(AssisAccountType assisAccountType, Example example){
        return super.updateByExampleSelective(assisAccountType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据assisAccountTypeId删除辅助核算类型管理
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int deleteData(AssisAccountType assisAccountType) {
        return super.delete(assisAccountType);
    }

    /**
     * @Title:
     * @Description: 根据assisAccountTypeId集合批量删除辅助核算类型管理
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int deleteDataList(List assisAccountTypeIds,AssisAccountType assisAccountType){
        return super.deleteByIds(assisAccountTypeIds,assisAccountType);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除辅助核算类型管理
     * @param example
     * @param assisAccountType
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int deleteExampleData(Example example,AssisAccountType assisAccountType){
        return super.deleteByExample(example,assisAccountType);
    }

    /**
     * @Title:
     * @Description: 查询全部辅助核算类型管理
     * @return List<AssisAccountType>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public List<AssisAccountType> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个辅助核算类型管理
     * @param example
     * @return AssisAccountType
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public AssisAccountType selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询辅助核算类型管理
     * @param example
     * @return List<AssisAccountType>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public List<AssisAccountType> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过assisAccountTypeId查询辅助核算类型管理
     * @param assisAccountTypeId
     * @return AssisAccountType
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public AssisAccountType selectByPrimaryKey(Object assisAccountTypeId) {
        return super.selectByPrimaryKey(assisAccountTypeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<AssisAccountType>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public PageInfoExtend<AssisAccountType> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改辅助核算类型管理
     * @param assisAccountType,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeyData(AssisAccountType assisAccountType,boolean exclusive) {
        return super.updateByPrimaryKey(assisAccountType,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改辅助核算类型管理,并进行排他
     * @param assisAccountTypes
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AssisAccountType> assisAccountTypes,boolean exclusive){
        return super.updateListByPrimaryKey(assisAccountTypes,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改辅助核算类型管理,并进行排他
     * @param assisAccountType
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AssisAccountType assisAccountType,boolean exclusive) {
        return super.updateByPrimaryKeySelective(assisAccountType,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改辅助核算类型管理,并进行排他
     * @param assisAccountTypes
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AssisAccountType> assisAccountTypes,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(assisAccountTypes,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改辅助核算类型管理,并进行排他
     * @param assisAccountType
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByExampleData(AssisAccountType assisAccountType, Example example,boolean exclusive) {
        return super.updateByExample(assisAccountType,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改辅助核算类型管理,并进行排他
     * @param assisAccountType
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @Override
    public int updateByExampleSelectiveData(AssisAccountType assisAccountType, Example example,boolean exclusive){
        return super.updateByExampleSelective(assisAccountType,example,exclusive);
    }

}
