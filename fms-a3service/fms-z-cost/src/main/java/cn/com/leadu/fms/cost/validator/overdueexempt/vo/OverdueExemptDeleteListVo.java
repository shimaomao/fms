package cn.com.leadu.fms.cost.validator.overdueexempt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptVo
 * @Description: 罚息免除任务表删除时载体及验证
 * @date 2018-05-30
 */
@Data
public class OverdueExemptDeleteListVo extends BaseVo<OverdueExempt> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 罚息免除任务id
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> overdueExemptIds;

}