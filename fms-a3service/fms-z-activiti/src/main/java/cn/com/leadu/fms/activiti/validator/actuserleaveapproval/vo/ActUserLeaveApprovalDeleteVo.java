package cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalVo
 * @Description: 用户请假审批删除时载体及验证
 * @date 2018-03-20
 */
@Data
public class ActUserLeaveApprovalDeleteVo extends BaseVo<ActUserLeaveApproval> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 审批id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String approvalId;

}