package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateService
 * @Description: 客户个人配偶信息业务层
 * @date 2018-03-26
 */
public interface CstmPersMateService {

	/**
	 * @Title:
	 * @Description: 分页查询客户个人配偶信息
	 * @param cstmPersMateVo
	 * @return PageInfoExtend<CstmPersMate>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	PageInfoExtend<CstmPersMate> findCstmPersMatesByPage(CstmPersMateVo cstmPersMateVo);

	/**
	 * @Title:
	 * @Description: 保存客户个人配偶信息
	 * @param cstmPersMateSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
    void saveCstmPersMate(CstmPersMateSaveVo cstmPersMateSaveVo,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户个人配偶信息
	 * @param cstmPersMateModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	void modifyCstmPersMate(CstmPersMateModifyVo cstmPersMateModifyVo);

	/**
	 * @Title:
	 * @Description:  通过persMateId删除客户个人配偶信息
	 * @param cstmPersMateDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	void deleteCstmPersMate(CstmPersMateDeleteVo cstmPersMateDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过persMateId集合删除客户个人配偶信息
	 * @param cstmPersMateDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	void deleteCstmPersMatesByPersMateIds(CstmPersMateDeleteListVo cstmPersMateDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据persMateId获取客户个人配偶信息
	 * @param persMateId
	 * @return CstmPersMate
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	CstmPersMate findCstmPersMateByPersMateId(String persMateId);


	/**
	 * 根据订单编号获取配偶信息
	 * @param applyNo
	 * @return
	 */
	 CstmPersMate findCstmPersMateByApplyNo(String applyNo);
	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户个人配偶信息
	 * @param cstmPersMate
	 * @return CstmPersMate
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 20:22:15
	 */
	void updateCstmPersMateByapplyNo(CstmPersMate cstmPersMate,String applyNo);
}
