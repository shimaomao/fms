package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgagePostVo;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterSaveVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterModifyVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterService
 * @Description: 解抵押过户信息业务层
 * @date 2018-05-18
 */
public interface MortgageRegisterService {

	/**
	 * @Title:
	 * @Description: 分页查询解抵押过户一览
	 * @param mortgageRegisterVo
	 * @return PageInfoExtend<MortgageRegister>
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	PageInfoExtend<MortgageRegisterVo> findMortgageRegistersByPage(MortgageRegisterVo mortgageRegisterVo);

	/**
	 * @Description: 根据合同编号查询解抵押信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/21 14:30
	 */
	MortgageRegister findMortgageRegisterByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 保存解抵押过户信息
	 * @param mortgageRegisterSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
    void saveMortgageRegister(MortgageRegisterSaveVo mortgageRegisterSaveVo);

	/**
	 * @Description: 保存解抵押资料邮寄信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/22 16:59
	 */
	void saveMortgagePost(MortgagePostVo mortgagePostVo);


	/**
	 * @Title:
	 * @Description: 修改解抵押过户信息
	 * @param mortgageRegisterModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	void modifyMortgageRegister(MortgageRegisterModifyVo mortgageRegisterModifyVo);

	/**
	 * @Title:
	 * @Description:  通过mortgageRegisterId删除解抵押过户信息
	 * @param mortgageRegisterDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	void deleteMortgageRegister(MortgageRegisterDeleteVo mortgageRegisterDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过mortgageRegisterId集合删除解抵押过户信息
	 * @param mortgageRegisterDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	void deleteMortgageRegistersByMortgageRegisterIds(MortgageRegisterDeleteListVo mortgageRegisterDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据mortgageRegisterId获取解抵押过户信息
	 * @param mortgageRegisterId
	 * @return MortgageRegister
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-18 19:12:45
	 */
	MortgageRegister findMortgageRegisterByMortgageRegisterId(String mortgageRegisterId);


}
