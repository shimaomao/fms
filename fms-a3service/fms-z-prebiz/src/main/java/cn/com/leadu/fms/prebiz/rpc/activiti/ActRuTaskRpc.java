package cn.com.leadu.fms.prebiz.rpc.activiti;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.entity.ActRuTask;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskRpc
 * @Description:
 * @date 2018/6/22
 */
@FeignClient("${fms.feigns.serverNames.fmsActiviti}")
public interface ActRuTaskRpc {

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    @RequestMapping(value = "act_ru_task/findActRuTasksByBusinessKeys" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse<List<ActRuTaskVo>>> findActRuTasksByBusinessKeys(@RequestBody List<String> businessKeys);

}
