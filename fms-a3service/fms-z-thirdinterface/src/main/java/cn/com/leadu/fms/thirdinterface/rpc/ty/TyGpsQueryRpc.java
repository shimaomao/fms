package cn.com.leadu.fms.thirdinterface.rpc.ty;

import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GpsTyQueryRpc
 * @Description: 天易gps查单
 * @date 2018/7/4
 */
@FeignClient(name = "tyGpsQuery",url = "${fms.gps.ty.queryUrl}")
public interface TyGpsQueryRpc {

    /**
     * @Title:
     * @Description:  gps天易单号查询
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 05:13:49
     */
    @RequestMapping(method = RequestMethod.GET)
    Response queryGpsDispatch(@RequestParam("applyNo") String applyNo);

}
