package cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainVo
 * @Description: 车辆维修记录载体
 */
@ExcelTitle(value = "车辆维修纪录")

@Data
public class VehMaintainVo extends PageQuery<VehMaintain> {

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
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	private String engineNo;

	/**
	 * @Fields  : 车牌号
	 * @author qinmuqiao
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 维修日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date maintainDate;

	/**
	 * @Fields  : 维修地点
	 * @author qinmuqiao
	 */
	private String maintainAddr;

	/**
	 * @Fields  : 维修金额
	 * @author qinmuqiao
	 */
	private BigDecimal maintainAmount;

	/**
	 * @Fields  : 维修备注
	 * @author qinmuqiao
	 */
	private String maintainMemo;

	/**
	 * @Fields  : 承租人
	 * @author qinmuqiao
	 */
	private String vehTenant;

	/**
	 * @Fields  : 出租人
	 * @author qinmuqiao
	 */
	private String vehLessor;

	/**
	 * @Fields  : 合同号
	 * @author qinmuqiao
	 */
	private String vehContNo;

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
	 * @Fields  : 车辆维修id

	 * @author qinmuqiao
	 */
	private List<String> vehMaintainIds;


	@ExcelTitle(value = "合同号", sort = 1)
	public String getVehContNo(){return this.vehContNo;}

	@ExcelTitle(value = "来源", sort = 2,codeType = CommonCodeTypeConstants.MAINTAIN_FLAG, types = {ExcelTypeConstants.ONE})
	public String getMaintainFlag(){
		return  this.maintainFlag;
	}

	@ExcelTitle(value = "承租人", sort = 3)
	public String getVehTenant(){return this.vehTenant;}

	@ExcelTitle(value = "出租人", sort = 4)
	public String getVehLessor(){return this.vehLessor;}

	@ExcelTitle(value = "车架号", sort = 5)
	public String getVinNo() {return this.vinNo;}

	@ExcelTitle(value = "发动机号", sort = 6)
	public String getEngineNo() {return this.engineNo;}

	@ExcelTitle(value = "车牌号", sort = 7)
	public String getVehicleLicenseNo() {return this.vehicleLicenseNo;}


	@ExcelTitle(value = "维修日期", sort = 8)
	public String getMaintainDateStr(){
		return DateUtils.dateToStr(maintainDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "维修地点", sort = 9)
	public String getMaintainAddr(){
		return maintainAddr;
	}

	@ExcelTitle(value = "维修金额", sort = 10)
	public String getMaintainAmountStr(){
		return BigDecimalUtils.getNotNullBigDecimal(maintainAmount).toString();
	}


}