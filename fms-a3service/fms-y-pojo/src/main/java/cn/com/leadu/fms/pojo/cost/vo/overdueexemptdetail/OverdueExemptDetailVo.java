package cn.com.leadu.fms.pojo.cost.vo.overdueexemptdetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExemptDetail;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptDetailVo
 * @Description: 罚息免除任务明细表载体
 * @date 2018-05-30
 */
@Data
public class OverdueExemptDetailVo extends PageQuery<OverdueExemptDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 罚息免除任务明细表id
	 * @author yanfengbo
	 */
	private String overdueExemptDetailId;

	/**
	 * @Fields  : 罚息免除任务号
	 * @author yanfengbo
	 */
	private String overdueExemptNo;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 期数
	 * @author yanfengbo
	 */
	private Integer periods;

	/**
	 * @Fields  : 免除金额
	 * @author yanfengbo
	 */
	private BigDecimal manualExemptAmount;

	/**
	 * @Fields  : 罚息免除任务明细表id
	 * @author yanfengbo
	 */
	private List<String> overdueExemptDetailIds;

	/**
	 * @Fields  : 罚息免除任务明细状态
	 * @author yanfengbo
	 */
	private String overdueExemptDetailStatus;

}