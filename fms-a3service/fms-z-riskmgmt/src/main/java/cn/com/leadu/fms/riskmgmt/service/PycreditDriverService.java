package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditdriver.PycreditDriverVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverService
 * @Description: 驾驶证核查业务层
 * @date 2018-06-04
 */
public interface PycreditDriverService {

	/**
	 * @Title:
	 * @Description: 分页查询驾驶证核查
	 * @param pycreditDriverVo
	 * @return PageInfoExtend<PycreditDriver>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PageInfoExtend<PycreditDriver> findPycreditDriversByPage(PycreditDriverVo pycreditDriverVo);

	/**
	 * @Title:
	 * @Description: 保存驾驶证核查
	 * @param pycreditDriverSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
    void savePycreditDriver(PycreditDriverSaveVo pycreditDriverSaveVo);


	/**
	 * @Title:
	 * @Description: 修改驾驶证核查
	 * @param pycreditDriverModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	void modifyPycreditDriver(PycreditDriverModifyVo pycreditDriverModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditDriverId删除驾驶证核查
	 * @param pycreditDriverDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	void deletePycreditDriver(PycreditDriverDeleteVo pycreditDriverDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditDriverId集合删除驾驶证核查
	 * @param pycreditDriverDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	void deletePycreditDriversByPycreditDriverIds(PycreditDriverDeleteListVo pycreditDriverDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditDriverId获取驾驶证核查
	 * @param pycreditDriverId
	 * @return PycreditDriver
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PycreditDriver findPycreditDriverByPycreditDriverId(String pycreditDriverId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改驾驶证核查,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditDriver> selectPycreditDriverList(String documentNo, int ceilingNumber);
}
