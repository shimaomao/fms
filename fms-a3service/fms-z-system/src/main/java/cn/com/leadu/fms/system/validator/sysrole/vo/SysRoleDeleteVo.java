package cn.com.leadu.fms.system.validator.sysrole.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleDeleteVo
 * @Description:
 * @date 2018/2/24
 */
public class SysRoleDeleteVo extends BaseVo<SysRole> {
    /**
     * 删除角色id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String id;

}
