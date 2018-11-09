package cn.com.leadu.fms.pojo.prebiz.vo.applyapprove;

import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesListVo;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefVo
 * @Description: 合同生成前确认载体
 * @date 2018-03-23
 */
@Data
public class ApplyApproveVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields  :
	 */
	private String taskId;

	/**
	 * @Fields  :
	 */
	private String applyType;

	/**
	 * @Fields  :
	 */
	private String contNo;
	/**
	 * @Fields  : 
	 */
	private String remark1;

	/**
	 * @Fields  :
	 */
	private String user;

	/**
	 * @Fields  : 附件
	 * @author qiaomengnan
	 */
	private List<BizFilesListVo> bizFilesListVos;
	/**
	 * @Fields  : 操作类型
	 */
	private String codeType1;
	/**
	 * @Fields: 操作代码
	 */
	private String codeValue1;
	/**
	 * @Fields: 审批区分
	 */
	private String detailFlag;


}