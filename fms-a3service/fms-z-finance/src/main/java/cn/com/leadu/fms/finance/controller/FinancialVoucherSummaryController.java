package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.FinancialVoucherSummaryService;
import cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary.FinancialVoucherSummaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryController
 * @Description: 财务凭证管理controller
 * @date 2018/7/23
 */
@RestController
@RequestMapping("financial_voucher_summary")
public class FinancialVoucherSummaryController {

    /**
     * @Fields  : 财务凭证管理service
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSummaryService financialVoucherSummaryService;

    /**
     * @Title:
     * @Description:   查询财务凭证管理列表
     * @param finVouSummaryVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 02:48:33
     */
    @RequestMapping(value = "findFinancialVoucherSummaryVosByPage" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherSummaryVosByPage(FinancialVoucherSummaryVo finVouSummaryVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherSummaryService.findFinancialVoucherSummaryVosByPage(finVouSummaryVo)),
                HttpStatus.OK);
    }

}
