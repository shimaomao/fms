package cn.com.leadu.fms.pojo.system.vo.sysinfo;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoVo
 * @Description: 消息管理载体
 * @date 2018-04-25
 */
@Data
public class SysInfoVo extends PageQuery<SysInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 消息id
	 * @author qiaomengnan
	 */
	private String infoId;

	/**
	 * @Fields  : 消息级别
	 * @author qiaomengnan
	 */
	private String infoLevel;

	/**
	 * @Fields  : 消息分类
	 * @author qiaomengnan
	 */
	private String infoType;

	/**
	 * @Fields  : 消息内容
	 * @author qiaomengnan
	 */
	private String infoContent;

	/**
	 * @Fields  : 消息id
	 * @author qiaomengnan
	 */
	private List<String> infoIds;

}