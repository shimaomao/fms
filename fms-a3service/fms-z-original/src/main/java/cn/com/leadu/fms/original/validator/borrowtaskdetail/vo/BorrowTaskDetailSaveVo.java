package cn.com.leadu.fms.original.validator.borrowtaskdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import lombok.Data;
import java.util.Date;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailVo
 * @Description: 借阅任务明细保存时载体及验证
 * @date 2018-07-16
 */
@Data
public class BorrowTaskDetailSaveVo extends BaseVo<BorrowTaskDetail> {

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

}