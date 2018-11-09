package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherSendRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendController
 * @Description: 财务凭证发送
 * @date 2018/7/30
 */
@RestController
@RequestMapping("financial_voucher_send")
public class FinancialVoucherSendController {

    /**
     * @Fields  : 凭证发送rpc
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSendRpc financialVoucherSendRpc;

    /**
     * @Title:
     * @Description:  发送财务凭证数据
     * @param voucherSummaryIds 凭证管理id集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 04:21:03
     */
    @RequestMapping(value = "sendFinancialVoucher" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendFinancialVoucher(@RequestBody List<String> voucherSummaryIds){
        return financialVoucherSendRpc.sendFinancialVoucher(voucherSummaryIds);
    }

}
