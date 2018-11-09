package cn.com.leadu.fms.prebiz.validator.commonborrower.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerVo
 * @Description: 共同借款人删除时载体及验证
 * @date 2018-05-25
 */
@Data
public class CommonBorrowerDeleteListVo extends BaseVo<CommonBorrower> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 共同借款人ID
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> comBorrowerIds;

}