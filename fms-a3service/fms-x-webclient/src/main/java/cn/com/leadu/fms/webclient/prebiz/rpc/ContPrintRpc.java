package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contprint.ContPrintVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liujinge
 * @ClassName: ContractController
 * @Description: 合同生成前确认rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPrintRpc {

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/cont_print/print",method = RequestMethod.POST)
    ResponseEntity<RestResponse> print(@RequestBody ContPrintVo contPrintVo);

    /**
     * @Title:
     * @Description: 合同打印
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/cont_print/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContPrintVo contPrintVo);

    /**
     * @Title:
     * @Description: 合同打印
     * @param contNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/cont_print/getContPrintFileList",method = RequestMethod.GET)
    ResponseEntity<RestResponse> getContPrintFileList(@RequestParam("contNo") String contNo);

}
