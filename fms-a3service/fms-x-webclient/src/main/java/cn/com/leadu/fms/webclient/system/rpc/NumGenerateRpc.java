package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huchenghao
 * @ClassName: SysCodeController
 * @Description: 字典数数值rpc
 * @date 2018-03-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface NumGenerateRpc {

    /**
     * @Title:
     * @Description:   取得自动生成的代码
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:10:56
     */
    @RequestMapping(value = "api/system/num_generate/getCodeByType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> getCodeByType(@RequestParam("codeType")String codeType);

}
