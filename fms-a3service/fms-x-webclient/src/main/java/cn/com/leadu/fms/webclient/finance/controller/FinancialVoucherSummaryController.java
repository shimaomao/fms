package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary.FinancialVoucherSummaryVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherRpc;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherSummaryRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryController
 * @Description: 财务凭证管理controller
 * @date 2018/7/23
 */
@RestController
@RequestMapping("financial_voucher_summary")
public class FinancialVoucherSummaryController {

    @Autowired
    private FinancialVoucherSummaryRpc financialVoucherSummaryRpc;


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
        Map finVouSummaryVoMap = finVouSummaryVo == null?null:(Map) JSON.toJSON(finVouSummaryVo);
        return financialVoucherSummaryRpc.findFinancialVoucherSummaryVosByPage(finVouSummaryVoMap);
    }


}
