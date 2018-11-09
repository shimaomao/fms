package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstSaveVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstModifyVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstDeleteVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstService
 * @Description: 产品利率业务层
 * @date 2018-03-27
 */
public interface ProdIntrstService {

	/**
	 * @Title:
	 * @Description: 分页查询产品利率
	 * @param prodIntrstVo
	 * @return PageInfoExtend<ProdIntrst>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
	PageInfoExtend<ProdIntrst> findProdIntrstsByPage(ProdIntrstVo prodIntrstVo);

	/**
	 * @Title:
	 * @Description: 保存产品利率
	 * @param prodIntrstSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
    void saveProdIntrst(ProdIntrstSaveVo prodIntrstSaveVo);


	/**
	 * @Title:
	 * @Description: 修改产品利率
	 * @param prodIntrstModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
	void modifyProdIntrst(ProdIntrstModifyVo prodIntrstModifyVo);

	/**
	 * @Title:
	 * @Description:  通过prodIntrstId删除产品利率
	 * @param prodIntrstDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
	void deleteProdIntrst(ProdIntrstDeleteVo prodIntrstDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过prodIntrstId集合删除产品利率
	 * @param prodIntrstDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
	void deleteProdIntrstsByProdIntrstIds(ProdIntrstDeleteListVo prodIntrstDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据prodIntrstId获取产品利率
	 * @param prodIntrstId
	 * @return ProdIntrst
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:28
	 */
	ProdIntrst findProdIntrstByProdIntrstId(String prodIntrstId);

	/**
	 * @Title:
	 * @Description:  根据产品代码，获取产品的全部利率方案信息
	 * @param product
	 * @return List<ProdIntrstVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 15:46:28
	 */
	List<ProdIntrstVo> findProdIntrstVoByProduct(String product);

	/**
	 * @Title:
	 * @Description:  根据产品代码，获取产品的全部利率方案信息
	 * @param product
	 * @return List<ProdIntrstVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 15:46:28
	 */
	String findMaxIntrstNoByProduct(String product);

	/**
	 * @Title:
	 * @Description:  根据产品代码，获取产品的全部利率方案信息
	 * @param products
	 * @return List<ProdIntrstVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 15:46:28
	 */
	void deleteProdIntrstsByProduct(List<String> products);

}
