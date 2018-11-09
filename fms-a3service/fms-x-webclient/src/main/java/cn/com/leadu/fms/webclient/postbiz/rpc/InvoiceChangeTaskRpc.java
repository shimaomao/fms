package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskController
 * @Description: 开票变更任务rpc
 * @date 2018-08-29
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InvoiceChangeTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询企业发票信息
     * @param invoiceChangeVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "api/postbiz/invoice_change_task/findCompanyInvoiceListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCompanyInvoiceListByPage(@RequestParam Map<String, Object> invoiceChangeVoMap);

    /**
     * @Title:
     * @Description: 查询开票信息变更任务
     * @param invoiceChangeVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "api/postbiz/invoice_change_task/findInvoiceChangeVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceChangeVosByPage(@RequestParam Map<String, Object> invoiceChangeVoMap);

    /**
     * @Title:
     * @Description: 分页查询制定社会统一信用号的开票变更历史任务
     * @param map 参数
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/invoice_change_task/findInvoiceChangeHistory" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceChangeHistory(@RequestParam Map<String, Object> map);

}
