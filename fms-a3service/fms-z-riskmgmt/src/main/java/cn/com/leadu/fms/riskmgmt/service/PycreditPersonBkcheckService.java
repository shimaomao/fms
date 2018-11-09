package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditpersonbkcheck.PycreditPersonBkcheckVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckService
 * @Description: 个人银行卡核查业务层
 * @date 2018-06-04
 */
public interface PycreditPersonBkcheckService {

	/**
	 * @Title:
	 * @Description: 分页查询个人银行卡核查
	 * @param pycreditPersonBkcheckVo
	 * @return PageInfoExtend<PycreditPersonBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
	PageInfoExtend<PycreditPersonBkcheck> findPycreditPersonBkchecksByPage(PycreditPersonBkcheckVo pycreditPersonBkcheckVo);

	/**
	 * @Title:
	 * @Description: 保存个人银行卡核查
	 * @param pycreditPersonBkcheckSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
    void savePycreditPersonBkcheck(PycreditPersonBkcheckSaveVo pycreditPersonBkcheckSaveVo);


	/**
	 * @Title:
	 * @Description: 修改个人银行卡核查
	 * @param pycreditPersonBkcheckModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
	void modifyPycreditPersonBkcheck(PycreditPersonBkcheckModifyVo pycreditPersonBkcheckModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditPersonBkcheckId删除个人银行卡核查
	 * @param pycreditPersonBkcheckDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
	void deletePycreditPersonBkcheck(PycreditPersonBkcheckDeleteVo pycreditPersonBkcheckDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditPersonBkcheckId集合删除个人银行卡核查
	 * @param pycreditPersonBkcheckDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
	void deletePycreditPersonBkchecksByPycreditPersonBkcheckIds(PycreditPersonBkcheckDeleteListVo pycreditPersonBkcheckDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditPersonBkcheckId获取个人银行卡核查
	 * @param pycreditPersonBkcheckId
	 * @return PycreditPersonBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:53
	 */
	PycreditPersonBkcheck findPycreditPersonBkcheckByPycreditPersonBkcheckId(String pycreditPersonBkcheckId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人银行卡核查,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditPersonBkcheck> selectPycreditPersonBkcheckList(String documentNo, int ceilingNumber);
}
