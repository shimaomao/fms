package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.ContPaymentService;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName: ContPaymentController
 * @Description:
 * @date
 */
@RestController
@RequestMapping("cont_payment")
public class ContPaymentController {

    /**
     * @Fields  : 财务付款service
     */
    @Autowired
    private ContPaymentService contPaymentService;

    /**
     * @Title:
     * @Description: 生成合同信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */

    @RequestMapping(value = "submit",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submit(@Valid @RequestBody ContPaymentVo contPaymentVo){
        contPaymentService.submit(contPaymentVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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

    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContPaymentVo contPaymentVo){
        contPaymentService.sendBack(contPaymentVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }











}
