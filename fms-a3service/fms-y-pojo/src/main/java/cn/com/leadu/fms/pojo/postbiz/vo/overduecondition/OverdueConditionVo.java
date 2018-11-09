package cn.com.leadu.fms.pojo.postbiz.vo.overduecondition;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionVo
 * @Description: 逾期状态维护载体
 * @date 2018-05-11
 */
@Data
public class OverdueConditionVo extends PageQuery<OverdueCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期状态ID
	 * @author yanfengbo
	 */
	private String overdueConditionId;

	/**
	 * @Fields  : 逾期状态代码
	 * @author yanfengbo
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 逾期状态名称
	 * @author yanfengbo
	 */
	private String overdueCondName;

	/**
	 * @Fields  : 逾期风险等级
	 * @author yanfengbo
	 */
	private String overdueRisk;

	/**
	 * @Fields  : 逾期状态详情代码
	 * @author yanfengbo
	 */
	private String overdueDetailType;

	/**
	 * @Fields  : 逾期状态备注
	 * @author yanfengbo
	 */
	private String overdueMeno;

	/**
	 * @Fields  : 是否启用标示
	 * @author yanfengbo
	 */
	private String enableFlag;

	/**
	 * @Fields  : 逾期状态ID
	 * @author yanfengbo
	 */
	private List<String> overdueConditionIds;

}