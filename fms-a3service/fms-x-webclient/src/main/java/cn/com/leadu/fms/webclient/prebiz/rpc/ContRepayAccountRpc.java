package cn.com.leadu.fms.webclient.prebiz.rpc;/**
 * Created by yyq on 2018/5/9.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @program: fms
 * @description: 客户还款信息一览rpc
 * @author: yangyiquan
 * @create: 2018-05-09 11:49
 **/
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContRepayAccountRpc {
    /** 
    * @Description: 分页查询客户还款信息一览
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 12:01
    */ 
    @RequestMapping(value = "api/prebiz/contRepayAccount/findContRepayAccountListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepayAccountListByPage(@RequestParam Map<String, Object> contRepayAccountListVoMap);

    /** 
    * @Description: 根据合同号取得融资合同还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 16:41
    */
    @RequestMapping(value = "api/prebiz/contRepayAccount/findContRepayAccountByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepayAccountByContNo(@RequestParam("contNo") String contNo);

    /** 
    * @Description: 动态修改客户还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 18:25
    */ 
    @RequestMapping(value = "api/prebiz/contRepayAccount/modifyContRepayAccount",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContRepayAccount(@RequestBody ContRepayAccountVo contRepayAccountVo);

}
