package cn.com.leadu.fms.pojo.postbiz.vo.annualinspection;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionVo
 * @Description: 年检提醒载体
 */
@ExcelTitle(value = "年检管理")
@Data
public class AnnualInspectionVo extends PageQuery<AnnualInspection> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 年检提醒id
	 * @author qinmuqiao
	 */
	private String annualInspectionId;

	/**
	 * @Fields  : 年检任务号
	 * @author qinmuqiao
	 */
	private String annualInspectNo;

	/**
	 * @Fields  : 合同编号
	 * @author qinmuqiao
	 */
	private String contNo;

	/**
	 * @Fields  : 年检状态
	 * @author qinmuqiao
	 */
	private String annualInspectStatus;

	/**
	 * @Fields  : 年检期限
	 * @author qinmuqiao
	 */
	@JsonFormat (pattern = DateUtils.formatStr_yyyyMMdd)
	private Date annualInspectDeadline;

	/**
	 * @Fields  : 年检日期
	 * @author qinmuqiao
	 */
	@JsonFormat (pattern = DateUtils.formatStr_yyyyMMdd)
	private Date annualInspectDate;
	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String annualInspecVinNo;

	/**
	 * @Fields  : 承租人
	 * @author qinmuqiao
	 */
	private String annualInspecUser;


	/**
	 * @Fields  : 车辆行驶证注册日期
	 * @author qinmuqiao
	 */
	@JsonFormat (pattern = DateUtils.formatStr_yyyyMMdd)
	private Date annualInspecDrivingLicenseRegisterDate;

	/**
	 * @Fields  : 
	 * @author qinmuqiao
	 */
	private List<String> annualInspectionIds;


	@ExcelTitle(value = "合同号", sort = 1)
	public String getContNo(){return this.contNo;}

	@ExcelTitle(value = "承租人", sort = 2)
	public String getAnnualInspecUser(){return this.annualInspecUser;}

	@ExcelTitle(value = "车架号", sort = 3)
	public String getAnnualInspecVinNo() {return this.annualInspecVinNo;}


	@ExcelTitle(value = "是否年检", sort = 4,codeType = CommonCodeTypeConstants.ANNUALINSPECTION_STATUS, types = {ExcelTypeConstants.ONE})
	public String getAnnualInspectStatus(){
		return  this.annualInspectStatus;
	}

	@ExcelTitle(value = "车辆行驶证书注册日期", sort = 5)
	public String getAnnualInspecDrivingLicenseRegisterDateStr(){
		return DateUtils.dateToStr(annualInspecDrivingLicenseRegisterDate,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "年检期限", sort = 6)
	public String getAnnualInspectDeadlineStr(){
		return DateUtils.dateToStr(annualInspectDeadline,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "年检日期", sort = 7)
	public String getAnnualInspectDateStr(){
		return DateUtils.dateToStr(annualInspectDate,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "年检任务号", sort = 8)
	public String getAnnualInspectNo(){
		return annualInspectNo;
	}


}