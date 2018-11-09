package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleResource
 * @Description:
 * @date 2018/1/7
 */
@Data
public class SysRoleResource extends BaseEntity<SysRoleResource> {

    @Id
    private String roleId;

    @Id
    private String resourceId;

}
