package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleSaveVo;

/**
 * @author niehaibing
 * @ClassName: BasVehicleService
 * @Description: 车辆信息维护业务层
 * @date 2018-03-20
 */
public interface BasVehicleService {

	/**
	 * @Title:
	 * @Description: 分页查询车辆信息维护
	 * @param basVehicleVo
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	PageInfoExtend<BasVehicle> findBasVehiclesByPage(BasVehicleVo basVehicleVo);

	/**
	 * @Title:
	 * @Description: 保存车辆信息维护
	 * @param basVehicleSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
    void saveBasVehicle(BasVehicleSaveVo basVehicleSaveVo);


	/**
	 * @Title:
	 * @Description: 修改车辆信息维护
	 * @param basVehicleModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	void modifyBasVehicle(BasVehicleModifyVo basVehicleModifyVo);

	/**
	 * @Title:
	 * @Description:  通过vehicleId删除车辆信息维护
	 * @param basVehicleDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	void deleteBasVehicle(BasVehicleDeleteVo basVehicleDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过vehicleId集合删除车辆信息维护
	 * @param basVehicleDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	void deleteBasVehiclesByVehicleIds(BasVehicleDeleteListVo basVehicleDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据vehicleId获取车辆信息维护
	 * @param vehicleId
	 * @return BasVehicle
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	BasVehicleVo findBasVehicleByVehicleId(String vehicleId);

	/**
	 * @Title:
	 * @Description:  根据vehicleCode获取车辆信息维护
	 * @param vehicleCode
	 * @return BasVehicle
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-20 13:33:19
	 */
	BasVehicle findBasVehicleByVehicleCode(String vehicleCode);


	/**
	 * @Title:
	 * @Description: 分页查询车辆信息Vo
	 * @param basVehicleVo
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-30 17:33:19
	 */
	PageInfoExtend<BasVehicleVo> findBasVehiclesVosByPage(BasVehicleVo basVehicleVo);
	/**
	 * @Title:
	 * @Description: 分页查询级别
	 * @param basVehicleVo
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-30 17:33:19
	 */
	PageInfoExtend<BasVehicleVo> findBasVehicleLevelsByPage(BasVehicleVo basVehicleVo);

	/**
	 * @Title:
	 * @Description: 根据车辆型号取得相关信息
	 * @param vehicleCode
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-30 17:33:19
	 */
	BasVehicleVo findBasVehicleVoByVehicleCode(String vehicleCode);
}
