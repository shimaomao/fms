package cn.com.leadu.fms.original.validator.filesend.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FileSendVo
 * @Description: 资料邮寄保存时载体及验证
 * @date 2018-05-04
 */
@Data
public class FileSendSaveVo extends BaseVo<FileSend> {

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
	 * @Fields  : 邮寄文件集合
	 * @author ningyangyang
	 */
	List<OrigFileDetail> origFileDetails;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark;
}