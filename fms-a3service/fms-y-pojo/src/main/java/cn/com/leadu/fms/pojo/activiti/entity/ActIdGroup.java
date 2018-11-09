package cn.com.leadu.fms.pojo.activiti.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroup
 * @Description: 用户组
 * @date 2018/6/19
 */
@Data
public class ActIdGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_")
    private String id;

    @Column(name = "REV_")
    private String rev;

    @Column(name = "NAME_")
    private String name;

    @Column(name = "TYPE_")
    private String type;

}
