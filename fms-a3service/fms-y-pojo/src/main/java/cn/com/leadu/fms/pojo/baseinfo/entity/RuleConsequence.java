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
 * @ClassName: RuleConsequence
 * @Description: 规则引擎结果实体
 * @date 2018-05-17
 */
@Data
public class RuleConsequence extends BaseEntity<RuleConsequence> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则结果ID
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String ruleConseqId;

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
	 * @Fields  : 优先级
	 * @author qiaomengnan
	 */
	private Integer priority;

	/**
	 * @Fields  : 结果项目key
	 * @author qiaomengnan
	 */
	private String conseqItemKey;

	/**
	 * @Fields  : 结果匹配逻辑
	 * @author qiaomengnan
	 */
	private String conseqLogicType;

	/**
	 * @Fields  : 结果项目值1
	 * @author qiaomengnan
	 */
	private String conseqLogicValue1;

	/**
	 * @Fields  : 结果项目值2
	 * @author qiaomengnan
	 */
	private String conseqLogicValue2;

	/**
	 * @Fields  : 结果排序
	 * @author qiaomengnan
	 */
	private Integer orderNo;

}