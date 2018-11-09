package cn.com.leadu.fms.finance.validator.finbackfill.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillVo
 * @Description: 融资回填删除时载体及验证
 * @date 2018-05-11
 */
@Data
public class FinBackfillDeleteListVo extends BaseVo<FinBackfill> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 融资回填ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> filBackfillIds;

}