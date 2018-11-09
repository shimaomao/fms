package cn.com.leadu.fms.finance.validator.financialsubject.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectVo
 * @Description: 财务科目管理修改时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialSubjectModifyVo extends BaseVo<FinancialSubject> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 科目id
	 * @author yanfengbo
	 */
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

	/**
	 * @Fields  : 辅助核算类型管理
	 * @author ningyangyang
	 */
	List<AssisAccountType> assisAccountTypes;

	/**
	 * @Fields  : 辅助核算类型管理vo
	 * @author yanfengbo
	 */
	List<AssisAccountTypeVo> assisAccountTypeVos;

}