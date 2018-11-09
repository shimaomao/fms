package cn.com.leadu.fms.prebiz.validator.commonborrower.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerVo
 * @Description: 共同借款人删除时载体及验证
 * @date 2018-05-25
 */
@Data
public class CommonBorrowerDeleteVo extends BaseVo<CommonBorrower> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 共同借款人ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String comBorrowerId;

}