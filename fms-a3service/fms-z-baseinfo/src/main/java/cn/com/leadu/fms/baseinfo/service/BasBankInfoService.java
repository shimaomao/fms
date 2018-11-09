package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.BasBankInfoDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoService
 * @Description: 银行账号维护业务层
 * @date 2018-03-26
 */
public interface BasBankInfoService {

	/**
	 * @Title:
	 * @Description: 分页查询银行账号维护
	 * @param basBankInfoVo
	 * @return PageInfoExtend<BasBankInfo>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	PageInfoExtend<BasBankInfoVo> findBasBankInfosByPage(BasBankInfoVo basBankInfoVo);

	/**
	 * @Title:
	 * @Description: 保存银行账号维护
	 * @param basBankInfoSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
    void saveBasBankInfo(BasBankInfoSaveVo basBankInfoSaveVo,SysUser sysUser);


	/**
	 * @Title:
	 * @Description: 修改银行账号维护
	 * @param basBankInfoModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	void modifyBasBankInfo(BasBankInfoModifyVo basBankInfoModifyVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  通过bankId删除银行账号维护
	 * @param basBankInfoDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	void deleteBasBankInfo(BasBankInfoDeleteVo basBankInfoDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过bankId集合删除银行账号维护
	 * @param basBankInfoDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	void deleteBasBankInfosByBankIds(BasBankInfoDeleteListVo basBankInfoDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据bankId获取银行账号维护
	 * @param bankId
	 * @return BasBankInfo
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	BasBankInfoVo findBasBankInfoByBankId(String bankId,String serviceId);

	/**
	 * @Title:
	 * @Description: 银行账号维护审核通过
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void approval(BasBankInfoVo basBankInfoVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 银行账号审核退回
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void sendBack(BasBankInfoVo basBankInfoVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 根据机构获取银行账号维护
	 * @param
	 * @return
	 * @throws
	 * @author liujinge
	 * @date
	 */
	BasBankInfo findBasBankInfoByOrg(String organizationType, String organizationId);

	/**
	* @Description: 根据银行账号获取财务科目代码
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/8/1 11:56
	*/
	String findFinassSubjectCd(String accountNo);

	/**
	* @Description: 根据银行账号获取银行信息
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/10/10 13:55
	*/
	BasBankInfo findBasBankInfoByAccountNo(String accountNo);
}
