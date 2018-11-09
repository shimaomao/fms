package cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeVchEntryVo
 * @Description: 凭证明细信息
 * @date 2018/7/17
 */
@Data
public class KingDeeVchEntryVo {

    /** 
     * @Fields  : 科目代码
     * @author qiaomengnan
     */
    @JsonProperty("AcctID")
    @NotBlank(message = "科目代码不能为空")
    private String acctID;

    /**
     * @Fields  : 摘要（凭证的第一条科目必填）
     * @author qiaomengnan
     */
    @JsonProperty("VchExp")
    @NotBlank(message = "摘要不能为空")
    private String vchExp;

    /**
     * @Fields  : 借方金额
     * @author qiaomengnan
     */
    @JsonProperty("VchDebit")
    @NotNull(message = "借方金额不能为空")
    private BigDecimal vchDebit;

    /**
     * @Fields  : 贷方金额
     * @author qiaomengnan
     */
    @JsonProperty("VchCredit")
    @NotNull(message = "贷方金额不能为空")
    private BigDecimal vchCredit;

    /**
     * @Fields  : 核算项目ID：如果科目有多个核算项目，则核算项目ID用逗号隔开传入/例如：212/552
     * @author qiaomengnan
     */
    @JsonProperty("ItemID")
    @NotBlank(message = "核算项目ID不能为空")
    private String itemID;

}
