package cn.com.leadu.fms.riskmgmt.validator.riskperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: RiskPersonVo
 * @Description: 个人风险信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskPersonDeleteVo extends BaseVo<RiskPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人风险信息id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String riskPersonId;

}