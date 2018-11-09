package cn.com.leadu.fms.webclient.activiti.diagram.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ProcessInstanceHighlightsResource
 * @Description:
 * @date 2018/3/12
 */
@RestController
public class ProcessInstanceHighlightsResource {

    @Autowired
    private ProcessInstanceHighlightsResourceRpc processInstanceHighlightsResourceRpc;

    @RequestMapping(value="/process-instance/{processInstanceId}/highlights", method = RequestMethod.GET, produces = "application/json")
    public ObjectNode getHighlighted(@PathVariable String processInstanceId) {
        return processInstanceHighlightsResourceRpc.getHighlighted(processInstanceId);
    }

}
