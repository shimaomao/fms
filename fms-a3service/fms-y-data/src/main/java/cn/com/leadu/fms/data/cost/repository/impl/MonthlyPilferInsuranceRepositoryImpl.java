package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.MonthlyPilferInsuranceDao;
import cn.com.leadu.fms.data.cost.repository.MonthlyPilferInsuranceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceRepositoryImpl
 * @Description: 盗抢险月结任务信息Repository 实现层
 * @date 2018-05-31
 */
@Repository
public class MonthlyPilferInsuranceRepositoryImpl extends AbstractBaseRepository<MonthlyPilferInsuranceDao, MonthlyPilferInsurance> implements MonthlyPilferInsuranceRepository {

    /**
     * @Title:
     * @Description: 新增盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int insertData(MonthlyPilferInsurance monthlyPilferInsurance) {
        return super.insert(monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量保存盗抢险月结任务信息
     * @param monthlyPilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int insertDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances){
        return super.insertListByJdbcTemplate(monthlyPilferInsurances);
    }

    /**
     * @Title:
     * @Description: 修改盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyPilferInsurance monthlyPilferInsurance) {
        return super.updateByPrimaryKey(monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量修改盗抢险月结任务信息
     * @param monthlyPilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances){
        return super.updateListByPrimaryKey(monthlyPilferInsurances);
    }

    /**
     * @Title:
     * @Description: 动态修改盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyPilferInsurance monthlyPilferInsurance) {
        return super.updateByPrimaryKeySelective(monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 批量动态修改盗抢险月结任务信息
     * @param monthlyPilferInsurances
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances) {
        return super.updateListByPrimaryKeySelective(monthlyPilferInsurances);
    }

    /**
     * @Title:
     * @Description: 根据条件修改盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByExampleData(MonthlyPilferInsurance monthlyPilferInsurance, Example example) {
        return super.updateByExample(monthlyPilferInsurance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyPilferInsurance monthlyPilferInsurance, Example example){
        return super.updateByExampleSelective(monthlyPilferInsurance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceId删除盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int deleteData(MonthlyPilferInsurance monthlyPilferInsurance) {
        return super.delete(monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceId集合批量删除盗抢险月结任务信息
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int deleteDataList(List monthlyPilferInsuranceIds,MonthlyPilferInsurance monthlyPilferInsurance){
        return super.deleteByIds(monthlyPilferInsuranceIds,monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除盗抢险月结任务信息
     * @param example
     * @param monthlyPilferInsurance
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int deleteExampleData(Example example,MonthlyPilferInsurance monthlyPilferInsurance){
        return super.deleteByExample(example,monthlyPilferInsurance);
    }

    /**
     * @Title:
     * @Description: 查询全部盗抢险月结任务信息
     * @return List<MonthlyPilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public List<MonthlyPilferInsurance> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个盗抢险月结任务信息
     * @param example
     * @return MonthlyPilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public MonthlyPilferInsurance selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询盗抢险月结任务信息
     * @param example
     * @return List<MonthlyPilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public List<MonthlyPilferInsurance> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过monthlyPilferInsuranceId查询盗抢险月结任务信息
     * @param monthlyPilferInsuranceId
     * @return MonthlyPilferInsurance
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public MonthlyPilferInsurance selectByPrimaryKey(Object monthlyPilferInsuranceId) {
        return super.selectByPrimaryKey(monthlyPilferInsuranceId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MonthlyPilferInsurance>
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public PageInfoExtend<MonthlyPilferInsurance> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改盗抢险月结任务信息
     * @param monthlyPilferInsurance,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyPilferInsurance monthlyPilferInsurance,boolean exclusive) {
        return super.updateByPrimaryKey(monthlyPilferInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改盗抢险月结任务信息,并进行排他
     * @param monthlyPilferInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances,boolean exclusive){
        return super.updateListByPrimaryKey(monthlyPilferInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改盗抢险月结任务信息,并进行排他
     * @param monthlyPilferInsurance
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyPilferInsurance monthlyPilferInsurance,boolean exclusive) {
        return super.updateByPrimaryKeySelective(monthlyPilferInsurance,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改盗抢险月结任务信息,并进行排他
     * @param monthlyPilferInsurances
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyPilferInsurance> monthlyPilferInsurances,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(monthlyPilferInsurances,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改盗抢险月结任务信息,并进行排他
     * @param monthlyPilferInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByExampleData(MonthlyPilferInsurance monthlyPilferInsurance, Example example,boolean exclusive) {
        return super.updateByExample(monthlyPilferInsurance,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改盗抢险月结任务信息,并进行排他
     * @param monthlyPilferInsurance
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyPilferInsurance monthlyPilferInsurance, Example example,boolean exclusive){
        return super.updateByExampleSelective(monthlyPilferInsurance,example,exclusive);
    }

}
