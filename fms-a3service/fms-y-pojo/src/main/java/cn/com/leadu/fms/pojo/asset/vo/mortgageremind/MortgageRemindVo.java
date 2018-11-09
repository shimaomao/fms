package cn.com.leadu.fms.pojo.asset.vo.mortgageremind;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindVo
 * @Description: 抵押提醒载体
 * @date 2018-07-27
 */
@ExcelTitle(value = "回租抵押提醒明细")
@Data
public class MortgageRemindVo extends PageQuery<MortgageRemind> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 抵押提醒id
	 * @author ningyangyang
	 */
	private String morRemindId;

	/**
	 * @Fields  : 承租人
	 * @author ningyangyang
	 */
	private String lessee;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
	private String lessor;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 合同生效日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;


	/**
	 * @Fields  : 融资额
	 * @author ningyangyang
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 融资期限
	 * @author ningyangyang
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 抵押状态
	 * @author ningyangyang
	 */
	private String mortgageStatus;

	/**
	 * @Fields  : 当抵押状态为空的时候 穿进去的抵押状态
	 * @author ningyangyang
	 */
	private String mortgageType;

	/**
	 * @Fields  : 抵押提醒id
	 * @author ningyangyang
	 */
	private List<String> morRemindIds;

	/**
	 * @Fields  : 抵押提醒实体集合
	 * @author ningyangyang
	 */
	private List<MortgageRemind> mortgageRemindList;

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
	 * @Fields : 需要上传的附件信息
	 * @author yanfengbo
	 */
	private List<BizFiles> bizUnlockFilesList;

	/**
	 * @Fields  : 抵押日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date mortgageDate;

	/**
	 * @Fields  : 申请类型
	 * @author ningyangyang
	 */
	private String applyType;

	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String licenseAttr;

	@ExcelTitle(value = "承租人", sort = 1)
	public String getLessee() {
		return lessee;
	}
	@ExcelTitle(value = "出租人", sort = 2)
	public String getLessor() {
		return lessor;
	}
	@ExcelTitle(value = "车架号", sort = 3)
	public String getVinNo() {
		return vinNo;
	}
	@ExcelTitle(value = "合同比编号", sort = 4)
	public String getContNo() {
		return contNo;
	}
	@ExcelTitle(value = "融资额", sort = 5)
	public BigDecimal getFinTotal() {
		return finTotal;
	}
	@ExcelTitle(value = "融资期限", sort = 6)
	public String getLeasePeriod() {
		return leasePeriod;
	}
	@ExcelTitle(value = "抵押状态", sort = 7,codeType = CommonCodeTypeConstants.MORTGAGE_STATUS)
	public String getMortgageStatus() {
		return mortgageStatus;
	}
}