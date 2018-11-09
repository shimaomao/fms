package cn.com.leadu.fms.asset.validator.equmorapply;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyVo
 * @Description: 合同资方抵押申请载体
 * @date 2018-05-30
 */
@Data
public class EquMorOtherApplyVo extends PageQuery<EquMorTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方
	 * @author qiaomengnan
	 */
	@NotBlank(message = "资金方不能为空")
	private String management;

	/**
	 * @Fields  : 抵押流程
	 * @author qiaomengnan
	 */
	@NotBlank(message = "抵押流程不能为空")
	private String mortgageProcess;

	/**
	 * @Fields  : 合同号集合
	 * @author qiaomengnan
	 */
	@Size(min = 1 , message = "请选择需要申请的合同")
	private List<String> contNos;

	/**
	 * @Fields  : 资方抵押任务id
	 * @author qiaomengnan
	 */
	private String equMorTaskId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;


	/**
	 * @Fields  : 任务id
	 * @author qiaomengnan
	 */
	private String taskId;

	/**
	 * @Fields  : 工作流key
	 * @author qiaomengnan
	 */
	private String taskDefinitionKey;
	
	/** 
	 * @Fields  : 备注
	 * @author qiaomengnan
	 */ 
	private String memo;

}