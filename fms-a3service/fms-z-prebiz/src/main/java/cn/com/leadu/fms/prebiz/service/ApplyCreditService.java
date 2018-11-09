package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import cn.com.leadu.fms.pojo.prebiz.vo.applycredit.ApplyCreditVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditSaveVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditModifyVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditDeleteVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditService
 * @Description: 征信信息业务层
 * @date 2018-05-15
 */
public interface ApplyCreditService {

	/**
	 * @Title:
	 * @Description: 分页查询征信信息
	 * @param applyCreditVo
	 * @return PageInfoExtend<ApplyCredit>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	PageInfoExtend<ApplyCredit> findApplyCreditsByPage(ApplyCreditVo applyCreditVo);

	/**
	 * @Title:
	 * @Description: 保存征信信息
	 * @param applyCreditSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
    void saveApplyCredit(ApplyCreditSaveVo applyCreditSaveVo);


	/**
	 * @Title:
	 * @Description: 修改征信信息
	 * @param applyCreditModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	void modifyApplyCredit(ApplyCreditModifyVo applyCreditModifyVo);

	/**
	 * @Title:
	 * @Description:  通过applyCreditId删除征信信息
	 * @param applyCreditDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	void deleteApplyCredit(ApplyCreditDeleteVo applyCreditDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过applyCreditId集合删除征信信息
	 * @param applyCreditDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	void deleteApplyCreditsByApplyCreditIds(ApplyCreditDeleteListVo applyCreditDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据applyCreditId获取征信信息
	 * @param applyCreditId
	 * @return ApplyCredit
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	ApplyCredit findApplyCreditByApplyCreditId(String applyCreditId);

	/**
	 * @Title:
	 * @Description: 保存征信信息
	 * @param applyNo
	 * @param inputExcelPath
	 * @param resultTxtPath
	 * @param creditGrade
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-15 17:27:00
	 */
	void saveApplyCredit(String applyNo,String inputExcelPath,String resultTxtPath,String creditGrade);

	/**
	 * @Title:
	 * @Description:   根据申请编号 获取申请模型对象
	 * @param applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/15 06:15:01
	 */
	ApplyCredit findApplyCreditByApplyNo(String applyNo);

}
