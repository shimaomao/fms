package cn.com.leadu.fms.system.validator.sysmenuclicks.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksVo
 * @Description: 利率因子删除时载体及验证
 * @date 2018-05-03
 */
@Data
public class SysMenuClicksDeleteVo extends BaseVo<SysMenuClicks> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 常用菜单id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String menuClicksId;

}