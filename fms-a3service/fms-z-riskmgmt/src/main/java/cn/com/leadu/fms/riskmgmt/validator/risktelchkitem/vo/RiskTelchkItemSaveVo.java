package cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import lombok.Data;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemVo
 * @Description: 风控电核项目表保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskTelchkItemSaveVo extends BaseVo<RiskTelchkItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控电核项目id
	 * @author liujinge
	 */
	private String telchkItemId;

	/**
	 * @Fields  : 核实项目
	 * @author liujinge
	 */
	private String telchkItem;

	/**
	 * @Fields  : 核实项目名
	 * @author liujinge
	 */
	private String telchkItemName;

	/**
	 * @Fields  : 核实项目选项
	 * @author liujinge
	 */
	private String codeType;

	/**
	 * @Fields  : 排序
	 * @author liujinge
	 */
	private Integer orderNo;

}