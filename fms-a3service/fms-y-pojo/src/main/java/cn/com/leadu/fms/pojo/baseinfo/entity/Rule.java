package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author qiaomengnan
 * @ClassName: Rule
 * @Description: 规则引擎实体
 * @date 2018-05-17
 */
@Data
public class Rule extends BaseEntity<Rule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String ruleId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

	/**
	 * @Fields  : 规则key
	 * @author qiaomengnan
	 */
	private String ruleKey;

	/**
	 * @Fields  : 规则名称
	 * @author qiaomengnan
	 */
	private String ruleName;

}