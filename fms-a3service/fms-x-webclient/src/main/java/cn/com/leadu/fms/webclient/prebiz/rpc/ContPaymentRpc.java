package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huchenghao
 * @ClassName: ContCreateRpc
 * @Description: 生成合同rpc
 * @date 2018-03-24
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPaymentRpc {

    /**
     * @Title:
     * @Description: 根据contactNo获取客户联系人信息
     * @param contPaymentVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 16:18:12
     */

    @RequestMapping(value = "api/finance/cont_payment/submit",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submit(@RequestBody ContPaymentVo contPaymentVo);

    /**
     * @Title:
     * @Description: 退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */

    @RequestMapping(value = "api/finance/cont_payment/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContPaymentVo contPaymentVo);

    /**
     * @Title:  
     * @Description: 通过合同编号和订单编号获取ContPaymentVo
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    @RequestMapping(value = "api/prebiz/cont_payment_detail/findContPaymentVo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPaymentVo(@RequestParam("contNo") String contNo,@RequestParam("applyNo")String applyNo);

}
