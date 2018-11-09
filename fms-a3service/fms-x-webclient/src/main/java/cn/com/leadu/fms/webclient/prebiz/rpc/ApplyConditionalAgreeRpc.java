package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: fms
 * @description: 申请有条件同意审批rpc
 * @author: yangyiquan
 * @create: 2018-06-22 14:17
 **/
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyConditionalAgreeRpc {

    /** 
    * @Description: 获取有条件同意申请融资信息，构造有条件同意默认定金，首付，尾付
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 14:22
    */ 
    @RequestMapping(value = "api/prebiz/apply_conditional_agree/findApplyFinanceByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyFinanceByApplyNo(@RequestParam("applyNo") String applyNo);

    /** 
    * @Description: 获取有条件同意vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/4 12:30
    */ 
    @RequestMapping(value = "api/prebiz/apply_conditional_agree/findApplyConditionalAgreeVoByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyConditionalAgreeVoByApplyNo(@RequestParam("applyNo") String applyNo);

    /** 
    * @Description: 是否有条件同意审批通用操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 15:33
    */ 
    @RequestMapping(value = "api/prebiz/apply_conditional_agree/approve",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approve(@RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo);

    /** 
    * @Description:  录入员是否同意操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 17:47
    */ 
    @RequestMapping(value = "api/prebiz/apply_conditional_agree/agreeOrNot",method = RequestMethod.POST)
    ResponseEntity<RestResponse> agreeOrNot(@RequestBody ApplyConditionalAgreeVo applyConditionalAgreeVo);

    /** 
    * @Description: 万量报价器计算 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 20:12
    */ 
    @RequestMapping(value = "api/prebiz/apply_conditional_agree/quotationCalculation",method = RequestMethod.POST)
    ResponseEntity<RestResponse> quotationCalculation(ApplyFinance applyFinance);
}
