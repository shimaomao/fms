package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucher.FinancialVoucherVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherController
 * @Description: 凭证类型管理rpc
 * @date 2018-06-20
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialVoucherRpc {

    /**
     * @Title:
     * @Description: 分页查询凭证类型管理信息
     * @param financialVoucherVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/findFinancialVouchersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVouchersByPage(@RequestParam Map<String, Object> financialVoucherVoMap);

    /**
     * @Title:
     * @Description: 保存凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/saveFinancialVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinancialVoucher(@RequestBody FinancialVoucherVo financialVoucherVo);

    /**
     * @Title:
     * @Description:  修改凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/modifyFinancialVoucher",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinancialVoucher(@RequestBody FinancialVoucherVo financialVoucherVo);

    /**
     * @Title:
     * @Description:   根据voucherId集合删除凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/deleteFinancialVouchersByVoucherIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinancialVouchersByVoucherIds(@RequestBody FinancialVoucherVo financialVoucherVo);

    /**
     * @Title:
     * @Description:  根据voucherId获取凭证类型管理
     * @param voucherId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/findFinancialVoucherByVoucherId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVoucherByVoucherId(@RequestParam("voucherId") String voucherId);

    /**
     * @Title:
     * @Description: 查询凭证信息树形结构
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "api/finance/financial_voucher/findFinancialVouchersByTree" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialVouchersByTree();

}
