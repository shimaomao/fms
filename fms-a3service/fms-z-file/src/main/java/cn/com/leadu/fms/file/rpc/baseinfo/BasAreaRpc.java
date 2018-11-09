package cn.com.leadu.fms.file.rpc.baseinfo;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: BasAreaRpc
 * @Description: 省市远程rpc
 * @date 2018/4/25
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsBaseInfo}")
public interface BasAreaRpc {

    /**
     * @Title:
     * @Description:  获取所有省市县
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "bas_area/findBasAreaByTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,BasAreaTreeVo>>> findBasAreaByTree();

}
