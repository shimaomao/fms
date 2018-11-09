package cn.com.leadu.fms.pojo.finance.vo.subjectassisaccount;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: SubjectAssisAccountVo
 * @Description: 科目辅助核算管理载体
 * @date 2018-06-23
 */
@Data
public class SubjectAssisAccountVo extends PageQuery<SubjectAssisAccount> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 科目辅助核算id
	 * @author ningyangyang
	 */
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

	/**
	 * @Fields  : 科目辅助核算id
	 * @author ningyangyang
	 */
	private List<String> subjectAssisAccountIds;

}