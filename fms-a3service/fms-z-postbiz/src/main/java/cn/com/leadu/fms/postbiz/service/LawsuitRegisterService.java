package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterSaveVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterModifyVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterDeleteVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterService
 * @Description: 诉讼登记信息业务层
 */
public interface LawsuitRegisterService {

	/**
	 * @Title:
	 * @Description: 分页查询诉讼登记信息
	 * @param lawsuitRegisterVo
	 * @return PageInfoExtend<LawsuitRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	PageInfoExtend<LawsuitRegister> findLawsuitRegistersByPage(LawsuitRegisterVo lawsuitRegisterVo);

	/**
	 * @Title:
	 * @Description: 保存诉讼登记信息
	 * @param lawsuitRegisterSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
    void saveLawsuitRegister(LawsuitRegisterSaveVo lawsuitRegisterSaveVo);


	/**
	 * @Title:
	 * @Description: 修改诉讼登记信息
	 * @param lawsuitRegisterModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	void modifyLawsuitRegister(LawsuitRegisterModifyVo lawsuitRegisterModifyVo);

	/**
	 * @Title:
	 * @Description:  通过lawsuitRegisterId删除诉讼登记信息
	 * @param lawsuitRegisterDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	void deleteLawsuitRegister(LawsuitRegisterDeleteVo lawsuitRegisterDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过lawsuitRegisterId集合删除诉讼登记信息
	 * @param lawsuitRegisterDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	void deleteLawsuitRegistersByLawsuitRegisterIds(LawsuitRegisterDeleteListVo lawsuitRegisterDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据lawsuitRegisterId获取诉讼登记信息
	 * @param lawsuitRegisterId
	 * @return LawsuitRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-12 15:55:46
	 */
	LawsuitRegister findLawsuitRegisterByLawsuitRegisterId(String lawsuitRegisterId);

}
