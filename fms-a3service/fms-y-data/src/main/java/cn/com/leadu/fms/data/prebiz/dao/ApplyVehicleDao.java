package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleDao
 * @Description: 融资车辆信息dao层
 * @date 2018-03-24
 */
public interface ApplyVehicleDao extends BaseDao<ApplyVehicle> {

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资车辆信息
     * @param applyNo 订单编号
     * @return List<ApplyVehicleVo>
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    List<ApplyVehicleVo> selectApplyVehicleVoByApplyNo(@Param("applyNo")String applyNo);

}