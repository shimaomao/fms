package cn.com.leadu.fms.insurance.validator.continsurclaim.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimVo
 * @Description: 保险理赔删除时载体及验证
 * @date 2018-05-14
 */
@Data
public class ContInsurClaimDeleteVo extends BaseVo<ContInsurClaim> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 保险理赔ID
     * @author yanfengbo
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contInsurClaimId;

}