package cn.com.leadu.fms.cost.validator.pilferinsurance.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceVo
 * @Description: 盗抢险信息删除时载体及验证
 * @date 2018-05-31
 */
@Data
public class PilferInsuranceDeleteListVo extends BaseVo<PilferInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 盗抢险信息id
     * @author yangyiquan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> pilferInsuranceIds;

}