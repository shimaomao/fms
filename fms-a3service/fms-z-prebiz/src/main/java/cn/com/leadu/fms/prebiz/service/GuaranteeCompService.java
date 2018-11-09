package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompSaveVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompModifyVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompDeleteVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompService
 * @Description: 担保企业信息业务层
 * @date 2018-03-30
 */
public interface GuaranteeCompService {

	/**
	 * @Title:
	 * @Description: 分页查询担保企业信息
	 * @param guaranteeCompVo
	 * @return PageInfoExtend<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	PageInfoExtend<GuaranteeComp> findGuaranteeCompsByPage(GuaranteeCompVo guaranteeCompVo);

	/**
	 * @Title:
	 * @Description: 保存担保企业信息
	 * @param guaranteeCompSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
    void saveGuaranteeComp(GuaranteeCompSaveVo guaranteeCompSaveVo);


	/**
	 * @Title:
	 * @Description: 修改担保企业信息
	 * @param guaranteeCompModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	void modifyGuaranteeComp(GuaranteeCompModifyVo guaranteeCompModifyVo);

	/**
	 * @Title:
	 * @Description:  通过guarCompId删除担保企业信息
	 * @param guaranteeCompDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	void deleteGuaranteeComp(GuaranteeCompDeleteVo guaranteeCompDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过guarCompId集合删除担保企业信息
	 * @param guaranteeCompDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	void deleteGuaranteeCompsByGuarCompIds(GuaranteeCompDeleteListVo guaranteeCompDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据guarCompId获取担保企业信息
	 * @param guarCompId
	 * @return GuaranteeComp
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	GuaranteeComp findGuaranteeCompByGuarCompId(String guarCompId);

	/**
	 * 批量保存担保企业信息
	 * @param guaranteeCompList
	 * @author ningyangyang
	 */
	void saveGuaranteeCompList(List<GuaranteeComp> guaranteeCompList,String applyNo);
	/**
	 * @Title:
	 * @Description:  根据订单编号获取担保企业信息
	 * @param applyNo
	 * @return List<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
     List<GuaranteeComp> findGuaranteeCompsByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据订单编号更新担保公司信息
	 * @param applyNo
	 * @return List<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	void  updateGuaranteeCompsByApplyNo(List<GuaranteeComp> guaranteeCompList,String applyNo);
}
