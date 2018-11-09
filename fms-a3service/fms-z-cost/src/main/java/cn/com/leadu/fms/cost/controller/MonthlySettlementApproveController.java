package cn.com.leadu.fms.cost.controller;/**
 * Created by yyq on 2018/5/30.
 */

import cn.com.leadu.fms.cost.service.MonthlySettlementApproveService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
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
 * @description: 月结审批Controller
 * @author: yangyiquan
 * @create: 2018-05-30 16:23
 **/
@RestController
@RequestMapping("monthly_settlement_approve")
public class MonthlySettlementApproveController {

    /**
     * @Field: 提前还款审批service
     */
    @Autowired
    private MonthlySettlementApproveService monthlySettlementApproveService;

    /** 
    * @Description: 月结审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 16:28
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody MonthlySettlementApproveVo monthlySettlementApproveVo, @AuthUserInfo SysUser sysUser){
        monthlySettlementApproveVo.setUser(sysUser.getUser());
        monthlySettlementApproveService.approval(monthlySettlementApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
