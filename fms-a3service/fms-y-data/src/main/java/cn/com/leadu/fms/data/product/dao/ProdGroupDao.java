package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupDao
 * @Description: 产品方案机构权限dao层
 * @date 2018-04-05
 */
public interface ProdGroupDao extends BaseDao<ProdGroup> {
    /**
     * @Title:
     * @Description: 根据产品方案取得
     * @param product 产品方案方案
     * @return List<ProdGroupVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<ProdGroupVo> selectProdGroupVosByProduct(@Param("product")String product);

}