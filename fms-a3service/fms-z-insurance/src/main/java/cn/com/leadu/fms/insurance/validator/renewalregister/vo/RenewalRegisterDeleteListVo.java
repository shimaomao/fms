package cn.com.leadu.fms.insurance.validator.renewalregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterVo
 * @Description: 续保任务一览删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RenewalRegisterDeleteListVo extends BaseVo<RenewalRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 续保任务ID
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> renewalRegisterIds;

}