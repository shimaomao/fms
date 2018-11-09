package cn.com.leadu.fms.cost.rpc.thirdinterface;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchQueryVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchRpc
 * @Description: 天易gps rpc
 * @date 2018/7/4
 */
@FeignClient("${fms.feigns.serverNames.fmsThirdInterface}")
public interface TyGpsDispatchRpc {

    /**
     * @Title:
     * @Description:   gps天易派单
     * @param tyGpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:20:03
     */
    @RequestMapping(value = "ty_gps_dispatch/sendGpsDispatch" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse<TyGpsDispatchVo>> sendGpsDispatch(@RequestBody TyGpsDispatchVo tyGpsDispatchVo);

    /**
     * @Title:
     * @Description:  gps天易查单
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    @RequestMapping(value = "ty_gps_dispatch/findGpsDisPatch" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<TyGpsDispatchQueryVo>> findGpsDisPatch(@RequestParam("applyNo") String applyNo);

}
