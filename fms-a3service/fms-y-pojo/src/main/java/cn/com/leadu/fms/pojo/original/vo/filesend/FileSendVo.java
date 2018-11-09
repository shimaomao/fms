package cn.com.leadu.fms.pojo.original.vo.filesend;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FileSendVo
 * @Description: 资料邮寄载体
 * @date 2018-05-04
 */
@Data
public class FileSendVo extends PageQuery<FileSend> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author ningyangyang
	 */
	private String filePostId;

	/**
	 * @Fields  : 快递公司
	 * @author ningyangyang
	 */
	private String postComp;

	/**
	 * @Fields  : 快递日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 快递编号
	 * @author ningyangyang
	 */
	private String postNo;

	/**
	 * @Fields  : 邮寄快递人员
	 * @author ningyangyang
	 */
	private String postMember;

	/**
	 * @Fields  : 联系电话
	 * @author ningyangyang
	 */
	private String postMemberTel;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author ningyangyang
	 */
	private List<String> filePostIds;
	/**
	 * @Fields  : 邮寄文件集合
	 * @author ningyangyang
	 */
	private List<OrigFileDetail> origFileDetails;

	/**
	 * @Fields  : 任务id
	 * @author ningyangyang
	 */
	private String taskId;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark;
}