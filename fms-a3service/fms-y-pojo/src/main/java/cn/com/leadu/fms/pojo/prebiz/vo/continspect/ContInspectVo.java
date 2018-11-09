package cn.com.leadu.fms.pojo.prebiz.vo.continspect;

import lombok.Data;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefVo
 * @Description: 合同生成前确认载体
 * @date 2018-03-23
 */
@Data
public class ContInspectVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  :
	 */
	private String applyNo;

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
	 * @Fields  :合同文件核查取消原因
	 */
	private String contInspectReason;

	/**
	 * @Fields  : 合同文件核查取消原因Key
	 */
	private String contInspectReasonKey;

	/**
	 * @Fields  :
	 */
	private String taskId;

	/**
	 * @Fields  :
	 */
	private String applyType;




}