package cn.com.leadu.fms.system.validator.sysrole.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.system.validator.sysrole.validator.SysRoleDeleteValidator;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleDeleteVo
 * @Description:
 * @date 2018/1/22
 */
@Data
public class SysRoleDeleteListVo extends BaseVo<SysRole> {

    @Size(min = 1, message = ValidatorConstants.DELETE_MESSAGE)
    @SysRoleDeleteValidator(message = "超级管理员角色不可删除")
    private List<String> ids;  //菜单id集合

}
