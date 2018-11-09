package cn.com.leadu.fms.postbiz.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @description:  合同融资信息rpc
 * @author:yangyiquan
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContractFinanceRpc {

    /** 
    * @Description: 根据合同号查找保证金，保证金返还方式 = 一次性的场合 ，不是一次性返回0
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 16:45
    */ 
    @RequestMapping(value = "contract_finance/findContractFinancesDepositByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<BigDecimal>> findContractFinancesDepositByContNo(@RequestParam("contNo") String contNo);
}
