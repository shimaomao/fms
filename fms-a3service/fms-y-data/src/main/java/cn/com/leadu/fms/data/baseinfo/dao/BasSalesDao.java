package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasSalesDao
 * @Description: 实际销售方dao层
 * @date 2018-05-03
 */
public interface BasSalesDao extends BaseDao<BasSales> {

    /**
     * @Title:
     * @Description: 分页查询实际销售方
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<BasSalesVo> selectBasSalessBypage(@Param("basSalesVo")BasSalesVo basSalesVo);

    /**
     * @Title:
     * @Description: 根据salesId获取实际销售方
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    BasSalesVo selectBasSalesBysalesId(@Param("salesId")String salesId);
}