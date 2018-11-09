package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.InvoiceChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeController
 * @Description: 开票信息变更相关接口
 * @date 2018-08-29
 */
@RestController
@RequestMapping("invoice_change")
public class InvoiceChangeController {

    /**
     * @Fields  : 开票信息变更service
     */
    @Autowired
    private InvoiceChangeService invoiceChangeService;

    /**
     * @Title:
     * @Description: 保存开票信息变更
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @RequestMapping(value = "saveInvoiceChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveInvoiceChange(@Valid @RequestBody InvoiceChangePostVo invoiceChangePostVo, @AuthUserInfo SysUser sysUser){
        invoiceChangeService.saveInvoiceChange(invoiceChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据applyNo查询企业发票信息
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @RequestMapping(value = "findApplyInvoiceVosBySocialCertifNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInvoiceVosBySocialCertifNo(InvoiceChangeVo invoiceChangeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceChangeService.findApplyInvoiceVosBySocialCertifNo(invoiceChangeVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据invoiceTaskNo查询企业开票变更前后信息
     * @param invoiceTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @RequestMapping(value = "findInvoiceChangeVosByInvoiceTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(invoiceChangeService.findInvoiceChangeVosByInvoiceTaskNo(invoiceTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核通过
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @RequestMapping(value = "invoiceChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeApproval(@Valid @RequestBody InvoiceChangePostVo invoiceChangePostVo, @AuthUserInfo SysUser sysUser){
        invoiceChangeService.invoiceChangeApproval(invoiceChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @RequestMapping(value = "invoiceChangeBackApply",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeBackApply(@Valid @RequestBody InvoiceChangePostVo invoiceChangePostVo, @AuthUserInfo SysUser sysUser){
        invoiceChangeService.invoiceChangeBackApply(invoiceChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @RequestMapping(value = "invoiceChangeRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> invoiceChangeRefuse(@Valid @RequestBody InvoiceChangePostVo invoiceChangePostVo, @AuthUserInfo SysUser sysUser){
        invoiceChangeService.invoiceChangeRefuse(invoiceChangePostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 验证当前企业是否存在变更任务
     * @param invoiceChangeVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @RequestMapping(value = "checkInvoiceChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> checkInvoiceChange(@Valid @RequestBody InvoiceChangeVo invoiceChangeVo){
        invoiceChangeService.checkInvoiceChange(invoiceChangeVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
