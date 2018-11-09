package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContInsuranceDao
 * @Description: 合同车辆保险信息dao层
 * @date 2018-03-23
 */
public interface ContInsuranceDao extends BaseDao<ContInsurance> {

    List<ContInsuranceVo> selectContInsuranceByStatus(@Param("contInsurance") ContInsuranceVo contInsurance);

}