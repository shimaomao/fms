package cn.com.leadu.fms.pojo.asset.vo.equreltask;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskVo
 * @Description: 资方解押任务载体
 * @date 2018-05-30
 */
@Data
public class EquRelTaskVo extends PageQuery<EquRelTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方解押任务id
	 * @author qiaomengnan
	 */
	private String equRelTaskId;

	/**
	 * @Fields  : 资方解押任务号
	 * @author qiaomengnan
	 */
	private String equRelTaskNo;

	/**
	 * @Fields  : 解押任务状态
	 * @author qiaomengnan
	 */
	private String reliefStatus;

	/**
	 * @Fields  : 审批人
	 * @author qiaomengnan
	 */
	private String presentUser;

	/**
	 * @Fields  : 差额
	 * @author qiaomengnan
	 */
	private BigDecimal differenceCharge;

	/**
	 * @Fields  : 资方解押任务id
	 * @author qiaomengnan
	 */
	private List<String> equRelTaskIds;

}