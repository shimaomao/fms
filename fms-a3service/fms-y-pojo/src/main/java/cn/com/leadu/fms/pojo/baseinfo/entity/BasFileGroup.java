package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroup
 * @Description: 附件组实体
 */
@Data
public class BasFileGroup extends BaseEntity<BasFileGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件组id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String basFileGroupId;

	/**
	 * @Fields  : 附件类型上级
	 * @author ningyangyang
	 */
	private String fileTypePar;

	/**
	 * @Fields  : 附件类型下级
	 * @author ningyangyang
	 */
	private String fileTypeChi;

}