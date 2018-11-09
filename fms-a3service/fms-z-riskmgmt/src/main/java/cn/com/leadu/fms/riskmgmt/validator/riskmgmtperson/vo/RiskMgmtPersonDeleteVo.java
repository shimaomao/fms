package cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonVo
 * @Description: 风控个人信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskMgmtPersonDeleteVo extends BaseVo<RiskMgmtPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 风控个人信息id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String riskMgmtPersonId;

}