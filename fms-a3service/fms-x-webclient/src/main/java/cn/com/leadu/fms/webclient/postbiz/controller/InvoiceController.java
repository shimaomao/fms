package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.InvoiceRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: InvoiceController
 * @Description: 开票信息controller
 */
@RestController
@RequestMapping("invoice")
public class InvoiceController {

    /**
     * @Fields  : 开票信息rpc
     */
    @Autowired
    private InvoiceRpc invoiceRpc;

    /**
     * @Title:
     * @Description: 分页查询开票信息信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "findInvoiceVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceVosByPage(InvoiceVo invoiceVo){
        Map invoiceVoMap = invoiceVo == null?null:(Map) JSON.toJSON(invoiceVo);
        return invoiceRpc.findInvoiceVosByPage(invoiceVoMap);
    }

    /**
     * @Title:
     * @Description: 手动开票
     * @param invoiceVos
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "invoiceManual",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> invoiceManual(@RequestBody List<InvoiceVo> invoiceVos){
        return invoiceRpc.invoiceManual(invoiceVos);
    }

    /**
     * @Title:
     * @Description:   发票作废
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 01:38:20
     */
    @RequestMapping(value = "cancelInvoice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> cancelInvoice(@RequestBody List<String> invoiceIds){
        return invoiceRpc.cancelInvoice(invoiceIds);
    }

    /**
     * @Title:
     * @Description:   自动开票
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 02:44:54
     */
    @RequestMapping(value = "autoManual",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> autoManual(@RequestBody List<String> invoiceIds) {
        return invoiceRpc.autoManual(invoiceIds);
    }

    /**
     * @Title:
     * @Description: 开票完成后的打印
     * @param invoiceAutos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 09:39:40
     */
    @RequestMapping(value = "printinv",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> printinv(@RequestBody List<InvoiceAuto> invoiceAutos){
        return invoiceRpc.printinv(invoiceAutos);
    }

    /**
     * @Title:
     * @Description:   手动打印
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 05:23:22
     */
    @RequestMapping(value = "manualPrintinv",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> manualPrintinv(@RequestBody List<String> invoiceIds){
        return invoiceRpc.manualPrintinv(invoiceIds);
    }

    /**
    * @Description: 生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/13 17:59
    */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody List<String> invoiceIds){
        return invoiceRpc.makeVoucher(invoiceIds);
    }

    /**
     * @Title:
     * @Description: 保存开票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "saveInvoice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoice(@RequestBody InvoiceVo invoiceVo){
        return invoiceRpc.saveInvoice(invoiceVo);
    }

    /**
     * @Title:
     * @Description:  修改开票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "modifyInvoice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyInvoice(@RequestBody InvoiceVo invoiceVo){
        return invoiceRpc.modifyInvoice(invoiceVo);
    }

    /**
     * @Title:
     * @Description:   根据invoiceId集合删除开票信息
     * @param invoiceIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "deleteInvoicesByInvoiceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoicesByInvoiceIds(@RequestBody List<String> invoiceIds){
        InvoiceVo invoiceVo = new InvoiceVo();
        invoiceVo.setInvoiceIds(invoiceIds);
        return invoiceRpc.deleteInvoicesByInvoiceIds(invoiceVo);
    }

    /**
     * @Title:
     * @Description:  根据invoiceId获取开票信息
     * @param invoiceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "findInvoiceByInvoiceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceByInvoiceId(String invoiceId){
        return invoiceRpc.findInvoiceByInvoiceId(invoiceId);
    }

    /**
     * @Title:
     * @Description:  根据开票号码获取自动开票信息
     * @param invoiceNoList
     * @return
     * @throws
     * @author nignyangyang
     * @date 2018-10-24 16:01:34
     */
    @RequestMapping(value = "findInvoiceAutos", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findInvoiceAutos(@RequestBody List<String> invoiceNoList){
        return invoiceRpc.findInvoiceAutos(invoiceNoList);
    }

}
