package cn.com.leadu.fms.pojo.system.vo.sysfile;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: SysFileVo
 * @Description: 菜单载体
 * @date 2018-03-01
 */
@Data
public class SysFileVo extends PageQuery<SysFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String id;

	/**
	 * @Fields  : 
	 */
	private String fileName;

	/**
	 * @Fields  : 
	 */
	private String filePath;

	/**
	 * @Fields  : 
	 */
	private Integer fileDownNum;

}