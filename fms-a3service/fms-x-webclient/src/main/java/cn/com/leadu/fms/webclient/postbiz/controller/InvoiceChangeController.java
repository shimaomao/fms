package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.InvoiceChangeRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeController
 * @Description: 开票信息变更controller
 * @date 2018-08-29
 */
@RestController
@RequestMapping("invoice_change")
public class InvoiceChangeController {

    /**
     * @Fields  : 开票信息变更rpc
     */
    @Autowired
    private InvoiceChangeRpc invoiceChangeRpc;

    /**
     * @Title:
     * @Description: 保存开票信息变更
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "saveInvoiceChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoiceChange(@RequestBody InvoiceChangePostVo invoiceChangePostVo){
        return invoiceChangeRpc.saveInvoiceChange(invoiceChangePostVo);
    }


    /**
     * @Title:
     * @Description:  根据applyNo获取企业发票基本信息
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "findApplyInvoiceVosBySocialCertifNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInvoiceVosBySocialCertifNo(InvoiceChangeVo invoiceChangeVo){
        Map invoiceChangeVoMap = invoiceChangeVo == null?null:(Map) JSON.toJSON(invoiceChangeVo);
        return invoiceChangeRpc.findApplyInvoiceVosBySocialCertifNo(invoiceChangeVoMap);
    }

    /**
     * @Title:
     * @Description:  根据invoiceTaskNo获取企业发票变更前后信息
     * @param invoiceTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "findInvoiceChangeVosByInvoiceTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo){
        return invoiceChangeRpc.findInvoiceChangeVosByInvoiceTaskNo(invoiceTaskNo);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核通过
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "invoiceChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeApproval(@RequestBody InvoiceChangePostVo invoiceChangePostVo){
        return invoiceChangeRpc.invoiceChangeApproval(invoiceChangePostVo);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "invoiceChangeBackApply",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeBackApply(@RequestBody InvoiceChangePostVo invoiceChangePostVo){
        return invoiceChangeRpc.invoiceChangeBackApply(invoiceChangePostVo);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "invoiceChangeRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeRefuse(@RequestBody InvoiceChangePostVo invoiceChangePostVo){
        return invoiceChangeRpc.invoiceChangeRefuse(invoiceChangePostVo);
    }

    /**
     * @Title:
     * @Description: 验证当前企业是否存在变更任务
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @RequestMapping(value = "checkInvoiceChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> checkInvoiceChange(@RequestBody InvoiceChangeVo invoiceChangeVo){
        return invoiceChangeRpc.checkInvoiceChange(invoiceChangeVo);
    }

}
