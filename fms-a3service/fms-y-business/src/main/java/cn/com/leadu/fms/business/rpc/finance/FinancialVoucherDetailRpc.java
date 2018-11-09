package cn.com.leadu.fms.business.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDetailRpc
 * @Description:
 * @date 2018/6/21
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsFinance}")
public interface FinancialVoucherDetailRpc {

    /**
     * @Title:
     * @Description:   根据凭证类型取得凭证类型明细列表
     * @param voucherType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:07:42
     */
    @RequestMapping(value = "financial_voucher_detail/findFinancialVoucherDetailsByVoucherType", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<FinancialVoucherDetail>>> findFinancialVoucherDetailsByVoucherType(@RequestParam("voucherType") String voucherType);

}
