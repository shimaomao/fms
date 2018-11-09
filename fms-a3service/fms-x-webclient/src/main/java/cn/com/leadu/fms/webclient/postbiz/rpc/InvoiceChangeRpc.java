package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeController
 * @Description: 开票信息变更rpc
 * @date 2018-08-29
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InvoiceChangeRpc {

    /**
     * @Title:
     * @Description: 保存开票信息变更
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "api/postbiz/invoice_change/saveInvoiceChange",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveInvoiceChange(@RequestBody InvoiceChangePostVo invoiceChangePostVo);

    /**
     * @Title:
     * @Description: 根据applyNo查询企业发票信息
     * @param invoiceChangeVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "api/postbiz/invoice_change/findApplyInvoiceVosBySocialCertifNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyInvoiceVosBySocialCertifNo(@RequestParam Map<String, Object> invoiceChangeVoMap);

    /**
     * @Title:
     * @Description: 根据invoiceTaskNo查询企业开票变更前后信息
     * @param invoiceTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "api/postbiz/invoice_change/findInvoiceChangeVosByInvoiceTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceChangeVosByInvoiceTaskNo(@RequestParam("invoiceTaskNo") String invoiceTaskNo);

    /**
     * @Title:
     * @Description: 开票信息变更审核通过
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "api/postbiz/invoice_change/invoiceChangeApproval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> invoiceChangeApproval(@RequestBody InvoiceChangePostVo invoiceChangePostVo);

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "api/postbiz/invoice_change/invoiceChangeBackApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> invoiceChangeBackApply(@RequestBody InvoiceChangePostVo invoiceChangePostVo);

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "api/postbiz/invoice_change/invoiceChangeRefuse",method = RequestMethod.POST)
    ResponseEntity<RestResponse> invoiceChangeRefuse(@RequestBody InvoiceChangePostVo invoiceChangePostVo);

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "api/postbiz/invoice_change/checkInvoiceChange",method = RequestMethod.POST)
    ResponseEntity<RestResponse> checkInvoiceChange(@RequestBody InvoiceChangeVo invoiceChangeVo);

}
