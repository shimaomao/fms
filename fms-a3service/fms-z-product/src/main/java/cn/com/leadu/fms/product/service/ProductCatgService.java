package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import cn.com.leadu.fms.pojo.product.vo.productcatg.ProductCatgVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgSaveVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgModifyVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgDeleteVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductCatgService
 * @Description: 产品大类管理业务层
 * @date 2018-03-21
 */
public interface ProductCatgService {

	/**
	 * @Title:
	 * @Description: 分页查询产品大类管理
	 * @param productCatgVo
	 * @return PageInfoExtend<ProductCatg>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	PageInfoExtend<ProductCatg> findProductCatgsByPage(ProductCatgVo productCatgVo);

	/**
	 * @Title:
	 * @Description: 保存产品大类管理
	 * @param productCatgSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
    void saveProductCatg(ProductCatgSaveVo productCatgSaveVo);


	/**
	 * @Title:
	 * @Description: 修改产品大类管理
	 * @param productCatgModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	void modifyProductCatg(ProductCatgModifyVo productCatgModifyVo);

	/**
	 * @Title:
	 * @Description:  通过productCatgId删除产品大类管理
	 * @param productCatgDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	void deleteProductCatg(ProductCatgDeleteVo productCatgDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过productCatgId集合删除产品大类管理
	 * @param productCatgDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	void deleteProductCatgsByProductCatgIds(ProductCatgDeleteListVo productCatgDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据productCatgId获取产品大类管理
	 * @param productCatgId
	 * @return ProductCatg
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	ProductCatg findProductCatgByProductCatgId(String productCatgId);

	/**
	 * @Title:
	 * @Description:  根据productCatg获取产品大类管理
	 * @param productCatg
	 * @return ProductCatg
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-21 12:09:48
	 */
	ProductCatg findProductCatgByProductCatg(String productCatg);

	/**
	 * @Title:
	 * @Description:  取得全部产品大类信息
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-21 19:43:48
	 */
	List<ProductCatg> findProductCatgListByAll();

}
