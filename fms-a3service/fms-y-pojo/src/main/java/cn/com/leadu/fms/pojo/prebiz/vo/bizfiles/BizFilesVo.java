package cn.com.leadu.fms.pojo.prebiz.vo.bizfiles;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author huchenghao
 * @ClassName: BizFilesVo
 * @Description: 附件信息载体
 * @date 2018-04-09
 */
@Data
public class BizFilesVo extends PageQuery<BizFiles> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件ID
	 */
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

	/**
	 * @Fields  : 附件ID
	 */
	private List<String> fileIds;

}