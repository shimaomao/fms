package cn.com.leadu.fms.schedule.rpc.postbiz;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author qiaomengnan
 * @ClassName: OverdueAssignmentRpc
 * @Description: 逾期任务
 * @date 2018/5/21
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface OverdueAssignmentRpc {



}
