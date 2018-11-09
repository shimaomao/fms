package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.vo.PageQuery;
import lombok.Data;

/**
 * @author huzongcheng
 * @ClassName: BasicChangeTaskVo
 * @Description: 个人基本信息变更联系人载体
 * @date 2018-08-31
 */
@Data
public class PersContactsVo extends PageQuery<PersContactsVo> {

	private static final long serialVersionUID = 1L;


	/**
	 * @Fields  : 联系人
	 * @author huzongcheng
	 */
	private String contactName;

	/**
	 * @Fields  : 数据类型
	 * @author huzongcheng
	 */
	private String solveType;

}