package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.CompanyBasicChangeDao;
import cn.com.leadu.fms.data.postbiz.repository.CompanyBasicChangeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CompanyBasicChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeRepositoryImpl
 * @Description: 企业基本信息变更Repository 实现层
 * @date 2018-09-01
 */
@Repository
public class CompanyBasicChangeRepositoryImpl extends AbstractBaseRepository<CompanyBasicChangeDao, CompanyBasicChange> implements CompanyBasicChangeRepository {

    /**
     * @Title:
     * @Description: 新增企业基本信息变更
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int insertData(CompanyBasicChange companyBasicChange) {
        return super.insert(companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量保存企业基本信息变更
     * @param companyBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int insertDataList(List<CompanyBasicChange> companyBasicChanges){
        return super.insertListByJdbcTemplate(companyBasicChanges);
    }

    /**
     * @Title:
     * @Description: 修改企业基本信息变更
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeyData(CompanyBasicChange companyBasicChange) {
        return super.updateByPrimaryKey(companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量修改企业基本信息变更
     * @param companyBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CompanyBasicChange> companyBasicChanges){
        return super.updateListByPrimaryKey(companyBasicChanges);
    }

    /**
     * @Title:
     * @Description: 动态修改企业基本信息变更
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CompanyBasicChange companyBasicChange) {
        return super.updateByPrimaryKeySelective(companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业基本信息变更
     * @param companyBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CompanyBasicChange> companyBasicChanges) {
        return super.updateListByPrimaryKeySelective(companyBasicChanges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业基本信息变更
     * @param companyBasicChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByExampleData(CompanyBasicChange companyBasicChange, Example example) {
        return super.updateByExample(companyBasicChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改企业基本信息变更
     * @param companyBasicChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByExampleSelectiveData(CompanyBasicChange companyBasicChange, Example example){
        return super.updateByExampleSelective(companyBasicChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据companyChangeId删除企业基本信息变更
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int deleteData(CompanyBasicChange companyBasicChange) {
        return super.delete(companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 根据companyChangeId集合批量删除企业基本信息变更
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int deleteDataList(List companyChangeIds,CompanyBasicChange companyBasicChange){
        return super.deleteByIds(companyChangeIds,companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除企业基本信息变更
     * @param example
     * @param companyBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int deleteExampleData(Example example,CompanyBasicChange companyBasicChange){
        return super.deleteByExample(example,companyBasicChange);
    }

    /**
     * @Title:
     * @Description: 查询全部企业基本信息变更
     * @return List<CompanyBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public List<CompanyBasicChange> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个企业基本信息变更
     * @param example
     * @return CompanyBasicChange
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public CompanyBasicChange selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询企业基本信息变更
     * @param example
     * @return List<CompanyBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public List<CompanyBasicChange> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过companyChangeId查询企业基本信息变更
     * @param companyChangeId
     * @return CompanyBasicChange
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public CompanyBasicChange selectByPrimaryKey(Object companyChangeId) {
        return super.selectByPrimaryKey(companyChangeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询企业基本信息变更
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CompanyBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public PageInfoExtend<CompanyBasicChange> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询企业基本信息变更vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改企业基本信息变更
     * @param companyBasicChange,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeyData(CompanyBasicChange companyBasicChange,boolean exclusive) {
        return super.updateByPrimaryKey(companyBasicChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改企业基本信息变更,并进行排他
     * @param companyBasicChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CompanyBasicChange> companyBasicChanges,boolean exclusive){
        return super.updateListByPrimaryKey(companyBasicChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改企业基本信息变更,并进行排他
     * @param companyBasicChange
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CompanyBasicChange companyBasicChange,boolean exclusive) {
        return super.updateByPrimaryKeySelective(companyBasicChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业基本信息变更,并进行排他
     * @param companyBasicChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CompanyBasicChange> companyBasicChanges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(companyBasicChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业基本信息变更,并进行排他
     * @param companyBasicChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByExampleData(CompanyBasicChange companyBasicChange, Example example,boolean exclusive) {
        return super.updateByExample(companyBasicChange,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改企业基本信息变更,并进行排他
     * @param companyBasicChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @Override
    public int updateByExampleSelectiveData(CompanyBasicChange companyBasicChange, Example example,boolean exclusive){
        return super.updateByExampleSelective(companyBasicChange,example,exclusive);
    }

}
