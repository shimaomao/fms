package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinanceTouchingVo
 * @Description: 财务制单
 * @date 2018/6/8
 */
@Data
public class EquMorChargeFinTouchingVo {

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = "请输入备注")
    private String memo;

    private EquMorCharge equMorCharge;

    List<EquMorDetailVo> equMorDetailVos;

    @NotNull(message = "请选择付款银行")
    @Valid
    private BasBankInfoVo basBankInfoVo;

}
