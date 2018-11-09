package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinancialSubjectDao;
import cn.com.leadu.fms.data.finance.repository.FinancialSubjectRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectRepositoryImpl
 * @Description: 财务科目管理Repository 实现层
 * @date 2018-06-20
 */
@Repository
public class FinancialSubjectRepositoryImpl extends AbstractBaseRepository<FinancialSubjectDao, FinancialSubject> implements FinancialSubjectRepository {

    /**
     * @Title:
     * @Description: 新增财务科目管理
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int insertData(FinancialSubject financialSubject) {
        return super.insert(financialSubject);
    }

    /**
     * @Title:
     * @Description: 批量保存财务科目管理
     * @param financialSubjects
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int insertDataList(List<FinancialSubject> financialSubjects){
        return super.insertListByJdbcTemplate(financialSubjects);
    }

    /**
     * @Title:
     * @Description: 修改财务科目管理
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeyData(FinancialSubject financialSubject) {
        return super.updateByPrimaryKey(financialSubject);
    }

    /**
     * @Title:
     * @Description: 批量修改财务科目管理
     * @param financialSubjects
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialSubject> financialSubjects){
        return super.updateListByPrimaryKey(financialSubjects);
    }

    /**
     * @Title:
     * @Description: 动态修改财务科目管理
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialSubject financialSubject) {
        return super.updateByPrimaryKeySelective(financialSubject);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务科目管理
     * @param financialSubjects
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialSubject> financialSubjects) {
        return super.updateListByPrimaryKeySelective(financialSubjects);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务科目管理
     * @param financialSubject
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByExampleData(FinancialSubject financialSubject, Example example) {
        return super.updateByExample(financialSubject,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务科目管理
     * @param financialSubject
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByExampleSelectiveData(FinancialSubject financialSubject, Example example){
        return super.updateByExampleSelective(financialSubject,example);
    }
    
    /**
     * @Title:
     * @Description: 根据subjectId删除财务科目管理
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int deleteData(FinancialSubject financialSubject) {
        return super.delete(financialSubject);
    }

    /**
     * @Title:
     * @Description: 根据subjectId集合批量删除财务科目管理
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int deleteDataList(List subjectIds,FinancialSubject financialSubject){
        return super.deleteByIds(subjectIds,financialSubject);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务科目管理
     * @param example
     * @param financialSubject
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int deleteExampleData(Example example,FinancialSubject financialSubject){
        return super.deleteByExample(example,financialSubject);
    }

    /**
     * @Title:
     * @Description: 查询全部财务科目管理
     * @return List<FinancialSubject>
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public List<FinancialSubject> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务科目管理
     * @param example
     * @return FinancialSubject
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public FinancialSubject selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务科目管理
     * @param example
     * @return List<FinancialSubject>
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public List<FinancialSubject> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过subjectId查询财务科目管理
     * @param subjectId
     * @return FinancialSubject
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public FinancialSubject selectByPrimaryKey(Object subjectId) {
        return super.selectByPrimaryKey(subjectId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务科目管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialSubject>
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public PageInfoExtend<FinancialSubject> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务科目管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务科目管理
     * @param financialSubject,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeyData(FinancialSubject financialSubject,boolean exclusive) {
        return super.updateByPrimaryKey(financialSubject,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务科目管理,并进行排他
     * @param financialSubjects
     * @param exclusive
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialSubject> financialSubjects,boolean exclusive){
        return super.updateListByPrimaryKey(financialSubjects,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务科目管理,并进行排他
     * @param financialSubject
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialSubject financialSubject,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialSubject,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务科目管理,并进行排他
     * @param financialSubjects
     * @param exclusive
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialSubject> financialSubjects,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialSubjects,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务科目管理,并进行排他
     * @param financialSubject
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByExampleData(FinancialSubject financialSubject, Example example,boolean exclusive) {
        return super.updateByExample(financialSubject,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务科目管理,并进行排他
     * @param financialSubject
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Override
    public int updateByExampleSelectiveData(FinancialSubject financialSubject, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialSubject,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 通过subjectId查询财务科目管理及其辅助核算类型
     * @param subjectId
     * @return FinancialSubject
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 11:24:39
     */
    @Override
    public FinancialSubjectVo selectFinancialSubjectVoByPrimaryKey(String subjectId) {
        return baseDao.selectFinancialSubjectVoByPrimaryKey(subjectId);
    }

}
