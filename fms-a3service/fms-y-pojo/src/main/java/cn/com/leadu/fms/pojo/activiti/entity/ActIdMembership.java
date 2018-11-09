package cn.com.leadu.fms.pojo.activiti.entity;

import cn.com.leadu.fms.common.entity.Entity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: ActIdMembership
 * @Description: 工作流用户组实体
 * @date 2018/3/12
 */
@Data
public class ActIdMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id_")
    private String userId;

    @Id
    @Column(name = "group_id_")
    private String groupId;

}
