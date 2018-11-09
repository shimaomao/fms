package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailController
 * @Description: 凭证类型明细管理rpc
 * @date 2018-06-20
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialVoucherDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询凭证类型明细管理信息
     * @param financialVoucherDetailVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "api/finance/financial_voucher_detail/findFinancialVoucherDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVoucherDetailsByPage(@RequestParam Map<String, Object> financialVoucherDetailVoMap);

    /**
     * @Title:
     * @Description: 保存凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "api/finance/financial_voucher_detail/saveFinancialVoucherDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinancialVoucherDetail(@RequestBody FinancialVoucherDetailVo financialVoucherDetailVo);

    /**
     * @Title:
     * @Description:  修改凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "api/finance/financial_voucher_detail/modifyFinancialVoucherDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinancialVoucherDetail(@RequestBody FinancialVoucherDetailVo financialVoucherDetailVo);

    /**
     * @Title:
     * @Description:   根据voucherDetailId集合删除凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "api/finance/financial_voucher_detail/deleteFinancialVoucherDetailsByVoucherDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinancialVoucherDetailsByVoucherDetailIds(@RequestBody FinancialVoucherDetailVo financialVoucherDetailVo);

    /**
     * @Title:
     * @Description:  根据voucherDetailId获取凭证类型明细管理
     * @param voucherDetailId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "api/finance/financial_voucher_detail/findFinancialVoucherDetailByVoucherDetailId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVoucherDetailByVoucherDetailId(@RequestParam("voucherDetailId") String voucherDetailId);

}
