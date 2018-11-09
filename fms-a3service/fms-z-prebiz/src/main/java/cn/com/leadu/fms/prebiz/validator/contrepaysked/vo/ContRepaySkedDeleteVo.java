package cn.com.leadu.fms.prebiz.validator.contrepaysked.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: ContRepaySkedVo
 * @Description: 融资合同还款计划删除时载体及验证
 * @date 2018-05-08
 */
@Data
public class ContRepaySkedDeleteVo extends BaseVo<ContRepaySked> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 还款计划表ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String repaySkedId;

}