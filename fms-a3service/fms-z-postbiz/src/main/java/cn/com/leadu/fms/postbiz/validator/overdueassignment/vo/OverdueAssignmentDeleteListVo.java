package cn.com.leadu.fms.postbiz.validator.overdueassignment.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentVo
 * @Description: 当日逾期任务信息删除时载体及验证
 * @date 2018-05-16
 */
@Data
public class OverdueAssignmentDeleteListVo extends BaseVo<OverdueAssignment> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期任务ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueAssignmentIds;

}