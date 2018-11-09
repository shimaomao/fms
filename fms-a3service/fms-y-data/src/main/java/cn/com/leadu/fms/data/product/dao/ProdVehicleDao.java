package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleDao
 * @Description: 产品方案车型权限dao层
 * @date 2018-04-05
 */
public interface ProdVehicleDao extends BaseDao<ProdVehicle> {
    /**
     * @Title:
     * @Description: 根据产品方案取得
     * @param product 产品方案方案
     * @return List<ProdVehicleVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<ProdVehicleVo> selectProdVehicleVosByProduct(@Param("product")String product);

}