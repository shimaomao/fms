package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueCondition
 * @Description: 逾期状态维护实体
 * @date 2018-05-11
 */
@ExcelTitle(value = "逾期状态维护信息")
@Data
public class OverdueCondition extends BaseEntity<OverdueCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期状态ID
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	@ExcelTitle(value = "逾期状态代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getOverdueCondCd(){
		return this.overdueCondCd;
	}

	@ExcelTitle(value = "逾期状态名称", sort = 2)
	public String getOverdueCondName(){
		return this.overdueCondName;
	}

	@ExcelTitle(value = "逾期风险等级", sort = 3,codeType = CommonCodeTypeConstants.OVERDUE_RISK)
	public String getOverdueRisk(){
		return overdueRisk;
	}

	@ExcelTitle(value = "逾期状态详情代码", sort = 4)
	public String getOverdueDetailType(){
		return overdueDetailType;
	}

	@ExcelTitle(value = "逾期状态备注", sort = 5)
	public String getOverdueMeno(){
		return this.overdueMeno;
	}

	@ExcelTitle(value = "启用标志", sort = 6,codeType = CommonCodeTypeConstants.enableFlag)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 7)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 8)
	public String getUpdater(){
		return updater;
	}

}