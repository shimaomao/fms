package cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceVo
 * @Description: 盗抢险月结任务信息删除时载体及验证
 * @date 2018-05-31
 */
@Data
public class MonthlyPilferInsuranceDeleteVo extends BaseVo<MonthlyPilferInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 盗抢险月结任务id
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String monthlyPilferInsuranceId;

}