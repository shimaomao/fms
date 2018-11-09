package cn.com.leadu.fms.pojo.system.entity;

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
 * @ClassName: SysAnnouncement
 * @Description: 利率因子实体
 * @date 2018-04-27
 */
@Data
public class SysAnnouncement extends BaseEntity<SysAnnouncement> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 公告id
	 * @author lijunjun
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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