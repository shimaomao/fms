package cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee;

import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeVchVo
 * @Description: 凭证信息
 * @date 2018/7/17
 */
@Data
public class KingDeeVchVo {

    /**
     * @Fields  :  凭证字
     * @author qiaomengnan
     */
    @JsonProperty("VchGroup")
    @NotBlank(message = "凭证字不能为空")
    private String vchGroup;

    /**
     * @Fields  : 凭证号：根据系统设置是否允许修改凭证号，不允许修改时，传入凭证号时失效，系统自动生成凭证号
     * @author qiaomengnan
     */
    @JsonProperty("VchNum")
    @NotBlank(message = "凭证号不能为空")
    private String vchNum;

    /**
     * @Fields  : 凭证明细类对象数组
     * @author qiaomengnan
     */
    @JsonProperty("VouchEntry")
    @NotNull(message = "凭证明细类对象数组不能为空")
    @Size(min = 1, message = "凭证明细类对象数组不能为空")
    @Valid
    private List<KingDeeVchEntryVo> vouchEntry;

    /**
     * @Fields  : 凭证日期
     * @author qiaomengnan
     */
    @JsonProperty("VchDate")
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    @NotNull(message = "凭证日期不能为空")
    private Date vchDate;

    /**
     * @Fields  : 凭证附件数
     * @author qiaomengnan
     */
    @JsonProperty("VchAttachment")
    @NotBlank(message = "凭证附件数不能为空")
    private String vchAttachment;

    /**
     * @Fields  : 业务日期，未传入则取凭证日期
     * @author qiaomengnan
     */
    @JsonProperty("VchTranDate")
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    @NotNull(message = "业务日期不能为空")
    private Date vchTranDate;

}
