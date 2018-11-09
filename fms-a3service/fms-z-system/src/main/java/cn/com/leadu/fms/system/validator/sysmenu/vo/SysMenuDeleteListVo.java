package cn.com.leadu.fms.system.validator.sysmenu.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuVo
 * @Description: 系统菜单删除时载体及验证
 * @date 2018-03-07
 */
@Data
public class SysMenuDeleteListVo extends BaseVo<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 菜单id集合
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> menuIds;

}