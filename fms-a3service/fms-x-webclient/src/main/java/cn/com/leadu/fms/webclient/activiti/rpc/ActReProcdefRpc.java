package cn.com.leadu.fms.webclient.activiti.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentRpc
 * @Description: 流程文件部署信息rpc
 * @date 2018/3/13
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ActReProcdefRpc {

    /**
     * @Title:
     * @Description:   分页查询流程文件信息
     * @param actReProcdefVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 03:28:35
     */
    @RequestMapping(value = "api/activiti/act_re_procdef/findActReProcdefVosByPage" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActReProcdefVosByPage(@RequestParam Map<String,Object> actReProcdefVoMap);

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    @RequestMapping(value = "api/activiti/act_re_procdef/findActReProcdefVosByUserOrGroup" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActReProcdefVosByUserOrGroup();

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型，并得到树形
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/12 11:15:14
     */
    @RequestMapping(value = "api/activiti/act_re_procdef/findProcdefTree" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProcdefTree();

}
