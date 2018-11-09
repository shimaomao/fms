package cn.com.leadu.fms.system.validator.sysusermenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuVo
 * @Description: 用户角色设置删除时载体及验证
 * @date 2018-03-17
 */
@Data
public class SysUserMenuDeleteListVo extends BaseVo<SysUserMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 用户菜单ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> userMenuIds;

}