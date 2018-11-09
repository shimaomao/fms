package cn.com.leadu.fms.pojo.system.vo.sysannouncement;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementVo
 * @Description: 利率因子载体
 * @date 2018-04-27
 */
@ExcelTitle(value = "公告信息")
@Data
public class SysAnnouncementVo extends PageQuery<SysAnnouncement> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 公告id
	 * @author lijunjun
	 */
	private String announceId;

	/**
	 * @Fields  : 公告标题
	 * @author lijunjun
	 */
	@NotBlank(message = "公告标题不能为空")
	private String announceTitle;

	/**
	 * @Fields  : 公告内容
	 * @author lijunjun
	 */
	@NotBlank(message = "公告内容不能为空")
	private String announceCotent;

	/**
	 * @Fields  : 公告日期
	 * @author lijunjun
	 */
	@NotBlank(message = "公告日期不能为空")
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date announceDate;

	/**
	 * @Fields  : 公告日期查询
	 * @author lijunjun
	 */
	private String announceDateSearch;

	/**
	 * @Fields  : 公告附件
	 * @author lijunjun
	 */
	@NotBlank(message = "公告附件不能为空")
	private String announceFile;

	/**
	 * @Fields  : 启用标志
	 * @author lijunjun
	 */
	@NotBlank(message = "启用标志不能为空")
	private String enableFlag;

	/**
	 * @Fields  : 公告id
	 * @author lijunjun
	 */
	private List<String> announceIds;

	/**
	 * @Fields  : 检索区分
	 * @author lijunjun
	 */
	private String announceSearchFlag;

	@ExcelTitle(value = "公告标题", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getAnnounceTitle() {return this.announceTitle;}

	@ExcelTitle(value = "公告内容", sort = 2)
	public String getAnnounceCotent() {return this.announceCotent;}

	@ExcelTitle(value = "公告日期", sort = 3 )
	public String getAnnounceDateStr() {return DateUtils.dateToStr(announceDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "公告附件", sort = 4 )
	public String getAnnounceFile() {return this.announceFile;}

	@ExcelTitle(value = "启用标志", sort = 5, codeType = CommonCodeTypeConstants.enableFlag)
	public String getEnableFlag() {return this.enableFlag;}

	@ExcelTitle(value = "更新时间", sort = 6)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 7)
	public String getUpdater(){
		return updater;
	}
}