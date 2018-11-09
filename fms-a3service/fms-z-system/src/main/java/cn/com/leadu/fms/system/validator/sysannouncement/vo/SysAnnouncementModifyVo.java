package cn.com.leadu.fms.system.validator.sysannouncement.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import lombok.Data;

import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementVo
 * @Description: 利率因子修改时载体及验证
 * @date 2018-04-27
 */
@Data
public class SysAnnouncementModifyVo extends BaseVo<SysAnnouncement> {

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
	private String announceTitle;

	/**
	 * @Fields  : 公告内容
	 * @author lijunjun
	 */
	private String announceCotent;

	/**
	 * @Fields  : 公告日期
	 * @author lijunjun
	 */
	private Date announceDate;

	/**
	 * @Fields  : 公告附件
	 * @author lijunjun
	 */
	private String announceFile;

	/**
	 * @Fields  : 启用标志
	 * @author lijunjun
	 */
	private String enableFlag;

}