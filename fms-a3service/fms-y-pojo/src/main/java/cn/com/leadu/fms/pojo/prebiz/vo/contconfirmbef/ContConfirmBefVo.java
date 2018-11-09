package cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef;

import lombok.Data;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefVo
 * @Description: 合同生成前确认载体
 * @date 2018-03-23
 */
@Data
public class ContConfirmBefVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields  : 
	 */
	private String remark1;

	/**
	 * @Fields  :
	 */
	private String user;

	/**
	 * @Fields  : 当前任务id
	 */
	private String taskId;


	/**
	 * @Field : 取消原因
	 */
	private String cancelReason;

	 /**
	  *  @Field :
	 */
	private String applyType;

	/**
	 *  @Field :
	 */
	private String contNo;

}