package cn.com.leadu.fms.pojo.asset.vo.equmortask;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskVo
 * @Description: 资方抵押任务载体
 * @date 2018-05-30
 */
@Data
public class EquMorTaskVo extends PageQuery<EquMorTask> {

	private static final long serialVersionUID = 1L;

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
	 * @Fields  : 资方
	 * @author qiaomengnan
	 */
	private String management;

	/**
	 * @Fields  : 抵押流程
	 * @author qiaomengnan
	 */
	private String mortgageProcess;

	/**
	 * @Fields  : 抵押任务状态
	 * @author qiaomengnan
	 */
	private String mortgageServStatus;

	/**
	 * @Fields  : 资方抵押任务id
	 * @author qiaomengnan
	 */
	private List<String> equMorTaskIds;

	/**
	 * @Fields  : 子申请单详情
	 * @author qiaomengnan
	 */
	private List<EquMorApplyVo> equMorApplyVos;

}