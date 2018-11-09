package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.ContInsurClaimPayService;
import cn.com.leadu.fms.finance.service.GpsMonthlyPayService;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 保险理赔制单付款Controller
 * @date
 */
@RestController
@RequestMapping("cont_insur_claim_pay")
public class ContInsurClaimPayController {
    /**
     * @Fields  : 保险理赔制单付款service
     */
    @Autowired
    private ContInsurClaimPayService contInsurClaimPayService;

    /**
     * @Description: 保险理赔制单
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date: 
     */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@Valid @RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setUser(sysUser.getUser());
        contInsurClaimPayService.makeVoucher(contInsurClaimVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保险理赔付款
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date:
     */
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@Valid @RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setUser(sysUser.getUser());
        contInsurClaimPayService.payment(contInsurClaimVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printContInsurClaim",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printContInsurClaim(@Valid @RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setUser(sysUser.getUser());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contInsurClaimPayService.printContInsurClaim(contInsurClaimVo)), HttpStatus.OK);
    }

}
