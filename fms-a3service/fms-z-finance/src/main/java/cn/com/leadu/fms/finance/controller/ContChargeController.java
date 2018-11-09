package cn.com.leadu.fms.finance.controller;/**
 * Created by yyq on 2018/6/13.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.ContChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 财务待收款Controller
 * @author: yangyiquan
 * @create: 2018-06-13 11:10
 **/
@RestController
@RequestMapping("cont_charge")
public class ContChargeController {
    /**
     * @Fields  : 财务待收款业务层
     */
    @Autowired
    private ContChargeService contChargeService;

    /** 
    * @Description:  根据业务类型和业务号查询待收款数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 11:14
    */ 
    @RequestMapping(value = "fingContChargeListByBizIdAndBizType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> fingContChargeListByBizIdAndBizType(String chargeBizId,String chargeBizType){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contChargeService.fingContChargeListByBizIdAndBizType(chargeBizId,chargeBizType)), HttpStatus.OK);
    }

    /**
     * @Description:  根据业务类型和业务号查询待收款数据和收款数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 11:14
     */
    @RequestMapping(value = "fingContChargeAndReceiptByBizIdAndBizType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> fingContChargeAndReceiptByBizIdAndBizType(String chargeBizId,String chargeBizType,String chargeFund){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contChargeService.fingContChargeAndReceiptByBizIdAndBizType(chargeBizId,chargeBizType,chargeFund)), HttpStatus.OK);
    }
}
