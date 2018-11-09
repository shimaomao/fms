package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepay.EquMorRepayVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeImportVo
 * @Description: 抵押费用导入vo
 * @date 2018/6/6
 */
@Data
public class EquMorChargeImportVo {

    /**
     * @Fields  : 资方抵押任务号
     * @author qiaomengnan
     */
    @NotBlank(message = "资方抵押任务号不能为空")
    private String equMorTaskNo;

    @NotBlank(message = ValidatorConstants.TASK_ID_NOT_NULL)
    private String taskId;

    @NotBlank(message = ValidatorConstants.TASK_DEFINITION_KEY_NOT_NULL)
    private String taskDefinitionKey;

    @NotNull(message = "请选择收款银行")
    @Valid
    private BasBankInfoVo basBankInfoVo;

    @NotNull(message = "请导入付款信息")
    @Size(min = 1 ,message = "请导入付款信息")
    @Valid
    private List<EquMorChargeVo> equMorChargeVos;

    @NotNull(message = "请导入客户还款计划信息")
    @Size(min = 1 ,message = "请导入客户还款计划信息")
    @Valid
    private List<EquMorRepayVo> equMorRepayVos;

    @NotBlank(message = "请输入备注")
    private String memo;

    /**
     * @Fields  : 费用信息
     * @author qiaomengnan
     */
    private List<EquMorCharge> equMorCharges;

    /**
     * @Fields  : 客户还款计划表
     * @author qiaomengnan
     */
    private List<EquMorRepay> equMorRepays;

    /**
     * @Fields  : 客户附件信息
     * @author qiaomengnan
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 抵押费用附件信息
     * @author qiaomengnan
     */
    private List<BizFiles> equMorChargeFileList;



}
