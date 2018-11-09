package cn.com.leadu.fms.pojo.baseinfo.vo.bassales;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: BasSalesVo
 * @Description: 实际销售方载体
 * @date 2018-05-03
 */
@ExcelTitle(value = "实际销售方信息")
@Data
public class BasSalesVo extends PageQuery<BasSales> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 实际销售方id
	 * @author yanfengbo
	 */
	private String salesId;

	/**
	 * @Fields  : 实际销售方代码
	 * @author yanfengbo
	 */
	private String salesCode;

	/**
	 * @Fields  : 实际销售方全称
	 * @author yanfengbo
	 */
	private String salesName;

	/**
	 * @Fields  : 实际销售方任务号
	 * @author yanfengbo
	 */
	private String salesTaskNo;

	/**
	 * @Fields  : 实际销售方状态
	 * @author yanfengbo
	 */
	private String salesTaskStatus;

	/**
	 * @Fields  : 所属集团
	 * @author yanfengbo
	 */
	private String withinGroup;

	/**
	 * @Fields  : 店面属性
	 * @author yanfengbo
	 */
	private String salesType;

	/**
	 * @Fields  : 经营省份
	 * @author yanfengbo
	 */
	private String addrProv;

	/**
	 * @Fields  : 经营城市
	 * @author yanfengbo
	 */
	private String addrCity;

	/**
	 * @Fields  : 经营区县
	 * @author yanfengbo
	 */
	private String addrCounty;

	/**
	 * @Fields  : 经营地址
	 * @author yanfengbo
	 */
	private String address;

	/**
	 * @Fields  : 注册省份
	 * @author yanfengbo
	 */
	private String registerProv;

	/**
	 * @Fields  : 注册城市
	 * @author yanfengbo
	 */
	private String registerCity;

	/**
	 * @Fields  : 注册区县
	 * @author yanfengbo
	 */
	private String registerCounty;

	/**
	 * @Fields  : 注册地址
	 * @author yanfengbo
	 */
	private String registerAddress;

	/**
	 * @Fields  : 担保期限
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date guaranteePeriod;

	/**
	 * @Fields  : 车辆类型
	 * @author yanfengbo
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 联系人员
	 * @author yanfengbo
	 */
	private String contact;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String contactTel1;

	/**
	 * @Fields  : 销售品牌
	 * @author yanfengbo
	 */
	private String saleBrand;

	/**
	 * @Fields  : 所属经销商代码
	 * @author yanfengbo
	 */
	private String parGroupCode;
	
	/** 
	 * @Fields  : 所属经销商全称
	 */
	private String partnerName;

	/**
	 * @Fields  : 实际销售方id
	 * @author yanfengbo
	 */
	private List<String> salesIds;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : TaskId
	 */
	private String taskId;

	/**
	 * @Fields  : 操作分类
	 */
	private String actType;

	/**
	 * @Fields  : 备注
	 */
	private String remark1;

	/**
	 * @Fields  : serviceId
	 */
	private String serviceId;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassSalesCode;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	@ExcelTitle(value = "实际销售方代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getSalesCode(){
		return this.salesCode;
	}

	@ExcelTitle(value = "实际销售方全称", sort = 2)
	public String getSalesName(){
		return this.salesName;
	}

	@ExcelTitle(value = "实际销售方状态", sort = 3 ,codeType = CommonCodeTypeConstants.SALESTASK_STATUS)
	public String getSalesTaskStatus(){
		return salesTaskStatus;
	}

	@ExcelTitle(value = "店面属性", sort = 4 ,codeType = CommonCodeTypeConstants.SALES_TYpe)
	public String getSalesType(){
		return salesType;
	}

	@ExcelTitle(value = "所属集团", sort = 5 ,codeType = CommonCodeTypeConstants.WITHIN_GROUP)
	public String getWithinGroup(){
		return withinGroup;
	}

	@ExcelTitle(value = "经营省份", sort = 6, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAddrProv(){
		return addrProv;
	}

	@ExcelTitle(value = "经营城市", sort = 7, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAddrCity(){
		return this.addrCity;
	}

	@ExcelTitle(value = "经营区县", sort = 8, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAddrCounty(){
		return this.addrCounty;
	}

	@ExcelTitle(value = "经营地址", sort = 9)
	public String getAddress(){
		return address;
	}

	@ExcelTitle(value = "注册省份", sort = 10, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterProv(){
		return registerProv;
	}

	@ExcelTitle(value = "注册城市", sort = 11, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterCity(){
		return this.registerCity;
	}

	@ExcelTitle(value = "注册区县", sort = 12, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterCounty(){
		return this.registerCounty;
	}

	@ExcelTitle(value = "注册地址", sort = 13)
	public String getRegisterAddress(){
		return registerAddress;
	}

	@ExcelTitle(value = "担保期限", sort = 14)
	public String getGuaranteePeriodStr(){return DateUtils.dateToStr(guaranteePeriod,DateUtils.formatStr_yyyyMMddChinese);}

	@ExcelTitle(value = "车辆类型",sort = 15, codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM, joinDelimiter = StringUtils.COMMA)
	public String getVehicleForm() {
		return vehicleForm;
	}

	@ExcelTitle(value = "联系人员", sort = 16)
	public String getContact(){
		return this.contact;
	}

	@ExcelTitle(value = "联系电话", sort = 17)
	public String getContactTel1(){
		return this.contactTel1;
	}

	@ExcelTitle(value = "财务辅助核算代码", sort = 18)
	public String getFinassSalesCode(){return this.finassSalesCode;}

	@ExcelTitle(value = "更新时间", sort = 19)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 20)
	public String getUpdater(){
		return updater;
	}
}