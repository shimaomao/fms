package cn.com.leadu.fms.pojo.finance.vo.financialsubject;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FinancialSubjectVo
 * @Description: 财务科目管理载体
 * @date 2018-06-20
 */
@Data
public class FinancialSubjectVo extends PageQuery<FinancialSubject> {

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
	 * @Fields  : 财务科目ID
	 * @author yanfengbo
	 */
	@Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
	private List<String> subjectIds;

	/**
	 * @Fields  : 辅助核算类型管理
	 * @author ningyangyang
	 */
	List<AssisAccountType> assisAccountTypes;

	/**
	 * @Fields  : 财务科目管理
	 * @author ningyangyang
	 */
	List<FinancialSubjectVo> financialSubjectVoList;

	/**
	 * @Fields  : 辅助核算类型管理vo
	 * @author yanfengbo
	 */
	List<AssisAccountTypeVo> assisAccountTypeVos;
}