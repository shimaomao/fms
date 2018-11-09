package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleRepository
 * @Description: 融资车辆信息Repository层
 * @date 2018-03-24
 */
public interface ApplyVehicleRepository {

	/**
	 * @Title:
	 * @Description: 新增融资车辆信息
	 * @param applyVehicle
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int insertData(ApplyVehicle applyVehicle);

	/**
	 * @Title:
	 * @Description: 批量保存融资车辆信息
	 * @param applyVehicles
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int insertDataList(List<ApplyVehicle> applyVehicles);

	/**
	 * @Title:
	 * @Description: 修改融资车辆信息
	 * @param applyVehicle
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByPrimaryKeyData(ApplyVehicle applyVehicle);

	/**
	 * @Title:
	 * @Description: 批量修改融资车辆信息
	 * @param applyVehicles
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByPrimaryKeyDataList(List<ApplyVehicle> applyVehicles);

	/**
	 * @Title:
	 * @Description: 动态修改融资车辆信息
	 * @param applyVehicle
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByPrimaryKeySelectiveData(ApplyVehicle applyVehicle);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资车辆信息
	 * @param applyVehicles
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyVehicle> applyVehicles);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资车辆信息
	 * @param applyVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByExampleData(ApplyVehicle applyVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资车辆信息
	 * @param applyVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int updateByExampleSelectiveData(ApplyVehicle applyVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据applyVehicleId删除融资车辆信息
	 * @param applyVehicle
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int deleteData(ApplyVehicle applyVehicle);

	/**
	 * @Title:
	 * @Description: 根据applyVehicleId集合批量删除融资车辆信息
	 * @param applyVehicleIds
	 * @param applyVehicle
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	int deleteDataList(List applyVehicleIds, ApplyVehicle applyVehicle);

	/**
	 * @Title:
	 * @Description: 查询全部融资车辆信息
	 * @return List<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	List<ApplyVehicle> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资车辆信息
	 * @param example
	 * @return ApplyVehicle
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	ApplyVehicle selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资车辆信息
	 * @param example
	 * @return List<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	List<ApplyVehicle> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyVehicleId查询融资车辆信息
	 * @param applyVehicleId
	 * @return ApplyVehicle
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	ApplyVehicle selectByPrimaryKey(Object applyVehicleId);

	/**
	 * @Title:
	 * @Description: 分页查询融资车辆信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	PageInfoExtend<ApplyVehicle> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资车辆信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyVehicle>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:20:31
	 */
	PageInfoExtend<ApplyVehicle> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据订单编号 获取融资车辆信息
	 * @param applyNo 订单编号
	 * @return List<ApplyVehicleVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 17:39:58
	 */
	List<ApplyVehicleVo> selectApplyVehicleVoByApplyNo(String applyNo);

}
