package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author license_idx
 * @ClassName: LicenseIdxVo
 * @Description: 指标管理表载体
 */
@Data
public class LicenseIdxVo extends PageQuery<LicenseIdx> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 指标管理id
	 * @author license_idx
	 */
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

	/**
	 * @Fields  : 指标管理id
	 * @author license_idx
	 */
	private List<String> licenseIdxIds;

	/**
	 * @Fields  : 分公司
	 * @author group_name
	 */
	private String groupName;

	/**
	 * @Fields  : 区域
	 * @author group_district
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 租赁期限开始日
	 * @author lease_term_start_date
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermStartDate;

	/**
	 * @Fields  : 租赁期限结束日
	 * @author lease_term_end_date
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermEndDate;

	/**
	 * @Fields  : 合同状态
	 * @author biz_status
	 */
	private String bizStatus;
	/**
	 * @Fields  : 还款状态
	 * @author payment_sts
	 */
	private String paymentSts;
	/**
	 * @Fields  : 用户代码
	 * @author syspambelongroup
	 */
	private String syspambelongroup;

	/**
	 * @Fields  : 附件信息
	 * @author fangshaofeng
	 */
	private List<BizFiles> bizFilesList;

}