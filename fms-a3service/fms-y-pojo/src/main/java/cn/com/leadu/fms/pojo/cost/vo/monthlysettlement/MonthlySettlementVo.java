package cn.com.leadu.fms.pojo.cost.vo.monthlysettlement;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementVo
 * @Description: gps月结任务表载体
 * @date 2018-05-28
 */
@Data
public class MonthlySettlementVo extends PageQuery<MonthlySettlement> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : gps月结任务id
	 * @author yangyiquan
	 */
	private String monthlySettlementId;

	/**
	 * @Fields  : gps月结任务号
	 * @author yangyiquan
	 */
	private String monthlySettlementNo;

	/**
	 * @Fields  : 月结状态
	 * @author yangyiquan
	 */
	private String monthlySts;

	/**
	 * @Fields  : 月结合计金额
	 * @author yangyiquan
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 收款银行
	 * @author yangyiquan
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款银行
	 * @author yangyiquan
	 */
	private String recAccBranch;
	/**
	 * @Fields  : 收款银行账户名
	 * @author yangyiquan
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款银行账号
	 * @author yangyiquan
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款联行号
	 * @author yangyiquan
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : gps月结任务id
	 * @author yangyiquan
	 */
	private List<String> monthlySettlementIds;

	/**
	 * @Feilds : gps月结明细数据
	 */
	private List<GpsDispatch> gpsDispatches;

	/**
	 * @Fields  : 当前任务id
	 * @author yangyiquan
	 */
	private String taskId;

	/**
	 * @Fields  : 附件信息
	 * @author yanfengbo
	 */
	private List<BizFiles> bizFilesList;

}