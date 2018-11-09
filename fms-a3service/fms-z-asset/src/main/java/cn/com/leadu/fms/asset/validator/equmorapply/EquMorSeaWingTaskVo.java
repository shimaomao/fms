package cn.com.leadu.fms.asset.validator.equmorapply;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskVo
 * @Description: 资方抵押任务载体
 * @date 2018-05-30
 */
@Data
public class EquMorSeaWingTaskVo extends PageQuery<EquMorTask> {

	private static final long serialVersionUID = 1L;

	private String equMorTaskId;

	/**
	 * @Fields  : 资方
	 * @author qiaomengnan
	 */
	private String management;

	/**
	 * @Fields  : 抵押流程
	 * @author qiaomengnan
	 */
	@NotBlank(message = "抵押流程不能为空")
	private String mortgageProcess;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author yanfengbo
	 */
	private String equMorTaskNo;

}