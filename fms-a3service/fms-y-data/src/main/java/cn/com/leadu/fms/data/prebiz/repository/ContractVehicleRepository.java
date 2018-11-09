package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVehicleRepository
 * @Description: 合同融资车辆信息Repository层
 * @date 2018-03-23
 */
public interface ContractVehicleRepository {

	/**
	 * @Title:
	 * @Description: 新增合同融资车辆信息
	 * @param contractVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int insertData(ContractVehicle contractVehicle);

	/**
	 * @Title:
	 * @Description: 批量保存合同融资车辆信息
	 * @param contractVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int insertDataList(List<ContractVehicle> contractVehicles);

	/**
	 * @Title:
	 * @Description: 修改合同融资车辆信息
	 * @param contractVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByPrimaryKeyData(ContractVehicle contractVehicle);

	/**
	 * @Title:
	 * @Description: 批量修改合同融资车辆信息
	 * @param contractVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByPrimaryKeyDataList(List<ContractVehicle> contractVehicles);

	/**
	 * @Title:
	 * @Description: 动态修改合同融资车辆信息
	 * @param contractVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByPrimaryKeySelectiveData(ContractVehicle contractVehicle);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同融资车辆信息
	 * @param contractVehicles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContractVehicle> contractVehicles);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同融资车辆信息
	 * @param contractVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByExampleData(ContractVehicle contractVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同融资车辆信息
	 * @param contractVehicle
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int updateByExampleSelectiveData(ContractVehicle contractVehicle, Example example);

	/**
	 * @Title:
	 * @Description: 根据contVehicleId删除合同融资车辆信息
	 * @param contractVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int deleteData(ContractVehicle contractVehicle);

	/**
	 * @Title:
	 * @Description: 根据contVehicleId集合批量删除合同融资车辆信息
	 * @param contVehicleIds
	 * @param contractVehicle
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	int deleteDataList(List contVehicleIds, ContractVehicle contractVehicle);

	/**
	 * @Title:
	 * @Description: 查询全部合同融资车辆信息
	 * @return List<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	List<ContractVehicle> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个合同融资车辆信息
	 * @param example
	 * @return ContractVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	ContractVehicle selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询合同融资车辆信息
	 * @param example
	 * @return List<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	List<ContractVehicle> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contVehicleId查询合同融资车辆信息
	 * @param contVehicleId
	 * @return ContractVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	ContractVehicle selectByPrimaryKey(Object contVehicleId);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资车辆信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	PageInfoExtend<ContractVehicle> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资车辆信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	PageInfoExtend<ContractVehicle> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资车辆信息vo
	 * @param contNo
	 * @return PageInfoExtend<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	ContractVehicleVo selectContractVehicleVoByContNo(String contNo);

	/**
	 * @Description: 查询合同车辆信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/21 16:49
	 */
	ContractVehicleFinanceVo selectContractVehicleFinanceVoByContNo(ContractVehicleFinanceVo contractVehicleFinanceVo);

}
