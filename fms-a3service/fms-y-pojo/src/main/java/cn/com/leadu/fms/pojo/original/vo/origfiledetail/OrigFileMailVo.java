package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: OrigFileDetailVo
 * @Description: 资料邮寄使用Vo
 * @author lijunjun
 * @date 2018-05-03
 */
@Data
public class OrigFileMailVo extends PageQuery<OrigFileDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 邮寄附件明细List
	 * @author ningyangyang
	 */
	private List<OrigFileDetailVo> origFileDetailVoList;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

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
	 * @Fields  : 快递公司
	 * @author ningyangyang
	 */
	private String postComp;

	/**
	 * @Fields  : 快递编号
	 * @author ningyangyang
	 */
	private String postNo;

	/**
	 * @Fields  : 邮寄日期
	 * @author ningyangyang
	 */
	private Date postDate;

	/**
	 * @Fields  : 任务Id
	 * @author ningyangyang
	 */
	private String taskId;

	/**
	 * @Fields  : 联系电话
	 * @author ningyangyang
	 */
	private String postMemberTel;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark;

}