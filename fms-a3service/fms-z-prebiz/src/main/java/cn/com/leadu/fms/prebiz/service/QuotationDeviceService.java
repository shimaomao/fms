package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceDeleteVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceModifyVo;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.QuotationDeviceSaveVo;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceService
 * @Description: 报价器信息业务层
 * @date 2018-05-23
 */
public interface QuotationDeviceService {

	/**
	 * @Title:
	 * @Description: 分页查询报价器信息
	 * @param quotationDeviceVo
	 * @return PageInfoExtend<QuotationDevice>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	PageInfoExtend<QuotationDeviceVo> findQuotationDevicesByPage(QuotationDeviceVo quotationDeviceVo,SysUserVo sysUser);

	/**
	 * @Title:
	 * @Description: 保存报价器信息
	 * @param quotationDeviceSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
    void saveQuotationDevice(QuotationDeviceSaveVo quotationDeviceSaveVo);


	/**
	 * @Title:
	 * @Description: 修改报价器信息
	 * @param quotationDeviceModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	void modifyQuotationDevice(QuotationDeviceModifyVo quotationDeviceModifyVo);

	/**
	 * @Title:
	 * @Description:  通过quotationDeviceId删除报价器信息
	 * @param quotationDeviceDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	void deleteQuotationDevice(QuotationDeviceDeleteVo quotationDeviceDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过quotationDeviceId集合删除报价器信息
	 * @param quotationDeviceDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	void deleteQuotationDevicesByQuotationDeviceIds(QuotationDeviceDeleteListVo quotationDeviceDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据quotationDeviceId获取报价器信息
	 * @param quotationDeviceId
	 * @return QuotationDevice
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	QuotationDeviceVo findQuotationDeviceByQuotationDeviceId(String quotationDeviceId);

	/**
	 * @Title:
	 * @Description: 保存报价器信息
	 * @param quotationDeviceVo
	 * @return QuotationDeviceVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	QuotationDeviceVo saveQuotationDeviceInfo(QuotationDeviceVo quotationDeviceVo, String inputMode);

	/**
	 * @Title:
	 * @Description: 获取计算所需参数
	 * @return QuotationDeviceVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	QuotationDeviceVo findSysParam();


	/**
	 * @Title:
	 * @Description: 获取计算所需参数
	 * @return QuotationDeviceVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-23 17:02:03
	 */
	QuotationDeviceVo convertToQuotation(ApplyInputVo applyInputVo);

	/**
	 * @Title:
	 * @Description: 打印报价器单
	 * @param quotationDeviceVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018/06/13 01:48:00
	 */
	QuotationDeviceVo printQuotationDevice(QuotationDeviceVo quotationDeviceVo, String inputMode,SysUser sysUser);

}
