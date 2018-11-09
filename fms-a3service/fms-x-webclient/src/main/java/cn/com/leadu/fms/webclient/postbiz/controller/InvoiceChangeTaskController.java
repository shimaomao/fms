package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.HistoryChangeVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.InvoiceChangeTaskRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskController
 * @Description: 开票变更任务controller
 * @date 2018-08-29
 */
@RestController
@RequestMapping("invoice_change_task")
public class InvoiceChangeTaskController {

    /**
     * @Fields  : 开票变更任务rpc
     */
    @Autowired
    private InvoiceChangeTaskRpc invoiceChangeTaskRpc;

    /**
     * @Title:
     * @Description:  根据invoiceChangeVo获取企业发票基本信息List
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "findCompanyInvoiceListByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCompanyInvoiceListByPage(InvoiceChangeVo invoiceChangeVo){
        Map invoiceChangeVoMap = invoiceChangeVo == null?null:(Map) JSON.toJSON(invoiceChangeVo);
        return invoiceChangeTaskRpc.findCompanyInvoiceListByPage(invoiceChangeVoMap);
    }

    /**
     * @Title:
     * @Description: 查询开票信息变更任务
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 10:40:44
     */
    @RequestMapping(value = "findInvoiceChangeVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeVosByPage(InvoiceChangeVo invoiceChangeVo){
        Map invoiceChangeVoMap = invoiceChangeVo == null?null:(Map) JSON.toJSON(invoiceChangeVo);
        return invoiceChangeTaskRpc.findInvoiceChangeVosByPage(invoiceChangeVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询制定社会统一信用号的开票变更历史任务
     * @param vo 参数
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findInvoiceChangeHistory", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeHistory(HistoryChangeVo vo){
        Map map = vo == null?null:(Map) JSON.toJSON(vo);
        return invoiceChangeTaskRpc.findInvoiceChangeHistory(map);
    }

}
