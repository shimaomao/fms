package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
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
 * @author yangyiquan
 * @ClassName: BasBlacklist
 * @Description: 黑名单实体
 * @date 2018-05-04
 */
@ExcelTitle(value = "黑名单管理")
@Data
public class BasBlacklist extends BaseEntity<BasBlacklist> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 黑名单id
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String blacklistId;

	/**
	 * @Fields  : 客户名称
	 * @author yangyiquan
	 */
	private String name;

	/**
	 * @Fields  : 证件号码
	 * @author yangyiquan
	 */
	private String certifNo;


	/**
	 * @Fields  : 手机号码
	 * @author wangxue
	 */
	private String mobileNo;

	/**
	 * @Fields  : 黑名单级别
	 * @author yangyiquan
	 */
	private String blackLevel;

	/**
	 * @Fields  : 来源
	 * @author yangyiquan
	 */
	private String source;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	@ExcelTitle(value = "客户名称", sort =1  ,types = {ExcelTypeConstants.ONE})
	public String getName() {
		return name;
	}

	@ExcelTitle(value = "证件号码", sort =2  ,types = {ExcelTypeConstants.ONE})
	public String getCertifNo() {
		return certifNo;
	}

	@ExcelTitle(value = "手机号码", sort =3  ,types = {ExcelTypeConstants.ONE})
	public String getMobileNo() {
		return mobileNo;
	}

	@ExcelTitle(value = "黑名单级别", sort =4  ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.BLACK_LEVEL)
	public String getBlackLevel() {
		return blackLevel;
	}

	@ExcelTitle(value = "来源", sort =5  ,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.SOURCE)
	public String getSource() {
		return source;
	}

	@ExcelTitle(value = "备注", sort =6  ,types = {ExcelTypeConstants.ONE})
	public String getMemo() {
		return memo;
	}

	@ExcelTitle(value = "更新时间", sort = 7,types = {ExcelTypeConstants.ONE})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(super.getUpdateTime(),DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 8,types = {ExcelTypeConstants.ONE})
	public String getUpdater(){
		return super.getUpdater();
	}
}