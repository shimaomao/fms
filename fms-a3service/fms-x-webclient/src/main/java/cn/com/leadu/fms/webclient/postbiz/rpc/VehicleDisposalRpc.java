package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalController
 * @Description: 车辆处置rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface VehicleDisposalRpc {

    /**
     * @Title:
     * @Description: 分页查询车辆处置信息
     * @param vehicleDisposalVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "api/postbiz/vehicle_disposal/findVehicleDisposalVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findVehicleDisposalVosByPage(@RequestParam Map<String, Object> vehicleDisposalVoMap);

    /**
     * @Title:
     * @Description:  根据vehicleDisposalId获取车辆处置信息Vo
     * @param vehicleDisposalId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "api/postbiz/vehicle_disposal/findVehicleDisposalVoByVehicleDisposalId" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findVehicleDisposalVoByVehicleDisposalId(@RequestParam("vehicleDisposalId") String vehicleDisposalId);

    /**
     * @Title:
     * @Description:  根据处置任务号，获取车辆处置信息Vo
     * @param disposalTaskNo 处置任务号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "api/postbiz/vehicle_disposal/findVehicleDisposalVoByDisposalTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findVehicleDisposalVoByDisposalTaskNo(@RequestParam("disposalTaskNo") String disposalTaskNo);

    /**
     * @Title:
     * @Description:  车辆处置申请提交
     * @param vehicleDisposalVo 处置信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "api/postbiz/vehicle_disposal/submitVehicleDisposalApply" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitVehicleDisposalApply(@RequestBody VehicleDisposalVo vehicleDisposalVo);

    /**
     * @Title:
     * @Description:  根据合同号和处置类型，获取当前正在处理中的处置任务号
     * @param contNo 合同编号
     * @param disposalStatus 车俩处置方式
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "api/postbiz/vehicle_disposal/findDisposalTaskNoByContNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDisposalTaskNoByContNo(@RequestParam("contNo") String contNo, @RequestParam("disposalStatus") String disposalStatus);
}
