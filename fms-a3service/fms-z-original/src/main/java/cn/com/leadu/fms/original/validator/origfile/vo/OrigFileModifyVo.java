package cn.com.leadu.fms.original.validator.origfile.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: OrigFileVo
 * @Description: 资料邮寄附件修改时载体及验证
 * @date 2018-05-03
 */
@Data
public class OrigFileModifyVo extends BaseVo<OrigFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String origFileId;

	/**
	 * @Fields  : 资料邮寄业务号
	 * @author ningyangyang
	 */
	private String bizCode;

	/**
	 * @Fields  : 资料邮寄业务类型
	 * @author ningyangyang
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 归档附件大类
	 * @author yangyiquan
	 */
	private String origFileType;

	/**
	 * @Fields  : 归档编号
	 * @author ningyangyang
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 归档状态
	 * @author ningyangyang
	 */
	private String origFileStatus;

	/**
	 * @Fields  : 归档日期
	 * @author ningyangyang
	 */
	private Date origFileDate;

	/**
	 * @Fields  : 归档用户
	 * @author ningyangyang
	 */
	private String origFileUser;

	/**
	 * @Fields  : 归档用户所属机构
	 * @author ningyangyang
	 */
	private String origFileGroup;

}