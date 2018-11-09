package cn.com.leadu.fms.insurance.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.insurance.service.InsurClaimCheckService;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:  保险理赔审核
 * @author:ningyangyang
 * @since:2018/5/18
 */
@RestController
@RequestMapping("insur_claim_check")
public class InsurClaimCheckController {

    @Autowired
    private InsurClaimCheckService insurClaimCheckService;
    /**
     * @Description: 保险理赔审核通过
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setPresentUser(sysUser.getUser());
        insurClaimCheckService.approval(contInsurClaimVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保险理赔审核退回上一级
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/16 15:09
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setPresentUser(sysUser.getUser());
        insurClaimCheckService.sendBack(contInsurClaimVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保险理赔财务收款完成
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/19 17:23
     */
    @RequestMapping(value = "Receivables",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> Receivables(@RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setPresentUser(sysUser.getUser());
        insurClaimCheckService.Receivables(contInsurClaimVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保险理赔财务收款返回上一级
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/22 17:23
     */
    @RequestMapping(value = "refunds",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> refunds(@RequestBody ContInsurClaimVo contInsurClaimVo, @AuthUserInfo SysUser sysUser){
        contInsurClaimVo.setPresentUser(sysUser.getUser());
        insurClaimCheckService.sendBack(contInsurClaimVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
