package cn.com.leadu.fms.pojo.system.vo.sysgrouplevel;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import lombok.Data;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelVo
 * @Description: 用户组层级载体
 * @date 2018-03-08
 */
@Data
public class SysGroupLevelVo extends PageQuery<SysGroupLevel> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 层级ID
	 */
	private String groupLevId;

	/**
	 * @Fields  : 层级代码
	 */
	private String groupLev;

	/**
	 * @Fields  : 层级名称
	 */
	private String groupLevName;

	/**
	 * @Fields  : 启用标识
	 */
	private String enableFlag;

	/**
	 * @Fields  : 层级ID集合
	 */
	private List<String> groupLevIds;

}