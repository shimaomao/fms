package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.continspect.ContInspectVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liujinge
 * @ClassName: ContractController
 * @Description: 合同生成前确认rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContInspectRpc {

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contInspectVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/cont_inspect/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody ContInspectVo contInspectVo);

    /**
     * @Title:
     * @Description: 退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/prebiz/cont_inspect/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContInspectVo contInspectVo);


}
