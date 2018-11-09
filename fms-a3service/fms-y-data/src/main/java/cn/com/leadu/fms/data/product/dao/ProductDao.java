package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.Product;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductDao
 * @Description: 产品方案管理dao层
 * @date 2018-03-23
 */
public interface ProductDao extends BaseDao<Product> {

    /**
     * @Title:
     * @Description: 根据机构代码等查询条件，取得产品方案信息
     * @param productVo 查询参数
     * @param groupCodes 机构代码
     * @return List<ProductVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<ProductVo> selectProductVoListByGroupCodes(@Param("productVo")ProductVo productVo, @Param("groupCodes") List<String> groupCodes);
    /**
     * @Title:
     * @Description: 分页取得产品方案信息
     * @param productVo 查询参数
     * @return List<ProductVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<ProductVo> selectProductVosByPage(@Param("productVo")ProductVo productVo);

    /**
     * @Title:
     * @Description: 根据产品代码 获取产品的有权限的车型代码
     * @param product 产品方案代码
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<String> selectVehicleCodeListByProduct(@Param("product")String product);

    /**
     * @Title:
     * @Description: 根据产品方案Id取得
     * @param productId 产品方案Id
     * @return ProductVo
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    ProductVo selectProductVoByProductId(@Param("productId")String productId);

}