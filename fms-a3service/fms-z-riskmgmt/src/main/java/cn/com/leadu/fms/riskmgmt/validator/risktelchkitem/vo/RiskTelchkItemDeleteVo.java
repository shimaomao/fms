package cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemVo
 * @Description: 风控电核项目表删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskTelchkItemDeleteVo extends BaseVo<RiskTelchkItem> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 风控电核项目id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String telchkItemId;

}