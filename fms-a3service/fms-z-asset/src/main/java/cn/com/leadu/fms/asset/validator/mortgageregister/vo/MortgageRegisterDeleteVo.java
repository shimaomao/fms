package cn.com.leadu.fms.asset.validator.mortgageregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterVo
 * @Description: 解抵押过户信息删除时载体及验证
 * @date 2018-05-18
 */
@Data
public class MortgageRegisterDeleteVo extends BaseVo<MortgageRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 解除抵押ID
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String mortgageRegisterId;

}