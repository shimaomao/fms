package cn.com.leadu.fms.original.validator.borrowbacktask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskVo
 * @Description: 借阅归还任务信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class BorrowBackTaskDeleteVo extends BaseVo<BorrowBackTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 借阅归还任务id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String borrowBackTaskId;

}