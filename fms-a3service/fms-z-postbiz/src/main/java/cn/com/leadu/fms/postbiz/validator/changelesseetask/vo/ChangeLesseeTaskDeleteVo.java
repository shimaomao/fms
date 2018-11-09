package cn.com.leadu.fms.postbiz.validator.changelesseetask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskVo
 * @Description: 承租人变更删除时载体及验证
 */
@Data
public class ChangeLesseeTaskDeleteVo extends BaseVo<ChangeLesseeTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 变更任务id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String taskId;

}