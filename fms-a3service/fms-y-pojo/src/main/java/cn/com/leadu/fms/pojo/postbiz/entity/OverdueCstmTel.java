package cn.com.leadu.fms.pojo.postbiz.entity;

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
 * @author lijunjun
 * @ClassName: OverdueCstmTel
 * @Description: 逾期客户电话信息实体
 * @date 2018-05-17
 */
@Data
public class OverdueCstmTel extends BaseEntity<OverdueCstmTel> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户电话信息ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueCstmTelId;

	/**
	 * @Fields  : 主贷人证件号码
	 * @author lijunjun
	 */
	private String certifNo;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 关系类型
	 * @author lijunjun
	 */
	private String relationType;

	/**
	 * @Fields  : 电话号码
	 * @author lijunjun
	 */
	private String telNo;
}