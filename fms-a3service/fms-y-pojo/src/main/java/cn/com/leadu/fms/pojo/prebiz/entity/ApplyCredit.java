package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCredit
 * @Description: 征信信息实体
 * @date 2018-05-15
 */
@Data
public class ApplyCredit extends BaseEntity<ApplyCredit> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 征信信息ID
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyCreditId;

	/**
	 * @Fields  : 申请编号
	 * @author qiaomengnan
	 */
	private String applyNo;

	/**
	 * @Fields  : excel路径
	 * @author qiaomengnan
	 */
	private String inputExcelPath;

	/**
	 * @Fields  : txt路径
	 * @author qiaomengnan
	 */
	private String resultTxtPath;

	/**
	 * @Fields  : 模型评分段
	 * @author qiaomengnan
	 */
	private String creditGrade;

}