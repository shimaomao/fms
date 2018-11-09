package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleDao
 * @Description: 还款日规则实体
 * @date 2018-03-16
 */
@Data
public class BasRepayRule extends BaseEntity<BasRepayRule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String ruleId;

	/**
	 * @Fields  : 
	 */
	private String repayDay;

	/**
	 * @Fields  : 
	 */
	private String beginInterval;

	/**
	 * @Fields  : 
	 */
	private String endInterval;

}