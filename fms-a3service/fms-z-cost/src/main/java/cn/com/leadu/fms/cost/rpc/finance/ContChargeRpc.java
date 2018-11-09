package cn.com.leadu.fms.cost.rpc.finance;/**
 * Created by yyq on 2018/6/13.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: fms
 * @description: 财务待收款rpc
 * @author: yangyiquan
 * @create: 2018-06-13 11:18
 **/
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface ContChargeRpc {

    /** 
    * @Description: 根据业务类型和业务号查询待收款数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 11:21
    */ 
    @RequestMapping(value = "cont_charge/fingContChargeListByBizIdAndBizType", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<ContCharge>>> fingContChargeListByBizIdAndBizType(@RequestParam("chargeBizId") String chargeBizId
            , @RequestParam("chargeBizType") String chargeBizType);
}
