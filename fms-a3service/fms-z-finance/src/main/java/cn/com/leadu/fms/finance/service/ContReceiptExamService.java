package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contreceiptexam.ContReceiptExamVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamSaveVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamModifyVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamDeleteVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamService
 * @Description: 财务勾稽业务层
 * @date 2018-05-09
 */
public interface ContReceiptExamService {

	/**
	 * @Title:
	 * @Description: 分页查询财务勾稽
	 * @param contReceiptExamVo
	 * @return PageInfoExtend<ContReceiptExam>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
	PageInfoExtend<ContReceiptExam> findContReceiptExamsByPage(ContReceiptExamVo contReceiptExamVo);

	/**
	 * @Title:
	 * @Description: 保存财务勾稽
	 * @param contReceiptExamSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
    void saveContReceiptExam(ContReceiptExamSaveVo contReceiptExamSaveVo);


	/**
	 * @Title:
	 * @Description: 修改财务勾稽
	 * @param contReceiptExamModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
	void modifyContReceiptExam(ContReceiptExamModifyVo contReceiptExamModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contReceiptExamId删除财务勾稽
	 * @param contReceiptExamDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
	void deleteContReceiptExam(ContReceiptExamDeleteVo contReceiptExamDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contReceiptExamId集合删除财务勾稽
	 * @param contReceiptExamDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
	void deleteContReceiptExamsByContReceiptExamIds(ContReceiptExamDeleteListVo contReceiptExamDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contReceiptExamId获取财务勾稽
	 * @param contReceiptExamId
	 * @return ContReceiptExam
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-9 11:52:38
	 */
	ContReceiptExam findContReceiptExamByContReceiptExamId(String contReceiptExamId);

}
