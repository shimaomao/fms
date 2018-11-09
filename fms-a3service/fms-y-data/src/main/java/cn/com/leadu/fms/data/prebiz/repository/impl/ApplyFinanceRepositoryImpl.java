package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ApplyFinanceDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyFinanceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceRepositoryImpl
 * @Description: 融资信息Repository 实现层
 * @date 2018-03-24
 */
@Repository
public class ApplyFinanceRepositoryImpl extends AbstractBaseRepository<ApplyFinanceDao, ApplyFinance> implements ApplyFinanceRepository {

    /**
     * @Title:
     * @Description: 新增融资信息
     * @param applyFinance
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int insertData(ApplyFinance applyFinance) {
        return super.insert(applyFinance);
    }

    /**
     * @Title:
     * @Description: 批量保存融资信息
     * @param applyFinances
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int insertDataList(List<ApplyFinance> applyFinances){
        return super.insertListByJdbcTemplate(applyFinances);
    }

    /**
     * @Title:
     * @Description: 修改融资信息
     * @param applyFinance
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int updateByPrimaryKeyData(ApplyFinance applyFinance) {
        return super.updateByPrimaryKey(applyFinance);
    }

    /**
     * @Title:
     * @Description: 批量修改融资信息
     * @param applyFinances
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyFinance> applyFinances){
        return super.insertListByJdbcTemplate(applyFinances);
    }

    /**
     * @Title:
     * @Description: 动态修改融资信息
     * @param applyFinance
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyFinance applyFinance) {
        return super.updateByPrimaryKeySelective(applyFinance);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资信息
     * @param applyFinances
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public int updateByPrimaryKeySelectiveDataList(List<ApplyFinance> applyFinances) {
        return super.updateListByPrimaryKeySelective(applyFinances);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资信息
     * @param applyFinance
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int updateByExampleData(ApplyFinance applyFinance, Example example) {
        return super.updateByExample(applyFinance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资信息
     * @param applyFinance
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int updateByExampleSelectiveData(ApplyFinance applyFinance, Example example){
        return super.updateByExampleSelective(applyFinance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据applyFinId删除融资信息
     * @param applyFinance
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public int deleteData(ApplyFinance applyFinance) {
        return super.delete(applyFinance);
    }

    /**
     * @Title:
     * @Description: 根据applyFinId集合批量删除融资信息
     * @param applyFinance
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public int deleteDataList(List applyFinIds,ApplyFinance applyFinance){
        return super.deleteByIds(applyFinIds,applyFinance);
    }

    /**
     * @Title:
     * @Description: 查询全部融资信息
     * @return List<ApplyFinance>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public List<ApplyFinance> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资信息
     * @param example
     * @return ApplyFinance
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public ApplyFinance selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资信息
     * @param example
     * @return List<ApplyFinance>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public List<ApplyFinance> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyFinId查询融资信息
     * @param applyFinId
     * @return ApplyFinance
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public ApplyFinance selectByPrimaryKey(Object applyFinId) {
        return super.selectByPrimaryKey(applyFinId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ApplyFinance>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    @Override
    public PageInfoExtend<ApplyFinance> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ApplyFinance>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public PageInfoExtend<ApplyFinance> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资信息
     * @param applyNo 订单编号
     * @return ApplyFinanceVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    @Override
    public ApplyFinanceVo selectApplyFinanceVoByApplyNo(String applyNo) {
        return baseDao.selectApplyFinanceVoByApplyNo(applyNo);
    }
}
