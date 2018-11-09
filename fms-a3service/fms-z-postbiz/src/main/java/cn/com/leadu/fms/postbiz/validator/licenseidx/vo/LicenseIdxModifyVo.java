package cn.com.leadu.fms.postbiz.validator.licenseidx.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author license_idx
 * @ClassName: LicenseIdxVo
 * @Description: 指标管理表修改时载体及验证
 */
@Data
public class LicenseIdxModifyVo extends BaseVo<LicenseIdx> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 指标管理id
	 * @author license_idx
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	private Date leaseStartDate;

	/**
	 * @Fields  : 指标续约结束日
	 * @author license_idx
	 */
	private Date leaseEndDate;

	/**
	 * @Fields  : 备注
	 * @author license_idx
	 */
	private String idxMemo;

	/**
	 * @Fields  : 附件信息
	 * @author fangshaofeng
	 */
	private List<BizFiles> bizFilesList;

}