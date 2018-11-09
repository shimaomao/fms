package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVehicleService
 * @Description: 合同车辆业务层
 * @date 2018-03-23
 */
public interface ContractVehicleService {

	/**
	 * @Title:
	 * @Description: 分页查询合同车辆
	 * @param contractVehicleVo
	 * @return PageInfoExtend<ContractVehicle>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	PageInfoExtend<ContractVehicle> findContractVehiclesByPage(ContractVehicleVo contractVehicleVo);

	/**
	 * @Title:
	 * @Description:  根据contVehicleId获取合同车辆
	 * @param contVehicleId
	 * @return ContractVehicle
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	ContractVehicle findContractVehicleByContVehicleId(String contVehicleId);

	/**
	 * @Title:
	 * @Description:  批量插入合同车辆信息
	 * @param contractVehicleList
	 * @return insert
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	 int insertContractvehicles(List<ContractVehicle> contractVehicleList);

	/**
	 * @Title:
	 * @Description:
	 * @param contNo
	 * @return ContractVehicleVo
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:35
	 */
	ContractVehicleVo findContractVehicleVoByContNo(String contNo);

	/**
	 * @Description: 查询合同车辆信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/21 16:49
	 */
	ContractVehicleFinanceVo findContractVehicleFinanceVoByContNo(String contNo);

	/** 
	* @Description: 修改合同融资车辆信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/11 16:36
	*/ 
	void modifyContractVehicleVo(ContractVehicleVo contractVehicleVo);
}
