package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: BasVehicleController
 * @Description: 车辆信息维护rpc
 * @date 2018-03-20
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasVehicleRpc {

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护信息
     * @param basVehicleVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/findBasVehiclesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasVehiclesByPage(@RequestParam Map<String, Object> basVehicleVoMap);

    /**
     * @Title:
     * @Description: 保存车辆信息维护
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/saveBasVehicle",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasVehicle(@RequestBody BasVehicleVo basVehicleVo);

    /**
     * @Title:
     * @Description:  修改车辆信息维护
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/modifyBasVehicle",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasVehicle(@RequestBody BasVehicleVo basVehicleVo);

    /**
     * @Title:
     * @Description:   根据vehicleId集合删除车辆信息维护
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/deleteBasVehiclesByVehicleIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasVehiclesByVehicleIds(@RequestBody BasVehicleVo basVehicleVo);

    /**
     * @Title:
     * @Description:  根据vehicleId获取车辆信息维护
     * @param vehicleId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/findBasVehicleByVehicleId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasVehicleByVehicleId(@RequestParam("vehicleId") String vehicleId);

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护信息
     * @param basVehicleVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/findBasVehiclesVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasVehiclesVosByPage(@RequestParam Map<String, Object> basVehicleVoMap);
    /**
     * @Title:
     * @Description: 分页查询车辆信息维护信息
     * @param basVehicleVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/findBasVehicleLevelsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasVehicleLevelsByPage(@RequestParam Map<String, Object> basVehicleVoMap);

    /**
     * @Title:
     * @Description: 根据车辆型号取得相关信息
     * @param vehicleCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "api/baseinfo/bas_vehicle/findBasVehicleVoByVehicleCode" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasVehicleVoByVehicleCode(@RequestParam("vehicleCode")String vehicleCode);
}
