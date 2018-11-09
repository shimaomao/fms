package cn.com.leadu.fms.prebiz.rpc.baseinfo;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: BasPartnerRpc
 * @Description: 经销商信息维护rpc
 * @date 2018-03-17
 */
@FeignClient("${fms.feigns.serverNames.fmsBaseInfo}")
public interface BasPartnerRpc {

    /**
     * @Title:
     * @Description:  根据经销商代码，获取经销商信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "bas_partner/findBasPartnerByPartnerCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String, Object>>> findBasPartnerByPartnerCode(@RequestParam("partnerCode") String partnerCode);

}
