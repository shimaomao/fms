package cn.com.leadu.fms.pojo.asset.vo.equmorapply;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: EquMorApplyApproveVo
 * @Description: 抵押审批vo
 * @date 2018/6/12
 */
@Data
public class EquMorApplyApproveVo {

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "备注不能为空")
    private String memo;

}
