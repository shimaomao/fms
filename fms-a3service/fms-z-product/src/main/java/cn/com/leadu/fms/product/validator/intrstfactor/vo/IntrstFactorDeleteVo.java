package cn.com.leadu.fms.product.validator.intrstfactor.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorVo
 * @Description: 利率因子删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class IntrstFactorDeleteVo extends BaseVo<IntrstFactor> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 利率因子ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String intrstFactorId;

}