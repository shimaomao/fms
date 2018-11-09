package cn.com.leadu.fms.pojo.original.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FileSend
 * @Description: 资料邮寄实体
 * @date 2018-05-04
 */
@Data
public class FileSend extends BaseEntity<FileSend> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String filePostId;

	/**
	 * @Fields  : 快递状态
	 * @author ningyangyang
	 */
	private String postStatus;
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
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark;

}