package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qiaomengnan
 * @ClassName: SysFileDao
 * @Description: 菜单实体
 * @date 2018-03-01
 */
@Data
public class SysFile extends BaseEntity<SysFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String id;

	/**
	 * @Fields  : 
	 */
	private String fileName;

	/**
	 * @Fields  : 
	 */
	private String filePath;

	/**
	 * @Fields  : 
	 */
	private Integer fileDownNum;

}