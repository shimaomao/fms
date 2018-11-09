package cn.com.leadu.fms.pojo.prebiz.vo.applycredit;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditVo
 * @Description: 征信信息载体
 * @date 2018-05-15
 */
@Data
public class ApplyCreditVo extends PageQuery<ApplyCredit> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 征信信息ID
	 * @author qiaomengnan
	 */
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

	/**
	 * @Fields  : 征信信息ID
	 * @author qiaomengnan
	 */
	private List<String> applyCreditIds;

}