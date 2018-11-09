package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: NumGenerate
 * @Description: 业务编号管理实体
 * @date 2018-03-26
 */
@Data
public class NumGenerate extends BaseEntity<NumGenerate> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String numGenerateId;

	/**
	 * @Fields  : 
	 */
	private String numType;

	/**
	 * @Fields  : 
	 */
	private Integer numSeq;

	/**
	 * @Fields  : 
	 */
	private Integer numLength;

	/**
	 * @Fields  : 
	 */
	private String prefix;

	/**
	 * @Fields  : 
	 */
	private String suffix;

	/**
	 * @Fields  :
	 */
	private String generateDate;
}