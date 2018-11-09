package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.HistoryChangeVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.postbiz.service.InvoiceChangeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskController
 * @Description: 开票变更任务相关接口
 * @date 2018-08-29
 */
@RestController
@RequestMapping("invoice_change_task")
public class InvoiceChangeTaskController {

    /**
     * @Fields  : 开票变更任务service
     */
    @Autowired
    private InvoiceChangeTaskService invoiceChangeTaskService;

    /**
     * @Title:
     * @Description: 分页查询企业发票信息
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @RequestMapping(value = "findCompanyInvoiceListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCompanyInvoiceListByPage(InvoiceChangeVo invoiceChangeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceChangeTaskService.findCompanyInvoiceListByPage(invoiceChangeVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询开票信息变更任务
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @RequestMapping(value = "findInvoiceChangeVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeVosByPage(InvoiceChangeVo invoiceChangeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceChangeTaskService.findInvoiceChangeVosByPage(invoiceChangeVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询制定社会统一信用号的开票变更历史任务
     * @param vo 参数
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findInvoiceChangeHistory" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeHistory(HistoryChangeVo vo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceChangeTaskService.findInvoiceChangeHistory(vo)), HttpStatus.OK);
    }

}
