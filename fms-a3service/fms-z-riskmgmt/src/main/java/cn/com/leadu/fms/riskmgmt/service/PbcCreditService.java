package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pbccredit.PbcCreditVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PbcCreditService
 * @Description: 个人人行征信信息业务层
 * @date 2018-06-04
 */
public interface PbcCreditService {

	/**
	 * @Title:
	 * @Description: 分页查询个人人行征信信息
	 * @param pbcCreditVo
	 * @return PageInfoExtend<PbcCredit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PageInfoExtend<PbcCredit> findPbcCreditsByPage(PbcCreditVo pbcCreditVo);

	/**
	 * @Title:
	 * @Description: 保存个人人行征信信息
	 * @param pbcCreditSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
    void savePbcCredit(PbcCreditSaveVo pbcCreditSaveVo);


	/**
	 * @Title:
	 * @Description: 修改个人人行征信信息
	 * @param pbcCreditModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	void modifyPbcCredit(PbcCreditModifyVo pbcCreditModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pbcCreditId删除个人人行征信信息
	 * @param pbcCreditDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	void deletePbcCredit(PbcCreditDeleteVo pbcCreditDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pbcCreditId集合删除个人人行征信信息
	 * @param pbcCreditDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	void deletePbcCreditsByPbcCreditIds(PbcCreditDeleteListVo pbcCreditDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pbcCreditId获取个人人行征信信息
	 * @param pbcCreditId
	 * @return PbcCredit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PbcCredit findPbcCreditByPbcCreditId(String pbcCreditId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取银行账号信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	List<PbcCredit> findPbcCreditListByApplyNo(String applyNo);
}
