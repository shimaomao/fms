package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskMgmtPersonDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtPersonRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonRepositoryImpl
 * @Description: 风控个人信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskMgmtPersonRepositoryImpl extends AbstractBaseRepository<RiskMgmtPersonDao, RiskMgmtPerson> implements RiskMgmtPersonRepository {

    /**
     * @Title:
     * @Description: 新增风控个人信息
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int insertData(RiskMgmtPerson riskMgmtPerson) {
        return super.insert(riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 批量保存风控个人信息
     * @param riskMgmtPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int insertDataList(List<RiskMgmtPerson> riskMgmtPersons){
        return super.insertListByJdbcTemplate(riskMgmtPersons);
    }

    /**
     * @Title:
     * @Description: 修改风控个人信息
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtPerson riskMgmtPerson) {
        return super.updateByPrimaryKey(riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 批量修改风控个人信息
     * @param riskMgmtPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtPerson> riskMgmtPersons){
        return super.updateListByPrimaryKey(riskMgmtPersons);
    }

    /**
     * @Title:
     * @Description: 动态修改风控个人信息
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtPerson riskMgmtPerson) {
        return super.updateByPrimaryKeySelective(riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控个人信息
     * @param riskMgmtPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtPerson> riskMgmtPersons) {
        return super.updateListByPrimaryKeySelective(riskMgmtPersons);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控个人信息
     * @param riskMgmtPerson
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByExampleData(RiskMgmtPerson riskMgmtPerson, Example example) {
        return super.updateByExample(riskMgmtPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改风控个人信息
     * @param riskMgmtPerson
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtPerson riskMgmtPerson, Example example){
        return super.updateByExampleSelective(riskMgmtPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskMgmtPersonId删除风控个人信息
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int deleteData(RiskMgmtPerson riskMgmtPerson) {
        return super.delete(riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 根据riskMgmtPersonId集合批量删除风控个人信息
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int deleteDataList(List riskMgmtPersonIds,RiskMgmtPerson riskMgmtPerson){
        return super.deleteByIds(riskMgmtPersonIds,riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除风控个人信息
     * @param example
     * @param riskMgmtPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int deleteExampleData(Example example,RiskMgmtPerson riskMgmtPerson){
        return super.deleteByExample(example,riskMgmtPerson);
    }

    /**
     * @Title:
     * @Description: 查询全部风控个人信息
     * @return List<RiskMgmtPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public List<RiskMgmtPerson> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个风控个人信息
     * @param example
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtPerson selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询风控个人信息
     * @param example
     * @return List<RiskMgmtPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public List<RiskMgmtPerson> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskMgmtPersonId查询风控个人信息
     * @param riskMgmtPersonId
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtPerson selectByPrimaryKey(Object riskMgmtPersonId) {
        return super.selectByPrimaryKey(riskMgmtPersonId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询风控个人信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskMgmtPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public PageInfoExtend<RiskMgmtPerson> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询风控个人信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改风控个人信息
     * @param riskMgmtPerson,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeyData(RiskMgmtPerson riskMgmtPerson,boolean exclusive) {
        return super.updateByPrimaryKey(riskMgmtPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改风控个人信息,并进行排他
     * @param riskMgmtPersons
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskMgmtPerson> riskMgmtPersons,boolean exclusive){
        return super.updateListByPrimaryKey(riskMgmtPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改风控个人信息,并进行排他
     * @param riskMgmtPerson
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskMgmtPerson riskMgmtPerson,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskMgmtPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控个人信息,并进行排他
     * @param riskMgmtPersons
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskMgmtPerson> riskMgmtPersons,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskMgmtPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控个人信息,并进行排他
     * @param riskMgmtPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByExampleData(RiskMgmtPerson riskMgmtPerson, Example example,boolean exclusive) {
        return super.updateByExample(riskMgmtPerson,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改风控个人信息,并进行排他
     * @param riskMgmtPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public int updateByExampleSelectiveData(RiskMgmtPerson riskMgmtPerson, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskMgmtPerson,example,exclusive);
    }


    /**
     * @Title:
     * @Description: 通过certifyNo查询风控个人信息
     * @param certifNo
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtPerson selectRiskMgmtPersonByMain(String certifNo,String applyNo) {
        return baseDao.selectRiskMgmtPersonByMain(certifNo,applyNo);
    }

}
