package cn.com.leadu.fms.pojo.postbiz.entity;

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
 * @author license_idx
 * @ClassName: LicenseIdx
 * @Description: 指标管理表实体
 */
@Data
public class LicenseIdx extends BaseEntity<LicenseIdx> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 指标管理id
	 * @author license_idx
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String licenseIdxId;

	/**
	 * @Fields  : 指标编号
	 * @author license_idx
	 */
	private String licenseIdxNo;

	/**
	 * @Fields  : 指标状态
	 * @author license_idx
	 */
	private String licenseIdxStatus;

	/**
	 * @Fields  : 指标失效日
	 * @author license_idx
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date idxInvalidDate;

	/**
	 * @Fields  : 指标有效天数
	 * @author license_idx
	 */
	private Integer idxValidDay;

	/**
	 * @Fields  : 指标所属分公司
	 * @author license_idx
	 */
	private String idxGroup;

	/**
	 * @Fields  : 指标使用人
	 * @author license_idx
	 */
	private String useCustomer;

	/**
	 * @Fields  : 使用人证件号
	 * @author license_idx
	 */
	private String useCertifNo;

	/**
	 * @Fields  : 使用人电话
	 * @author license_idx
	 */
	private String usePhoneNo;

	/**
	 * @Fields  : 指标预约日期
	 * @author license_idx
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date useAppointDate;

	/**
	 * @Fields  : 指标合同编号
	 * @author license_idx
	 */
	private String useContNo;

	/**
	 * @Fields  : 车牌号
	 * @author license_idx
	 */
	private String useLicenseNo;

	/**
	 * @Fields  : 历史车牌号
	 * @author license_idx
	 */
	private String licenseNoUsed;

	/**
	 * @Fields  : 指标续约开始日
	 * @author license_idx
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseStartDate;

	/**
	 * @Fields  : 指标续约结束日
	 * @author license_idx
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseEndDate;

	/**
	 * @Fields  : 备注
	 * @author license_idx
	 */
	private String idxMemo;

}