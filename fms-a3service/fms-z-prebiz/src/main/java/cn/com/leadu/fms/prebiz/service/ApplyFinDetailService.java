package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;

import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailService
 * @Description: 融资费用明细信息业务层
 * @date 2018-03-24
 */
public interface ApplyFinDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询融资费用明细信息
	 * @param applyFinDetailVo
	 * @return PageInfoExtend<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	PageInfoExtend<ApplyFinDetail> findApplyFinDetailsByPage(ApplyFinDetailVo applyFinDetailVo);

	/**
	 * @Title:
	 * @Description:  根据applyFinDetailId获取融资费用明细信息
	 * @param applyFinDetailId
	 * @return ApplyFinDetail
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	ApplyFinDetail findApplyFinDetailByApplyFinDetailId(String applyFinDetailId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取融资费用明细信息
	 * @param applyNo
	 * @return List<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	List<ApplyFinDetail> findApplyFinDetailsByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  批量保存融资费用明细信息
	 * @param applyFinDetailList
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	void saveApplyFinDetailList(List<ApplyFinDetail> applyFinDetailList);

	/**
	 * @Title:
	 * @Description:  根据订单编号，获取融资费用明细项目
	 * @param applyNo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 19:22:32
	 */
	Map<String, List<ApplyFinDetailVo>> findApplyFinDetailVoMapByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据订单编号和车辆序号，删除融资明细信息.
	 * @param applyNo 订单编号
	 * @param vehicleNoList 车辆序号
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 19:22:32
	 */
	void deleteApplyFinDetailByApplyNoAndVehicleNos(String applyNo, List<String> vehicleNoList);

	/**
	 * @Title:
	 * @Description:  根据订单编号和车辆序号，删除融资明细信息. 物理删除
	 * @param applyNo 订单编号
	 * @param vehicleNoList 车辆序号
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 19:22:32
	 */
	void deletePhysicsApplyFinDetailsByApplyNoAndVehicleNos(String applyNo, List<String> vehicleNoList);

}
