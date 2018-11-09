package cn.com.leadu.fms.pojo.activiti.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdef
 * @Description: 实例流程
 * @date 2018/6/19
 */
@Data
public class ActReProcdef implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_")
    private String id;

    @Column(name = "REV_")
    private String rev;

    @Column(name = "CATEGORY_")
    private String category;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "KEY_")
    private String key;

    @Column(name = "VERSION_")
    private String version;

    @Column(name = "DEPLOYMENT_ID_")
    private String deploymentId;

    @Column(name = "RESOURCE_NAME_")
    private String resourceName;

    @Column(name = "DGRM_RESOURCE_NAME_")
    private String dgrmResourceName;

    @Column(name = "DESCRIPTION_")
    private String description;

    @Column(name = "HAS_START_FORM_KEY_")
    private String hasStartFormKey;

    @Column(name = "HAS_GRAPHICAL_NOTATION_")
    private String hasGraphicalNotation;

    @Column(name = "SUSPENSION_STATE_")
    private String suspensionState;

    @Column(name = "TENANT_ID_")
    private String tenantId;

}
