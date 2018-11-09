package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/6/22.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyConditionalAgreeRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 申请有条件同意审批Controller
 * @author: yangyiquan
 * @create: 2018-06-22 14:17
 **/
@RestController
@RequestMapping("apply_conditional_agree")
public class ApplyConditionalAgreeController {
    /**
     * @Fields  : 申请有条件同意审批rpc
     */
    @Autowired
    private ApplyConditionalAgreeRpc applyConditionalAgreeRpc;

    /** 
    * @Description: 获取有条件同意申请融资信息，构造有条件同意默认定金，首付，尾付
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 14:21
    */ 
    @RequestMapping(value = "findApplyFinanceByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyFinanceByApplyNo(String applyNo){
        return applyConditionalAgreeRpc.findApplyFinanceByApplyNo(applyNo);
    }

    /** 
    * @Description: 获取有条件同意vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/4 12:30
    */ 
    @RequestMapping(value = "findApplyConditionalAgreeVoByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyConditionalAgreeVoByApplyNo(String applyNo){
        return applyConditionalAgreeRpc.findApplyConditionalAgreeVoByApplyNo(applyNo);
    }

    /** 
    * @Description:  是否有条件同意审批通用操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 15:31
    */ 
    @RequestMapping(value = "approve",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approve(@RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo){
        return applyConditionalAgreeRpc.approve(applyConditionalAgreeVo);
    }

    /** 
    * @Description: 录入员是否同意操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 17:46
    */ 
    @RequestMapping(value = "agreeOrNot",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> agreeOrNot(@RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo){
        return applyConditionalAgreeRpc.agreeOrNot(applyConditionalAgreeVo);
    }

    /** 
    * @Description: 万量报价器计算
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 20:12
    */ 
    @RequestMapping(value = "quotationCalculation",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> quotationCalculation(@RequestBody ApplyFinance applyFinance){
        return applyConditionalAgreeRpc.quotationCalculation(applyFinance);
    }
}
