package cn.com.leadu.fms.webclient.activiti.diagram.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaomengnan
 * @ClassName: ProcessInstanceDiagramLayoutResourceRpc
 * @Description:
 * @date 2018/3/12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ProcessInstanceDiagramLayoutResourceRpc {

    @RequestMapping(value="api/activiti/process-instance/{processInstanceId}/diagram-layout", method = RequestMethod.GET, produces = "application/json")
    ObjectNode getDiagram(@PathVariable("processInstanceId") String processInstanceId);

}
