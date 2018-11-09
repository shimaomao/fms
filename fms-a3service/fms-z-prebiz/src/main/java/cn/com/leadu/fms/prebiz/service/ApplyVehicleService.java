package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleService
 * @Description: 融资车辆信息业务层
 * @date 2018-03-24
 */
public interface ApplyVehicleService {

	/**
	 * @Title:
	 * @Description: 分页查询融资车辆信息
	 * @param applyVehicleVo
	 * @return PageInfoExtend<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	PageInfoExtend<ApplyVehicle> findApplyVehiclesByPage(ApplyVehicleVo applyVehicleVo);

	/**
	 * @Title:
	 * @Description:  根据applyVehicleId获取融资车辆信息
	 * @param applyVehicleId
	 * @return ApplyVehicle
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	ApplyVehicle findApplyVehicleByApplyVehicleId(String applyVehicleId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取融资车辆信息
	 * @param applyNo
	 * @return List<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	List<ApplyVehicle> findApplyVehiclesByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  批量保存融资车辆信息
	 * @param applyVehicleList
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	void saveApplyVehicleList(List<ApplyVehicle> applyVehicleList);

	/**
	 * @Title:
	 * @Description:  批量更新融资车辆信息
	 * @param applyVehicleList
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	void modifyApplyVehicleList(List<ApplyVehicle> applyVehicleList);

	/**
	 * @Title:
	 * @Description:  批量保存融资车辆信息
	 * @param applyNo 申请编号
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 19:20:32
	 */
	List<ApplyVehicleVo> findApplyVehicleVosByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  批量删除融资车辆信息以及对应的融资明细
	 * @param applyVehicleList
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:32
	 */
	void deleteApplyVehicleListAndFinDetail(List<ApplyVehicle> applyVehicleList);

}
