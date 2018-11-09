package cn.com.leadu.fms.pojo.asset.vo.equmordetail;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailInfoUploadVo
 * @Description: 资方抵押归档
 * @date 2018/6/8
 */
@Data
public class EquMorArchiveVo {

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotNull(message = "请上传资料明细")
    @Size(min = 1 , message = "请上传资料明细")
    @Valid
    List<EquMorDetailArchiveVo> equMorDetailArchiveVos;

    @NotBlank(message = "请输入备注")
    private String memo;

}
