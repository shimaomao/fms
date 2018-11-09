package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName:  EquMorChargeFinTouchingPrintVo
 * @Description: 资方抵押打印Vo
 * @date
 */
@Data
public class EquMorChargeFinTouchingPrintVo {

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    private String memo;

    private EquMorCharge equMorCharge;

    List<EquMorDetailVo> equMorDetailVos;

    private BasBankInfoVo basBankInfoVo;
}
