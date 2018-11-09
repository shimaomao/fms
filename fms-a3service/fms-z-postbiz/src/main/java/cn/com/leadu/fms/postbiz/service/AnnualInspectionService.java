package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.postbiz.validator.annualinspection.vo.AnnualInspectionModifyVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionService
 * @Description: 年检提醒业务层
 */
public interface AnnualInspectionService {

	/**
	 * @Title:
	 * @Description: 分页查询年检提醒
	 * @param annualInspectionVo
	 * @return PageInfoExtend<AnnualInspection>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	PageInfoExtend<AnnualInspectionVo> findAnnualInspectionVosByPage(AnnualInspectionVo annualInspectionVo);


	/**
	 * @Title:
	 * @Description: 修改年检提醒
	 * @param annualInspectionModifyVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	void modifyAnnualInspection(AnnualInspectionModifyVo annualInspectionModifyVo);

	/**
	 * @Title:
	 * @Description:  根据annualInspectionId获取年检提醒
	 * @param annualInspectionId
	 * @return AnnualInspection
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	AnnualInspectionVo findAnnualInspectionVoByAnnualInspectionId(String annualInspectionId);

	/**
	 * @Title:
	 * @Description: 获取合同信息表里面符合的数据
	 * @return AnnualInspection
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	void findInfomationFromContract();


}
