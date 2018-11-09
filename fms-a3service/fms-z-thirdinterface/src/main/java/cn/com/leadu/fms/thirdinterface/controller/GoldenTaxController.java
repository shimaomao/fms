package cn.com.leadu.fms.thirdinterface.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxInvoiceSendVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxPrintinvVo;
import cn.com.leadu.fms.thirdinterface.service.GoldenTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxController
 * @Description: 金税接口
 * @date 2018/9/12 0012
 */
@RestController
@RequestMapping("golden_tax")
public class GoldenTaxController {

    @Autowired
    private GoldenTaxService goldenTaxService;

    /**
     * @Title:
     * @Description:   金税开票
     * @param goldenTaxInvoiceSendVo 开票信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    @RequestMapping(value = "invoice" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoice(@Valid @RequestBody GoldenTaxInvoiceSendVo goldenTaxInvoiceSendVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        goldenTaxService.invoice(goldenTaxInvoiceSendVo)
                ),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   金税打印
     * @param goldenTaxPrintinvVo 打印信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    @RequestMapping(value = "printinv" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printinv(@Valid @RequestBody GoldenTaxPrintinvVo goldenTaxPrintinvVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        goldenTaxService.printinv(goldenTaxPrintinvVo)
                ),
                HttpStatus.OK);
    }

}
