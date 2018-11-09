package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalService
 * @Description: 车辆处置业务层
 */
public interface VehicleDisposalService {

	/**
	 * @Title:
	 * @Description: 分页查询车辆处置
	 * @param vehicleDisposalVo
	 * @return PageInfoExtend<VehicleDisposalVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	PageInfoExtend<VehicleDisposalVo> findVehicleDisposalVosByPage(VehicleDisposalVo vehicleDisposalVo);

	/**
	 * @Title:
	 * @Description:  根据vehicleDisposalId获取车辆处置信息Vo
	 * @param vehicleDisposalId 车辆处置ID
	 * @return VehicleDisposalVo
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	VehicleDisposalVo findVehicleDisposalVoByVehicleDisposalId(String vehicleDisposalId);

	/**
	 * @Title:
	 * @Description:  根据处置任务号，获取车辆处置信息Vo
	 * @param disposalTaskNo 处置任务号
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	VehicleDisposalVo findVehicleDisposalVoByDisposalTaskNo(String disposalTaskNo);

	/**
	 * @Title:
	 * @Description:  车辆处置申请提交
	 * @param vehicleDisposalVo 处置信息
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
    void submitVehicleDisposalApply(VehicleDisposalVo vehicleDisposalVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  根据合同号和处置类型，获取当前正在处理中的处置任务号
	 * @param contNo 合同编号
	 * @param disposalStatus 车俩处置方式
	 * @return String
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	String findDisposalTaskNoByContNo(String contNo, String disposalStatus);
}
