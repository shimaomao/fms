package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleItem
 * @Description: 规则引擎项目管理实体
 * @date 2018-05-17
 */
@Data
public class RuleItem extends BaseEntity<RuleItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则项目ID
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String ruleItemId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

	/**
	 * @Fields  : 规则项目key
	 * @author qiaomengnan
	 */
	private String ruleItemKey;

	/**
	 * @Fields  : 规则项目名称
	 * @author qiaomengnan
	 */
	private String ruleItemName;

	/**
	 * @Fields  : 项目属性
	 * @author qiaomengnan
	 */
	private String itemType;

}