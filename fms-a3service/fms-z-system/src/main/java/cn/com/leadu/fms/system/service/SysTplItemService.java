package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.system.validator.systplitem.vo.SysTplItemDeleteListVo;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemService
 * @Description: 模板可设项目管理业务层
 * @date 2018-03-12
 */
public interface SysTplItemService {

	/**
	 * @Title:
	 * @Description:  通过tplItemId集合删除模板可设项目管理
	 * @param sysTplItemDeleteListVo
	 * @return
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	void deleteSysTplItemsByTplItemIds(SysTplItemDeleteListVo sysTplItemDeleteListVo);

	/**
	 * @Title:
	 * @Description: 保存模板可设项目List
	 * @param sysTplItemList
	 * @throws
	 * @author wangxue
	 * @date 2018-3-15 10:53:25
	 */
	void saveSysTplItemList(List<SysTplItem> sysTplItemList);

	/**
	 * @Title:
	 * @Description: 根据tplTypeKey获取模板类型的可设置项目
	 * @param tplTypeKey
	 * @return List
	 * @throws
	 * @author wangxue
	 * @date 2018-3-15 10:53:25
	 */
	List<SysTplItemVo> findSysTplItemListByTplTypeKey(String tplTypeKey);

}
