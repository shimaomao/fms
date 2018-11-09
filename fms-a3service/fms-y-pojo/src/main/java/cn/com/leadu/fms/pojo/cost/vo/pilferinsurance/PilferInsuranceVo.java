package cn.com.leadu.fms.pojo.cost.vo.pilferinsurance;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceVo
 * @Description: 盗抢险信息载体
 * @date 2018-05-31
 */
@Data
public class PilferInsuranceVo extends PageQuery<PilferInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 盗抢险信息id
	 * @author yangyiquan
	 */
	private String pilferInsuranceId;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : gps厂商
	 * @author yangyiquan
	 */
	private String gpsSeller;

	/**
	 * @Fields  : 第一受益人
	 * @author yangyiquan
	 */
	private String firstBeneficiary;

	/**
	 * @Fields  : 有线设备号
	 * @author yangyiquan
	 */
	private String wiredDeviceNo;

	/**
	 * @Fields  : 无线设备号
	 * @author yangyiquan
	 */
	private String wirelessDeviceNo;

	/**
	 * @Fields  : 新车购置价
	 * @author yangyiquan
	 */
	private BigDecimal purchasePrice;

	/**
	 * @Fields  : 最高赔偿限额
	 * @author yangyiquan
	 */
	private BigDecimal maximumCompensation;

	/**
	 * @Fields  : 盗抢险费用
	 * @author yangyiquan
	 */
	private BigDecimal pilferInsuranceCost;

	/**
	 * @Fields  : 年限
	 * @author yangyiquan
	 */
	private Integer timeLimit;

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
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 账单盗抢险费用
	 * @author yangyiquan
	 */
	private BigDecimal billPilferInsuranceCost;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 盗抢险信息id
	 * @author yangyiquan
	 */
	private List<String> pilferInsuranceIds;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 出租人
	 * @author yangyiquan
	 */
	private String rentPerson;

	/**
	 * @Fields  : 承租人
	 * @author yangyiquan
	 */
	private String lessee;

	/**
	 * @Fields  : 车架号
	 * @author yangyiquan
	 */
	private String vinNo;

	/**
	 * @Fields  : 个人标志
	 */
	private String personFlag;

	/**
	 * @Fields  : 合同id
	 * @author yanfengbo
	 */
	private String contractId;

	/**
	 * @Fields  : 订单编号
	 * @author yanfengbo
	 */
	private String applyNo;

	/**
	 * @Fields  : 客户类型
	 * @author yanfengbo
	 */
	private String applyType;

	/**
	 * @Fields  : 业务类型
	 * @author yanfengbo
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 业务经理(录单人)
	 * @author yanfengbo
	 */
	private String applyUser;

	/**
	 * @Fields  : 放款日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date contractValidDate;

	/**
	 * @Fields  : 品牌
	 * @author yanfengbo
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 车型
	 * @author yanfengbo
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 实际销售方代码
	 * @author yanfengbo
	 */
	private String saleGroupCode;

	/**
	 * @Fields  : 实际销售方
	 * @author yanfengbo
	 */
	private String salesName;

	/**
	 * @Fields  : 盗抢险投保渠道
	 * @author yanfengbo
	 */
	private String theftInsuranceType;

	/**
	 * @Fields  : 合同状态
	 * @author yanfengbo
	 */
	private String bizStatus;

	/**
	 * @Fields  : 申请类型  个人
	 * @author yanfengbo
	 */
	private String applyTypePerson;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 发动机号
	 * @author yanfengbo
	 */
	private String engineNo;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 账单月
	 * @author ningyangyang
	 */
	private String billMonth;

	/**
	 * @Fields  : 是否融盗抢险
	 * @author yanfengbo
	 */
	private String theftInsuranceFlag;

	/**
	 * @Fields  : 安装状态
	 * @author yanfengbo
	 */
	private String installStatus;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 预计安装时间
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date expectInstallDate;


	/**
	 * @Fields  : 搜索用预计安装起始时间
	 * @author yanfengbo
	 */
	private String expectInstallStartDateStr;

	/**
	 * @Fields  : 搜索用预计安装结束时间
	 * @author yanfengbo
	 */
	private String expectInstallEndDateStr;

}