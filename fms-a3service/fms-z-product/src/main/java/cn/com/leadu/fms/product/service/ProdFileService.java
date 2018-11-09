package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileService
 * @Description: 产品附件管理业务层
 * @date 2018-04-05
 */
public interface ProdFileService {

	/**
	 * @Title:
	 * @Description: 分页查询产品附件管理
	 * @param prodFileVo
	 * @return PageInfoExtend<ProdFile>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	PageInfoExtend<ProdFile> findProdFilesByPage(ProdFileVo prodFileVo);

	/**
	 * @Title:
	 * @Description:  根据prodFileId获取产品附件管理
	 * @param prodFileId
	 * @return ProdFile
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	ProdFile findProdFileByProdFileId(String prodFileId);

	/**
	 * @Title:
	 * @Description:  根据prodVehicleId获取产品方案车型权限
	 * @param product
	 * @return ProdVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:35:36
	 */
	List<ProdFile> findProdFilesByProduct(String product);

	/**
	 * @Title:
	 * @Description:  根据产品方案获取附件类型
	 * @param product
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-4-20 11:10:00
	 */
	List<ProdFileVo> findProdFileVosByProduct(String product);

	void deleteProdFilesByProducts(List<String> products);
}
