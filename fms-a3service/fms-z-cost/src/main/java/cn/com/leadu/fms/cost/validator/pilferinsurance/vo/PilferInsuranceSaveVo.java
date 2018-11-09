package cn.com.leadu.fms.cost.validator.pilferinsurance.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceVo
 * @Description: 盗抢险信息保存时载体及验证
 * @date 2018-05-31
 */
@Data
public class PilferInsuranceSaveVo extends BaseVo<PilferInsurance> {

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
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

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

}