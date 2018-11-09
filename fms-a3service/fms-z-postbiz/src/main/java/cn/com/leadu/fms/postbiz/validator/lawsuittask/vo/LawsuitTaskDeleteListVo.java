package cn.com.leadu.fms.postbiz.validator.lawsuittask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskVo
 * @Description: 诉讼任务信息删除时载体及验证
 */
@Data
public class LawsuitTaskDeleteListVo extends BaseVo<LawsuitTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 诉讼任务id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> lawsuitTaskIds;

}