package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.MonthlySettlementDao;
import cn.com.leadu.fms.data.cost.repository.MonthlySettlementRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementRepositoryImpl
 * @Description: gps月结任务表Repository 实现层
 * @date 2018-05-28
 */
@Repository
public class MonthlySettlementRepositoryImpl extends AbstractBaseRepository<MonthlySettlementDao, MonthlySettlement> implements MonthlySettlementRepository {

    /**
     * @Title:
     * @Description: 新增gps月结任务表
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int insertData(MonthlySettlement monthlySettlement) {
        return super.insert(monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 批量保存gps月结任务表
     * @param monthlySettlements
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int insertDataList(List<MonthlySettlement> monthlySettlements){
        return super.insertListByJdbcTemplate(monthlySettlements);
    }

    /**
     * @Title:
     * @Description: 修改gps月结任务表
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int updateByPrimaryKeyData(MonthlySettlement monthlySettlement) {
        return super.updateByPrimaryKey(monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 批量修改gps月结任务表
     * @param monthlySettlements
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MonthlySettlement> monthlySettlements){
        return super.updateListByPrimaryKey(monthlySettlements);
    }

    /**
     * @Title:
     * @Description: 动态修改gps月结任务表
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MonthlySettlement monthlySettlement) {
        return super.updateByPrimaryKeySelective(monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 批量动态修改gps月结任务表
     * @param monthlySettlements
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public int updateByPrimaryKeySelectiveDataList(List<MonthlySettlement> monthlySettlements) {
        return super.updateListByPrimaryKeySelective(monthlySettlements);
    }

    /**
     * @Title:
     * @Description: 根据条件修改gps月结任务表
     * @param monthlySettlement
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int updateByExampleData(MonthlySettlement monthlySettlement, Example example) {
        return super.updateByExample(monthlySettlement,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改gps月结任务表
     * @param monthlySettlement
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int updateByExampleSelectiveData(MonthlySettlement monthlySettlement, Example example){
        return super.updateByExampleSelective(monthlySettlement,example);
    }
    
    /**
     * @Title:
     * @Description: 根据monthlySettlementId删除gps月结任务表
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public int deleteData(MonthlySettlement monthlySettlement) {
        return super.delete(monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 根据monthlySettlementId集合批量删除gps月结任务表
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public int deleteDataList(List monthlySettlementIds,MonthlySettlement monthlySettlement){
        return super.deleteByIds(monthlySettlementIds,monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除gps月结任务表
     * @param example
     * @param monthlySettlement
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public int deleteExampleData(Example example,MonthlySettlement monthlySettlement){
        return super.deleteByExample(example,monthlySettlement);
    }

    /**
     * @Title:
     * @Description: 查询全部gps月结任务表
     * @return List<MonthlySettlement>
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public List<MonthlySettlement> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个gps月结任务表
     * @param example
     * @return MonthlySettlement
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public MonthlySettlement selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询gps月结任务表
     * @param example
     * @return List<MonthlySettlement>
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public List<MonthlySettlement> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过monthlySettlementId查询gps月结任务表
     * @param monthlySettlementId
     * @return MonthlySettlement
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public MonthlySettlement selectByPrimaryKey(Object monthlySettlementId) {
        return super.selectByPrimaryKey(monthlySettlementId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询gps月结任务表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MonthlySettlement>
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @Override
    public PageInfoExtend<MonthlySettlement> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询gps月结任务表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
