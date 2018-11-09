package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysInfo
 * @Description: 消息管理实体
 * @date 2018-04-25
 */
@Data
public class SysInfo extends BaseEntity<SysInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 消息id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String infoId;

	/**
	 * @Fields  : 消息级别
	 * @author qiaomengnan
	 */
	private String infoLevel;

	/**
	 * @Fields  : 消息分类
	 * @author qiaomengnan
	 */
	private String infoType;

	/**
	 * @Fields  : 消息内容
	 * @author qiaomengnan
	 */
	private String infoContent;

}