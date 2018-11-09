package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import org.apache.ibatis.annotations.Param;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstDao
 * @Description: 产品利率dao层
 * @date 2018-03-27
 */
public interface ProdIntrstDao extends BaseDao<ProdIntrst> {

    /**
     * @Title:
     * @Description: 查询最大的利率方案序号
     * @param product
     * @return String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    String selectIntrstNoMax(@Param("product")String product) ;

}