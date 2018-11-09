package cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterVo
 * @Description: 诉讼登记信息删除时载体及验证
 */
@Data
public class LawsuitRegisterDeleteListVo extends BaseVo<LawsuitRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 诉讼登记id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> lawsuitRegisterIds;

}