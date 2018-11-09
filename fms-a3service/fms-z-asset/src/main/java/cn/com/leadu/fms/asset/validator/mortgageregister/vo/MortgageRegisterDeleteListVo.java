package cn.com.leadu.fms.asset.validator.mortgageregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterVo
 * @Description: 解抵押过户信息删除时载体及验证
 * @date 2018-05-18
 */
@Data
public class MortgageRegisterDeleteListVo extends BaseVo<MortgageRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 解除抵押ID
     * @author yangyiquan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> mortgageRegisterIds;

}