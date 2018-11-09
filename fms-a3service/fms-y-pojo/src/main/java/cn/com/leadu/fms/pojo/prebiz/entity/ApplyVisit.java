package cn.com.leadu.fms.pojo.prebiz.entity;

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
 * @author liujinge
 * @ClassName: ApplyVisit
 * @Description: 贷前家访实体
 * @date 2018-06-04
 */
@Data
public class ApplyVisit extends BaseEntity<ApplyVisit> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 贷前家访id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyVisitId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 开始时间
	 * @author liujinge
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date startTime;

	/**
	 * @Fields  : 结束时间
	 * @author liujinge
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date endTime;

	/**
	 * @Fields  : 家访人员
	 * @author liujinge
	 */
	private String visitorUser;

	/**
	 * @Fields  : 接待人员
	 * @author liujinge
	 */
	private String reception;

	/**
	 * @Fields  : 接待人员电话
	 * @author liujinge
	 */
	private String receptionTel;

	/**
	 * @Fields  : 与承租人关系
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 上门地址
	 * @author liujinge
	 */
	private String location;

	/**
	 * @Fields  : 现场走访简述
	 * @author liujinge
	 */
	private String visitBriefReport;

}