package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorprisk.PycreditCorpRiskVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskService
 * @Description: 企业风险业务层
 * @date 2018-06-04
 */
public interface PycreditCorpRiskService {

	/**
	 * @Title:
	 * @Description: 分页查询企业风险
	 * @param pycreditCorpRiskVo
	 * @return PageInfoExtend<PycreditCorpRisk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PageInfoExtend<PycreditCorpRisk> findPycreditCorpRisksByPage(PycreditCorpRiskVo pycreditCorpRiskVo);

	/**
	 * @Title:
	 * @Description: 保存企业风险
	 * @param pycreditCorpRiskSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
    void savePycreditCorpRisk(PycreditCorpRiskSaveVo pycreditCorpRiskSaveVo);


	/**
	 * @Title:
	 * @Description: 修改企业风险
	 * @param pycreditCorpRiskModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	void modifyPycreditCorpRisk(PycreditCorpRiskModifyVo pycreditCorpRiskModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditCorpRiskId删除企业风险
	 * @param pycreditCorpRiskDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	void deletePycreditCorpRisk(PycreditCorpRiskDeleteVo pycreditCorpRiskDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditCorpRiskId集合删除企业风险
	 * @param pycreditCorpRiskDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	void deletePycreditCorpRisksByPycreditCorpRiskIds(PycreditCorpRiskDeleteListVo pycreditCorpRiskDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditCorpRiskId获取企业风险
	 * @param pycreditCorpRiskId
	 * @return PycreditCorpRisk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PycreditCorpRisk findPycreditCorpRiskByPycreditCorpRiskId(String pycreditCorpRiskId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpRisk> selectPycreditCorpRiskList(String name, int ceilingNumber);
}
