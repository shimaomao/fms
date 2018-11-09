package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmrelation.CstmRelationVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmrelation.vo.CstmRelationSaveVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationService
 * @Description: 融资申请客户关系业务层
 * @date 2018-05-16
 */
public interface CstmRelationService {

	/**
	 * @Title:
	 * @Description: 分页查询融资申请客户关系
	 * @param cstmRelationVo
	 * @return PageInfoExtend<CstmRelation>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	PageInfoExtend<CstmRelation> findCstmRelationsByPage(CstmRelationVo cstmRelationVo);

	/**
	 * @Title:
	 * @Description: 保存融资申请客户关系
	 * @param cstmRelationSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
    void saveCstmRelation(CstmRelationSaveVo cstmRelationSaveVo);


	/**
	 * @Title:
	 * @Description: 修改融资申请客户关系
	 * @param cstmRelationModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	void modifyCstmRelation(CstmRelationModifyVo cstmRelationModifyVo);

	/**
	 * @Title:
	 * @Description:  通过relationId删除融资申请客户关系
	 * @param cstmRelationDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	void deleteCstmRelation(CstmRelationDeleteVo cstmRelationDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过relationId集合删除融资申请客户关系
	 * @param cstmRelationDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	void deleteCstmRelationsByRelationIds(CstmRelationDeleteListVo cstmRelationDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据relationId获取融资申请客户关系
	 * @param relationId
	 * @return CstmRelation
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:40:33
	 */
	CstmRelation findCstmRelationByRelationId(String relationId);

	/**
	 * @Title:
	 * @Description: 保存融资申请客户关系
	 * @param applyInputVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-16 11:13:22
	 */
	void saveApplyRelation(ApplyInputVo applyInputVo);

	/**
	 * @Title:
	 * @Description:   根据申请编号拿到对应的客户信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/16 03:43:21
	 */
	List<CstmRelation> findCstmRelationsByApplyNo(String applyNo);

}
