package cn.com.leadu.fms.pojo.product.vo.finitem;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemVo
 * @Description: 融资项目管理载体
 * @date 2018-03-19
 */
@Data
public class FinItemVo extends PageQuery<FinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资项目ID
	 */
	private String finItemId;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目名称
	 */
	private String finItemName;

	/**
	 * @Fields  : 牌照属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 融资方式
	 */
	private String finMode;

	/**
	 * @Fields  : 是否可修改
	 */
	private String editMode;

	/**
	 * @Fields  : 是否和车款一起支付
	 */
	private String payMode;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 融资年限
	 */
	private String finItemYear;

	/**
	 * @Fields  : 融资项目类型
	 */
	private String finItemType;

	/**
	 * @Fields  : 是否为首尾付项目  0:否，1:是
	 * 贷前管理专用
	 */
	private Integer initFinalItemFlag;

	/**
	 * @Fields  : 是否为尾付项目  0:否，1:是
	 * 贷前管理专用
	 */
	private Integer finalItemFlag;
	/**
	 * @Fields  : 是否保证金融资项目 0:否，1:是
	 * 贷前管理专用
	 */
	private Integer depositItemFlag;

	/**
	 * @Fields  : 融资项目ID
	 */
	private List<String> finItemIds;

	/**
	 * @Fields  : 财务税率
	 */
	private BigDecimal finTax;

}