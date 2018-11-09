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
 * @ClassName: RuleCondition
 * @Description: 规则引擎条件实体
 * @date 2018-05-17
 */
@Data
public class RuleCondition extends BaseEntity<RuleCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则条件ID
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String ruleCondId;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	private String ruleId;

	/**
	 * @Fields  : 规则序号
	 * @author qiaomengnan
	 */
	private Integer ruleNo;
	
	/**
	 * @Fields  : 条件项目key
	 * @author qiaomengnan
	 */
	private String condItemKey;

	/**
	 * @Fields  : 条件匹配逻辑
	 * @author qiaomengnan
	 */
	private String condLogicType;

	/**
	 * @Fields  : 条件项目值1
	 * @author qiaomengnan
	 */
	private String condLogicValue1;

	/**
	 * @Fields  : 条件项目值2
	 * @author qiaomengnan
	 */
	private String condLogicValue2;

	/**
	 * @Fields  : 排序
	 * @author qiaomengnan
	 */
	private Integer orderNo;

}