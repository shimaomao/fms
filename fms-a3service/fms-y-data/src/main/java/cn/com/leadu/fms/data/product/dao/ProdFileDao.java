package cn.com.leadu.fms.data.product.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileDao
 * @Description: 产品附件管理dao层
 * @date 2018-04-05
 */
public interface ProdFileDao extends BaseDao<ProdFile> {
    /**
     * @Title:
     * @Description: 根据产品方案取得
     * @param product 产品方案方案
     * @return List<ProdFileVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<ProdFileVo> selectProdFileVosByProduct(@Param("product")String product);


}