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
 * @ClassName: FinancialVoucherDataController
 * @Description: 财务凭证数据rpc
 * @date 2018-06-21
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialVoucherDataRpc {

    /**
     * @Title:
     * @Description: 分页查询财务凭证数据信息
     * @param financialVoucherDataVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @RequestMapping(value = "api/finance/financial_voucher_data/findFinVouDataVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinVouDataVosByPage(@RequestParam Map<String, Object> financialVoucherDataVoMap);

    /**
     * @Title:
     * @Description: 根据凭证号查询对应的凭证数据
     * @param:  voucherNo 凭证号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/16 0016 19:37
     */
    @RequestMapping(value = "api/finance/financial_voucher_data/findFinVouDataVoDetails", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinVouDataVoDetails(@RequestParam("voucherNo") String voucherNo);

    /**
     * @Title:
     * @Description:   根据财务凭证id获取财务凭证核算数据
     * @param voucherDataId 财务凭证id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 03:01:10
     */
    @RequestMapping(value = "api/finance/financial_voucher_data/findFinVouAssisVosByVouDataId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinVouAssisVosByVouDataId(@RequestParam("voucherDataId") String voucherDataId);

}
