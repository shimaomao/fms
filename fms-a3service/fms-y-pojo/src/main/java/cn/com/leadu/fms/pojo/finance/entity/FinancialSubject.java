package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubject
 * @Description: 财务科目管理实体
 * @date 2018-06-20
 */
@Data
public class FinancialSubject extends BaseEntity<FinancialSubject> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 科目id
	 * @author yanfengbo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String subjectId;

	/**
	 * @Fields  : 科目代码
	 * @author yanfengbo
	 */
	private String subjectCd;

	/**
	 * @Fields  : 科目名称
	 * @author yanfengbo
	 */
	private String subjectName;

	/**
	 * @Fields  : 用途备注
	 * @author yanfengbo
	 */
	private String subjectMemo;

}