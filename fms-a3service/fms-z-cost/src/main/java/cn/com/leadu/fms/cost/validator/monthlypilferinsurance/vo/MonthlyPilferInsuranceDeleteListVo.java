package cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceVo
 * @Description: 盗抢险月结任务信息删除时载体及验证
 * @date 2018-05-31
 */
@Data
public class MonthlyPilferInsuranceDeleteListVo extends BaseVo<MonthlyPilferInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 盗抢险月结任务id
     * @author yangyiquan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> monthlyPilferInsuranceIds;

}