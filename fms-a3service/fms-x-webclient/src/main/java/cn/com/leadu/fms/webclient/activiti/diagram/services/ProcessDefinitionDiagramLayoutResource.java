package cn.com.leadu.fms.webclient.activiti.diagram.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ProcessDefinitionDiagramLayoutResource
 * @Description:
 * @date 2018/3/12
 */
@RestController
public class ProcessDefinitionDiagramLayoutResource {

    @Autowired
    private ProcessDefinitionDiagramLayoutResourceRpc processDefinitionDiagramLayoutResourceRpc;

    @RequestMapping(value="/process-definition/{processDefinitionId}/diagram-layout", method = RequestMethod.GET, produces = "application/json")
    public ObjectNode getDiagram(@PathVariable String processDefinitionId) {
        return processDefinitionDiagramLayoutResourceRpc.getDiagram(processDefinitionId);
    }

}
