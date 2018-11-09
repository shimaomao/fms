package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: ProdFinItem
 * @Description: 产品方案融资项目实体
 * @date 2018-04-06
 */
@Data
public class ProdFinItem extends BaseEntity<ProdFinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品融资项目ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String prodFinItemId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目类型
	 */
	private String finItemType;

}