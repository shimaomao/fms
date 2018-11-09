package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.prebiz.service.CreditModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: CreditModelController
 * @Description: 贷前模型controller
 * @date 2018/5/15
 */
@RestController
@RequestMapping("credit_model")
public class CreditModelController {

    @Autowired
    private CreditModelService creditModelService;

    /**
     * @Title:
     * @Description:   生成贷前模型
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 04:32:36
     */
    @RequestMapping(value = "generatePreBizCreditModel" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> generatePreBizCreditModel(String applyNo){
        creditModelService.generatePreBizCreditModel(applyNo);
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取用户报告基础信息
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 11:05:56
     */
    @RequestMapping(value = "findCustomerByApplyNo" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findCustomerByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(creditModelService.findCustomerByApplyNo(applyNo)),
                HttpStatus.OK);
    }

}
