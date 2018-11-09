package cn.com.leadu.fms.insurance.service;

import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimSaveVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimModifyVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimService
 * @Description: 保险理赔业务层
 * @date 2018-05-14
 */
public interface ContInsurClaimService {

	/**
	 * @Title:
	 * @Description: 分页查询保险理赔一览
	 * @param contInsurClaimVo
	 * @return PageInfoExtend<ContInsurClaim>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPage(ContInsurClaimVo contInsurClaimVo);

	/**
	 * @Title:
	 * @Description: 分页查询保险理赔查询页面
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPageSelect(ContInsurClaimVo contInsurClaimVo);

	/**
	 * @Title:
	 * @Description: 保险理赔excel导出
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public PageInfoExtend<ContInsurClaimVo> findContInsurClaimsByPageSelect2(ContInsurClaimVo contInsurClaimVo);

	/**
	 * @Title:
	 * @Description: 保存保险理赔
	 * @param contInsurClaimVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	void saveContInsurClaim(ContInsurClaimVo contInsurClaimVo,SysUser sysUser);



	/**
	 * @Title:
	 * @Description: 修改保险理赔
	 * @param contInsurClaimModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	void modifyContInsurClaim(ContInsurClaimModifyVo contInsurClaimModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contInsurClaimId删除保险理赔
	 * @param contInsurClaimDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	void deleteContInsurClaim(ContInsurClaimDeleteVo contInsurClaimDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contInsurClaimId集合删除保险理赔
	 * @param contInsurClaimDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	void deleteContInsurClaimsByContInsurClaimIds(ContInsurClaimDeleteListVo contInsurClaimDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contInsurClaimId获取保险理赔
	 * @param contInsurClaimId
	 * @return ContInsurClaim
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	ContInsurClaim findContInsurClaimByContInsurClaimId(String contInsurClaimId);

	/**
	 * @Title:
	 * @Description: 根据合同编号和保险信息id查询一条明细
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public ContInsurClaimVo findDetailedByContNo(String contVehinsId,String contInsurClaimId,String serviceId);

	/**
	 * @Title:
	 * @Description: 取保险理赔详情
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public ContInsurClaimVo findDetailContInsurClaim(String serviceId);

}
