package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangePostVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeService
 * @Description: 企业基本信息变更业务层
 * @date 2018-09-01
 */
public interface CompanyBasicChangeService {

	/**
	 * @Title:
	 * @Description: 保存企业基本信息变更
	 * @param companyBasicChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
    void saveCompanyBasicChange(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  根据companyTaskNo获取企业基本信息变更
	 * @param companyTaskNo
	 * @return CompanyBasicChangePostVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	CompanyBasicChangePostVo findCstmCompanyByTaskNo(String companyTaskNo);

	/**
	 * @Title:
	 * @Description:  根据companyTaskNo获取企业基本信息变更
	 * @param applyNo
	 * @param companyTaskNo
	 * @return CompanyBasicChangePostVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	CompanyBasicChangePostVo findApplyCstmPersonByApplyNo(String applyNo, String companyTaskNo);

	/**
	 * @Title:
	 * @Description:  资管审核通过
	 * @param companyBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	void companyBasicChangeApproval(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管审核退回
	 * @param companyBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	void companyBasicChangeBack(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核通过
	 * @param companyBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	void companyBasicChangeReview(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核退回
	 * @param companyBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:10:36
	 */
	void companyBasicChangeReviewBack(CompanyBasicChangePostVo companyBasicChangePostVo, SysUser sysUser);

}
