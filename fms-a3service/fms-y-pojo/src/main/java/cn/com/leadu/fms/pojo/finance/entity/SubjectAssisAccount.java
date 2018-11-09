package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SubjectAssisAccount
 * @Description: 科目辅助核算管理实体
 * @date 2018-06-23
 */
@Data
public class SubjectAssisAccount extends BaseEntity<SubjectAssisAccount> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 科目辅助核算id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String subjectAssisAccountId;

	/**
	 * @Fields  : 科目代码
	 * @author ningyangyang
	 */
	private String subjectCd;

	/**
	 * @Fields  : 辅助核算类型
	 * @author ningyangyang
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算序号
	 * @author ningyangyang
	 */
	private Integer assisAccountOrder;

}