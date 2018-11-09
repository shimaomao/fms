package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorSaveVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorModifyVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorDeleteVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorService
 * @Description: 利率因子业务层
 * @date 2018-03-27
 */
public interface IntrstFactorService {

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param intrstFactorVo
	 * @return PageInfoExtend<IntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	PageInfoExtend<IntrstFactor> findIntrstFactorsByPage(IntrstFactorVo intrstFactorVo);

	/**
	 * @Title:
	 * @Description: 保存利率因子
	 * @param intrstFactorSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
    void saveIntrstFactor(IntrstFactorSaveVo intrstFactorSaveVo);


	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param intrstFactorModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	void modifyIntrstFactor(IntrstFactorModifyVo intrstFactorModifyVo);

	/**
	 * @Title:
	 * @Description:  通过intrstFactorId删除利率因子
	 * @param intrstFactorDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	void deleteIntrstFactor(IntrstFactorDeleteVo intrstFactorDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过intrstFactorId集合删除利率因子
	 * @param intrstFactorDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	void deleteIntrstFactorsByIntrstFactorIds(IntrstFactorDeleteListVo intrstFactorDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据intrstFactorId获取利率因子
	 * @param intrstFactorId
	 * @return IntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	IntrstFactor findIntrstFactorByIntrstFactorId(String intrstFactorId);

    /**
     * @Title:
     * @Description: 取得全部启用的利率因子
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 18:07:17
	 */
	List<IntrstFactor> findIntrstFactorAllList();


}
