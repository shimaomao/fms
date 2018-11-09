package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPerson
 * @Description: 催收组员实体
 */
@Data
public class CollectionPerson extends BaseEntity<CollectionPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 催收人员id

	 * @author qinmuqiao
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String collectionPersonId;

	/**
	 * @Fields  : 0-电催，1-上门，2-诉讼，3-收车
	 * @author qinmuqiao
	 */
	private String collectionType;

	/**
	 * @Fields  : 催收人员账号
	 * @author qinmuqiao
	 */
	private String collectionPersonNum;

	/**
	 * @Fields  : 备注
	 * @author qinmuqiao
	 */
	private String remark;

	/**
	 * @Fields  : 启用标识
	 * @author qinmuqiao
	 */
	private String enableFlag;



}