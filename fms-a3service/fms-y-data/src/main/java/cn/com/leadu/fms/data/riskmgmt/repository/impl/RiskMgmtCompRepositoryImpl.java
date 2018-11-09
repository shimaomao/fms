package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskMgmtCompDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtCompRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompRepositoryImpl
 * @Description: 风控企业信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskMgmtCompRepositoryImpl extends AbstractBaseRepository<RiskMgmtCompDao, RiskMgmtComp> implements RiskMgmtCompRepository {

    /**
     * @Title:
     * @Description: 新增风控企业信息
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int insertData(RiskMgmtComp riskMgmtComp) {
        return super.insert(riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 批量保存风控企业信息
     * @param riskMgmtComps
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int insertDataList(List<RiskMgmtComp> riskMgmtComps){
        return super.insertListByJdbcTemplate(riskMgmtComps);
    }

    /**
     * @Title:
     * @Description: 修改风控企业信息
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtComp riskMgmtComp) {
        return super.updateByPrimaryKey(riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 批量修改风控企业信息
     * @param riskMgmtComps
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtComp> riskMgmtComps){
        return super.updateListByPrimaryKey(riskMgmtComps);
    }

    /**
     * @Title:
     * @Description: 动态修改风控企业信息
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtComp riskMgmtComp) {
        return super.updateByPrimaryKeySelective(riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控企业信息
     * @param riskMgmtComps
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtComp> riskMgmtComps) {
        return super.updateListByPrimaryKeySelective(riskMgmtComps);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控企业信息
     * @param riskMgmtComp
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByExampleData(RiskMgmtComp riskMgmtComp, Example example) {
        return super.updateByExample(riskMgmtComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改风控企业信息
     * @param riskMgmtComp
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtComp riskMgmtComp, Example example){
        return super.updateByExampleSelective(riskMgmtComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskMgmtCompId删除风控企业信息
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int deleteData(RiskMgmtComp riskMgmtComp) {
        return super.delete(riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 根据riskMgmtCompId集合批量删除风控企业信息
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int deleteDataList(List riskMgmtCompIds,RiskMgmtComp riskMgmtComp){
        return super.deleteByIds(riskMgmtCompIds,riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除风控企业信息
     * @param example
     * @param riskMgmtComp
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int deleteExampleData(Example example,RiskMgmtComp riskMgmtComp){
        return super.deleteByExample(example,riskMgmtComp);
    }

    /**
     * @Title:
     * @Description: 查询全部风控企业信息
     * @return List<RiskMgmtComp>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public List<RiskMgmtComp> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个风控企业信息
     * @param example
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public RiskMgmtComp selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询风控企业信息
     * @param example
     * @return List<RiskMgmtComp>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public List<RiskMgmtComp> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskMgmtCompId查询风控企业信息
     * @param riskMgmtCompId
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public RiskMgmtComp selectByPrimaryKey(Object riskMgmtCompId) {
        return super.selectByPrimaryKey(riskMgmtCompId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询风控企业信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskMgmtComp>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public PageInfoExtend<RiskMgmtComp> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询风控企业信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改风控企业信息
     * @param riskMgmtComp,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtComp riskMgmtComp,boolean exclusive) {
        return super.updateByPrimaryKey(riskMgmtComp,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改风控企业信息,并进行排他
     * @param riskMgmtComps
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtComp> riskMgmtComps,boolean exclusive){
        return super.updateListByPrimaryKey(riskMgmtComps,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改风控企业信息,并进行排他
     * @param riskMgmtComp
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtComp riskMgmtComp,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskMgmtComp,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控企业信息,并进行排他
     * @param riskMgmtComps
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtComp> riskMgmtComps,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskMgmtComps,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控企业信息,并进行排他
     * @param riskMgmtComp
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByExampleData(RiskMgmtComp riskMgmtComp, Example example,boolean exclusive) {
        return super.updateByExample(riskMgmtComp,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改风控企业信息,并进行排他
     * @param riskMgmtComp
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtComp riskMgmtComp, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskMgmtComp,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 通过certifyNo查询风控个人信息
     * @param certifNo
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtComp selectRiskMgmtCompByMain(String certifNo,String applyNo) {
        return baseDao.selectRiskMgmtCompByMain(certifNo,applyNo);
    }

}
