package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainDao
 * @Description: 车辆维修记录dao层
 */
public interface VehMaintainDao extends BaseDao<VehMaintain> {
    /**
     * @Title:
     * @Description: 关联多张表获取承租人、出租人信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<VehMaintainVo> selectVeMaintainVosByPage(@Param("vehMaintainVo")VehMaintainVo vehMaintainVo);

    /**
     * @Title:
     * @Description: 关联多张表获取承租人、出租人信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    VehMaintainVo selectVehMaintainVoByVehMaintainId(@Param("vehMaintainId") String vehMaintainId);
}