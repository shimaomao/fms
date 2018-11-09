package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author liujinge
 * @ClassName: ContractVehicleDao
 * @Description: 合同车辆信息dao层
 * @date 2018-03-23
 */
public interface ContractVehicleDao extends BaseDao<ContractVehicle> {

    ContractVehicleVo selectContractVehicleVoByContNo(@Param("contNo")String contNo);

    /** 
    * @Description: 查询合同车辆信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/21 16:49
    */ 
    ContractVehicleFinanceVo selectContractVehicleFinanceVoByContNo(@Param("contractVehicleFinanceVo")ContractVehicleFinanceVo contractVehicleFinanceVo);
}