package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: ProdFile
 * @Description: 产品附件管理实体
 * @date 2018-04-05
 */
@Data
public class ProdFile extends BaseEntity<ProdFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String prodFileId;

	/**
	 * @Fields  : 
	 */
	private String product;

	/**
	 * @Fields  : 
	 */
	private String fileType;

	/**
	 * @Fields  :
	 */
	private String showType;


}