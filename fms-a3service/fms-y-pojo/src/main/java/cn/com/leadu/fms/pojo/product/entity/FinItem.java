package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: FinItemDao
 * @Description: 融资项目管理实体
 * @date 2018-03-19
 */
@ExcelTitle(value = "融资费用信息")
@Data
public class FinItem extends BaseEntity<FinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资项目ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 财务税率
	 */
	private BigDecimal finTax;

	@ExcelTitle(value = "融资项目代码", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getFinItem() {
		return this.finItem;
	}

	@ExcelTitle(value = "融资项目名称", sort = 2)
	public String getFinItemName() {
		return this.finItemName;
	}

	@ExcelTitle(value = "融资方式", sort = 3, codeType = CommonCodeTypeConstants.PROD_FIN_MODE)
	public String getFinMode() {return this.finMode;}

	@ExcelTitle(value = "是否可以修改", sort = 4, codeType = CommonCodeTypeConstants.COMMON_EDIT_MODE)
	public String getEditMode() {
		return this.editMode;
	}

	@ExcelTitle(value = "是否和车款一起支付", sort = 5, codeType = CommonCodeTypeConstants.PROD_PAY_MODE)
	public String getPayMode() {
		return this.payMode;
	}

	@ExcelTitle(value = "更新时间", sort = 6)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 7)
	public String getUpdater(){
		return updater;
	}

}