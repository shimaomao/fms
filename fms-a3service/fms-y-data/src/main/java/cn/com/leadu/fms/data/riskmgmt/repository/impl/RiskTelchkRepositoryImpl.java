package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskTelchkDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskTelchkRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkRepositoryImpl
 * @Description: 风控电核信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskTelchkRepositoryImpl extends AbstractBaseRepository<RiskTelchkDao, RiskTelchk> implements RiskTelchkRepository {

    /**
     * @Title:
     * @Description: 新增风控电核信息
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int insertData(RiskTelchk riskTelchk) {
        return super.insert(riskTelchk);
    }

    /**
     * @Title:
     * @Description: 批量保存风控电核信息
     * @param riskTelchks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int insertDataList(List<RiskTelchk> riskTelchks){
        return super.insertListByJdbcTemplate(riskTelchks);
    }

    /**
     * @Title:
     * @Description: 修改风控电核信息
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeyData(RiskTelchk riskTelchk) {
        return super.updateByPrimaryKey(riskTelchk);
    }

    /**
     * @Title:
     * @Description: 批量修改风控电核信息
     * @param riskTelchks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskTelchk> riskTelchks){
        return super.updateListByPrimaryKey(riskTelchks);
    }

    /**
     * @Title:
     * @Description: 动态修改风控电核信息
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskTelchk riskTelchk) {
        return super.updateByPrimaryKeySelective(riskTelchk);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控电核信息
     * @param riskTelchks
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskTelchk> riskTelchks) {
        return super.updateListByPrimaryKeySelective(riskTelchks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控电核信息
     * @param riskTelchk
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByExampleData(RiskTelchk riskTelchk, Example example) {
        return super.updateByExample(riskTelchk,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改风控电核信息
     * @param riskTelchk
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByExampleSelectiveData(RiskTelchk riskTelchk, Example example){
        return super.updateByExampleSelective(riskTelchk,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskTelchkId删除风控电核信息
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int deleteData(RiskTelchk riskTelchk) {
        return super.delete(riskTelchk);
    }

    /**
     * @Title:
     * @Description: 根据riskTelchkId集合批量删除风控电核信息
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int deleteDataList(List riskTelchkIds,RiskTelchk riskTelchk){
        return super.deleteByIds(riskTelchkIds,riskTelchk);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除风控电核信息
     * @param example
     * @param riskTelchk
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int deleteExampleData(Example example,RiskTelchk riskTelchk){
        return super.deleteByExample(example,riskTelchk);
    }

    /**
     * @Title:
     * @Description: 查询全部风控电核信息
     * @return List<RiskTelchk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public List<RiskTelchk> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个风控电核信息
     * @param example
     * @return RiskTelchk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public RiskTelchk selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询风控电核信息
     * @param example
     * @return List<RiskTelchk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public List<RiskTelchk> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskTelchkId查询风控电核信息
     * @param riskTelchkId
     * @return RiskTelchk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public RiskTelchk selectByPrimaryKey(Object riskTelchkId) {
        return super.selectByPrimaryKey(riskTelchkId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询风控电核信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskTelchk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public PageInfoExtend<RiskTelchk> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询风控电核信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改风控电核信息
     * @param riskTelchk,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeyData(RiskTelchk riskTelchk,boolean exclusive) {
        return super.updateByPrimaryKey(riskTelchk,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改风控电核信息,并进行排他
     * @param riskTelchks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskTelchk> riskTelchks,boolean exclusive){
        return super.updateListByPrimaryKey(riskTelchks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改风控电核信息,并进行排他
     * @param riskTelchk
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskTelchk riskTelchk,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskTelchk,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控电核信息,并进行排他
     * @param riskTelchks
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskTelchk> riskTelchks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskTelchks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控电核信息,并进行排他
     * @param riskTelchk
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByExampleData(RiskTelchk riskTelchk, Example example,boolean exclusive) {
        return super.updateByExample(riskTelchk,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改风控电核信息,并进行排他
     * @param riskTelchk
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:44
     */
    @Override
    public int updateByExampleSelectiveData(RiskTelchk riskTelchk, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskTelchk,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据订单编号 获取电核信息
     * @param applyNo 订单编号
     * @return List<RiskTelchkVo>
     * @throws
     * @author liujinge
     * @date 2018-6-4 17:39:58
     */
    @Override
    public List<RiskTelchkVo> selectRiskTelchkByApplyNo(String applyNo){
        return baseDao.selectRiskTelchkByApplyNo(applyNo);
    }
}
