package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.prebiz.service.ContPaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName: ContPaymentController
 * @Description:
 * @date
 */
@RestController
@RequestMapping("cont_payment_detail")
public class ContPaymentDetailController {

    /**
     * @Fields  : 财务付款service
     */
    @Autowired
    private ContPaymentDetailService contPaymentDetailService;

    /**
     * @Title:  
     * @Description: 通过合同编号和订单编号获取ContPaymentVo
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */

    @RequestMapping(value = "findContPaymentVo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPaymentVo(String contNo,String applyNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPaymentDetailService.findContPaymentVo(contNo,applyNo)),
                HttpStatus.OK);
    }











}
