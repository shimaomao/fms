package cn.com.leadu.fms.original.validator.origfiledetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailVo
 * @Description: 资料邮寄附件明细保存时载体及验证
 * @date 2018-05-03
 */
@Data
public class OrigFileDetailSaveVo extends BaseVo<OrigFileDetail> {

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
	 * @Fields  : 资料邮寄业务类型
	 * @author ningyangyang
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 文件类型
	 * @author ningyangyang
	 */
	private String fileType;

	/**
	 * @Fields  : 文件数量
	 * @author ningyangyang
	 */
	private Integer fileCount;

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
	 * @Fields  : 是否需要归档
	 * @author ningyangyang
	 */
	private String origFlag;

}