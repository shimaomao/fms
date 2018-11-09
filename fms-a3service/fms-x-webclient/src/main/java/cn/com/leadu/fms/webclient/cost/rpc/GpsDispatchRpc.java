package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchController
 * @Description: 派单信息rpc
 * @date 2018-05-25
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface GpsDispatchRpc {

    /**
     * @Title:
     * @Description: 查询派单信息一览
     * @param gpsDispatchVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "api/cost/gps_dispatch/findGpsDispatchVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGpsDispatchVosByPage(@RequestParam Map<String, Object> gpsDispatchVoMap);

    /**
     * @Title:
     * @Description: 暂存派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "api/cost/gps_dispatch/storageGpsDispatch",method = RequestMethod.POST)
    ResponseEntity<RestResponse> storageGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo);

    /**
     * @Title:
     * @Description: 保存派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "api/cost/gps_dispatch/saveGpsDispatch",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo);

    /**
     * @Title:
     * @Description:  修改派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "api/cost/gps_dispatch/modifyGpsDispatch",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo);

    /**
     * @Title:
     * @Description:  根据dispatchId获取派单信息
     * @param dispatchId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "api/cost/gps_dispatch/findGpsDispatchByDispatchId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGpsDispatchByDispatchId(@RequestParam("dispatchId") String dispatchId);

    /** 
    * @Description: 查询派单月结信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/28 15:35
    */ 
    @RequestMapping(value = "api/cost/gps_dispatch/findGpsDispatchMonthlysVosListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGpsDispatchMonthlysVosListByPage(@RequestParam Map<String, Object> gpsDispatchMonthlyVoMap);

    /** 
    * @Description: 查询派单月结信息,不分页 ,POST
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/29 17:35
    */ 
    @RequestMapping(value = "api/cost/gps_dispatch/findGpsDispatchMonthlysVos" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> findGpsDispatchMonthlysVos(@RequestBody GpsDispatchMonthlyVo gpsDispatchMonthlyVo);

    /**
     * @Title:
     * @Description:   根据合同id查询派单信息详情
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    @RequestMapping(value = "api/cost/gps_dispatch/findGpsDispatchDetailByContNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGpsDispatchDetailByContNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description:   查询天易派单状态
     * @param dispatchId
     * @param tyOrderNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/05 08:33:45
     */
    @RequestMapping(value = "api/cost/gps_dispatch/findTyGpsDisPatch" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTyGpsDisPatch(@RequestParam("dispatchId") String dispatchId,@RequestParam("tyOrderNo") String tyOrderNo);

}
