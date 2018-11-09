package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef.ContConfirmBefVo;
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
public interface ContConfirmBefRpc {

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contConfirmBefVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/cont_confirm_bef/confirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> confirm(@RequestBody ContConfirmBefVo contConfirmBefVo);

    /**
    * @Description: 退回到申请
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/15 14:52
    */
    @RequestMapping(value = "api/prebiz/cont_confirm_bef/returnDealer",method = RequestMethod.POST)
    ResponseEntity<RestResponse> returnDealer(@RequestBody ContConfirmBefVo contConfirmBefVo);
}
