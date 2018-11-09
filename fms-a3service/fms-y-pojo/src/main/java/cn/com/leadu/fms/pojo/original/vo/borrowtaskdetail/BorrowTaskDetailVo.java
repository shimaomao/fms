package cn.com.leadu.fms.pojo.original.vo.borrowtaskdetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailVo
 * @Description: 借阅任务明细载体
 * @date 2018-07-16
 */
@Data
public class BorrowTaskDetailVo extends PageQuery<BorrowTaskDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅任务明细id
	 * @author yebangqiang
	 */
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

	/**
	 * @Fields  : 借阅任务明细id
	 * @author yebangqiang
	 */
	private List<String> borrowTaskDetailIds;

}