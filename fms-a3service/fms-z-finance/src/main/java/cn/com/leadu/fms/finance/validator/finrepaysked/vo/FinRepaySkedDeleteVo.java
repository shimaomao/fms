package cn.com.leadu.fms.finance.validator.finrepaysked.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedVo
 * @Description: 财务还款计划删除时载体及验证
 * @date 2018-05-12
 */
@Data
public class FinRepaySkedDeleteVo extends BaseVo<FinRepaySked> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 扣款ID
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String finRepaySkedId;

}