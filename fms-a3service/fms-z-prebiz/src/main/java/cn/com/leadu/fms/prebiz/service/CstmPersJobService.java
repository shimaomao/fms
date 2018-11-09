package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobService
 * @Description: 客户个人职业信息业务层
 * @date 2018-03-26
 */
public interface CstmPersJobService {

	/**
	 * @Title:
	 * @Description: 分页查询客户个人职业信息
	 * @param cstmPersJobVo
	 * @return PageInfoExtend<CstmPersJob>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	PageInfoExtend<CstmPersJob> findCstmPersJobsByPage(CstmPersJobVo cstmPersJobVo);

	/**
	 * @Title:
	 * @Description: 保存客户个人职业信息
	 * @param cstmPersJobSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
    void saveCstmPersJob(CstmPersJobSaveVo cstmPersJobSaveVo,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户个人职业信息
	 * @param cstmPersJobModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	void modifyCstmPersJob(CstmPersJobModifyVo cstmPersJobModifyVo);

	/**
	 * @Title:
	 * @Description:  通过persJobId删除客户个人职业信息
	 * @param cstmPersJobDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	void deleteCstmPersJob(CstmPersJobDeleteVo cstmPersJobDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过persJobId集合删除客户个人职业信息
	 * @param cstmPersJobDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	void deleteCstmPersJobsByPersJobIds(CstmPersJobDeleteListVo cstmPersJobDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据persJobId获取客户个人职业信息
	 * @param persJobId
	 * @return CstmPersJob
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	CstmPersJob findCstmPersJobByPersJobId(String persJobId);

	/**
	 * 根据订单编号获取职业信息
	 * @param applyNo
	 * @return
	 */
	 CstmPersJob findCstmPersJobByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户个人职业信息
	 * @param cstmPersJob
	 * @return CstmPersJob
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:48
	 */
	void updateCstmPersJobByApplyNo(CstmPersJob cstmPersJob,String applyNo);
}
