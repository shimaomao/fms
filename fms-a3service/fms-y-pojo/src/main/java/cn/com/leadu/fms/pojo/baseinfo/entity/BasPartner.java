package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author huchenghao
 * @ClassName: BasPartnerDao
 * @Description: 经销商信息维护实体
 * @date 2018-03-17
 */
@ExcelTitle(value = "经销商信息管理")
@Data
public class BasPartner extends BaseEntity<BasPartner> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合作商ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 区域经理
	 */
	private String areaManager;

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

	@ExcelTitle(value = "经销商代码", sort =1  ,types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getPartnerCode(){
		return this.partnerCode;
	}

	@ExcelTitle(value = "经销商全称", sort = 2 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getPartnerName(){
		return this.partnerName;
	}

	@ExcelTitle(value = "经销商简称", sort =3  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getPartnerNameShort(){
		return this.partnerNameShort;
	}

	@ExcelTitle(value = "经营品牌", sort =4 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getBrand(){
		return this.brand;
	}

	@ExcelTitle(value = "经营省份", sort =5  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO}, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getPartnerProv(){
		return this.partnerProv;
	}

	@ExcelTitle(value = "经营城市", sort =6  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO}, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getPartnerCity(){
		return this.partnerCity;
	}

	@ExcelTitle(value = "经营区县", sort =7  ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO}, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getPartnerCounty(){
		return this.partnerCounty;
	}

	@ExcelTitle(value = "经销商经营地址", sort =8  ,types = {ExcelTypeConstants.ONE})
	public String getPartnerAddr(){
		return this.partnerAddr;
	}


	@ExcelTitle(value = "联系人员", sort =10  ,types = {ExcelTypeConstants.ONE})
	public String getContact(){
		return this.contact;
	}

	@ExcelTitle(value = "联系方式1", sort =11  ,types = {ExcelTypeConstants.ONE})
	public String getContactTel1(){
		return this.contactTel1;
	}

	@ExcelTitle(value = "联系方式2", sort =12  ,types = {ExcelTypeConstants.ONE})
	public String getContactTel2(){
		return this.contactTel2;
	}

	@ExcelTitle(value = "合作类型", sort =13  ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.PARTNER_TYPE)
	public String getPartnerType(){
		return this.partnerType;
	}

	@ExcelTitle(value = "车辆类型", sort =14 ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.VEHICLE_FORM)
	public String getVehicleForm(){
		return this.vehicleForm;
	}

	@ExcelTitle(value = "放款模式", sort =15 ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.REMIT_TYPE)
	public String getRemitType(){
		return this.remitType;
	}

	@ExcelTitle(value = "经营类型", sort =16 ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.RENT_TYPE)
	public String getRentType(){
		return this.rentType;
	}


	@ExcelTitle(value = "金融专员", sort =17 ,types = {ExcelTypeConstants.ONE})
	public String getSalesExec(){
		return this.salesExec;
	}

	@ExcelTitle(value = "金融专员手机", sort =18 ,types = {ExcelTypeConstants.ONE})
	public String getSalesExecMobno(){
		return this.salesExecMobno;
	}

	@ExcelTitle(value = "区域经理", sort =19 ,types = {ExcelTypeConstants.ONE})
	public String getAreaManager(){
		return this.areaManager;
	}

	@ExcelTitle(value = "区域经理手机", sort =20 ,types = {ExcelTypeConstants.ONE})
	public String getAreaManagerMobno(){
		return this.areaManagerMobno;
	}

	@ExcelTitle(value = "备注", sort =21  ,types = {ExcelTypeConstants.ONE})
	public String getRemark(){
		return this.remark;
	}

	@ExcelTitle(value = "更新时间", sort = 22,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(super.getUpdateTime(),DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 23,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getUpdater(){
		return super.getUpdater();
	}

}