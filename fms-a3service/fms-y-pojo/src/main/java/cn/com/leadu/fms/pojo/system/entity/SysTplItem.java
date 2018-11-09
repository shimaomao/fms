package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemDao
 * @Description: 模板可设项目管理实体
 * @date 2018-03-12
 */
@Data
public class SysTplItem extends BaseEntity<SysTplItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 模板项目ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String tplItemId;

	/**
	 * @Fields  : 类型识别
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 可设项目key
	 */
	private String tplItemKey;

	/**
	 * @Fields  : 可设项目名
	 */
	private String tplItemName;

}