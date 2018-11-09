package cn.com.leadu.fms.schedule.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangxue
 * @ClassName: CountDistributeOverdueRpc
 * @Description: 逾期数据统计与分配相关接口
 * @date 2018/9/5
 */
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface CountDistributeOverdueRpc {

    /**
     * @Title:
     * @Description: 逾期数据统计与分配
     * @return
     * @throws
     * @author wangxue
     * @date 2018/09/05 16:47:10
     */
    @RequestMapping(value = "count_distribute_overdue/distributeOverdueData" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> distributeOverdueData();
}
