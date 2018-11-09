package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmPersJobDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersJobRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobRepositoryImpl
 * @Description: 客户个人职业信息Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class CstmPersJobRepositoryImpl extends AbstractBaseRepository<CstmPersJobDao, CstmPersJob> implements CstmPersJobRepository {

    /**
     * @Title:
     * @Description: 新增客户个人职业信息
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int insertData(CstmPersJob cstmPersJob) {
        return super.insert(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 批量保存客户个人职业信息
     * @param cstmPersJobs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int insertDataList(List<CstmPersJob> cstmPersJobs){
        return super.insertListByJdbcTemplate(cstmPersJobs);
    }

    /**
     * @Title:
     * @Description: 修改客户个人职业信息
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int updateByPrimaryKeyData(CstmPersJob cstmPersJob) {
        return super.updateByPrimaryKey(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 批量修改客户个人职业信息
     * @param cstmPersJobs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmPersJob> cstmPersJobs){
        return super.insertListByJdbcTemplate(cstmPersJobs);
    }

    /**
     * @Title:
     * @Description: 动态修改客户个人职业信息
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmPersJob cstmPersJob) {
        return super.updateByPrimaryKeySelective(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户个人职业信息
     * @param cstmPersJobs
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmPersJob> cstmPersJobs) {
        return super.updateListByPrimaryKeySelective(cstmPersJobs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户个人职业信息
     * @param cstmPersJob
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int updateByExampleData(CstmPersJob cstmPersJob, Example example) {
        return super.updateByExample(cstmPersJob,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户个人职业信息
     * @param cstmPersJob
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int updateByExampleSelectiveData(CstmPersJob cstmPersJob, Example example){
        return super.updateByExampleSelective(cstmPersJob,example);
    }
    
    /**
     * @Title:
     * @Description: 根据persJobId删除客户个人职业信息
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public int deleteData(CstmPersJob cstmPersJob) {
        return super.delete(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 根据persJobId集合批量删除客户个人职业信息
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    public int deleteDataList(List persJobIds,CstmPersJob cstmPersJob){
        return super.deleteByIds(persJobIds,cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户个人职业信息
     * @param example
     * @param cstmPersJob
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    public int deleteExampleData(Example example,CstmPersJob cstmPersJob){
        return super.deleteByExample(example,cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 查询全部客户个人职业信息
     * @return List<CstmPersJob>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public List<CstmPersJob> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户个人职业信息
     * @param example
     * @return CstmPersJob
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public CstmPersJob selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户个人职业信息
     * @param example
     * @return List<CstmPersJob>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public List<CstmPersJob> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过persJobId查询客户个人职业信息
     * @param persJobId
     * @return CstmPersJob
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public CstmPersJob selectByPrimaryKey(Object persJobId) {
        return super.selectByPrimaryKey(persJobId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmPersJob>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @Override
    public PageInfoExtend<CstmPersJob> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmPersJob>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    public PageInfoExtend<CstmPersJob> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
