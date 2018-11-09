package cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskCompany;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: RiskCompanyVo
 * @Description: 企业风险信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskCompanyDeleteVo extends BaseVo<RiskCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业风险信息id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String riskCompanyId;

}