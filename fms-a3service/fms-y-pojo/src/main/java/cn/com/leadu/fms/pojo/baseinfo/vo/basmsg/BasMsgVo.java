package cn.com.leadu.fms.pojo.baseinfo.vo.basmsg;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasMsgVo
 * @Description: 短信发送管理表载体
 * @date 2018-03-15
 */
@ExcelTitle(value = "短信发送信息")
@Data
public class BasMsgVo extends PageQuery<BasMsg> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 短信发送ID
	 */
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
	 * @Fields  : 备注
	 */
	private String memo;
	/**
	 * @Fields  : 短信发送状态
	 */
	private String msgStatus;

	/**
	 * @Fields  : 短信发送ID
	 */
	private List<String> msgIds;

	/**
	 * @Fields  : 类型名称
	 */

	private String tplTypeName;

	@ExcelTitle(value = "手机号码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getTelNo(){
		return this.telNo;
	}

	@ExcelTitle(value = "短信内容", sort = 2)
	public String getMsgText(){
		return this.msgText;
	}

	@ExcelTitle(value = "短信发送状态", sort = 3,codeType = CommonCodeTypeConstants.MSG_STATUS)
	public String getMsgStatus(){
		return this.msgStatus;
	}

	@ExcelTitle(value = "短信分类", sort = 4)
	public String getTplTypeName(){
		return tplTypeName;
	}

	@ExcelTitle(value = "更新时间", sort = 5)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 6)
	public String getUpdater(){
		return updater;
	}

}