package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpdebt.PycreditCorpDebtVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtService
 * @Description: 企业债务业务层
 * @date 2018-06-04
 */
public interface PycreditCorpDebtService {

	/**
	 * @Title:
	 * @Description: 分页查询企业债务
	 * @param pycreditCorpDebtVo
	 * @return PageInfoExtend<PycreditCorpDebt>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PageInfoExtend<PycreditCorpDebt> findPycreditCorpDebtsByPage(PycreditCorpDebtVo pycreditCorpDebtVo);

	/**
	 * @Title:
	 * @Description: 保存企业债务
	 * @param pycreditCorpDebtSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
    void savePycreditCorpDebt(PycreditCorpDebtSaveVo pycreditCorpDebtSaveVo);


	/**
	 * @Title:
	 * @Description: 修改企业债务
	 * @param pycreditCorpDebtModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	void modifyPycreditCorpDebt(PycreditCorpDebtModifyVo pycreditCorpDebtModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditCorpDebtId删除企业债务
	 * @param pycreditCorpDebtDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	void deletePycreditCorpDebt(PycreditCorpDebtDeleteVo pycreditCorpDebtDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditCorpDebtId集合删除企业债务
	 * @param pycreditCorpDebtDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	void deletePycreditCorpDebtsByPycreditCorpDebtIds(PycreditCorpDebtDeleteListVo pycreditCorpDebtDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditCorpDebtId获取企业债务
	 * @param pycreditCorpDebtId
	 * @return PycreditCorpDebt
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PycreditCorpDebt findPycreditCorpDebtByPycreditCorpDebtId(String pycreditCorpDebtId);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业债务,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpDebt> selectPycreditCorpDebtList(String name, int ceilingNumber);
}
