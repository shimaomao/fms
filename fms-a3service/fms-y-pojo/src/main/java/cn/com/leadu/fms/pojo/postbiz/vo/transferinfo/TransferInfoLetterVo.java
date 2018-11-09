package cn.com.leadu.fms.pojo.postbiz.vo.transferinfo;

import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: TransferInfoVo
 * @Description: 过户流程载体
 * @date 2018-08-30
 */
@Data
public class TransferInfoLetterVo extends PageQuery<TransferInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 过户信息ID
	 * @author wangxue
	 */
	private String transferId;

	/**
	 * @Fields  : 过户任务号
	 * @author wangxue
	 */
	private String transferNo;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 车辆品牌
	 * @author wangxue
	 */
	private String vehBrandCodeName;

	/**
	 * @Fields  : 车型
	 * @author wangxue
	 */
	private String vehicleCodeName;

	/**
	 * @Fields  : 车牌号
	 * @author wangxue
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 车架号
	 * @author wangxue
	 */
	private String vinNo;

	/**
	 * @Fields  : 所有权转移人
	 * @author wangxue
	 */
	private String ownershipPerson;

	/**
	 * @Fields  : 证件号码
	 * @author wangxue
	 */
	private String certifNo;

	/**
	 * @Fields  : 联系号码
	 * @author wangxue
	 */
	private String contactMobile;

	/**
	 * @Fields  : 品牌+型号
	 * @author wangxue
	 */
	private String brandModel;

	/**
	 * @Fields  : 车牌号+车架号
	 * @author wangxue
	 */
	private String licenseVinNo;

	}