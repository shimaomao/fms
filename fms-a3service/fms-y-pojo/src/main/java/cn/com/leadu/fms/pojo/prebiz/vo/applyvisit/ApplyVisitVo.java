package cn.com.leadu.fms.pojo.prebiz.vo.applyvisit;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVisit;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: ApplyVisitVo
 * @Description: 贷前家访载体
 * @date 2018-06-04
 */
@Data
public class ApplyVisitVo extends PageQuery<ApplyVisit> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 贷前家访id
	 * @author liujinge
	 */
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

	/**
	 * @Fields  : 贷前家访id
	 * @author liujinge
	 */
	private List<String> applyVisitIds;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 不家访原因
	 * @author ningyangyang
	 */
	private String reason;

	@NotNull(message = "请上传家访附件")
	@Size(min = 1 , message = "请上传家访附件")
	@Valid
	private List<BizFilesVo> bizFilesList;

	/**
	 * @Fields  : 回显附件
	 * @author ningyangyang
	 */
	private List<BizFiles> bizFiles;


}