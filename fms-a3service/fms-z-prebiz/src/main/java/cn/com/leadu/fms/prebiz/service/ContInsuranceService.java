package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;

import java.util.List;

/**
 * @description:  车辆保险service
 * @author:ningyangyang
 * @since:2018/5/14
 */
public interface ContInsuranceService {

    /**
     * @Title:
     * @Description: 查询车辆保险信息
     * @param
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 18:48:00
     */
    List<ContInsurance> findContInsurance(ContInsurance contInsurance);

    /**
     * @Title:
     * @Description: 通过contVehinsId查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContInsurance findContInsuranceByPrimaryKey(String contVehinsId);

    /**
     * @Title:
     * @Description: 根据状态查询车辆保险信息
     * @param
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 18:48:00
     */
    List<ContInsuranceVo> findContInsuranceByStatus(ContInsuranceVo contInsurance);
}
