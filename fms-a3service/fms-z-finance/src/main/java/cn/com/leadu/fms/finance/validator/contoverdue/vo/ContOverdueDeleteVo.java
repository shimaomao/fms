package cn.com.leadu.fms.finance.validator.contoverdue.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: ContOverdueVo
 * @Description: 还款逾期罚息删除时载体及验证
 * @date 2018-05-08
 */
@Data
public class ContOverdueDeleteVo extends BaseVo<ContOverdue> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期罚息Id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contOverdueId;

}