package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasVehicleRepository
 * @Description: 车辆信息维护Repository层
 * @date 2018-03-20
 */
public interface BasVehicleRepository {

	/**
	 * @Title:
	 * @Description: 新增车辆信息维护
	 * @param basVehicle
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int insertData(BasVehicle basVehicle);

	/**
	 * @Title:
	 * @Description: 批量保存车辆信息维护
	 * @param basVehicles
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int insertDataList(List<BasVehicle> basVehicles);

	/**
	 * @Title:
	 * @Description: 修改车辆信息维护
	 * @param basVehicle
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByPrimaryKeyData(BasVehicle basVehicle);

	/**
	 * @Title:
	 * @Description: 批量修改车辆信息维护
	 * @param basVehicles
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByPrimaryKeyDataList(List<BasVehicle> basVehicles);

	/**
	 * @Title:
	 * @Description: 动态修改车辆信息维护
	 * @param basVehicle
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByPrimaryKeySelectiveData(BasVehicle basVehicle);

	/**
	 * @Title:
	 * @Description: 批量动态修改车辆信息维护
	 * @param basVehicles
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasVehicle> basVehicles);

	/**
	 * @Title:
	 * @Description: 根据条件修改车辆信息维护
	 * @param basVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByExampleData(BasVehicle basVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改车辆信息维护
	 * @param basVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int updateByExampleSelectiveData(BasVehicle basVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据vehicleId删除车辆信息维护
	 * @param basVehicle
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int deleteData(BasVehicle basVehicle);

	/**
	 * @Title:
	 * @Description: 根据vehicleId集合批量删除车辆信息维护
	 * @param vehicleIds
	 * @param basVehicle
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	int deleteDataList(List vehicleIds, BasVehicle basVehicle);

	/**
	 * @Title:
	 * @Description: 查询全部车辆信息维护
	 * @return List<BasVehicle>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	List<BasVehicle> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个车辆信息维护
	 * @param example
	 * @return BasVehicle
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	BasVehicle selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询车辆信息维护
	 * @param example
	 * @return List<BasVehicle>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	List<BasVehicle> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过vehicleId查询车辆信息维护
	 * @param vehicleId
	 * @return BasVehicle
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	BasVehicle selectByPrimaryKey(Object vehicleId);

	/**
	 * @Title:
	 * @Description: 通过vehicleId查询车辆信息维护
	 * @param vehicleId
	 * @return BasVehicle
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-20 13:33:19
	 */
	BasVehicleVo findBasVehicleByVehicleId(String vehicleId);

	/**
	 * @Title:
	 * @Description: 分页查询车辆信息维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	PageInfoExtend<BasVehicle> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询车辆信息维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasVehicle>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
	PageInfoExtend<BasVehicleVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);
	/**
	 * @Title:
	 * @Description: 分页查询车辆信息维护vo
	 * @param vehicleCode
	 * @return BasVehicleVo
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-20 13:33:19
	 */
    BasVehicleVo selectBasVehicleVoByVehicleCode(String vehicleCode);

	/**
	 * @Title:
	 * @Description: 根据车型代码取得车型名称,并封装合同号与车型名称的对应关系,为了后续更新合同任务信息车型信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	String findVehicleNameForContConfirm(String vehicleCode);
}
