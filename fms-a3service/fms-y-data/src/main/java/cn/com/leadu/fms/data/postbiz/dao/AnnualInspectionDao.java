package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionDao
 * @Description: 年检提醒dao层
 */
public interface AnnualInspectionDao extends BaseDao<AnnualInspection> {
    /**
     * @Title:
     * @Description: 获取合同信息表里面需要年检的车辆数据
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<Contract> selectContractsByPaymentSts(@Param("annualinspectionYear") Integer annualinspectionYear , @Param("annualinspectionDays") Integer annualinspectionDays);
    /**
     * @Title:
     * @Description: 关联合同表获取用户信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<AnnualInspectionVo> selectAnnualInspectionVosByPage(@Param("annualInspectionVo")AnnualInspectionVo annualInspectionVo);

    /**
     * @Title:
     * @Description: 获取合同信息表里面需要年检的车辆数据
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    AnnualInspectionVo selectAnnualInspectionVoByAnnualInspectionId(@Param("annualInspectionId") String annualInspectionId);


}