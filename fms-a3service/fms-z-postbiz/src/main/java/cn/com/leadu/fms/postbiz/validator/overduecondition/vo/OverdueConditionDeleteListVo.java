package cn.com.leadu.fms.postbiz.validator.overduecondition.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionVo
 * @Description: 逾期状态维护删除时载体及验证
 * @date 2018-05-11
 */
@Data
public class OverdueConditionDeleteListVo extends BaseVo<OverdueCondition> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期状态ID
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueConditionIds;

}