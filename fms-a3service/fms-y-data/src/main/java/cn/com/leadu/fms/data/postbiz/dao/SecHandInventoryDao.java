package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: SecHandInventoryDao
 * @Description: 二手车库存dao层
 */
public interface SecHandInventoryDao extends BaseDao<SecHandInventory> {

    /**
     * @Title:
     * @Description: 获取车型名称
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<SecHandInventoryVo> selectSecHandInventoryVosByPage(@Param("secHandInventoryVo") SecHandInventoryVo secHandInventoryVo);
}