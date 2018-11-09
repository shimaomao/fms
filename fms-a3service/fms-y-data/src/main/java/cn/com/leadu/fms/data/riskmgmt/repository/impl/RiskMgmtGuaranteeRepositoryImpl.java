package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskMgmtGuaranteeDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtGuaranteeRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeRepositoryImpl
 * @Description: 风控担保人信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskMgmtGuaranteeRepositoryImpl extends AbstractBaseRepository<RiskMgmtGuaranteeDao, RiskMgmtGuarantee> implements RiskMgmtGuaranteeRepository {

    /**
     * @Title:
     * @Description: 新增风控担保人信息
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int insertData(RiskMgmtGuarantee riskMgmtGuarantee) {
        return super.insert(riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 批量保存风控担保人信息
     * @param riskMgmtGuarantees
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int insertDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees){
        return super.insertListByJdbcTemplate(riskMgmtGuarantees);
    }

    /**
     * @Title:
     * @Description: 修改风控担保人信息
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtGuarantee riskMgmtGuarantee) {
        return super.updateByPrimaryKey(riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 批量修改风控担保人信息
     * @param riskMgmtGuarantees
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees){
        return super.updateListByPrimaryKey(riskMgmtGuarantees);
    }

    /**
     * @Title:
     * @Description: 动态修改风控担保人信息
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtGuarantee riskMgmtGuarantee) {
        return super.updateByPrimaryKeySelective(riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控担保人信息
     * @param riskMgmtGuarantees
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees) {
        return super.updateListByPrimaryKeySelective(riskMgmtGuarantees);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控担保人信息
     * @param riskMgmtGuarantee
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByExampleData(RiskMgmtGuarantee riskMgmtGuarantee, Example example) {
        return super.updateByExample(riskMgmtGuarantee,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改风控担保人信息
     * @param riskMgmtGuarantee
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtGuarantee riskMgmtGuarantee, Example example){
        return super.updateByExampleSelective(riskMgmtGuarantee,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskMgmtGuaranteeId删除风控担保人信息
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int deleteData(RiskMgmtGuarantee riskMgmtGuarantee) {
        return super.delete(riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 根据riskMgmtGuaranteeId集合批量删除风控担保人信息
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int deleteDataList(List riskMgmtGuaranteeIds,RiskMgmtGuarantee riskMgmtGuarantee){
        return super.deleteByIds(riskMgmtGuaranteeIds,riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除风控担保人信息
     * @param example
     * @param riskMgmtGuarantee
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int deleteExampleData(Example example,RiskMgmtGuarantee riskMgmtGuarantee){
        return super.deleteByExample(example,riskMgmtGuarantee);
    }

    /**
     * @Title:
     * @Description: 查询全部风控担保人信息
     * @return List<RiskMgmtGuarantee>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public List<RiskMgmtGuarantee> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个风控担保人信息
     * @param example
     * @return RiskMgmtGuarantee
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public RiskMgmtGuarantee selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询风控担保人信息
     * @param example
     * @return List<RiskMgmtGuarantee>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public List<RiskMgmtGuarantee> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskMgmtGuaranteeId查询风控担保人信息
     * @param riskMgmtGuaranteeId
     * @return RiskMgmtGuarantee
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public RiskMgmtGuarantee selectByPrimaryKey(Object riskMgmtGuaranteeId) {
        return super.selectByPrimaryKey(riskMgmtGuaranteeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询风控担保人信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskMgmtGuarantee>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public PageInfoExtend<RiskMgmtGuarantee> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询风控担保人信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改风控担保人信息
     * @param riskMgmtGuarantee,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtGuarantee riskMgmtGuarantee,boolean exclusive) {
        return super.updateByPrimaryKey(riskMgmtGuarantee,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改风控担保人信息,并进行排他
     * @param riskMgmtGuarantees
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees,boolean exclusive){
        return super.updateListByPrimaryKey(riskMgmtGuarantees,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改风控担保人信息,并进行排他
     * @param riskMgmtGuarantee
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtGuarantee riskMgmtGuarantee,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskMgmtGuarantee,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控担保人信息,并进行排他
     * @param riskMgmtGuarantees
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskMgmtGuarantees,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控担保人信息,并进行排他
     * @param riskMgmtGuarantee
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByExampleData(RiskMgmtGuarantee riskMgmtGuarantee, Example example,boolean exclusive) {
        return super.updateByExample(riskMgmtGuarantee,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改风控担保人信息,并进行排他
     * @param riskMgmtGuarantee
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtGuarantee riskMgmtGuarantee, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskMgmtGuarantee,example,exclusive);
    }

}
