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
 * @ClassName: AssisAccountType
 * @Description: 辅助核算类型管理实体
 * @date 2018-06-23
 */
@Data
public class AssisAccountType extends BaseEntity<AssisAccountType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 辅助核算类型id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String assisAccountTypeId;

	/**
	 * @Fields  : 辅助核算类型
	 * @author ningyangyang
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算类型名称
	 * @author ningyangyang
	 */
	private String assisAccountTypeName;

	/**
	 * @Fields  : 核算项目值设值
	 * @author ningyangyang
	 */
	private String assisAccountValue;

}