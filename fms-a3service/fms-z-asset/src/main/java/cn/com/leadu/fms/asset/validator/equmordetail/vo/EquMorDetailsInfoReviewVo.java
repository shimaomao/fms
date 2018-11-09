package cn.com.leadu.fms.asset.validator.equmordetail.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailsInfoReviewVo
 * @Description: 资方抵押资料复核
 * @date 2018/6/8
 */
@Data
public class EquMorDetailsInfoReviewVo {

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "备注不能为空")
    private String memo;

}
