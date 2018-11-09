package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.MonthlyRentDao;
import cn.com.leadu.fms.data.postbiz.repository.MonthlyRentRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyRentRepositoryImpl
 * @Description: 月度租金到账率Repository 实现层
 */
@Repository
public class MonthlyRentRepositoryImpl extends AbstractBaseRepository<MonthlyRentDao, MonthlyRent> implements MonthlyRentRepository {

    /**
     * @Title:
     * @Description: 新增月度租金到账率
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int insertData(MonthlyRent monthlyRent) {
        return super.insert(monthlyRent);
    }

    /**
     * @Title:
     * @Description: 批量保存月度租金到账率
     * @param monthlyRents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int insertDataList(List<MonthlyRent> monthlyRents){
        return super.insertListByJdbcTemplate(monthlyRents);
    }

    /**
     * @Title:
     * @Description: 修改月度租金到账率
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyRent monthlyRent) {
        return super.updateByPrimaryKey(monthlyRent);
    }

    /**
     * @Title:
     * @Description: 批量修改月度租金到账率
     * @param monthlyRents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyRent> monthlyRents){
        return super.updateListByPrimaryKey(monthlyRents);
    }

    /**
     * @Title:
     * @Description: 动态修改月度租金到账率
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyRent monthlyRent) {
        return super.updateByPrimaryKeySelective(monthlyRent);
    }

    /**
     * @Title:
     * @Description: 批量动态修改月度租金到账率
     * @param monthlyRents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyRent> monthlyRents) {
        return super.updateListByPrimaryKeySelective(monthlyRents);
    }

    /**
     * @Title:
     * @Description: 根据条件修改月度租金到账率
     * @param monthlyRent
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByExampleData(MonthlyRent monthlyRent, Example example) {
        return super.updateByExample(monthlyRent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改月度租金到账率
     * @param monthlyRent
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyRent monthlyRent, Example example){
        return super.updateByExampleSelective(monthlyRent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据monthlyRentId删除月度租金到账率
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int deleteData(MonthlyRent monthlyRent) {
        return super.delete(monthlyRent);
    }

    /**
     * @Title:
     * @Description: 根据monthlyRentId集合批量删除月度租金到账率
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int deleteDataList(List monthlyRentIds,MonthlyRent monthlyRent){
        return super.deleteByIds(monthlyRentIds,monthlyRent);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除月度租金到账率
     * @param example
     * @param monthlyRent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int deleteExampleData(Example example,MonthlyRent monthlyRent){
        return super.deleteByExample(example,monthlyRent);
    }

    /**
     * @Title:
     * @Description: 查询全部月度租金到账率
     * @return List<MonthlyRent>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public List<MonthlyRent> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个月度租金到账率
     * @param example
     * @return MonthlyRent
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public MonthlyRent selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询月度租金到账率
     * @param example
     * @return List<MonthlyRent>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public List<MonthlyRent> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过monthlyRentId查询月度租金到账率
     * @param monthlyRentId
     * @return MonthlyRent
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public MonthlyRent selectByPrimaryKey(Object monthlyRentId) {
        return super.selectByPrimaryKey(monthlyRentId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询月度租金到账率
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MonthlyRent>
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public PageInfoExtend<MonthlyRent> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询月度租金到账率vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改月度租金到账率
     * @param monthlyRent,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeyData(MonthlyRent monthlyRent,boolean exclusive) {
        return super.updateByPrimaryKey(monthlyRent,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改月度租金到账率,并进行排他
     * @param monthlyRents
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlyRent> monthlyRents,boolean exclusive){
        return super.updateListByPrimaryKey(monthlyRents,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改月度租金到账率,并进行排他
     * @param monthlyRent
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlyRent monthlyRent,boolean exclusive) {
        return super.updateByPrimaryKeySelective(monthlyRent,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改月度租金到账率,并进行排他
     * @param monthlyRents
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MonthlyRent> monthlyRents,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(monthlyRents,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改月度租金到账率,并进行排他
     * @param monthlyRent
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByExampleData(MonthlyRent monthlyRent, Example example,boolean exclusive) {
        return super.updateByExample(monthlyRent,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改月度租金到账率,并进行排他
     * @param monthlyRent
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-25 17:11:35
     */
    @Override
    public int updateByExampleSelectiveData(MonthlyRent monthlyRent, Example example,boolean exclusive){
        return super.updateByExampleSelective(monthlyRent,example,exclusive);
    }

}
