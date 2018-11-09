package cn.com.leadu.fms.original.validator.borrowtaskdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailVo
 * @Description: 借阅任务明细删除时载体及验证
 * @date 2018-07-16
 */
@Data
public class BorrowTaskDetailDeleteListVo extends BaseVo<BorrowTaskDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 借阅任务明细id
     * @author yebangqiang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> borrowTaskDetailIds;

}