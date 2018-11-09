package cn.com.leadu.fms.pojo.prebiz.vo.contprint;

import lombok.Data;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefVo
 * @Description: 合同生成前确认载体
 * @date 2018-03-23
 */
@Data
public class ContPrintVo {

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
	 * @Fields  :
	 */
	private String applyType;

	/**
	 * @Fields  :
	 */
	private String taskId;

}