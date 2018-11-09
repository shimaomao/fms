package cn.com.leadu.fms.system.validator.sysuserinfo.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoVo
 * @Description: 消息用户操作管理删除时载体及验证
 * @date 2018-04-25
 */
@Data
public class SysUserInfoDeleteVo extends BaseVo<SysUserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 消息用户操作id
     * @author qiaomengnan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String userInfoId;

}