package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.InvoiceService;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceModifyVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceController
 * @Description: 开票信息相关接口
 */
@RestController
@RequestMapping("invoice")
public class InvoiceController {

    /**
     * @Fields  : 开票信息service
     */
    @Autowired
    private InvoiceService invoiceService;

    /**
     * @Title:
     * @Description: 分页查询开票信息信息
     * @param invoiceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "findInvoiceVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceVosByPage(InvoiceVo invoiceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceService.findInvoiceVosByPage(invoiceVo)),
                HttpStatus.OK);
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
        invoiceService.invoiceManual(invoiceVos);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> cancelInvoice(@RequestBody List<String> invoiceIds) {
        invoiceService.cancelInvoice(invoiceIds);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> autoManual(@RequestBody List<String> invoiceIds, @AuthUserInfo SysUser sysUser) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(invoiceService.autoManual(invoiceIds,sysUser)), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> printinv(@RequestBody List<InvoiceAuto> invoiceAutos, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(invoiceService.printinv(invoiceAutos,sysUser)), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> manualPrintinv(@RequestBody List<String> invoiceIds, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(invoiceService.manualPrintinv(invoiceIds,sysUser)), HttpStatus.OK);
    }

    /**
    * @Description: 生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/13 18:02
    */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody List<String> invoiceIds, @AuthUserInfo SysUser sysUser){
        invoiceService.makeVoucher(invoiceIds, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存开票信息
     * @param invoiceSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "saveInvoice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoice(@Valid @RequestBody InvoiceSaveVo invoiceSaveVo){
        invoiceService.saveInvoice(invoiceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改开票信息
     * @param invoiceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "modifyInvoice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyInvoice(@Valid @RequestBody InvoiceModifyVo invoiceModifyVo){
        invoiceService.modifyInvoice(invoiceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除开票信息
     * @param invoiceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "deleteInvoice",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoice(@Valid @RequestBody InvoiceDeleteVo invoiceDeleteVo){
        invoiceService.deleteInvoice(invoiceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据invoiceId集合删除开票信息
     * @param invoiceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "deleteInvoicesByInvoiceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteInvoicesByInvoiceIds(@Valid @RequestBody InvoiceDeleteListVo invoiceDeleteListVo){
        invoiceService.deleteInvoicesByInvoiceIds(invoiceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据invoiceId获取开票信息
     * @param invoiceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:33
     */
    @RequestMapping(value = "findInvoiceByInvoiceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceByInvoiceId(String invoiceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(invoiceService.findInvoiceByInvoiceId(invoiceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据发票号查找要打印的信息
     * @param invoiceNoList
     * @return
     * @throws
     * @author nignyangyang
     * @date 2018-10-24 16:01:33
     */
    @RequestMapping(value = "findInvoiceAutos" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findInvoiceAutos(@RequestBody List<String> invoiceNoList){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceService.findInvoiceAutos(invoiceNoList)),
                HttpStatus.OK);
    }

}
