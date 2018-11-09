package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemSaveVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemModifyVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemDeleteVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemService
 * @Description: 融资项目管理业务层
 * @date 2018-03-19
 */
public interface FinItemService {

	/**
	 * @Title:
	 * @Description: 分页查询融资项目管理
	 * @param finItemVo
	 * @return PageInfoExtend<FinItem>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	PageInfoExtend<FinItem> findFinItemsByPage(FinItemVo finItemVo);

	/**
	 * @Title:
	 * @Description: 保存融资项目管理
	 * @param finItemSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
    void saveFinItem(FinItemSaveVo finItemSaveVo);


	/**
	 * @Title:
	 * @Description: 修改融资项目管理
	 * @param finItemModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	void modifyFinItem(FinItemModifyVo finItemModifyVo);

	/**
	 * @Title:
	 * @Description:  通过finItemId删除融资项目管理
	 * @param finItemDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	void deleteFinItem(FinItemDeleteVo finItemDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过finItemId集合删除融资项目管理
	 * @param finItemDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	void deleteFinItemsByFinItemIds(FinItemDeleteListVo finItemDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据finItemId获取融资项目管理
	 * @param finItemId
	 * @return FinItem
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-19 11:03:18
	 */
	FinItem findFinItemByFinItemId(String finItemId);
	/**
	 * @Title:
	 * @Description:  根据finItem获取融资项目管理
	 * @param finItem 代码
	 * @return FinItem
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-4 11:03:18
	 */
	FinItem findFinItemByFinItem(String finItem);

	/**
	 * @Title:
	 * @Description:  根据product 获取融资项目信息
	 * @param product
	 * @return List<FinItemVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-19 11:03:18
	 */
	List<FinItemVo> findFinItemVoByProduct(String product);
	/**
	 * @Title:
	 * @Description:  取得所有融资项目
	 * @throws
	 * @author wangxue
	 * @date 2018-3-23 16:18:12
	 */
	List<FinItem> findAllFinItemList();
}
