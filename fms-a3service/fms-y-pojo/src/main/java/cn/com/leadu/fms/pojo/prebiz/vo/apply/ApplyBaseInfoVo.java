package cn.com.leadu.fms.pojo.prebiz.vo.apply;

import lombok.Data;

/**
 * @author huzongcheng
 * @ClassName: ApplyBaseInfoVo
 * @Description: 申请详情顶部蓝色字体信息
 */
@Data
public class ApplyBaseInfoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 申请编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 状态
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


}