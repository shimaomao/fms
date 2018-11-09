package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContPaymentRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @ClassName:
 * @Description: 财务付款controller
 * @date 2018-03-30
 */
@RestController
@RequestMapping("cont_payment")
public class ContPaymentController {

    /**
     * @Fields  : 财务付款rpc
     */
    @Autowired
    private ContPaymentRpc contPaymentRpc;

    /**
     * @Title:
     * @Description:  生成合同信息
     * @param contPaymentVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submit(@RequestBody ContPaymentVo contPaymentVo){
        return contPaymentRpc.submit(contPaymentVo);
    }


    /**
     * @Title:
     * @Description: 退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContPaymentVo contPaymentVo){
        return contPaymentRpc.sendBack(contPaymentVo);
    }

    /**
     * @Title:  
     * @Description: 通过合同编号和订单编号获取ContPaymentVo
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    @RequestMapping(value = "findContPaymentVo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPaymentVo(String contNo,String applyNo){
        return contPaymentRpc.findContPaymentVo(contNo,applyNo);
    }
}
