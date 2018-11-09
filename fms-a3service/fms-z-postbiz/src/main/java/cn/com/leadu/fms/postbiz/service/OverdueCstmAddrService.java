package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmaddr.OverdueCstmAddrVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrService
 * @Description: 逾期客户地址信息业务层
 * @date 2018-05-17
 */
public interface OverdueCstmAddrService {

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户地址信息
	 * @param overdueCstmAddrVo
	 * @return PageInfoExtend<OverdueCstmAddr>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	PageInfoExtend<OverdueCstmAddr> findOverdueCstmAddrsByPage(OverdueCstmAddrVo overdueCstmAddrVo);

	/**
	 * @Title:
	 * @Description: 保存逾期客户地址信息
	 * @param overdueCstmAddrSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
    void saveOverdueCstmAddr(OverdueCstmAddrSaveVo overdueCstmAddrSaveVo);


	/**
	 * @Title:
	 * @Description: 修改逾期客户地址信息
	 * @param overdueCstmAddrModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	void modifyOverdueCstmAddr(OverdueCstmAddrModifyVo overdueCstmAddrModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueCstmAddrId删除逾期客户地址信息
	 * @param overdueCstmAddrDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	void deleteOverdueCstmAddr(OverdueCstmAddrDeleteVo overdueCstmAddrDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueCstmAddrId集合删除逾期客户地址信息
	 * @param overdueCstmAddrDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	void deleteOverdueCstmAddrsByOverdueCstmAddrIds(OverdueCstmAddrDeleteListVo overdueCstmAddrDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据overdueCstmAddrId获取逾期客户地址信息
	 * @param overdueCstmAddrId
	 * @return OverdueCstmAddr
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	OverdueCstmAddr findOverdueCstmAddrByOverdueCstmAddrId(String overdueCstmAddrId);

}
