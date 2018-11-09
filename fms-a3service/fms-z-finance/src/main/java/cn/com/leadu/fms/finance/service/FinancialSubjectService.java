package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectSaveVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectModifyVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectDeleteVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectService
 * @Description: 财务科目管理业务层
 * @date 2018-06-20
 */
public interface FinancialSubjectService {

	/**
	 * @Title:
	 * @Description: 分页查询财务科目管理
	 * @param financialSubjectVo
	 * @return PageInfoExtend<FinancialSubject>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	PageInfoExtend<FinancialSubjectVo> findFinancialSubjectsByPage(FinancialSubjectVo financialSubjectVo);

	/**
	 * @Title:
	 * @Description: 保存财务科目管理
	 * @param financialSubjectSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
    void saveFinancialSubject(FinancialSubjectSaveVo financialSubjectSaveVo);


	/**
	 * @Title:
	 * @Description: 修改财务科目管理
	 * @param financialSubjectModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	void modifyFinancialSubject(FinancialSubjectModifyVo financialSubjectModifyVo);

	/**
	 * @Title:
	 * @Description:  通过subjectId删除财务科目管理
	 * @param financialSubjectDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	void deleteFinancialSubject(FinancialSubjectDeleteVo financialSubjectDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过subjectId集合删除财务科目管理
	 * @param financialSubjectDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-6-20 11:24:39
	 */
	void deleteFinancialSubjectsBySubjectIds(FinancialSubjectDeleteListVo financialSubjectDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据subjectId获取财务科目管理
	 * @param subjectId
	 * @return FinancialSubject
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 11:24:39
	 */
	FinancialSubjectVo findFinancialSubjectBySubjectId(String subjectId);

}
