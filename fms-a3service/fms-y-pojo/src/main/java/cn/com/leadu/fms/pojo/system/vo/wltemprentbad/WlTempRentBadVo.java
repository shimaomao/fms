package cn.com.leadu.fms.pojo.system.vo.wltemprentbad;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.WlTempRentBad;
import lombok.Data;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentBadVo
 * @Description: 数据迁移载体
 * @date 2018-08-04
 */
@Data
public class WlTempRentBadVo extends PageQuery<WlTempRentBad> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 序号
	 * @author liujinge
	 */
	private String rentcol1;

	/**
	 * @Fields  : 地区
	 * @author liujinge
	 */
	private String rentcol2;

	/**
	 * @Fields  : 还款情况
	 * @author liujinge
	 */
	private String rentcol3;

	/**
	 * @Fields  : 类型
	 * @author liujinge
	 */
	private String rentcol4;

	/**
	 * @Fields  : 分类
	 * @author liujinge
	 */
	private String rentcol5;

	/**
	 * @Fields  : 客户名称
	 * @author liujinge
	 */
	private String rentcol6;

	/**
	 * @Fields  : 车架号
	 * @author liujinge
	 */
	private String rentcol7;

	/**
	 * @Fields  : 开票类型
	 * @author liujinge
	 */
	private String rentcol8;

	/**
	 * @Fields  : 贷款银行
	 * @author liujinge
	 */
	private String rentcol9;

	/**
	 * @Fields  : 融资类型
	 * @author liujinge
	 */
	private String rentcol10;

	/**
	 * @Fields  : 客户类型
	 * @author liujinge
	 */
	private String rentcol11;

	/**
	 * @Fields  : 主要联系人
	 * @author liujinge
	 */
	private String rentcol12;

	/**
	 * @Fields  : 联系电话
	 * @author liujinge
	 */
	private String rentcol13;

	/**
	 * @Fields  : 期数
	 * @author liujinge
	 */
	private String rentcol14;

	/**
	 * @Fields  : 应收租金
	 * @author liujinge
	 */
	private String rentcol15;

	/**
	 * @Fields  : 应还款日
	 * @author liujinge
	 */
	private String rentcol16;

	/**
	 * @Fields  : 实际还款日
	 * @author liujinge
	 */
	private String rentcol17;

	/**
	 * @Fields  : 实收租金
	 * @author liujinge
	 */
	private String rentcol18;

	/**
	 * @Fields  : 本金
	 * @author liujinge
	 */
	private String rentcol19;

	/**
	 * @Fields  : 利息
	 * @author liujinge
	 */
	private String rentcol20;

	/**
	 * @Fields  : 实收违约金
	 * @author liujinge
	 */
	private String rentcol21;

	/**
	 * @Fields  : 发票开具时间
	 * @author liujinge
	 */
	private String rentcol22;

	/**
	 * @Fields  : 发票邮寄时间
	 * @author liujinge
	 */
	private String rentcol23;

	/**
	 * @Fields  : 备注1
	 * @author liujinge
	 */
	private String rentcol24;

	/**
	 * @Fields  : 
	 * @author liujinge
	 */
	private String rentBadId;

	/**
	 * @Fields  : 
	 * @author liujinge
	 */
	private List<String> rentBadIds;

}