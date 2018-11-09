package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskCompanyDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskCompanyRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskCompany;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskCompanyRepositoryImpl
 * @Description: 企业风险信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskCompanyRepositoryImpl extends AbstractBaseRepository<RiskCompanyDao, RiskCompany> implements RiskCompanyRepository {

    /**
     * @Title:
     * @Description: 新增企业风险信息
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int insertData(RiskCompany riskCompany) {
        return super.insert(riskCompany);
    }

    /**
     * @Title:
     * @Description: 批量保存企业风险信息
     * @param riskCompanys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int insertDataList(List<RiskCompany> riskCompanys){
        return super.insertListByJdbcTemplate(riskCompanys);
    }

    /**
     * @Title:
     * @Description: 修改企业风险信息
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeyData(RiskCompany riskCompany) {
        return super.updateByPrimaryKey(riskCompany);
    }

    /**
     * @Title:
     * @Description: 批量修改企业风险信息
     * @param riskCompanys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskCompany> riskCompanys){
        return super.updateListByPrimaryKey(riskCompanys);
    }

    /**
     * @Title:
     * @Description: 动态修改企业风险信息
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskCompany riskCompany) {
        return super.updateByPrimaryKeySelective(riskCompany);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业风险信息
     * @param riskCompanys
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskCompany> riskCompanys) {
        return super.updateListByPrimaryKeySelective(riskCompanys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业风险信息
     * @param riskCompany
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByExampleData(RiskCompany riskCompany, Example example) {
        return super.updateByExample(riskCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险信息
     * @param riskCompany
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByExampleSelectiveData(RiskCompany riskCompany, Example example){
        return super.updateByExampleSelective(riskCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskCompanyId删除企业风险信息
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int deleteData(RiskCompany riskCompany) {
        return super.delete(riskCompany);
    }

    /**
     * @Title:
     * @Description: 根据riskCompanyId集合批量删除企业风险信息
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int deleteDataList(List riskCompanyIds,RiskCompany riskCompany){
        return super.deleteByIds(riskCompanyIds,riskCompany);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除企业风险信息
     * @param example
     * @param riskCompany
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int deleteExampleData(Example example,RiskCompany riskCompany){
        return super.deleteByExample(example,riskCompany);
    }

    /**
     * @Title:
     * @Description: 查询全部企业风险信息
     * @return List<RiskCompany>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public List<RiskCompany> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个企业风险信息
     * @param example
     * @return RiskCompany
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public RiskCompany selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询企业风险信息
     * @param example
     * @return List<RiskCompany>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public List<RiskCompany> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskCompanyId查询企业风险信息
     * @param riskCompanyId
     * @return RiskCompany
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public RiskCompany selectByPrimaryKey(Object riskCompanyId) {
        return super.selectByPrimaryKey(riskCompanyId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询企业风险信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskCompany>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public PageInfoExtend<RiskCompany> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询企业风险信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改企业风险信息
     * @param riskCompany,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeyData(RiskCompany riskCompany,boolean exclusive) {
        return super.updateByPrimaryKey(riskCompany,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改企业风险信息,并进行排他
     * @param riskCompanys
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskCompany> riskCompanys,boolean exclusive){
        return super.updateListByPrimaryKey(riskCompanys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改企业风险信息,并进行排他
     * @param riskCompany
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskCompany riskCompany,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskCompany,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改企业风险信息,并进行排他
     * @param riskCompanys
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskCompany> riskCompanys,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskCompanys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改企业风险信息,并进行排他
     * @param riskCompany
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByExampleData(RiskCompany riskCompany, Example example,boolean exclusive) {
        return super.updateByExample(riskCompany,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险信息,并进行排他
     * @param riskCompany
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    @Override
    public int updateByExampleSelectiveData(RiskCompany riskCompany, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskCompany,example,exclusive);
    }

}
