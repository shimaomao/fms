package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: SysGroupParentDao
 * @Description: 用户组关系实体
 * @date 2018-03-12
 */
@Data
public class SysGroupParent extends BaseEntity<SysGroupParent> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 用户组关系ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String parentId;

	/**
	 * @Fields  : 用户组代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 上级用户组代码
	 */
	private String parentGroup;

	/**
	 * @Fields  : 组织类别
	 */
	private String parentType;

}