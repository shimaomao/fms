package cn.com.leadu.fms.schedule.rpc.postbiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description 自动结清
 * @author wangxue
 * @since 2018/9/26
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface MonthlyOverdueRpc {

    /**
     * @Title:
     * @Description: 每月定位统计逾期数据
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-25 11:24:39
     */
    @RequestMapping(value = "monthly_overdue/analyseMonthlyOverdue" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> analyseMonthlyOverdue();
}
