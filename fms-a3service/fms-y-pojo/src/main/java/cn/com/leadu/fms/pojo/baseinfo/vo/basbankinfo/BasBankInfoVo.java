package cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoVo
 * @Description: 银行账号维护载体
 * @date 2018-03-26
 */
@ExcelTitle(value = "银行账号信息")
@Data
public class BasBankInfoVo extends PageQuery<BasBankInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行ID
	 */
	private String bankId;

	/**
	 * @Fields  : 机构代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 机构类型
	 */
	private String organizationType;

	/**
	 * @Fields  : 机构信息
	 */
	private String organizationId;

	/**
	 * @Fields  : 机构信息代码(辅助用)
	 */
	private String organizationIdCode;

	/**
	 * @Fields  : 银行账号维护任务号
	 */
	private String bankTaskNo;

	/**
	 * @Fields  : 银行账号状态
	 */
	private String accountNoStatus;

	/**
	 * @Fields  : 银行账号序号
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 电子联行号
	 */
	private String eleAccountNo;

	/**
	 * @Fields  : 开户行
	 */
	private String accBank;

	/**
	 * @Fields  : 开户行名称
	 */
	@NotBlank(message = "开户行不能为空")
	private String accBankName;

	/**
	 * @Fields  : 分行名称
	 */
	@NotBlank(message = "分行不能为空")
	private String accBranchBank;

	/**
	 * @Fields  : 开户行省份
	 */
	private String accOpBankProv;

	/**
	 * @Fields  : 开户行城市
	 */
	private String accOpBankCity;

	/**
	 * @Fields  : 开户名
	 */
	@NotBlank(message = "开户名不能为空")
	private String accountName;

	/**
	 * @Fields  : 银行账号
	 */
	@NotBlank(message = "银行账号不能为空")
	private String accountNo;

	/**
	 * @Fields  : 编码
	 */
	private String accountCode;

	/**
	 * @Fields  : 是否启用
	 */
	private String enableFlag;

	/**
	 * @Fields  : 银行ID
	 */
	private List<String> bankIds;

	/**
	 * @Fields  : 机构名称
	 */
	private  String groupName;

	/**
	 * @Fields  : 是否默认账号
	 */
	private String accDefault;
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
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 财务科目代码
	 */
	private String finassSubjectCd;

	/**
	 * @Fields  : 收款银行
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款银行(抵押制单用到)
	 */
	private String recAccEquBank;

	/**
	 * @Fields  : 收款账号
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款联行号
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : 供应商辅助核算代码
	 */
	private String assisFinassSupplyCd;

	@ExcelTitle(value = "机构代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getGroupCode(){
		return this.groupCode;
	}

	@ExcelTitle(value = "机构名称", sort = 2)
	public String getGroupName(){
		return this.groupName;
	}

	@ExcelTitle(value = "银行账号类型", sort = 3,codeType = CommonCodeTypeConstants.ORGANIZATION_TYPE)
	public String getOrganizationType(){return this.organizationType;}

	@ExcelTitle(value = "机构信息", sort = 4)
	public String getOrganizationId(){return this.organizationId;}

	@ExcelTitle(value = "银行账号状态", sort = 5,codeType = CommonCodeTypeConstants.ACCOUNTNO_STATUS)
	public String getAccountNoStatus(){return this.accountNoStatus;}

	@ExcelTitle(value = "开户名", sort = 6)
	public String getAccountName(){return this.accountName;}

	@ExcelTitle(value = "开户行", sort = 7,codeType = CommonCodeTypeConstants.OPENING_BANK)
	public String getAccBank(){
		return accBank;
	}

	@ExcelTitle(value = "分行名称", sort = 8)
	public String getAccBranchBank(){
		return this.accBranchBank;
	}

	@ExcelTitle(value = "银行账号", sort = 9)
	public String getAccountNo(){
		return this.accountNo;
	}

	@ExcelTitle(value = "开户行省份", sort = 10, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAccOpBankProv(){
		return accOpBankProv;
	}

	@ExcelTitle(value = "开户行城市", sort = 11, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAccOpBankCity(){
		return this.accOpBankCity;
	}

	@ExcelTitle(value = "电子银联号", sort = 12)
	public String getEleAccountNo(){
		return this.eleAccountNo;
	}

	@ExcelTitle(value = "是否默认账号", sort = 13 ,codeType = CommonCodeTypeConstants.ACCDEFAULT)
	public String getAccDefault(){
		return accDefault;
	}

	@ExcelTitle(value = "启用标志", sort = 14 ,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 15)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 16)
	public String getUpdater(){
		return updater;
	}

}