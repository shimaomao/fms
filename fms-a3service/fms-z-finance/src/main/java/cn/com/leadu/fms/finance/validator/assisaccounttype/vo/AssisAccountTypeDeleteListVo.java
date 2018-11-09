package cn.com.leadu.fms.finance.validator.assisaccounttype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeVo
 * @Description: 辅助核算类型管理删除时载体及验证
 * @date 2018-06-23
 */
@Data
public class AssisAccountTypeDeleteListVo extends BaseVo<AssisAccountType> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 辅助核算类型id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> assisAccountTypeIds;

}