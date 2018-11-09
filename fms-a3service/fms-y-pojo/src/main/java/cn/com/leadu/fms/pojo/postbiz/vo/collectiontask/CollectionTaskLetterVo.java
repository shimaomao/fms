package cn.com.leadu.fms.pojo.postbiz.vo.collectiontask;

import lombok.Data;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskVo
 * @Description: 催收任务载体
 */
@Data
public class CollectionTaskLetterVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 合同编号
	 */
	private String contNo;

	/**
	 * 申请编号
	 */
	private String applyType;

	private String collectionTaskNo;

}