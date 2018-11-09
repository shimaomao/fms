package cn.com.leadu.fms.cost.validator.contprepayment.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentVo
 * @Description: 提前还款删除时载体及验证
 * @date 2018-05-10
 */
@Data
public class ContPrepaymentDeleteListVo extends BaseVo<ContPrepayment> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 提前还款ID
     * @author yangyiquan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> contPrepaymentIds;

}