package cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkVo
 * @Description: 风控电核信息载体
 * @date 2018-06-04
 */
@Data
public class RiskTelchkVo extends PageQuery<RiskTelchk> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控电核id
	 * @author liujinge
	 */
	private String riskTelchkId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 核实项目
	 * @author liujinge
	 */
	private String telchkItem;

	/**
	 * @Fields  : 核实值
	 * @author liujinge
	 */
	private String telchkResult;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String memo;

	/**
	 * @Fields  : 风控电核id
	 * @author liujinge
	 */
	private List<String> riskTelchkIds;

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