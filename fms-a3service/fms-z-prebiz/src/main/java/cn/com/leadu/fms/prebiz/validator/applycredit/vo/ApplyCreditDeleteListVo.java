package cn.com.leadu.fms.prebiz.validator.applycredit.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditVo
 * @Description: 征信信息删除时载体及验证
 * @date 2018-05-15
 */
@Data
public class ApplyCreditDeleteListVo extends BaseVo<ApplyCredit> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 征信信息ID
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> applyCreditIds;

}