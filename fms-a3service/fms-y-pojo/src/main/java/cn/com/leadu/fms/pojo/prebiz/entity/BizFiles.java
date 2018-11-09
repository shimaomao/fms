package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author huchenghao
 * @ClassName: BizFiles
 * @Description: 附件信息实体
 * @date 2018-04-09
 */
@Data
public class BizFiles extends BaseEntity<BizFiles> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String fileId;

	/**
	 * @Fields  : 所属业务代码
	 */
	private String bizCode;

	/**
	 * @Fields  : 代码类型
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 附件类型代码
	 */
	private String fileType;

	/**
	 * @Fields  : 文件名称
	 */
	private String fileName;

	/**
	 * @Fields  : 附件
	 */
	private String filePath;

}