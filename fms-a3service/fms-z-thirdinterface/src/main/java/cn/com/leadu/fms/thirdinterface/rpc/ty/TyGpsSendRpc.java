package cn.com.leadu.fms.thirdinterface.rpc.ty;

import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaomengnan
 * @ClassName: GpsTyRpc
 * @Description: 天易gps派单
 * @date 2018/7/4
 */
@FeignClient(name = "tyGpsSend",url = "${fms.gps.ty.sendUrl}")
public interface TyGpsSendRpc {

    /**
     * @Title:
     * @Description:  gps天易派单
     * @param tyGpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    @RequestMapping(method = RequestMethod.POST)
    Response sendGpsDispatch(@RequestBody TyGpsDispatchVo tyGpsDispatchVo);


}
