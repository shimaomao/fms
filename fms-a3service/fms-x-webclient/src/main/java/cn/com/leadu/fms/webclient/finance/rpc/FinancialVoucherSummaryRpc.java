package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryRpc
 * @Description:
 * @date 2018/7/23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialVoucherSummaryRpc {


    /**
     * @Title:
     * @Description:   查询财务凭证管理列表
     * @param finVouSummaryVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 02:48:33
     */
    @RequestMapping(value = "api/finance/financial_voucher_summary/findFinancialVoucherSummaryVosByPage" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVoucherSummaryVosByPage(@RequestParam Map<String,Object> finVouSummaryVoMap);

}
