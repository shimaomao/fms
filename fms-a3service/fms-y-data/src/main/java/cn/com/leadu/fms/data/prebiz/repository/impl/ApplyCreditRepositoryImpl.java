package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ApplyCreditDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyCreditRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditRepositoryImpl
 * @Description: 征信信息Repository 实现层
 * @date 2018-05-15
 */
@Repository
public class ApplyCreditRepositoryImpl extends AbstractBaseRepository<ApplyCreditDao, ApplyCredit> implements ApplyCreditRepository {

    /**
     * @Title:
     * @Description: 新增征信信息
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int insertData(ApplyCredit applyCredit) {
        return super.insert(applyCredit);
    }

    /**
     * @Title:
     * @Description: 批量保存征信信息
     * @param applyCredits
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int insertDataList(List<ApplyCredit> applyCredits){
        return super.insertListByJdbcTemplate(applyCredits);
    }

    /**
     * @Title:
     * @Description: 修改征信信息
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int updateByPrimaryKeyData(ApplyCredit applyCredit) {
        return super.updateByPrimaryKey(applyCredit);
    }

    /**
     * @Title:
     * @Description: 批量修改征信信息
     * @param applyCredits
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyCredit> applyCredits){
        return super.updateListByPrimaryKey(applyCredits);
    }

    /**
     * @Title:
     * @Description: 动态修改征信信息
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyCredit applyCredit) {
        return super.updateByPrimaryKeySelective(applyCredit);
    }

    /**
     * @Title:
     * @Description: 批量动态修改征信信息
     * @param applyCredits
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    public int updateByPrimaryKeySelectiveDataList(List<ApplyCredit> applyCredits) {
        return super.updateListByPrimaryKeySelective(applyCredits);
    }

    /**
     * @Title:
     * @Description: 根据条件修改征信信息
     * @param applyCredit
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int updateByExampleData(ApplyCredit applyCredit, Example example) {
        return super.updateByExample(applyCredit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改征信信息
     * @param applyCredit
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int updateByExampleSelectiveData(ApplyCredit applyCredit, Example example){
        return super.updateByExampleSelective(applyCredit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据applyCreditId删除征信信息
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public int deleteData(ApplyCredit applyCredit) {
        return super.delete(applyCredit);
    }

    /**
     * @Title:
     * @Description: 根据applyCreditId集合批量删除征信信息
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    public int deleteDataList(List applyCreditIds,ApplyCredit applyCredit){
        return super.deleteByIds(applyCreditIds,applyCredit);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除征信信息
     * @param example
     * @param applyCredit
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    public int deleteExampleData(Example example,ApplyCredit applyCredit){
        return super.deleteByExample(example,applyCredit);
    }

    /**
     * @Title:
     * @Description: 查询全部征信信息
     * @return List<ApplyCredit>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public List<ApplyCredit> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个征信信息
     * @param example
     * @return ApplyCredit
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public ApplyCredit selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询征信信息
     * @param example
     * @return List<ApplyCredit>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public List<ApplyCredit> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyCreditId查询征信信息
     * @param applyCreditId
     * @return ApplyCredit
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public ApplyCredit selectByPrimaryKey(Object applyCreditId) {
        return super.selectByPrimaryKey(applyCreditId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询征信信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ApplyCredit>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    @Override
    public PageInfoExtend<ApplyCredit> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询征信信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:26:59
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
