package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: InvoiceController
 * @Description: 开票信息rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InvoiceRpc {

    /**
     * @Title:
     * @Description: 分页查询开票信息信息
     * @param invoiceVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/findInvoiceVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceVosByPage(@RequestParam Map<String,Object> invoiceVoMap);


    /**
     * @Title:
     * @Description: 手动开票
     * @param invoiceVos
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "api/postbiz/invoice/invoiceManual",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> invoiceManual(@RequestBody List<InvoiceVo> invoiceVos);

    /**
     * @Title:
     * @Description:   发票作废
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 01:38:20
     */
    @RequestMapping(value = "api/postbiz/invoice/cancelInvoice",method = RequestMethod.PUT)
   ResponseEntity<RestResponse> cancelInvoice(@RequestBody List<String> invoiceIds);

    /**
     * @Title:
     * @Description:   自动开票
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 02:44:54
     */
    @RequestMapping(value = "api/postbiz/invoice/autoManual",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> autoManual(@RequestBody List<String> invoiceIds) ;

    /**
     * @Title:
     * @Description: 开票完成后的打印
     * @param invoiceAutos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 09:39:40
     */
    @RequestMapping(value = "api/postbiz/invoice/printinv",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> printinv(@RequestBody List<InvoiceAuto> invoiceAutos);


    /**
     * @Title:
     * @Description:   手动打印
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 05:23:22
     */
    @RequestMapping(value = "api/postbiz/invoice/manualPrintinv",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> manualPrintinv(@RequestBody List<String> invoiceIds);

    /**
     * @Title:
     * @Description: 保存开票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/saveInvoice",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveInvoice(@RequestBody InvoiceVo invoiceVo);

    /**
     * @Title:
     * @Description:  修改开票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/modifyInvoice",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyInvoice(@RequestBody InvoiceVo invoiceVo);

    /**
     * @Title:
     * @Description:   根据invoiceId集合删除开票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/deleteInvoicesByInvoiceIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteInvoicesByInvoiceIds(@RequestBody InvoiceVo invoiceVo);

    /**
     * @Title:
     * @Description:  根据invoiceId获取开票信息
     * @param invoiceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/findInvoiceByInvoiceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findInvoiceByInvoiceId(@RequestParam("invoiceId") String invoiceId);

    /**
    * @Description: 生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/13 18:00
    */
    @RequestMapping(value = "api/postbiz/invoice/makeVoucher", method = RequestMethod.PUT)
    ResponseEntity<RestResponse> makeVoucher(@RequestBody List<String> invoiceIds);

    /**
     * @Title:
     * @Description:  根据开票号码获取自动开票信息
     * @param invoiceNoList
     * @return
     * @throws
     * @author nignyangyang
     * @date 2018-10-24 16:01:34
     */
    @RequestMapping(value = "api/postbiz/invoice/findInvoiceAutos", method = RequestMethod.POST)
    ResponseEntity<RestResponse> findInvoiceAutos(@RequestBody List<String> invoiceNoList);

}
