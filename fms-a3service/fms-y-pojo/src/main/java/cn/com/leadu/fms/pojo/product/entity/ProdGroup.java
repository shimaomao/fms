package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: ProdGroup
 * @Description: 产品方案机构权限实体
 * @date 2018-04-05
 */
@Data
public class ProdGroup extends BaseEntity<ProdGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品机构权限ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String prodGroupId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 用户组(机构)代码 
	 */
	private String groupCode;

}