package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangePostVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeService
 * @Description: 个人基本信息变更表业务层
 * @date 2018-08-31
 */
public interface PersonBasicChangeService {

	/**
	 * @Title:
	 * @Description: 保存个人基本信息变更表
	 * @param personBasicChangePostVo
	 * @param sysUser
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
    void savePersonBasicChange(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  根据personTaskNo获取个人基本信息变更表
	 * @param personTaskNo
	 * @return PersonBasicChangePostVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PersonBasicChangePostVo findCstmPersonByTaskNo(String personTaskNo);

	/**
	 * @Title:
	 * @Description:  根据personTaskNo获取个人基本信息变更表
	 * @param applyNo
	 * @param personTaskNo
	 * @return PersonBasicChangePostVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	PersonBasicChangePostVo findApplyCstmPersonByApplyNo(String applyNo, String personTaskNo);

	/**
	 * @Title:
	 * @Description:  资管审核通过
	 * @param personBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	void personBasicChangeApproval(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管审核退回
	 * @param personBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	void personBasicChangeBack(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核通过
	 * @param personBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	void personBasicChangeReview(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  资管复核退回
	 * @param personBasicChangePostVo
	 * @param sysUser
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-8-31 18:16:22
	 */
	void personBasicChangeReviewBack(PersonBasicChangePostVo personBasicChangePostVo, SysUser sysUser);

}
