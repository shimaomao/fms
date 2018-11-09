package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailVo
 * @Description: 资料邮寄附件明细载体
 * @date 2018-05-03
 */
@Data
public class OrigFileDetailVo extends PageQuery<OrigFileDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	private String origFileDetailId;

	/**
	 * @Fields  : 资料邮寄业务号
	 * @author ningyangyang
	 */
	private String bizCode;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

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
	 * @Fields  : 文件类型
	 * @author ningyangyang
	 */
	private String fileType;

	/**
	 * @Fields  : 文件类型名称
	 * @author ningyangyang
	 */
	private String fileTypeName;

	/**
	 * @Fields  : 文件数量
	 * @author ningyangyang
	 */
	private Integer fileCount;
	/**
	 * @Fields  : 文件数量限制
	 * @author ningyangyang
	 */
	private Integer fileQtyLimit;

	/**
	 * @Fields  : 附件属性名
	 * @author ningyangyang
	 */
	private String fileAttr;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author ningyangyang
	 */
	private String filePostId;

	/**
	 * @Fields  : 归档编号
	 * @author ningyangyang
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 文件状态
	 * @author ningyangyang
	 */
	private String origFileDetailStatus;

	/**
	 * @Fields  : 借阅任务号
	 * @author ningyangyang
	 */
	private String borrowTaskNo;

	/**
	 * @Fields  : 借阅归还任务号
	 * @author ningyangyang
	 */
	private String borrowBackTaskNo;

	/**
	 * @Fields  : 文件补充信息1
	 * @author ningyangyang
	 */
	private String fileInfo1;

	/**
	 * @Fields  : 文件补充信息2
	 * @author ningyangyang
	 */
	private String fileInfo2;

	/**
	 * @Fields  : 文件补充信息3
	 * @author ningyangyang
	 */
	private String fileInfo3;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	private List<String> origFileDetailIds;

	/**
	 * @Fields  : 业务号集合
	 * @author ningyangyang
	 */
	private List<String> origFileDetailBizCodes;

	/**
	 * @Fields  : 业务号
	 * @author ningyangyang
	 */
	private String origFileDetailBizCode;

	/**
	 * @Fields  : 处理区分
	 * @author ningyangyang
	 */
	private String fileSolveFlag;

	/**
	 * @Fields  : 是否需要归档
	 * @author ningyangyang
	 */
	private String origFlag;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark;

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 归档任务号
	 * @author ningyangyang
	 */
	private String origFileTaskNo;

	/**
	 * @Fields  : 当前借出人
	 * @author ningyangyang
	 */
	private String borrowUser;

	/**
	 * @Fields  : 借阅用途
	 * @author : yangyiquan
	 */
	private String borrowPurpose;

}