package cn.com.leadu.fms.asset.validator.equmorapply;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmortask.EquMorTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyVo
 * @Description: 合同资方抵押申请载体
 * @date 2018-05-30
 */
@Data
public class EquMorSeaWingApplyVo extends PageQuery<EquMorCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同编号
	 * @author qiaomengnan
	 */
	@NotBlank(message = "合同编号不能为空")
	private String contNo;

	/**
	 * @Fields  : 资方抵押任务
	 * @author qiaomengnan
	 */
	@NotNull(message = "资方抵押任务不能为空")
	@Valid
	private EquMorSeaWingTaskVo equMorTaskVo;

	/** 
	 * @Fields  : 资方抵押明细
	 * @author qiaomengnan
	 */
	@NotNull(message = "资方抵押明细不能为空")
	@Valid
	private EquMorSeaWingDetailVo equMorDetailVo;

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
	 * @Fields  : 还款日
	 * @author yanfengbo
	 */
	private String repayDay;

	/**
	 * @Fields  : 租金支付模式
	 * @author yanfengbo
	 */
	private String rentPayMode;

}