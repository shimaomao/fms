package cn.com.leadu.fms.riskmgmt.validator.riskperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskPersonVo
 * @Description: 个人风险信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskPersonDeleteListVo extends BaseVo<RiskPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人风险信息id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> riskPersonIds;

}