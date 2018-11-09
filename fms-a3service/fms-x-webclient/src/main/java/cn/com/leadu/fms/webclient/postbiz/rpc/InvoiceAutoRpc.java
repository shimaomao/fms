package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto.InvoiceAutoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoController
 * @Description: 自动开票信息rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InvoiceAutoRpc {

    /**
     * @Title:
     * @Description: 分页查询自动开票信息信息
     * @param invoiceAutoVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "api/postbiz/invoice_auto/findInvoiceAutosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceAutosByPage(@RequestParam Map<String,Object> invoiceAutoVoMap);

    /**
     * @Title:
     * @Description: 保存自动开票信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "api/postbiz/invoice_auto/saveInvoiceAuto",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveInvoiceAuto(@RequestBody InvoiceAutoVo invoiceAutoVo);

    /**
     * @Title:
     * @Description:  修改自动开票信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "api/postbiz/invoice_auto/modifyInvoiceAuto",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyInvoiceAuto(@RequestBody InvoiceAutoVo invoiceAutoVo);

    /**
     * @Title:
     * @Description:   根据invoiceAutoId集合删除自动开票信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "api/postbiz/invoice_auto/deleteInvoiceAutosByInvoiceAutoIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteInvoiceAutosByInvoiceAutoIds(@RequestBody InvoiceAutoVo invoiceAutoVo);

    /**
     * @Title:
     * @Description:  根据invoiceAutoId获取自动开票信息
     * @param invoiceAutoId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "api/postbiz/invoice_auto/findInvoiceAutoByInvoiceAutoId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceAutoByInvoiceAutoId(@RequestParam("invoiceAutoId") String invoiceAutoId);

}
