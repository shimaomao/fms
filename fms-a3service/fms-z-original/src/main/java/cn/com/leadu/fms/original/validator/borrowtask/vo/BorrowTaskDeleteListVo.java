package cn.com.leadu.fms.original.validator.borrowtask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskVo
 * @Description: 借阅任务信息删除时载体及验证
 * @date 2018-05-30
 */
@Data
public class BorrowTaskDeleteListVo extends BaseVo<BorrowTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 借阅任务id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> borrowTaskIds;

}