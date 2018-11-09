package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.CapitalAssetsVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskRpc
 * @Description: 转固定资产任务rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CapitalAssetsTaskRpc {

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 复审通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/capital_assets/approve", method = RequestMethod.POST)
    ResponseEntity<RestResponse> approve(@RequestBody CapitalAssetsVo vo);

}
