package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import cn.com.leadu.fms.postbiz.validator.sechandinventory.vo.SecHandInventorySaveVo;
import cn.com.leadu.fms.postbiz.validator.sechandinventory.vo.SecHandInventoryModifyVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryService
 * @Description: 库存管理业务层
 */
public interface SecHandInventoryService {

	/**
	 * @Title:
	 * @Description: 分页查询库存管理
	 * @param secHandInventoryVo
	 * @return PageInfoExtend<SecHandInventoryVo>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-19 14:16:21
	 */
	PageInfoExtend<SecHandInventoryVo> findSecHandInventoryVosByPage(SecHandInventoryVo secHandInventoryVo);

	/**
	 * @Title:
	 * @Description: 保存库存管理
	 * @param secHandInventorySaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-19 14:16:21
	 */
    void saveSecHandInventory(SecHandInventorySaveVo secHandInventorySaveVo);


	/**
	 * @Title:
	 * @Description: 修改库存管理
	 * @param secHandInventoryModifyVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-19 14:16:21
	 */
	void modifySecHandInventory(SecHandInventoryModifyVo secHandInventoryModifyVo);


	/**
	 * @Title:
	 * @Description:  根据secHandId获取库存管理
	 * @param secHandId
	 * @return SecHandInventory
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-19 14:16:21
	 */
	SecHandInventoryVo findSecHandInventoryVoBySecHandId(String secHandId);

}
