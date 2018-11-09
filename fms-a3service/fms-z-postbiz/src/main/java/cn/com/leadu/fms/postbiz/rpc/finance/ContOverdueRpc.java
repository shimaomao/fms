package cn.com.leadu.fms.postbiz.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @description:  还款逾期罚息
 * @author:yangyiquan
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface ContOverdueRpc {
    /** 
    * @Description:  查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 14:42
    */ 
    @RequestMapping(value = "cont_overdue/findOverdueInterestSum", method = RequestMethod.GET)
    ResponseEntity<RestResponse<BigDecimal>> findOverdueInterestSum(@RequestParam("contNo") String contNo);
}
