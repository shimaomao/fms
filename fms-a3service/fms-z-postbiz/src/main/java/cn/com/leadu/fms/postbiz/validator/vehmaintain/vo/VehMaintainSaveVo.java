package cn.com.leadu.fms.postbiz.validator.vehmaintain.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainVo
 * @Description: 车辆维修记录保存时载体及验证
 */
@Data
public class VehMaintainSaveVo extends BaseVo<VehMaintain> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车辆维修id

	 * @author qinmuqiao
	 */
	private String vehMaintainId;

	/**
	 * @Fields  : 来源
	 * @author qinmuqiao
	 */
	private String maintainFlag;

	/**
	 * @Fields  : 理赔号
	 * @author qinmuqiao
	 */
	private String contInsurClaimNo;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "车架号不能为空")
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "发动机号不能为空")
	private String engineNo;

	/**
	 * @Fields  : 车牌号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "车牌号不能为空")
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 维修日期
	 * @author qinmuqiao
	 */
	@NotNull(message = "维修日期不能为空")
	private Date maintainDate;

	/**
	 * @Fields  : 维修地点
	 * @author qinmuqiao
	 */
	@NotBlank(message = "维修地点不能为空")
	private String maintainAddr;

	/**
	 * @Fields  : 维修金额
	 * @author qinmuqiao
	 */
	@NotNull(message = "维修金额不能为空")
	private BigDecimal maintainAmount;

	/**
	 * @Fields : 读取上传后的附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields : 需要上传的附件信息
	 * @author yanfengbo
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 维修备注
	 * @author qinmuqiao
	 */
	private String maintainMemo;

}