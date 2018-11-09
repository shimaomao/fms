package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto.InvoiceAutoVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.InvoiceAutoRpc;
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
 * @ClassName: InvoiceAutoController
 * @Description: 自动开票信息controller
 */
@RestController
@RequestMapping("invoice_auto")
public class InvoiceAutoController {

    /**
     * @Fields  : 自动开票信息rpc
     */
    @Autowired
    private InvoiceAutoRpc invoiceAutoRpc;

    /**
     * @Title:
     * @Description: 分页查询自动开票信息信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "findInvoiceAutosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceAutosByPage(InvoiceAutoVo invoiceAutoVo){
        Map invoiceAutoVoMap = invoiceAutoVo == null?null:(Map) JSON.toJSON(invoiceAutoVo);
        return invoiceAutoRpc.findInvoiceAutosByPage(invoiceAutoVoMap);
    }

    /**
     * @Title:
     * @Description: 保存自动开票信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "saveInvoiceAuto",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoiceAuto(@RequestBody InvoiceAutoVo invoiceAutoVo){
        return invoiceAutoRpc.saveInvoiceAuto(invoiceAutoVo);
    }

    /**
     * @Title:
     * @Description:  修改自动开票信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "modifyInvoiceAuto",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyInvoiceAuto(@RequestBody InvoiceAutoVo invoiceAutoVo){
        return invoiceAutoRpc.modifyInvoiceAuto(invoiceAutoVo);
    }

    /**
     * @Title:
     * @Description:   根据invoiceAutoId集合删除自动开票信息
     * @param invoiceAutoIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "deleteInvoiceAutosByInvoiceAutoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoiceAutosByInvoiceAutoIds(@RequestBody List<String> invoiceAutoIds){
        InvoiceAutoVo invoiceAutoVo = new InvoiceAutoVo();
        invoiceAutoVo.setInvoiceAutoIds(invoiceAutoIds);
        return invoiceAutoRpc.deleteInvoiceAutosByInvoiceAutoIds(invoiceAutoVo);
    }

    /**
     * @Title:
     * @Description:  根据invoiceAutoId获取自动开票信息
     * @param invoiceAutoId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @RequestMapping(value = "findInvoiceAutoByInvoiceAutoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceAutoByInvoiceAutoId(String invoiceAutoId){
        return invoiceAutoRpc.findInvoiceAutoByInvoiceAutoId(invoiceAutoId);
    }

}
