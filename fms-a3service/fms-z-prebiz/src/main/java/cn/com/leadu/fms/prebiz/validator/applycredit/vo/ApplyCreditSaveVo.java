package cn.com.leadu.fms.prebiz.validator.applycredit.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import lombok.Data;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditVo
 * @Description: 征信信息保存时载体及验证
 * @date 2018-05-15
 */
@Data
public class ApplyCreditSaveVo extends BaseVo<ApplyCredit> {

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

}