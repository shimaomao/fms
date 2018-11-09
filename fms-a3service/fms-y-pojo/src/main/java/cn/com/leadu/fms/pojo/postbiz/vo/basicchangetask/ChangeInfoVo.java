package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.vo.PageQuery;
import lombok.Data;

/**
 * @author huzongcheng
 * @ClassName: BasicChangeTaskVo
 * @Description: 展期、增加保证金、变更承租人变更任务号载体
 * @date 2018-08-31
 */
@Data
public class ChangeInfoVo extends PageQuery<ChangeInfoVo> {

	private static final long serialVersionUID = 1L;


	/**
	 * @Fields  : 展期任务号
	 * @author huzongcheng
	 */
	private String deferTaskNo;

	/**
	 * @Fields  : 增加保证金任务号
	 * @author huzongcheng
	 */
	private String depositTaskNo;

	/**
	 * @Fields  : 变更承租人任务号
	 * @author huzongcheng
	 */
	private String lesseeTaskNo;

}