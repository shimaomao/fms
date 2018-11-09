package cn.com.leadu.fms.system.validator.sysfile.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysFileVo
 * @Description: 菜单修改时载体及验证
 * @date 2018-03-01
 */
@Data
public class SysFileModifyVo extends BaseVo<SysFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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