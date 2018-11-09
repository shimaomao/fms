package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/6/22.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyConditionalAgreeService;
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
 * @description: 申请有条件同意审批Controller
 * @author: yangyiquan
 * @create: 2018-06-22 11:58
 **/
@RestController
@RequestMapping("apply_conditional_agree")
public class ApplyConditionalAgreeController {
    /**
     * @Fields  : 申请有条件同意审批业务层
     */
    @Autowired
    private ApplyConditionalAgreeService applyConditionalAgreeService;

    /** 
    * @Description: 获取有条件同意申请融资信息，构造有条件同意默认定金，首付，尾付
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 12:02
    */ 
    @RequestMapping(value = "findApplyFinanceByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByApplyNo(String applyNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                applyConditionalAgreeService.findApplyFinanceByApplyNo(applyNo) ), HttpStatus.OK);
    }

    /** 
    * @Description: 获取有条件同意vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/4 12:30
    */ 
    @RequestMapping(value = "findApplyConditionalAgreeVoByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyConditionalAgreeVoByApplyNo(String applyNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                applyConditionalAgreeService.findApplyConditionalAgreeVoByApplyNo(applyNo) ), HttpStatus.OK);
    }

    /** 
    * @Description: 是否有条件同意审批通用操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 15:34
    */ 
    @RequestMapping(value = "approve",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approve(@Valid @RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo, @AuthUserInfo SysUser sysUser){
        applyConditionalAgreeVo.setUser(sysUser.getUser());
        applyConditionalAgreeService.approve(applyConditionalAgreeVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 录入员是否同意操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 17:50
    */ 
    @RequestMapping(value = "agreeOrNot",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> agreeOrNot(@Valid @RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo, @AuthUserInfo SysUser sysUser){
        applyConditionalAgreeVo.setUser(sysUser.getUser());
        applyConditionalAgreeService.agreeOrNot(applyConditionalAgreeVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description:  万量报价器计算
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 20:04
    */ 
    @RequestMapping(value = "quotationCalculation",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> quotationCalculation(@Valid @RequestBody ApplyFinance applyFinance){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyConditionalAgreeService.quotationCalculation(applyFinance)), HttpStatus.OK);
    }

}
