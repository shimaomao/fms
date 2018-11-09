package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchSaveVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchModifyVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchDeleteVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchService
 * @Description: 派单信息业务层
 * @date 2018-05-25
 */
public interface GpsDispatchService {

	/**
	 * @Title:
	 * @Description:  查询派单信息一览
	 * @param gpsDispatchVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/25 03:51:07
	 */
	PageInfoExtend<GpsDispatchVo> findGpsDispatchVosByPage(GpsDispatchVo gpsDispatchVo);

	/**
	 * @Title:
	 * @Description: 暂存派单信息
	 * @param: gpsDispatchVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/18 0018 16:23
	 */
    void storageGpsDispatch(GpsDispatchVo gpsDispatchVo);

	/**
	 * @Title:
	 * @Description: 保存派单信息
	 * @param gpsDispatchSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
    void saveGpsDispatch(GpsDispatchSaveVo gpsDispatchSaveVo);


	/**
	 * @Title:
	 * @Description: 修改派单信息
	 * @param gpsDispatchModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	void modifyGpsDispatch(GpsDispatchModifyVo gpsDispatchModifyVo);


	/**
	 * @Title:
	 * @Description:  根据dispatchId获取派单信息
	 * @param dispatchId
	 * @return GpsDispatch
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	GpsDispatch findGpsDispatchByDispatchId(String dispatchId);
	
	/** 
	* @Description: 查询gps月结一览信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/17 20:26
	*/
	PageInfoExtend<GpsDispatchMonthlyVo> findGpsDispatchMonthlysVosListByPage(GpsDispatchMonthlyVo gpsDispatchMonthlyVo);

	/** 
	* @Description: 查询派单月结信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/28 15:13
	*/ 
	PageInfoExtend<GpsDispatchMonthlyVo> findGpsDispatchMonthlysVos(GpsDispatchMonthlyVo gpsDispatchMonthlyVo);

	/**
	 * @Title:
	 * @Description:   根据合同号查询派单信息详情
	 * @param contNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/28 04:44:13
	 */
	GpsDispatchVo findGpsDispatchDetailByContNo(String contNo);

	/**
	 * @Title:
	 * @Description:   查询天易派单状态
	 * @param dispatchId
	 * @param tyOrderNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/05 08:33:45
	 */
	GpsDispatch findTyGpsDisPatch(String dispatchId,String tyOrderNo);

}
