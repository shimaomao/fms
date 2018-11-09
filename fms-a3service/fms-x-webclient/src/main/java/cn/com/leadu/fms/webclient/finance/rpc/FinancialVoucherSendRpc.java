package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendRpc
 * @Description: 财务凭证发送
 * @date 2018/7/30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialVoucherSendRpc {

    /**
     * @Title:
     * @Description:  发送财务凭证数据
     * @param voucherSummaryIds 凭证管理id集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 04:21:03
     */
    @RequestMapping(value = "api/finance/financial_voucher_send/sendFinancialVoucher" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendFinancialVoucher(@RequestBody List<String> voucherSummaryIds);

}
