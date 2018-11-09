package cn.com.leadu.fms.postbiz.validator.lawsuittask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskVo
 * @Description: 诉讼任务信息删除时载体及验证
 */
@Data
public class LawsuitTaskDeleteVo extends BaseVo<LawsuitTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 诉讼任务id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String lawsuitTaskId;

}