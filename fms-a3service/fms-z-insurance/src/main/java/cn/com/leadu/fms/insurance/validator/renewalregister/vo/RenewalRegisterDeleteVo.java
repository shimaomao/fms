package cn.com.leadu.fms.insurance.validator.renewalregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterVo
 * @Description: 续保任务一览删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class RenewalRegisterDeleteVo extends BaseVo<RenewalRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 续保任务ID
     * @author yanfengbo
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String renewalRegisterId;

}