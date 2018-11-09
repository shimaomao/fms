package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yanfengbo
 * @ClassName: BasMsgDao
 * @Description: 短信发送管理表实体
 * @date 2018-03-15
 */
@Data
public class BasMsg extends BaseEntity<BasMsg> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 短信发送ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String msgId;

	/**
	 * @Fields  : 短信类型识别
	 */
	private String msgTypeKey;

	/**
	 * @Fields  : 手机号
	 */
	private String telNo;

	/**
	 * @Fields  : 短信内容
	 */
	private String msgText;

	/**
	 * @Fields  : 业务备注
	 */
	private String memo;

	/**
	 * @Fields  : 短信发送状态
	 */
	private String msgStatus;


}