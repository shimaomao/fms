package cn.com.leadu.fms.asset.validator.equmorapply;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorApplyFinReceiptVo
 * @Description: 财务收款 vo
 * @date 2018/6/9
 */
@Data
public class EquMorApplyFinReceiptVo {

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "请输入备注")
    private String memo;

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @Size(min = 1,message = "请选择收款银行")
    @Valid
    private List<ContReceiptVo> contReceiptVos;

}
