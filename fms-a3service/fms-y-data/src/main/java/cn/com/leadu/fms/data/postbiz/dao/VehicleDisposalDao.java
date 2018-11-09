package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.SecCarInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.DisposalContVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalDao
 * @Description: 车辆处置dao层
 */
public interface VehicleDisposalDao extends BaseDao<VehicleDisposal> {

    /**
     * @Title:
     * @Description: 根据条件获取车辆处置一览数据
     * @param vehicleDisposalVo 查询参数
     * @return List<VehicleDisposalVo>
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    List<VehicleDisposalVo> selectVehicleDisposalVosByPage(@Param("vehicleDisposalVo") VehicleDisposalVo vehicleDisposalVo);

    /**
     * @Title:
     * @Description: 根据合同编号，获取合同客户信息
     * @param contNo 合同编号
     * @return DisposalContVo
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    DisposalContVo selectDisposalContVoByContNo(@Param("contNo") String contNo);

    /**
     * @Title:
     * @Description: 根据合同编号处置状态，获取最新收车数据的收车费用
     * @param contNo 合同编号
     * @param vehicleDisposalStatus 车辆处置状态
     * @return BigDecimal
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    BigDecimal selectRecoveryChargeByContNo(@Param("contNo") String contNo, @Param("vehicleDisposalStatus") String vehicleDisposalStatus);


    /**
     * @Title:
     * @Description: 根据处置任务号，查询构建二手车库存表需要的数据源
     * @param taskNo 处置任务号
     * @return SecCarInfoVo
     * @throws
     * @author huzongcheng
     */
    SecCarInfoVo selectSecCarInfoByTaskNo(@Param("taskNo") String taskNo);
}