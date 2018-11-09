package cn.com.leadu.fms.prebiz.validator.contrepaysked.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContRepaySkedVo
 * @Description: 融资合同还款计划删除时载体及验证
 * @date 2018-05-08
 */
@Data
public class ContRepaySkedDeleteListVo extends BaseVo<ContRepaySked> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 还款计划表ID
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> repaySkedIds;

}