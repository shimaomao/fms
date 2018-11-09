package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcardcheck.PycreditCardCheckVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckService
 * @Description: 卡核查及交易业务层
 * @date 2018-06-14
 */
public interface PycreditCardCheckService {

	/**
	 * @Title:
	 * @Description: 分页查询卡核查及交易
	 * @param pycreditCardCheckVo
	 * @return PageInfoExtend<PycreditCardCheck>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PageInfoExtend<PycreditCardCheck> findPycreditCardChecksByPage(PycreditCardCheckVo pycreditCardCheckVo);

	/**
	 * @Title:
	 * @Description: 保存卡核查及交易
	 * @param pycreditCardCheckSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
    void savePycreditCardCheck(PycreditCardCheckSaveVo pycreditCardCheckSaveVo);


	/**
	 * @Title:
	 * @Description: 修改卡核查及交易
	 * @param pycreditCardCheckModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	void modifyPycreditCardCheck(PycreditCardCheckModifyVo pycreditCardCheckModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditCardCheckId删除卡核查及交易
	 * @param pycreditCardCheckDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	void deletePycreditCardCheck(PycreditCardCheckDeleteVo pycreditCardCheckDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditCardCheckId集合删除卡核查及交易
	 * @param pycreditCardCheckDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	void deletePycreditCardChecksByPycreditCardCheckIds(PycreditCardCheckDeleteListVo pycreditCardCheckDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditCardCheckId获取卡核查及交易
	 * @param pycreditCardCheckId
	 * @return PycreditCardCheck
	 * @throws
	 * @author yangyiquan
	 * @date 2018-6-14 19:59:30
	 */
	PycreditCardCheck findPycreditCardCheckByPycreditCardCheckId(String pycreditCardCheckId);

}
