package cn.com.leadu.fms.postbiz.validator.overduetelregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterVo
 * @Description: 电话催收登记信息删除时载体及验证
 * @date 2018-05-17
 */
@Data
public class OverdueTelRegisterDeleteListVo extends BaseVo<OverdueTelRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 电话催收登记ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueTelRegisterIds;

}