package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersSaveVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersModifyVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersDeleteVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersService
 * @Description: 担保个人信息业务层
 * @date 2018-03-30
 */
public interface GuaranteePersService {

	/**
	 * @Title:
	 * @Description: 分页查询担保个人信息
	 * @param guaranteePersVo
	 * @return PageInfoExtend<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
	PageInfoExtend<GuaranteePers> findGuaranteePerssByPage(GuaranteePersVo guaranteePersVo);

	/**
	 * @Title:
	 * @Description: 保存担保个人信息
	 * @param guaranteePersSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
    void saveGuaranteePers(GuaranteePersSaveVo guaranteePersSaveVo);


	/**
	 * @Title:
	 * @Description: 修改担保个人信息
	 * @param guaranteePersModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
	void modifyGuaranteePers(GuaranteePersModifyVo guaranteePersModifyVo);

	/**
	 * @Title:
	 * @Description:  通过guarPersId删除担保个人信息
	 * @param guaranteePersDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
	void deleteGuaranteePers(GuaranteePersDeleteVo guaranteePersDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过guarPersId集合删除担保个人信息
	 * @param guaranteePersDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
	void deleteGuaranteePerssByGuarPersIds(GuaranteePersDeleteListVo guaranteePersDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据guarPersId获取担保个人信息
	 * @param guarPersId
	 * @return GuaranteePers
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:13
	 */
	GuaranteePers findGuaranteePersByGuarPersId(String guarPersId);

	/**
	 * 批量保存担保人信息
	 * @param guaranteePersList
	 */
	void saveGuaranteePresList(List<GuaranteePers> guaranteePersList,String applyNo);

	/**
	 * @Title:
	 * @Description:  根据订单编号获取担保人信息
	 * @param applyNo
	 * @return List<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	List<GuaranteePers> findGuaranteePersByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据订单编号更新担保人信息
	 * @param applyNo
	 * @return List<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	void  updateGuaranteePersByApplyNo(List<GuaranteePers> guaranteePersList,String applyNo);
}
