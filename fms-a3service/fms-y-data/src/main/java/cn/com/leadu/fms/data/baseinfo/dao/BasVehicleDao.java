package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasVehicleDao
 * @Description: 车辆信息维护dao层
 * @date 2018-03-20
 */
public interface BasVehicleDao extends BaseDao<BasVehicle> {

    /**
     * @Title:
     * @Description: 分页获取车辆信息Vo
     * @param basVehicleVo 查询条件
     * @return BasVehicleVo
     * @throws
     * @author wangxue
     * @date 2018-3-22 22:06:58
     */
    List<BasVehicleVo> selectBasVehicleVosByPages(@Param("basVehicleVo") BasVehicleVo basVehicleVo);

    /**
     * @Title:
     * @Description: 分页获取车辆信息Vo
     * @param basVehicleVo 查询条件
     * @return BasVehicleVo
     * @throws
     * @author huchenghao
     * @date 2018-3-22 22:06:58
     */
    List<BasVehicleVo> findBasVehicleLevelsByPages(@Param("basVehicleVo") BasVehicleVo basVehicleVo);
    /**
     * @Title:
     * @Description: 通过ID取得一条信息
     * @param vehicleId 查询条件
     * @return BasVehicleVo
     * @throws
     * @author huchenghao
     * @date 2018-4-9 22:06:58
     */
    BasVehicleVo findBasVehicleByVehicleId(@Param("vehicleId")String vehicleId);

    BasVehicleVo selectBasVehicleVoByVehicleCode(@Param("vehicleCode")String vehicleCode);

    /**
     * @Title:
     * @Description: 根据车型代码取得车型名称,并封装合同号与车型名称的对应关系,为了后续更新合同任务信息车型信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    String findVehicleNameForContConfirm(@Param("vehicleCode") String vehicleCode);
}