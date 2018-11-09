package cn.com.leadu.fms.pojo.prebiz.vo.contract;

import lombok.Data;

/**
 * @author huzongcheng
 * @ClassName: ApplyBaseInfoVo
 * @Description: 申请详情顶部蓝色字体信息
 */
@Data
public class ContBaseInfoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 合同状态
	 */
	private String bizStatus;

	/**
	 * @Fields  :当前节点账号
	 */
	private String presentUser;


	/**
	 * @Fields  : 当前节点用户姓名
	 */
	private String presentUserName;

	/**
	 * @Fields  : 还款状态
	 */
	private String paymentSts;


}