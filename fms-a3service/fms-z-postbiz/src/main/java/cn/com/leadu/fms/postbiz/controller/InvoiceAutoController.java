package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto.InvoiceAutoVo;
import cn.com.leadu.fms.postbiz.service.InvoiceAutoService;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoController
 * @Description: 自动开票信息相关接口
 */
@RestController
@RequestMapping("invoice_auto")
public class InvoiceAutoController {

    /**
     * @Fields  : 自动开票信息service
     */
    @Autowired
    private InvoiceAutoService invoiceAutoService;

    /**
     * @Title:
     * @Description: 分页查询自动开票信息信息
     * @param invoiceAutoVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "findInvoiceAutosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceAutosByPage(InvoiceAutoVo invoiceAutoVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceAutoService.findInvoiceAutosByPage(invoiceAutoVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存自动开票信息
     * @param invoiceAutoSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "saveInvoiceAuto",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoiceAuto(@Valid @RequestBody InvoiceAutoSaveVo invoiceAutoSaveVo){
        invoiceAutoService.saveInvoiceAuto(invoiceAutoSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改自动开票信息
     * @param invoiceAutoModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "modifyInvoiceAuto",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyInvoiceAuto(@Valid @RequestBody InvoiceAutoModifyVo invoiceAutoModifyVo){
        invoiceAutoService.modifyInvoiceAuto(invoiceAutoModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除自动开票信息
     * @param invoiceAutoDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "deleteInvoiceAuto",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoiceAuto(@Valid @RequestBody InvoiceAutoDeleteVo invoiceAutoDeleteVo){
        invoiceAutoService.deleteInvoiceAuto(invoiceAutoDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据invoiceAutoId集合删除自动开票信息
     * @param invoiceAutoDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "deleteInvoiceAutosByInvoiceAutoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoiceAutosByInvoiceAutoIds(@Valid @RequestBody InvoiceAutoDeleteListVo invoiceAutoDeleteListVo){
        invoiceAutoService.deleteInvoiceAutosByInvoiceAutoIds(invoiceAutoDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据invoiceAutoId获取自动开票信息
     * @param invoiceAutoId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:19
     */
    @RequestMapping(value = "findInvoiceAutoByInvoiceAutoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceAutoByInvoiceAutoId(String invoiceAutoId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(invoiceAutoService.findInvoiceAutoByInvoiceAutoId(invoiceAutoId)), HttpStatus.OK);
    }

}
