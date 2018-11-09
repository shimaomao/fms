package cn.com.leadu.fms.data.insurance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimDao
 * @Description: 保险理赔dao层
 * @date 2018-05-14
 */
public interface ContInsurClaimDao extends BaseDao<ContInsurClaim> {
    /**
     * @Title:
     * @Description: 分页查询保险理赔一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContInsurClaimVo> selectContInsurClaimsByPage(@Param("contInsurClaimVo")ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description: 分页查询保险理赔查询页面
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContInsurClaimVo> selectContInsurClaimsByPageSelect(@Param("contInsurClaimVo")ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description: 根据保险信息id查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContInsurClaimVo selectContInsuranceByContVehinsId(@Param("contVehinsId")String contVehinsId);

    /**
     * @Title:
     * @Description: 根据contInsurClaimId和contVehinsId查询保险理赔表和合同车辆信息表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContInsurClaimVo selectContInsurClaimAndContInsurance(@Param("contInsurClaimId")String contInsurClaimId,@Param("contVehinsId")String contVehinsId);

    /**
     * @Title:
     * @Description: 保险理赔状态为退回时查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContInsurClaimVo selectDetailedByReturn(@Param("contInsurClaimId")String contInsurClaimId);

    /**
     * @Title:
     * @Description: 根据保险理赔任务号和业务类型查询财务付款表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContPay selectContPayByContInsurClaimNo(@Param("bizCode")String bizCode,@Param("paymentType")String paymentType);

    /**
     * @Title:
     * @Description: 保险理赔excel导出
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContInsurClaimVo> selectContInsurClaimsByPageSelect2(@Param("contInsurClaimVo")ContInsurClaimVo contInsurClaimVo);

}