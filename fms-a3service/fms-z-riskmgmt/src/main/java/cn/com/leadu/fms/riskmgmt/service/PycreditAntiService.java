package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditanti.PycreditAntiVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAntiService
 * @Description: 反欺诈分析业务层
 * @date 2018-06-04
 */
public interface PycreditAntiService {

	/**
	 * @Title:
	 * @Description: 分页查询反欺诈分析
	 * @param pycreditAntiVo
	 * @return PageInfoExtend<PycreditAnti>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
	PageInfoExtend<PycreditAnti> findPycreditAntisByPage(PycreditAntiVo pycreditAntiVo);

	/**
	 * @Title:
	 * @Description: 保存反欺诈分析
	 * @param pycreditAntiSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
    void savePycreditAnti(PycreditAntiSaveVo pycreditAntiSaveVo);


	/**
	 * @Title:
	 * @Description: 修改反欺诈分析
	 * @param pycreditAntiModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
	void modifyPycreditAnti(PycreditAntiModifyVo pycreditAntiModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditAntiId删除反欺诈分析
	 * @param pycreditAntiDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
	void deletePycreditAnti(PycreditAntiDeleteVo pycreditAntiDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditAntiId集合删除反欺诈分析
	 * @param pycreditAntiDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
	void deletePycreditAntisByPycreditAntiIds(PycreditAntiDeleteListVo pycreditAntiDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditAntiId获取反欺诈分析
	 * @param pycreditAntiId
	 * @return PycreditAnti
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:53
	 */
	PycreditAnti findPycreditAntiByPycreditAntiId(String pycreditAntiId);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改反欺诈分析,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditAnti> selectPycreditAntiList(String documentNo,int ceilingNumber);
}
