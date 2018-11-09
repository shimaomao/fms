package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.BasSalesDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasSalesRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasSalesRepositoryImpl
 * @Description: 实际销售方Repository 实现层
 * @date 2018-05-03
 */
@Repository
public class BasSalesRepositoryImpl extends AbstractBaseRepository<BasSalesDao, BasSales> implements BasSalesRepository {

    /**
     * @Title:
     * @Description: 新增实际销售方
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int insertData(BasSales basSales) {
        return super.insert(basSales);
    }

    /**
     * @Title:
     * @Description: 批量保存实际销售方
     * @param basSaless
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int insertDataList(List<BasSales> basSaless){
        return super.insertListByJdbcTemplate(basSaless);
    }

    /**
     * @Title:
     * @Description: 修改实际销售方
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int updateByPrimaryKeyData(BasSales basSales) {
        return super.updateByPrimaryKey(basSales);
    }

    /**
     * @Title:
     * @Description: 批量修改实际销售方
     * @param basSaless
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasSales> basSaless){
        return super.updateListByPrimaryKey(basSaless);
    }

    /**
     * @Title:
     * @Description: 动态修改实际销售方
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasSales basSales) {
        return super.updateByPrimaryKeySelective(basSales);
    }

    /**
     * @Title:
     * @Description: 批量动态修改实际销售方
     * @param basSaless
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasSales> basSaless) {
        return super.updateListByPrimaryKeySelective(basSaless);
    }

    /**
     * @Title:
     * @Description: 根据条件修改实际销售方
     * @param basSales
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int updateByExampleData(BasSales basSales, Example example) {
        return super.updateByExample(basSales,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改实际销售方
     * @param basSales
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int updateByExampleSelectiveData(BasSales basSales, Example example){
        return super.updateByExampleSelective(basSales,example);
    }
    
    /**
     * @Title:
     * @Description: 根据salesId删除实际销售方
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public int deleteData(BasSales basSales) {
        return super.delete(basSales);
    }

    /**
     * @Title:
     * @Description: 根据salesId集合批量删除实际销售方
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public int deleteDataList(List salesIds,BasSales basSales){
        return super.deleteByIds(salesIds,basSales);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除实际销售方
     * @param example
     * @param basSales
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public int deleteExampleData(Example example,BasSales basSales){
        return super.deleteByExample(example,basSales);
    }

    /**
     * @Title:
     * @Description: 查询全部实际销售方
     * @return List<BasSales>
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public List<BasSales> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个实际销售方
     * @param example
     * @return BasSales
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public BasSales selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询实际销售方
     * @param example
     * @return List<BasSales>
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public List<BasSales> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过salesId查询实际销售方
     * @param salesId
     * @return BasSales
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public BasSales selectByPrimaryKey(Object salesId) {
        return super.selectByPrimaryKey(salesId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询实际销售方
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasSales>
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Override
    public PageInfoExtend<BasSales> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询实际销售方vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据salesId获取实际销售方
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public BasSalesVo selectBasSalesBysalesId(String salesId){
        return baseDao.selectBasSalesBysalesId(salesId);
    }

}
