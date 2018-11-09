package cn.com.leadu.fms.pojo.prebiz.vo.contract;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVo
 * @Description: 合同信息载体
 * @date 2018-03-23
 */
@Data
public class ContractVo extends PageQuery<Contract> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同ID
	 */
	private String contractId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 合同状态
	 */
	private String bizStatus;

	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 订单提出账号
	 */
	private String applyUser;

	/**
	 * @Fields  : 订单提出机构代码
	 */
	private String applyGroup;

	/**
	 * @Fields  : 当前节点账号
	 */
	private String presentUser;

	/**
	 * @Fields  : 收款机构代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 出租人
	 */
	private String groupName;

	/**
	 * @Fields  : 收款机构银行序号
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 颜色
	 */
	private String color;

	/**
	 * @Fields  : 车架号
	 */
	private String vinNo;

	/**
	 * @Fields  : 车架号（画面录入）
	 */
	private String newVinNo;

	/**
	 * @Fields  : 发动机号
	 */
	private String engineNo;

	/**
	 * @Fields  : 发动机号（画面录入）
	 */
	private String newEngineNo;

	/**
	 * @Fields  : 车辆配置描述
	 */
	private String vehicleComment;

	/**
	 * @Fields  : 车牌号
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : GPS-SIM卡号
	 */
	private String gpsNo;

	/**
	 * @Fields  : 放款模式
	 */
	private String loanMode;

	/**
	 * @Fields  : 合同邮寄ID
	 */
	private String filePostId;

	/**
	 * @Fields  : 创建日期
	 */
	private Date creatDate;

	/**
	 * @Fields  : 审核通过日期
	 */
	private Date passDate;

	/**
	 * @Fields  : 生成合同日期
	 */
	private Date contractDate;

	/**
	 * @Fields  : 合同打印日期
	 */
	private Date contractPrintDate;

	/**
	 * @Fields  : 合同请款日期
	 */
	private Date contractRequestDate;

	/**
	 * @Fields  : 合同生效日期
	 */
	private Date contractValidDate;

	/**
	 * @Fields  : 车辆行驶证注册日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date vehicleDrivingLicenseRegisterDate;

	/**
	 * @Fields  : 归档车辆类型
	 */
	private String vehicleTypeOrig;

	/**
	 * @Fields  : 合同ID
	 */
	private List<String> contractIds;
	/**
	 * @Fields  : 合同模板类型
	 */
	private String contractFileType;

	/**
	 * @Fields  : 申请人财务核算代码
	 * @author qiaomengnan
	 */
	private String finassCstmCode;

	/**
	 * @Fields  : 申请人姓名
	 * @author yangyiquan
	 */
	private String applyPersonName;

	/**
	 * @Fields  : 出租人财务核算代码
	 * @author qiaomengnan
	 */
	private String finassGroupCode;

	/**
	 * @Fields  : 实际销售方财务核算代码
	 * @author qiaomengnan
	 */
	private String finassSalesCode;

	/**
	 * @Fields  : 个人申请类型
	 * @author qiaomengnan
	 */
	private String applyTypePerson;

	/**
	 * @Fields  : 是否收首期租金
	 */
	private String  chargeFirstRent;

	/**
	 * @Fields  : 牌照属性
	 */
	private String  licenseAttr;

	/**
	 * @Fields  : 区域
	 */
	private String  groupDistrict;

	/**
	 * @Fields  : 是否展期
	 */
	private String  isDefer;

}