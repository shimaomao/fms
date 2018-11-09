package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecondition.OverdueConditionVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionService
 * @Description: 逾期状态维护业务层
 * @date 2018-05-11
 */
public interface OverdueConditionService {

	/**
	 * @Title:
	 * @Description: 分页查询逾期状态维护
	 * @param overdueConditionVo
	 * @return PageInfoExtend<OverdueCondition>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	PageInfoExtend<OverdueCondition> findOverdueConditionsByPage(OverdueConditionVo overdueConditionVo);

	/**
	 * @Title:
	 * @Description: 保存逾期状态维护
	 * @param overdueConditionSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
    void saveOverdueCondition(OverdueConditionSaveVo overdueConditionSaveVo);


	/**
	 * @Title:
	 * @Description: 修改逾期状态维护
	 * @param overdueConditionModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	void modifyOverdueCondition(OverdueConditionModifyVo overdueConditionModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueConditionId删除逾期状态维护
	 * @param overdueConditionDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	void deleteOverdueCondition(OverdueConditionDeleteVo overdueConditionDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueConditionId集合删除逾期状态维护
	 * @param overdueConditionDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	void deleteOverdueConditionsByOverdueConditionIds(OverdueConditionDeleteListVo overdueConditionDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据overdueConditionId获取逾期状态维护
	 * @param overdueConditionId
	 * @return OverdueCondition
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	OverdueCondition findOverdueConditionByOverdueConditionId(String overdueConditionId);

	/**
	 * @Title:
	 * @Description: 根据overdueCondCd获取逾期状态维护
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	OverdueCondition findOverdueConditionByOverdueCondCd(String overdueCondCd);

}
