package cn.com.leadu.fms.system.validator.sysuser.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: SysUserVo
 * @Description: 用户管理删除时载体及验证
 * @date 2018-03-22
 */
@Data
public class SysUserDeleteVo extends BaseVo<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 用户ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String userId;

}