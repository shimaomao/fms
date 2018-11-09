package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrService
 * @Description: 客户个人地址信息业务层
 * @date 2018-03-26
 */
public interface CstmPersAddrService {

	/**
	 * @Title:
	 * @Description: 分页查询客户个人地址信息
	 * @param cstmPersAddrVo
	 * @return PageInfoExtend<CstmPersAddr>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	PageInfoExtend<CstmPersAddr> findCstmPersAddrsByPage(CstmPersAddrVo cstmPersAddrVo);

	/**
	 * @Title:
	 * @Description: 保存客户个人地址信息
	 * @param cstmPersAddrSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
    void saveCstmPersAddr(CstmPersAddrSaveVo cstmPersAddrSaveVo,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户个人地址信息
	 * @param cstmPersAddrModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	void modifyCstmPersAddr(CstmPersAddrModifyVo cstmPersAddrModifyVo);

	/**
	 * @Title:
	 * @Description:  通过persAddrId删除客户个人地址信息
	 * @param cstmPersAddrDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	void deleteCstmPersAddr(CstmPersAddrDeleteVo cstmPersAddrDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过persAddrId集合删除客户个人地址信息
	 * @param cstmPersAddrDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	void deleteCstmPersAddrsByPersAddrIds(CstmPersAddrDeleteListVo cstmPersAddrDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据persAddrId获取客户个人地址信息
	 * @param persAddrId
	 * @return CstmPersAddr
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	CstmPersAddr findCstmPersAddrByPersAddrId(String persAddrId);

	/**
	 * 根据订单号获取地址信息
	 * @param applyNo
	 * @return
	 */
	 CstmPersAddr findCstmPersAddrByApplyNo(String applyNo);
	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户个人地址信息
	 * @param cstmPersAddr
	 * @return CstmPersAddr
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	 void updateCstmPersAddrByApplyNo(CstmPersAddr cstmPersAddr,String applyNo);
}
