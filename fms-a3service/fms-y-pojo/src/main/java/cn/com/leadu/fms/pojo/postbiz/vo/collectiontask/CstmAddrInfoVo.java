package cn.com.leadu.fms.pojo.postbiz.vo.collectiontask;

import lombok.Data;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskVo
 * @Description: 催收任务载体
 */
@Data
public class CstmAddrInfoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 申请编号
	 */
	private String applyNo;

	/**
	 * 联系人姓名
	 */
	private String name;

	/**
	 * 联系人关系
	 */
	private String relationType;

	/**
	 * 联系人号码
	 */
	private String mobileNo;

	/**
	 * 地址类型
	 */
	private String addrType;

	/**
	 * 联系人地址
	 */
	private String resideAddr;

}