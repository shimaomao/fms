package cn.com.leadu.fms.pojo.asset.vo.mortgageregister;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterVo
 * @Description: 解抵押过户信息载体
 * @date 2018-05-18
 */
@ExcelTitle(value = "解抵押过户信息")
@Data
public class MortgageRegisterVo extends PageQuery<MortgageRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 解除抵押ID
	 * @author yangyiquan
	 */
	private String mortgageRegisterId;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 结清日期
	 * @author yangyiquan
	 */
	private Date settleDate;

	/**
	 * @Fields  : 牌照属性
	 * @author yangyiquan
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 解抵押状态
	 * @author yangyiquan
	 */
	private String mortgateSts;

	/**
	 * @Fields  : 登记账号
	 * @author yangyiquan
	 */
	private String registerUser;

	/**
	 * @Fields  : 保险公司
	 * @author yangyiquan
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业险保单号
	 * @author yangyiquan
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 抵押日期
	 * @author yangyiquan
	 */
	private Date mortgageDate;

	/**
	 * @Fields  : 车管所
	 * @author yangyiquan
	 */
	private String dmvName;

	/**
	 * @Fields  : 解除抵押原因
	 * @author yangyiquan
	 */
	private String mortgageReason;

	/**
	 * @Fields  : 邮寄资料地址属性
	 * @author yangyiquan
	 */
	private String postAddrType;

	/**
	 * @Fields  : 邮寄地址 
	 * @author yangyiquan
	 */
	private String postAddr;

	/**
	 * @Fields  : 邮寄备注
	 * @author yangyiquan
	 */
	private String postMemo;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author yangyiquan
	 */
	private String filePostId;

	/**
	 * @Fields  : 解除抵押ID
	 * @author yangyiquan
	 */
	private List<String> mortgageRegisterIds;

	/**
	 * @Fields  : 申请姓名
	 * @author yanfengbo
	 */
	private String name;

	/**
	 * @Fields  : 订单提出机构
	 * @author yanfengbo
	 */
	private String groupName;

	/**
	 * @Fields  : 车牌号
	 * @author yanfengbo
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 车架号
	 * @author yanfengbo
	 */
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author yanfengbo
	 */
	private String engineNo;


	@ExcelTitle(value = "合同编号", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getContNo(){
		return this.contNo;
	}

	@ExcelTitle(value = "申请姓名", sort = 2)
	public String getName(){
		return this.name;
	}

	@ExcelTitle(value = "订单提出机构", sort = 3)
	public String getGroupName(){
		return groupName;
	}

	@ExcelTitle(value = "车牌号", sort = 4)
	public String getVehicleLicenseNo(){
		return vehicleLicenseNo;
	}

	@ExcelTitle(value = "车架号", sort = 5)
	public String getVinNo(){
		return this.vinNo;
	}

	@ExcelTitle(value = "发动机号", sort = 6)
	public String getEngineNo(){
		return this.engineNo;
	}

	@ExcelTitle(value = "商业险保单号", sort = 7)
	public String getInsPolicyNo(){
		return insPolicyNo;
	}

	@ExcelTitle(value = "保险公司", sort = 8)
	public String getInsCompName(){
		return this.insCompName;
	}

}