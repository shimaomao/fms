package cn.com.leadu.fms.pojo.original.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetail
 * @Description: 借阅任务明细实体
 * @date 2018-07-16
 */
@Data
public class BorrowTaskDetail extends BaseEntity<BorrowTaskDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅任务明细id
	 * @author yebangqiang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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