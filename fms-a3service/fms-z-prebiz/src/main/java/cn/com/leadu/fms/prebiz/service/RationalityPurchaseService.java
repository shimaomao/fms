package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import cn.com.leadu.fms.pojo.prebiz.vo.rationalitypurchase.RationalityPurchaseVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseSaveVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseModifyVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseDeleteVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseService
 * @Description: 购买合理性业务层
 * @date 2018-05-29
 */
public interface RationalityPurchaseService {

	/**
	 * @Title:
	 * @Description: 分页查询购买合理性
	 * @param rationalityPurchaseVo
	 * @return PageInfoExtend<RationalityPurchase>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	PageInfoExtend<RationalityPurchase> findRationalityPurchasesByPage(RationalityPurchaseVo rationalityPurchaseVo);

	/**
	 * @Title:
	 * @Description: 保存购买合理性
	 * @param rationalityPurchaseSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
    void saveRationalityPurchase(RationalityPurchaseSaveVo rationalityPurchaseSaveVo);


	/**
	 * @Title:
	 * @Description: 修改购买合理性
	 * @param rationalityPurchaseModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	void modifyRationalityPurchase(RationalityPurchaseModifyVo rationalityPurchaseModifyVo);

	/**
	 * @Title:
	 * @Description:  通过buyCarId删除购买合理性
	 * @param rationalityPurchaseDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	void deleteRationalityPurchase(RationalityPurchaseDeleteVo rationalityPurchaseDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过buyCarId集合删除购买合理性
	 * @param rationalityPurchaseDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	void deleteRationalityPurchasesByBuyCarIds(RationalityPurchaseDeleteListVo rationalityPurchaseDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据buyCarId获取购买合理性
	 * @param buyCarId
	 * @return RationalityPurchase
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	RationalityPurchase findRationalityPurchaseByBuyCarId(String buyCarId);

	/**
	 * @Title:
	 * @Description:  根据applyNo更新购买合理性
	 * @param rationalityPurchase
	 * @return RationalityPurchase
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	void modifyRationalityPurchaseByApplyNo(RationalityPurchase rationalityPurchase,String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取购买合理性
	 * @param applyNo
	 * @return RationalityPurchase
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	RationalityPurchase findRationalityPurchaseByApplyNo(String applyNo);

}
