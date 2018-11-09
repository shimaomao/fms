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
 * @ClassName: SysWidgetDao
 * @Description: 画面控件管理实体
 * @date 2018-03-09
 */
@Data
public class SysWidget extends BaseEntity<SysWidget> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 画面管理ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String widgetUuid;

	/**
	 * @Fields  : 识别ID
	 */
	private String widgetId;

	/**
	 * @Fields  : 类型
	 */
	private String widgetType;

	/**
	 * @Fields  : 名称
	 */
	private String widgetName;

	/**
	 * @Fields  : 提示信息
	 */
	private String memo;

}