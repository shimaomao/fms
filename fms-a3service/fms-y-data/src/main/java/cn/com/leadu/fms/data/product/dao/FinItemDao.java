package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemDao
 * @Description: 融资项目管理dao层
 * @date 2018-03-19
 */
public interface FinItemDao extends BaseDao<FinItem> {

    /**
     * @Title:
     * @Description: 根据产品方案代码，获取产品方案的融资项目
     * @param product 产品方案代码
     * @throws
     * @author wangxue
     * @date 2018-3-24 22:06:58
     */
    List<FinItemVo> selectFinItemVoListByProduct(@Param("product") String product);

}