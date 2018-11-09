package cn.com.leadu.fms.finance.controller;/**
 * Created by yyq on 2018/6/4.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.PilferMonthlyPayService;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
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
 * @program: fms
 * @description: 盗抢险月结付款Controller
 * @author: yangyiquan
 * @create: 2018-06-04 18:12
 **/
@RestController
@RequestMapping("pilfer_monthly_pay")
public class PilferMonthlyPayController {

    /**
     * @Fields  : 盗抢险月结付款service
     */
    @Autowired
    private PilferMonthlyPayService pilferMonthlyPayService;


    /**
     * @Description: 盗抢险月结财务制单
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/2 14:00
     */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@Valid @RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo, @AuthUserInfo SysUser sysUser){
        pilferInsuranceApproveVo.setUser(sysUser.getUser());
        pilferMonthlyPayService.makeVoucher(pilferInsuranceApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 盗抢险月结财务付款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/4 13:48
     */
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@Valid @RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo, @AuthUserInfo SysUser sysUser){
        pilferInsuranceApproveVo.setUser(sysUser.getUser());
        pilferMonthlyPayService.payment(pilferInsuranceApproveVo);
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
    @RequestMapping(value = "printPilferMonthly",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPilferMonthly(@Valid @RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pilferMonthlyPayService.printPilferMonthly(pilferInsuranceApproveVo)), HttpStatus.OK);
    }
}
