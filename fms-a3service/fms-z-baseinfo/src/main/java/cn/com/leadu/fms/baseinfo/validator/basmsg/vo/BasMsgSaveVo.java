package cn.com.leadu.fms.baseinfo.validator.basmsg.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import lombok.Data;

/**
 * @author wubaoliang
 * @ClassName: BasMsgVo
 * @Description: 短信发送管理保存时载体及验证
 * @date 2018-03-09
 */
@Data
public class BasMsgSaveVo extends BaseVo<BasMsg> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 短信发送ID
	 */
	private String msgId;

	/**
	 * @Fields  : 短信类型ID
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
	 * @Fields  : 短信发送状态
	 */
	private String msgStatus;

}