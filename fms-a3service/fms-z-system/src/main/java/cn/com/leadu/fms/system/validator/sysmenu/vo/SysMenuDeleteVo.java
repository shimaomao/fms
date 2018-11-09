package cn.com.leadu.fms.system.validator.sysmenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: SysMenuVo
 * @Description: 系统菜单删除时载体及验证
 * @date 2018-03-07
 */
@Data
public class SysMenuDeleteVo extends BaseVo<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 菜单id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String menuId;

}