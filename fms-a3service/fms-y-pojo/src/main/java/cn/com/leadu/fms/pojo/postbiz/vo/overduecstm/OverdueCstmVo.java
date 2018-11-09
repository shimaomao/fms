package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 逾期客户信息载体
 * @date 2018-05-16
 */
@Data
public class OverdueCstmVo extends PageQuery<OverdueCstm> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 出租人
	 * @author lijunjun
	 */
	private String groupName;

	/**
	 * @Fields  : 已还期数
	 * @author lijunjun
	 */
	private Integer repayPeriods;

	/**
	 * @Fields  : 证件类型
	 * @author lijunjun
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号码
	 * @author lijunjun
	 */
	private String certifNo;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 性别
	 * @author lijunjun
	 */
	private String sex;

	/**
	 * @Fields  : 初登日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date firstOverdueDate;

	/**
	 * @Fields  : 当前逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDays;

	/**
	 * @Fields  : 当前逾期期数
	 * @author lijunjun
	 */
	private Integer overduePeriods;

	/**
	 * @Fields  : 当前逾期本金
	 * @author lijunjun
	 */
	private BigDecimal overduePrincipal;

	/**
	 * @Fields  : 当前逾期租金
	 * @author lijunjun
	 */
	private BigDecimal overdueRent;

	/**
	 * @Fields  : 当前逾期罚息
	 * @author lijunjun
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 当前逾期总额
	 * @author lijunjun
	 */
	private BigDecimal overdueSum;

	/**
	 * @Fields  : 当前销售未还剩余本金
	 * @author lijunjun
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 当前财务未还剩余本金
	 * @author lijunjun
	 */
	private BigDecimal finRestPrincipal;

	/**
	 * @Fields  : 历史最高逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDaysHis;

	/**
	 * @Fields  : 当前是否逾期
	 * @author lijunjun
	 */
	private String overdueFlag;

	/**
	 * @Fields  : 当前逾期状态
	 * @author lijunjun
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 当前逾期详情
	 * @author lijunjun
	 */
	private String overdueDetail;

	/**
	 * @Fields  : 当前风险等级
	 * @author lijunjun
	 */
	private String overdueRisk;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private List<String> overdueCstmIds;

	/**
	 * @Fields  : 催收类型
	 * @author lijunjun
	 */
	private String assignmentType;

	/**
	 * @Fields  : 分配人员账号
	 * @author lijunjun
	 */
	private String assignUser;

	/**
	 * @Fields  : 任务处理状态
	 * @author lijunjun
	 */
	private String assignmentSts;

	/**
	 * @Fields  : 合同签订日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractDate;

	/**
	 * @Fields  : 合同生效日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;

	/**
	 * @Fields  : 逾期合同信息List
	 * @author lijunjun
	 */
	private List<OverdueContVo> overdueContVoList;

	/**
	 * @Fields  : 逾期客户电话信息List
	 * @author lijunjun
	 */
	private List<OverdueCstmTel> overdueCstmTelList;

	/**
	 * @Fields  : 电话催收登记信息List
	 * @author lijunjun
	 */
	private List<OverdueTelRegisterVo> overdueTelRegisterVoList;

	/**
	 * @Fields  : 合同编号List
	 * @author lijunjun
	 */
	private List<String> contNoList;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

	/**
	 * @Fields  : 查看区分
	 * @author lijunjun
	 */
	private String searchFlag;

	/**
	 * @Fields  : 上门催收List
	 * @author lijunjun
	 */
	private List<CollectionTaskVo> collectionTaskVoList;

	/**
	 * @Fields  : 收车信息List
	 * @author lijunjun
	 */
	private List<RetrieveCarsTaskVo> retrieveCarsTaskVoList;

	/**
	 * @Fields  : 诉讼信息List
	 * @author lijunjun
	 */
	private List<LawsuitTaskVo> lawsuitTaskVoList;

	/**
	 * @Fields  : 客户逾期天数起始天数
	 * @author lijunjun
	 */
	private Integer cstmOverdueStartDays;

	/**
	 * @Fields  : 客户逾期天数结束天数
	 * @author lijunjun
	 */
	private Integer cstmOverdueEndDays;

	/**
	 * @Fields  : 合同逾期天数起始天数
	 * @author lijunjun
	 */
	private Integer contOverdueStartDays;

	/**
	 * @Fields  : 合同逾期天数结束天数
	 * @author lijunjun
	 */
	private Integer contOverdueEndDays;

}