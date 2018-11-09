package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxSaveVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxModifyVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxDeleteVo;
import cn.com.leadu.fms.postbiz.validator.licenseidx.vo.LicenseIdxDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author license_idx
 * @ClassName: LicenseIdxService
 * @Description: 指标管理表业务层
 */
public interface LicenseIdxService {

	/**
	 * @Title:
	 * @Description: 分页查询指标管理表
	 * @param licenseIdxVo
	 * @return PageInfoExtend<LicenseIdx>
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	PageInfoExtend<LicenseIdxVo> findLicenseIdxVosByPage(LicenseIdxVo licenseIdxVo);

	/**
	 * @Title:
	 * @Description: 保存指标管理表
	 * @param licenseIdxSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
    void saveLicenseIdx(LicenseIdxSaveVo licenseIdxSaveVo);


	/**
	 * @Title:
	 * @Description: 修改指标管理表
	 * @param licenseIdxModifyVo
	 * @return
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	void modifyLicenseIdx(LicenseIdxModifyVo licenseIdxModifyVo);

	/**
	 * @Title:
	 * @Description:  通过licenseIdxId删除指标管理表
	 * @param licenseIdxDeleteVo
	 * @return
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	void deleteLicenseIdx(LicenseIdxDeleteVo licenseIdxDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过licenseIdxId集合删除指标管理表
	 * @param licenseIdxDeleteListVo
	 * @return
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	void deleteLicenseIdxsByLicenseIdxIds(LicenseIdxDeleteListVo licenseIdxDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据licenseIdxId获取指标管理表
	 * @param licenseIdxId
	 * @return LicenseIdx
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	LicenseIdx findLicenseIdxByLicenseIdxId(String licenseIdxId);

	/**
	 * @Title:
	 * @Description:  根据licenseIdxId获取指标管理表
	 * @param licenseIdxId
	 * @return LicenseIdx
	 * @throws
	 * @author license_idx
	 * @date 2018-9-12 11:38:16
	 */
	LicenseIdxVo findLicenseIdxVoByLicenseIdxId(String licenseIdxId);

	/**
	 * @Title:
	 * @Description:  根据licenseIdxNo获取指标管理表是否存在
	 * @param licenseIdxNo
	 * @return
	 * @throws
	 * @author license_idx
	 * @date 2018-9-13 11:38:16
	 */
	LicenseIdxVo checkLicenseIdxVoBylicenseIdxNo(String licenseIdxNo);

	/**
	 * @Title:
	 * @Description: 修改指标管理表
	 * @param licenseIdxId
	 * @author license_idx
	 * @date 2018-9-13 11:38:16
	 */
	void modifyLicenseIdxVoBylicenseIdx(String licenseIdxId,String licenseIdxzt);

	/**
	 * @Title:
	 * @Description:  根据用户代码查询未使用指标信息
	 * @throws
	 * @author license_idx
	 * @date 2018-9-20 11:38:16
	 */
	PageInfoExtend<LicenseIdxVo> findLicenseIdxVoBylicenseIdxlist(LicenseIdxVo licenseIdxVo);
}
