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
 * @ClassName: SysTplDao
 * @Description: 模板管理实体
 * @date 2018-03-12
 */
@Data
public class SysTpl extends BaseEntity<SysTpl> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 模板ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String tplId;

	/**
	 * @Fields  : 模板名称
	 */
	private String tplName;

	/**
	 * @Fields  : 类型ID
	 */
	private String tplTypeKey;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 模板内容:短信内容/合同模板文件路径
	 */
	private String tplContent;

}