package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditaddr.PycreditAddrVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrService
 * @Description: 地址核验业务层
 * @date 2018-06-04
 */
public interface PycreditAddrService {

	/**
	 * @Title:
	 * @Description: 分页查询地址核验
	 * @param pycreditAddrVo
	 * @return PageInfoExtend<PycreditAddr>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PageInfoExtend<PycreditAddr> findPycreditAddrsByPage(PycreditAddrVo pycreditAddrVo);

	/**
	 * @Title:
	 * @Description: 保存地址核验
	 * @param pycreditAddrSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
    void savePycreditAddr(PycreditAddrSaveVo pycreditAddrSaveVo);


	/**
	 * @Title:
	 * @Description: 修改地址核验
	 * @param pycreditAddrModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	void modifyPycreditAddr(PycreditAddrModifyVo pycreditAddrModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditAddrId删除地址核验
	 * @param pycreditAddrDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	void deletePycreditAddr(PycreditAddrDeleteVo pycreditAddrDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditAddrId集合删除地址核验
	 * @param pycreditAddrDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	void deletePycreditAddrsByPycreditAddrIds(PycreditAddrDeleteListVo pycreditAddrDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditAddrId获取地址核验
	 * @param pycreditAddrId
	 * @return PycreditAddr
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PycreditAddr findPycreditAddrByPycreditAddrId(String pycreditAddrId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改地址核验,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditAddr> selectPycreditAddrList(String documentNo, int ceilingNumber);
}
