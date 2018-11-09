package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterService
 * @Description: 电话催收登记信息业务层
 * @date 2018-05-17
 */
public interface OverdueTelRegisterService {

	/**
	 * @Title:
	 * @Description: 分页查询电话催收登记信息
	 * @param overdueTelRegisterVo
	 * @return PageInfoExtend<OverdueTelRegister>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	PageInfoExtend<OverdueTelRegister> findOverdueTelRegistersByPage(OverdueTelRegisterVo overdueTelRegisterVo);

	/**
	 * @Title:
	 * @Description: 保存电话催收登记信息
	 * @param overdueTelRegisterSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
    void saveOverdueTelRegister(OverdueTelRegisterSaveVo overdueTelRegisterSaveVo);


	/**
	 * @Title:
	 * @Description: 修改电话催收登记信息
	 * @param overdueTelRegisterModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	void modifyOverdueTelRegister(OverdueTelRegisterModifyVo overdueTelRegisterModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueTelRegisterId删除电话催收登记信息
	 * @param overdueTelRegisterDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	void deleteOverdueTelRegister(OverdueTelRegisterDeleteVo overdueTelRegisterDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueTelRegisterId集合删除电话催收登记信息
	 * @param overdueTelRegisterDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	void deleteOverdueTelRegistersByOverdueTelRegisterIds(OverdueTelRegisterDeleteListVo overdueTelRegisterDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据overdueTelRegisterId获取电话催收登记信息
	 * @param overdueTelRegisterId
	 * @return OverdueTelRegister
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 11:01:07
	 */
	OverdueTelRegister findOverdueTelRegisterByOverdueTelRegisterId(String overdueTelRegisterId);

}
