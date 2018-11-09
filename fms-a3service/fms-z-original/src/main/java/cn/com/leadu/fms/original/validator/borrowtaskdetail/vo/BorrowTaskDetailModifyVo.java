package cn.com.leadu.fms.original.validator.borrowtaskdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailVo
 * @Description: 借阅任务明细修改时载体及验证
 * @date 2018-07-16
 */
@Data
public class BorrowTaskDetailModifyVo extends BaseVo<BorrowTaskDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅任务明细id
	 * @author yebangqiang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String borrowTaskDetailId;

	/**
	 * @Fields  : 借阅任务号
	 * @author yebangqiang
	 */
	private String borrowTaskNo;

	/**
	 * @Fields  : 归还任务号
	 * @author yebangqiang
	 */
	private String borrowBackTaskNo;

	/**
	 * @Fields  : 资料ID
	 * @author yebangqiang
	 */
	private String origFileDetailId;

}