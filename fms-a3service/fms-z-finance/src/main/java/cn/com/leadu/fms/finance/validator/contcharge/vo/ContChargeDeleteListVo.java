package cn.com.leadu.fms.finance.validator.contcharge.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeVo
 * @Description: 财务待收款删除时载体及验证
 * @date 2018-06-01
 */
@Data
public class ContChargeDeleteListVo extends BaseVo<ContCharge> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务待收款id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> contChargeIds;

}