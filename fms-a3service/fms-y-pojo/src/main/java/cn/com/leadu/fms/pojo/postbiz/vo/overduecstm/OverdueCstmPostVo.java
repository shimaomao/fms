package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 逾期客户信息载体
 * @date 2018-05-16
 */
@Data
public class OverdueCstmPostVo extends PageQuery<OverdueCstm> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 主贷人证件号码
	 * @author lijunjun
	 */
	private String certifNo;

	/**
	 * @Fields  : 逾期客户电话信息ID
	 * @author lijunjun
	 */
	private String overdueCstmTelId;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 联系人
	 * @author lijunjun
	 */
	private String relationer;

	/**
	 * @Fields  : 联系人类型
	 * @author lijunjun
	 */
	private String relationType;

	/**
	 * @Fields  : 联系人电话号码
	 * @author lijunjun
	 */
	private String telNo;

	/**
	 * @Fields  : 电话备注
	 * @author lijunjun
	 */
	private String telMemo;

	/**
	 * @Fields  : 逾期状态
	 * @author lijunjun
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 逾期状态详情
	 * @author lijunjun
	 */
	private String overdueDetail;

	/**
	 * @Fields  : 风险等级
	 * @author lijunjun
	 */
	private String overdueRisk;

	/**
	 * @Fields  : 承诺还款日
	 * @author lijunjun
	 */
	private Date commitRepayDate;

	/**
	 * @Fields  : 处理状态
	 * @author lijunjun
	 */
	private String assignmentSts;

	/**
	 * @Fields  : 是否风险账户
	 * @author lijunjun
	 */
	private String riskFlag;

	/**
	 * @Fields  : 客户可联性
	 * @author lijunjun
	 */
	private String connectType;

	/**
	 * @Fields  : 工作稳定性
	 * @author lijunjun
	 */
	private String jobType;

	/**
	 * @Fields  : 收入类型
	 * @author lijunjun
	 */
	private String incomeType;

	/**
	 * @Fields  : 居住类型
	 * @author lijunjun
	 */
	private String resideType;

	/**
	 * @Fields  : 居住地真实性
	 * @author lijunjun
	 */
	private String addrValidType;

	/**
	 * @Fields  : 车辆适用情况
	 * @author lijunjun
	 */
	private String vehicleCondType;

	/**
	 * @Fields  : 担保人可联性
	 * @author lijunjun
	 */
	private String guaranteeConnType;

	/**
	 * @Fields  : 联系人可联性
	 * @author lijunjun
	 */
	private String contactConnType;

	/**
	 * @Fields  : 配偶可联性
	 * @author lijunjun
	 */
	private String mateConnType;

	/**
	 * @Fields  : 逾期客户地址信息
	 * @author lijunjun
	 */
	private List<OverdueCstmAddr> overdueCstmAddrList;

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
	 * 合同号
	 */
	private String contNo;

	/**
	 * 申请编号
	 */
	private String applyType;
}