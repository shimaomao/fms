package cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceVo
 * @Description: 盗抢险月结任务信息载体
 * @date 2018-05-31
 */
@Data
public class MonthlyPilferInsuranceVo extends PageQuery<MonthlyPilferInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 盗抢险月结任务id
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceId;

	/**
	 * @Fields  : 盗抢险月结任务号
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceNo;

	/**
	 * @Fields  : 月结状态
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceSts;

	/**
	 * @Fields  : 合计金额
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
	 * @Fields  : 盗抢险月结任务id
	 * @author yangyiquan
	 */
	private List<String> monthlyPilferInsuranceIds;

	/**
	 * @Feilds : 盗抢险信息明细数据
	 */
	private List<PilferInsurance> pilferInsurances;

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