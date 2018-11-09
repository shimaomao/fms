package cn.com.leadu.fms.system.validator.sysfile.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: SysFileVo
 * @Description: 菜单保存时载体及验证
 * @date 2018-03-01
 */
@Data
public class SysFileSaveVo extends BaseVo<SysFile> {

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