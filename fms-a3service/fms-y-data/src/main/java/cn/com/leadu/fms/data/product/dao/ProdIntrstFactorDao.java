package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorDao
 * @Description: 产品利率dao层
 * @date 2018-03-27
 */
public interface ProdIntrstFactorDao extends BaseDao<ProdIntrstFactor> {

    /**
     * @Title:
     * @Description: 根据机构代码等查询条件，取得产品方案信息
     * @param product 产品方案代码
     * @return List<ProdIntrstFactorVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:21:58
     */
    List<ProdIntrstFactorVo> selectProdIntrstFactorListByProduct(@Param("product") String product);

}