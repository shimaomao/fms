package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskPersonDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskPersonRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskPersonRepositoryImpl
 * @Description: 个人风险信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskPersonRepositoryImpl extends AbstractBaseRepository<RiskPersonDao, RiskPerson> implements RiskPersonRepository {

    /**
     * @Title:
     * @Description: 新增个人风险信息
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int insertData(RiskPerson riskPerson) {
        return super.insert(riskPerson);
    }

    /**
     * @Title:
     * @Description: 批量保存个人风险信息
     * @param riskPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int insertDataList(List<RiskPerson> riskPersons){
        return super.insertListByJdbcTemplate(riskPersons);
    }

    /**
     * @Title:
     * @Description: 修改个人风险信息
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeyData(RiskPerson riskPerson) {
        return super.updateByPrimaryKey(riskPerson);
    }

    /**
     * @Title:
     * @Description: 批量修改个人风险信息
     * @param riskPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskPerson> riskPersons){
        return super.updateListByPrimaryKey(riskPersons);
    }

    /**
     * @Title:
     * @Description: 动态修改个人风险信息
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskPerson riskPerson) {
        return super.updateByPrimaryKeySelective(riskPerson);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人风险信息
     * @param riskPersons
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskPerson> riskPersons) {
        return super.updateListByPrimaryKeySelective(riskPersons);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人风险信息
     * @param riskPerson
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByExampleData(RiskPerson riskPerson, Example example) {
        return super.updateByExample(riskPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改个人风险信息
     * @param riskPerson
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByExampleSelectiveData(RiskPerson riskPerson, Example example){
        return super.updateByExampleSelective(riskPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据riskPersonId删除个人风险信息
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int deleteData(RiskPerson riskPerson) {
        return super.delete(riskPerson);
    }

    /**
     * @Title:
     * @Description: 根据riskPersonId集合批量删除个人风险信息
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int deleteDataList(List riskPersonIds,RiskPerson riskPerson){
        return super.deleteByIds(riskPersonIds,riskPerson);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除个人风险信息
     * @param example
     * @param riskPerson
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int deleteExampleData(Example example,RiskPerson riskPerson){
        return super.deleteByExample(example,riskPerson);
    }

    /**
     * @Title:
     * @Description: 查询全部个人风险信息
     * @return List<RiskPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public List<RiskPerson> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个个人风险信息
     * @param example
     * @return RiskPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public RiskPerson selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询个人风险信息
     * @param example
     * @return List<RiskPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public List<RiskPerson> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过riskPersonId查询个人风险信息
     * @param riskPersonId
     * @return RiskPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public RiskPerson selectByPrimaryKey(Object riskPersonId) {
        return super.selectByPrimaryKey(riskPersonId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询个人风险信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public PageInfoExtend<RiskPerson> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询个人风险信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改个人风险信息
     * @param riskPerson,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeyData(RiskPerson riskPerson,boolean exclusive) {
        return super.updateByPrimaryKey(riskPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改个人风险信息,并进行排他
     * @param riskPersons
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskPerson> riskPersons,boolean exclusive){
        return super.updateListByPrimaryKey(riskPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改个人风险信息,并进行排他
     * @param riskPerson
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskPerson riskPerson,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskPerson,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人风险信息,并进行排他
     * @param riskPersons
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskPerson> riskPersons,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskPersons,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人风险信息,并进行排他
     * @param riskPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByExampleData(RiskPerson riskPerson, Example example,boolean exclusive) {
        return super.updateByExample(riskPerson,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改个人风险信息,并进行排他
     * @param riskPerson
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:14
     */
    @Override
    public int updateByExampleSelectiveData(RiskPerson riskPerson, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskPerson,example,exclusive);
    }

}
