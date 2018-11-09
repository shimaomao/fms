package cn.com.leadu.fms.pojo.cost.vo.overdueexempt;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptVo
 * @Description: 罚息免除任务表载体
 * @date 2018-05-30
 */
@Data
public class OverdueExemptVo extends PageQuery<OverdueExempt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 罚息免除任务id
	 * @author yanfengbo
	 */
	private String overdueExemptId;

	/**
	 * @Fields  : 罚息免除任务号
	 * @author yanfengbo
	 */
	private String overdueExemptNo;

	/**
	 * @Fields  : 罚息免除任务状态
	 * @author yanfengbo
	 */
	private String overdueExemptStatus;

	/**
	 * @Fields  : 罚息免除任务id
	 * @author yanfengbo
	 */
	private List<String> overdueExemptIds;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 用于罚息免除上部页面回显的vo
	 * @author yanfengbo
	 */
	private ContOverdueOneVo contOverdueOneVo;

	/**
	 * @Fields  : 逾期罚息表集合
	 */
	private List<ContOverdueVo> contOverdueVoList;

	/**
	 * @Fields  : TaskId
	 */
	private String taskId;

	/**
	 * @Fields  : 操作分类
	 */
	private String actType;

	/**
	 * @Fields  : 备注
	 */
	private String remark1;

	/**
	 * @Fields  : serviceId
	 */
	private String serviceId;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

	/**
	 * @Fields  : 承租人
	 */
	private String cstmName;

	/**
	 * @Fields  :出租人
	 */
	private String groupName;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 申请时间
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date overdueDate;

	/**
	 * @Fields  : 申请免除金额(罚息免除一览展示用)
	 * @author yanfengbo
	 */
	private BigDecimal applyExemptAmount;
}