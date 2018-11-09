package cn.com.leadu.fms.pojo.prebiz.vo.bizactstatus;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.BizActStatus;
import lombok.Data;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BizActStatusVo
 * @Description: 业务状态管理载体
 * @date 2018-03-27
 */
@Data
public class BizActStatusVo extends PageQuery<BizActStatus> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String actStsId;

	/**
	 * @Fields  : 
	 */
	private String actStsType;

	/**
	 * @Fields  : 
	 */
	private String actWidgetId;

	/**
	 * @Fields  : 
	 */
	private String befStatus;

	/**
	 * @Fields  : 
	 */
	private String aftStatus;

	/**
	 * @Fields  : 
	 */
	private List<String> actStsIds;

}