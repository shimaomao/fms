package cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.CompanyBasicChange;
import lombok.Data;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeVo
 * @Description: 企业基本信息变更载体
 * @date 2018-09-01
 */
@Data
public class CompanyBasicChangePostVo extends PageQuery<CompanyBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * 变更前
	 */
	private CompanyBasicChangeVo oldCompanyBasicChangeVo;
	/**
	 * 变更后
	 */
	private CompanyBasicChangeVo newCompanyBasicChangeVo;

	/**
	 * taskId
	 */
	private String taskId;

	/**
	 * 任务号
	 */
	private String basicTaskNo;
}