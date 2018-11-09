package cn.com.leadu.fms.data.cost.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchDao
 * @Description: 派单信息dao层
 * @date 2018-05-25
 */
public interface GpsDispatchDao extends BaseDao<GpsDispatch> {

    /**
     * @Title:
     * @Description: 查询派单信息一览
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/25 03:43:13
     */
    List<GpsDispatchVo> selectGpsDispatchVosByPage(@Param("gpsDispatchVo") GpsDispatchVo gpsDispatchVo);


    /** 
    * @Description: 查询派单月结信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/28 15:01
    */ 
    List<GpsDispatchMonthlyVo> selectGpsDispatchMonthlysVosByPage(@Param("gpsDispatchMonthlyVo") GpsDispatchMonthlyVo gpsDispatchMonthlyVo);

    /**
     * @Description: 查询月结一览信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/28 15:01
     */
    List<GpsDispatchMonthlyVo> selectGpsDispatchMonthlysVosListByPage(@Param("gpsDispatchMonthlyVo") GpsDispatchMonthlyVo gpsDispatchMonthlyVo);

    /**
     * @Title:
     * @Description:   根据合同id查询派单信息详情
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    GpsDispatchVo selectGpsDispatchVo(@Param("gpsDispatchVo") GpsDispatchVo gpsDispatchVo);

}