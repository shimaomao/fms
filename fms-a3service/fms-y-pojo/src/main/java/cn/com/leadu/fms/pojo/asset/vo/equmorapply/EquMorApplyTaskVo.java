package cn.com.leadu.fms.pojo.asset.vo.equmorapply;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: EquMorApplyTaskVo
 * @Description: 抵押申请退回上一级载体
 * @date 2018/6/9
 */
@Data
public class EquMorApplyTaskVo {

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "备注不能为空")
    private String memo;


}
