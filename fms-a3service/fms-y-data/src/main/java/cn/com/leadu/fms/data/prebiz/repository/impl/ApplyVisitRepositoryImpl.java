package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.prebiz.dao.ApplyVisitDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyVisitRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVisit;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyVisitRepositoryImpl
 * @Description: 贷前家访Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class ApplyVisitRepositoryImpl extends AbstractBaseRepository<ApplyVisitDao, ApplyVisit> implements ApplyVisitRepository {

    /**
     * @Title:
     * @Description: 新增贷前家访
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int insertData(ApplyVisit applyVisit) {
        return super.insert(applyVisit);
    }

    /**
     * @Title:
     * @Description: 批量保存贷前家访
     * @param applyVisits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int insertDataList(List<ApplyVisit> applyVisits){
        return super.insertListByJdbcTemplate(applyVisits);
    }

    /**
     * @Title:
     * @Description: 修改贷前家访
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeyData(ApplyVisit applyVisit) {
        return super.updateByPrimaryKey(applyVisit);
    }

    /**
     * @Title:
     * @Description: 批量修改贷前家访
     * @param applyVisits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyVisit> applyVisits){
        return super.updateListByPrimaryKey(applyVisits);
    }

    /**
     * @Title:
     * @Description: 动态修改贷前家访
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyVisit applyVisit) {
        return super.updateByPrimaryKeySelective(applyVisit);
    }

    /**
     * @Title:
     * @Description: 批量动态修改贷前家访
     * @param applyVisits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ApplyVisit> applyVisits) {
        return super.updateListByPrimaryKeySelective(applyVisits);
    }

    /**
     * @Title:
     * @Description: 根据条件修改贷前家访
     * @param applyVisit
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByExampleData(ApplyVisit applyVisit, Example example) {
        return super.updateByExample(applyVisit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改贷前家访
     * @param applyVisit
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByExampleSelectiveData(ApplyVisit applyVisit, Example example){
        return super.updateByExampleSelective(applyVisit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据applyVisitId删除贷前家访
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int deleteData(ApplyVisit applyVisit) {
        return super.delete(applyVisit);
    }

    /**
     * @Title:
     * @Description: 根据applyVisitId集合批量删除贷前家访
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int deleteDataList(List applyVisitIds,ApplyVisit applyVisit){
        return super.deleteByIds(applyVisitIds,applyVisit);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除贷前家访
     * @param example
     * @param applyVisit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int deleteExampleData(Example example,ApplyVisit applyVisit){
        return super.deleteByExample(example,applyVisit);
    }

    /**
     * @Title:
     * @Description: 查询全部贷前家访
     * @return List<ApplyVisit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public List<ApplyVisit> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个贷前家访
     * @param example
     * @return ApplyVisit
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public ApplyVisit selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询贷前家访
     * @param example
     * @return List<ApplyVisit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public List<ApplyVisit> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyVisitId查询贷前家访
     * @param applyVisitId
     * @return ApplyVisit
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public ApplyVisit selectByPrimaryKey(Object applyVisitId) {
        return super.selectByPrimaryKey(applyVisitId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询贷前家访
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ApplyVisit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public PageInfoExtend<ApplyVisit> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询贷前家访vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改贷前家访
     * @param applyVisit,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeyData(ApplyVisit applyVisit,boolean exclusive) {
        return super.updateByPrimaryKey(applyVisit,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改贷前家访,并进行排他
     * @param applyVisits
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyVisit> applyVisits,boolean exclusive){
        return super.updateListByPrimaryKey(applyVisits,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改贷前家访,并进行排他
     * @param applyVisit
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyVisit applyVisit,boolean exclusive) {
        return super.updateByPrimaryKeySelective(applyVisit,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改贷前家访,并进行排他
     * @param applyVisits
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ApplyVisit> applyVisits,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(applyVisits,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改贷前家访,并进行排他
     * @param applyVisit
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByExampleData(ApplyVisit applyVisit, Example example,boolean exclusive) {
        return super.updateByExample(applyVisit,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改贷前家访,并进行排他
     * @param applyVisit
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    @Override
    public int updateByExampleSelectiveData(ApplyVisit applyVisit, Example example,boolean exclusive){
        return super.updateByExampleSelective(applyVisit,example,exclusive);
    }

}
