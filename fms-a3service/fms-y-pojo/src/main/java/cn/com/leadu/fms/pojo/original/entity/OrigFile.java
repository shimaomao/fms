package cn.com.leadu.fms.pojo.original.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: OrigFile
 * @Description: 资料邮寄附件实体
 * @date 2018-05-03
 */
@Data
public class OrigFile extends BaseEntity<OrigFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料ID
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	/**
	 * @Fields  : 归档期限
	 * @author ningyangyang
	 */
	private Date origDeadline;

	/**
	 * @Fields  : 客户姓名
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 归档任务号
	 * @author ningyangyang
	 */
	private String origFileTaskNo;

	/**
	 * @Fields  : 归档任务状态
	 * @author ningyangyang
	 */
	private String origFileTaskStatus;

	/**
	 * @Fields  : 归档车架号
	 * @author yanfengbo
	 */
	private String origVinNo;

	/**
	 * @Fields  : 归档发动机号
	 * @author yanfengbo
	 */
	private String origEngineeNo;

	/**
	 * @Fields  : 归档备注
	 * @author yanfengbo
	 */
	private String origMemo;

}