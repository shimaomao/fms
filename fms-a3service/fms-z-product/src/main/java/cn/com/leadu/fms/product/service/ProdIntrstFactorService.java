package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorSaveVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorModifyVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorDeleteVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;
import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorService
 * @Description: 产品利率业务层
 * @date 2018-03-27
 */
public interface ProdIntrstFactorService {

	/**
	 * @Title:
	 * @Description: 分页查询产品利率
	 * @param prodIntrstFactorVo
	 * @return PageInfoExtend<ProdIntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
	PageInfoExtend<ProdIntrstFactor> findProdIntrstFactorsByPage(ProdIntrstFactorVo prodIntrstFactorVo);

	/**
	 * @Title:
	 * @Description: 保存产品利率
	 * @param prodIntrstFactorSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
    void saveProdIntrstFactor(ProdIntrstFactorSaveVo prodIntrstFactorSaveVo);


	/**
	 * @Title:
	 * @Description: 修改产品利率
	 * @param prodIntrstFactorModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
	void modifyProdIntrstFactor(ProdIntrstFactorModifyVo prodIntrstFactorModifyVo);

	/**
	 * @Title:
	 * @Description:  通过prodIntrstFactorId删除产品利率
	 * @param prodIntrstFactorDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
	void deleteProdIntrstFactor(ProdIntrstFactorDeleteVo prodIntrstFactorDeleteVo);

	/**
	 * @Title:
	 * @Description:  通过prodIntrstFactorId集合删除产品利率
	 * @param prodIntrstFactorDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
	void deleteProdIntrstFactorsByProdIntrstFactorIds(ProdIntrstFactorDeleteListVo prodIntrstFactorDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据prodIntrstFactorId获取产品利率
	 * @param prodIntrstFactorId
	 * @return ProdIntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:28
	 */
	ProdIntrstFactor findProdIntrstFactorByProdIntrstFactorId(String prodIntrstFactorId);

	/**
	 * @Title:
	 * @Description:  根据产品方案代码，取得产品的利率方案的因子信息
	 * @param product
	 * @return List<ProdIntrstFactorVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 15:45:28
	 */
	Map<String, List<ProdIntrstFactorVo>> findProdIntrstFactorVosByProduct(String product);;
}
