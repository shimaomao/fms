package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpbkcheck.PycreditCorpBkcheckVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckService
 * @Description: 企业银行卡核查业务层
 * @date 2018-06-04
 */
public interface PycreditCorpBkcheckService {

	/**
	 * @Title:
	 * @Description: 分页查询企业银行卡核查
	 * @param pycreditCorpBkcheckVo
	 * @return PageInfoExtend<PycreditCorpBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PageInfoExtend<PycreditCorpBkcheck> findPycreditCorpBkchecksByPage(PycreditCorpBkcheckVo pycreditCorpBkcheckVo);

	/**
	 * @Title:
	 * @Description: 保存企业银行卡核查
	 * @param pycreditCorpBkcheckSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
    void savePycreditCorpBkcheck(PycreditCorpBkcheckSaveVo pycreditCorpBkcheckSaveVo);


	/**
	 * @Title:
	 * @Description: 修改企业银行卡核查
	 * @param pycreditCorpBkcheckModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	void modifyPycreditCorpBkcheck(PycreditCorpBkcheckModifyVo pycreditCorpBkcheckModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditCorpBkcheckId删除企业银行卡核查
	 * @param pycreditCorpBkcheckDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	void deletePycreditCorpBkcheck(PycreditCorpBkcheckDeleteVo pycreditCorpBkcheckDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditCorpBkcheckId集合删除企业银行卡核查
	 * @param pycreditCorpBkcheckDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	void deletePycreditCorpBkchecksByPycreditCorpBkcheckIds(PycreditCorpBkcheckDeleteListVo pycreditCorpBkcheckDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditCorpBkcheckId获取企业银行卡核查
	 * @param pycreditCorpBkcheckId
	 * @return PycreditCorpBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PycreditCorpBkcheck findPycreditCorpBkcheckByPycreditCorpBkcheckId(String pycreditCorpBkcheckId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业银行卡核查,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpBkcheck> selectPycreditCorpBkcheckList(String name, int ceilingNumber);
}
