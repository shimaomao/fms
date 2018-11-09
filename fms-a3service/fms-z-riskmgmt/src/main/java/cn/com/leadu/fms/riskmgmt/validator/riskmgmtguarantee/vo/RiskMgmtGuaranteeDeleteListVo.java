package cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeVo
 * @Description: 风控担保人信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskMgmtGuaranteeDeleteListVo extends BaseVo<RiskMgmtGuarantee> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 风控企业信息id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> riskMgmtGuaranteeIds;

}