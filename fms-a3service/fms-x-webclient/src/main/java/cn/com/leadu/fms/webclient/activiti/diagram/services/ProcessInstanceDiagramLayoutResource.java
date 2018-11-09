package cn.com.leadu.fms.webclient.activiti.diagram.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ProcessInstanceDiagramLayoutResource
 * @Description:
 * @date 2018/3/12
 */
@RestController
public class ProcessInstanceDiagramLayoutResource {

    @Autowired
    private ProcessInstanceDiagramLayoutResourceRpc processInstanceDiagramLayoutResourceRpc;

    @RequestMapping(value="/process-instance/{processInstanceId}/diagram-layout", method = RequestMethod.GET, produces = "application/json")
    public ObjectNode getDiagram(@PathVariable String processInstanceId) {
        return processInstanceDiagramLayoutResourceRpc.getDiagram(processInstanceId);
    }

}
