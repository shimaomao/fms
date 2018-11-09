package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: WlTempRentBad
 * @Description: 数据迁移实体
 * @date 2018-08-04
 */
@Data
public class WlTempRentBad extends BaseEntity<WlTempRentBad> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 序号
	 * @author liujinge
	 */
	@ExcelImportTitle("序号")
	private String rentcol1;

	/**
	 * @Fields  : 地区
	 * @author liujinge
	 */
	@ExcelImportTitle("地区")
	private String rentcol2;

	/**
	 * @Fields  : 还款情况
	 * @author liujinge
	 */
	@ExcelImportTitle("还款情况")
	private String rentcol3;

	/**
	 * @Fields  : 类型
	 * @author liujinge
	 */
	@ExcelImportTitle("类型")
	private String rentcol4;

	/**
	 * @Fields  : 分类
	 * @author liujinge
	 */
	@ExcelImportTitle("分类")
	private String rentcol5;

	/**
	 * @Fields  : 客户名称
	 * @author liujinge
	 */
	@ExcelImportTitle("客户名称")
	private String rentcol6;

	/**
	 * @Fields  : 车架号
	 * @author liujinge
	 */
	@ExcelImportTitle("车架号")
	private String rentcol7;

	/**
	 * @Fields  : 开票类型
	 * @author liujinge
	 */
	@ExcelImportTitle("开票类型")
	private String rentcol8;

	/**
	 * @Fields  : 贷款银行
	 * @author liujinge
	 */
//	@ExcelImportTitle("贷款银行")
	private String rentcol9;

	/**
	 * @Fields  : 融资类型
	 * @author liujinge
	 */
//	@ExcelImportTitle("融资类型")
	private String rentcol10;

	/**
	 * @Fields  : 客户类型
	 * @author liujinge
	 */
//	@ExcelImportTitle("客户类型")
	private String rentcol11;

	/**
	 * @Fields  : 主要联系人
	 * @author liujinge
	 */
//	@ExcelImportTitle("主要联系人")
	private String rentcol12;

	/**
	 * @Fields  : 联系电话
	 * @author liujinge
	 */
//	@ExcelImportTitle("联系电话")
	private String rentcol13;

	/**
	 * @Fields  : 期数
	 * @author liujinge
	 */
	@ExcelImportTitle("期数")
	private String rentcol14;

	/**
	 * @Fields  : 应收租金
	 * @author liujinge
	 */
	@ExcelImportTitle("应收租金")
	private String rentcol15;

	/**
	 * @Fields  : 应还款日
	 * @author liujinge
	 */
	@ExcelImportTitle("应还款日")
	private String rentcol16;

	/**
	 * @Fields  : 实际还款日
	 * @author liujinge
	 */
	@ExcelImportTitle("实际还款日")
	private String rentcol17;

	/**
	 * @Fields  : 实收租金
	 * @author liujinge
	 */
	@ExcelImportTitle("实收租金")
	private String rentcol18;

	/**
	 * @Fields  : 本金
	 * @author liujinge
	 */
	@ExcelImportTitle("本金")
	private String rentcol19;

	/**
	 * @Fields  : 利息
	 * @author liujinge
	 */
	@ExcelImportTitle("利息")
	private String rentcol20;

	/**
	 * @Fields  : 实收违约金
	 * @author liujinge
	 */
	@ExcelImportTitle("实收违约金")
	private String rentcol21;

	/**
	 * @Fields  : 发票开具时间
	 * @author liujinge
	 */
	@ExcelImportTitle("发票开具时间")
	private String rentcol22;

	/**
	 * @Fields  : 发票邮寄时间
	 * @author liujinge
	 */
//	@ExcelImportTitle("发票邮寄时间")
	private String rentcol23;

	/**
	 * @Fields  : 备注1
	 * @author liujinge
	 */
//	@ExcelImportTitle("备注1")
	private String rentcol24;

	/**
	 * @Fields  : 
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String rentBadId;

}