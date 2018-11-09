package cn.com.leadu.fms.pojo.activiti.vo.actreprocdef;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefVo
 * @Description: 流程定义vo
 * @date 2018/3/13
 */
@Data
public class ActReProcdefVo extends PageQuery<ActReProcdefVo> {

    private String id;

    private String category;

    private String name;

    private String key;

    private String description;

    private int version;

    private String resourceName;

    private String deploymentId;

    private String diagramResourceName;

    private boolean hasStartFormKey;

    private boolean hasGraphicalNotation;

    private boolean isSuspended;

    private String tenantId;

    private ActReDeploymentVo actReDeploymentVo;

    private String user;

    private List<String> userGroups;

    private Boolean tree;

}
