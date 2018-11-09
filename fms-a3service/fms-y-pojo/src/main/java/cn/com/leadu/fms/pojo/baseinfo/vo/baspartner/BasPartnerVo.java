package cn.com.leadu.fms.pojo.baseinfo.vo.baspartner;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasPartnerVo
 * @Description: 经销商信息维护载体
 * @date 2018-03-17
 */
@Data
public class BasPartnerVo extends PageQuery<BasPartner> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合作商ID
	 */
	private String partnerId;

	/**
	 * @Fields  : 合作商代码
	 */
	private String partnerCode;

	/**
	 * @Fields  : 合作商全称
	 */
	private String partnerName;

	/**
	 * @Fields  : 合作商简称
	 */
	private String partnerNameShort;

	/**
	 * @Fields  : 经营省份
	 */
	private String partnerProv;

	/**
	 * @Fields  : 经营城市
	 */
	private String partnerCity;

	/**
	 * @Fields  : 经营区县
	 */
	private String partnerCounty;

	/**
	 * @Fields  : 经营地址
	 */
	private String partnerAddr;

	/**
	 * @Fields  : 经营品牌
	 */
	private String brand;
	/**
	 * @Fields  : 层级代码
	 */
	private String groupLev;
	/**
	 * @Fields  : 层级代码名称
	 */
	private String groupLevName;
	/**
	 * @Fields  : 上级组织代码
	 */
	private String ParentGroupCode;
	/**
	 * @Fields  : 上级组织名称
	 */
	private String ParentGroupName;
	/**
	 * @Fields  : 联系人员
	 */
	private String contact;

	/**
	 * @Fields  : 联系方式1
	 */
	private String contactTel1;

	/**
	 * @Fields  : 联系方式2
	 */
	private String contactTel2;

	/**
	 * @Fields  : 合作类型
	 */
	private String partnerType;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 放款模式
	 */
	private String remitType;

	/**
	 * @Fields  : 经营牌照类型
	 */
	private String rentType;

	/**
	 * @Fields  : 金融专员
	 */
	private String salesExec;

	/**
	 * @Fields  : 金融专员手机
	 */
	private String salesExecMobno;

	/**
	 * @Fields  : 区域经理代码
	 */
	private String areaManager;

	/**
	 * @Fields  : 区域经理名称
	 */
	private String areaManagerName;

	/**
	 * @Fields  : 区域经理手机
	 */
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
	 * @Fields  : 合作商ID
	 */
	private List<String> partnerIds;

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