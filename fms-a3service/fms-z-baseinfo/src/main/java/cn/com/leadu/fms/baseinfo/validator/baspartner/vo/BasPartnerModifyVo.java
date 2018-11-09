package cn.com.leadu.fms.baseinfo.validator.baspartner.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasPartnerVo
 * @Description: 经销商信息维护修改时载体及验证
 * @date 2018-03-17
 */
@Data
public class BasPartnerModifyVo extends BaseVo<BasPartner> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合作商ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String partnerId;

	/**
	 * @Fields  : 合作商代码
	 */
	@NotBlank(message = "经销商代码不能为空！")
	private String partnerCode;

	/**
	 * @Fields  : 合作商全称
	 */
	@NotBlank(message = "经销商名称不能为空！")
	private String partnerName;

	/**
	 * @Fields  : 合作商简称
	 */
	private String partnerNameShort;

	/**
	 * @Fields  : 经营省份
	 */
	@NotBlank(message = "经销商经营省份不能为空！")
	private String partnerProv;

	/**
	 * @Fields  : 经营城市
	 */
	@NotBlank(message = "经销商经营城市不能为空！")
	private String partnerCity;

	/**
	 * @Fields  : 经营区县
	 */
	@NotBlank(message = "经销商经营区县不能为空！")
	private String partnerCounty;

	/**
	 * @Fields  : 经营地址
	 */
	@NotBlank(message = "经销商经营地址不能为空！")
	private String partnerAddr;

	/**
	 * @Fields  : 经营品牌
	 */
	@NotBlank(message = "经销商经营品牌不能为空！")
	private String brand;
	/**
	 * @Fields  : 层级代码
	 */
	@NotBlank(message = "经销商层级不能为空！")
	private String groupLev;
	/**
	 * @Fields  : 上级组织代码
	 */
	@NotBlank(message = "经销商上级组织代码不能为空！")
	private String parentGroupCode;
	/**
	 * @Fields  : 联系人员
	 */
	@NotBlank(message = "经销商联系人员不能为空！")
	private String contact;

	/**
	 * @Fields  : 联系方式1
	 */
	@NotBlank(message = "经销商联系方式1不能为空！")
	private String contactTel1;

	/**
	 * @Fields  : 联系方式2
	 */
	private String contactTel2;

	/**
	 * @Fields  : 合作类型
	 */
	@NotBlank(message = "经销商合作类型不能为空！")
	private String partnerType;

	/**
	 * @Fields  : 车辆类型
	 */
	@NotBlank(message = "经销商车辆类型不能为空！")
	private String vehicleForm;

	/**
	 * @Fields  : 放款模式
	 */
	@NotBlank(message = "经销商放款模式不能为空！")
	private String remitType;

	/**
	 * @Fields  : 经营牌照类型
	 */
	@NotBlank(message = "经销商经营牌照类型不能为空！")
	private String rentType;

	/**
	 * @Fields  : 金融专员
	 */
	@NotBlank(message = "经销商金融专员不能为空！")
	private String salesExec;

	/**
	 * @Fields  : 金融专员手机
	 */
	@NotBlank(message = "经销商金融专员手机不能为空！")
	private String salesExecMobno;

	/**
	 * @Fields  : 区域经理
	 */
	@NotBlank(message = "经销商区域经理不能为空！")
	private String areaManager;

	/**
	 * @Fields  : 区域经理手机
	 */
	@NotBlank(message = "经销商区域经理手机不能为空！")
	private String areaManagerMobno;

	/**
	 * @Fields  : 扩展属性1
	 */
	private String attr1;

	/**
	 * @Fields  : 扩展属性2
	 */
	private String attr2;

	/**
	 * @Fields  : 扩展属性3
	 */
	private String attr3;

	/**
	 * @Fields  : 扩展属性4
	 */
	private String attr4;

	/**
	 * @Fields  : 扩展属性5
	 */
	private String attr5;

	/**
	 * @Fields  : 备注
	 */
	private String remark;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 附件集合用于返回详情使用
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

}