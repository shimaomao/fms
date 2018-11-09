package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmperson.vo.CstmPersonDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonService
 * @Description: 客户个人基本信息业务层
 * @date 2018-03-26
 */
public interface CstmPersonService {

	/**
	 * @Title:
	 * @Description: 分页查询客户个人基本信息
	 * @param cstmPersonVo
	 * @return PageInfoExtend<CstmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	PageInfoExtend<CstmPerson> findCstmPersonsByPage(CstmPersonVo cstmPersonVo);

	/**
	 * @Title:
	 * @Description: 保存客户个人基本信息
	 * @param cstmPersonSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
    void saveCstmPerson(CstmPersonSaveVo cstmPersonSaveVo,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户个人基本信息
	 * @param cstmPersonModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	void modifyCstmPerson(CstmPersonModifyVo cstmPersonModifyVo);

	/**
	 * @Title:
	 * @Description:  通过cstmPersonId删除客户个人基本信息
	 * @param cstmPersonDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	void deleteCstmPerson(CstmPersonDeleteVo cstmPersonDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过cstmPersonId集合删除客户个人基本信息
	 * @param cstmPersonDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	void deleteCstmPersonsByCstmPersonIds(CstmPersonDeleteListVo cstmPersonDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据cstmPersonId获取客户个人基本信息
	 * @param cstmPersonId
	 * @return CstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	CstmPerson findCstmPersonByCstmPersonId(String cstmPersonId);

	/**
	 * @Description: 根据订单编号获取客户信息
	 * @param: [applyNo]
	 * @return: cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson
	 * @Author: yangyiquan
	 * @Date: 2018/7/13 16:31
	 */
	CstmPerson findCstmPersonByApplyNo(String applyNo);

	/**
	 * @Description: 根据certifNo获取所有客户信息,排除applyNo
	 * @param: [certifNo, applyNo]
	 * @return: java.util.List<cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson>
	 * @Author: yangyiquan
	 * @Date: 2018/7/13 16:30
	 */
	List<CstmPerson> findCstmPersonListByCertifNo(String certifNo,String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户个人基本信息
	 * @param cstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 11:27:21
	 */
	void updateCstmpersonByapplyNo(CstmPerson cstmPerson,String applyNo);

}
