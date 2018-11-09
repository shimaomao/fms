package cn.com.leadu.fms.activiti.validator.actuserleave.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveVo
 * @Description: 用户请假删除时载体及验证
 * @date 2018-03-14
 */
@Data
public class ActUserLeaveDeleteVo extends BaseVo<ActUserLeave> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 请假id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String leaveId;

}