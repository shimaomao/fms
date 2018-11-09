package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qiaomengnan
 * @ClassName: SysUserRole
 * @Description:
 * @date 2018/1/7
 */
@Data
public class SysUserRole extends BaseEntity<SysUserRole> {
    /**
     * @Fields  : 用户角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
    private String userRoleId;
    /**
     * @Fields  : 用户id
     */
    @Id
    private String userId;
    /**
     * @Fields  : 角色id
     */
    @Id
    private String roleId;

}
