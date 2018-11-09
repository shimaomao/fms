package cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterVo
 * @Description: 诉讼登记信息删除时载体及验证
 */
@Data
public class LawsuitRegisterDeleteVo extends BaseVo<LawsuitRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 诉讼登记id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String lawsuitRegisterId;

}