package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditListService
 * @Description: 鹏元查询一览业务层
 * @date 2018-06-04
 */
public interface PycreditListService {

	/**
	 * @Title:
	 * @Description: 分页查询鹏元查询一览
	 * @param pycreditListVo
	 * @return PageInfoExtend<PycreditList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PageInfoExtend<PycreditList> findPycreditListsByPage(PycreditListVo pycreditListVo);

	/**
	 * @Title:
	 * @Description: 保存鹏元查询一览
	 * @param pycreditListSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
    void savePycreditList(PycreditListSaveVo pycreditListSaveVo);


	/**
	 * @Title:
	 * @Description: 修改鹏元查询一览
	 * @param pycreditListModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	void modifyPycreditList(PycreditListModifyVo pycreditListModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pycreditId删除鹏元查询一览
	 * @param pycreditListDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	void deletePycreditList(PycreditListDeleteVo pycreditListDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pycreditId集合删除鹏元查询一览
	 * @param pycreditListDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	void deletePycreditListsByPycreditIds(PycreditListDeleteListVo pycreditListDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pycreditId获取鹏元查询一览
	 * @param pycreditId
	 * @return PycreditList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	PycreditList findPycreditListByPycreditId(String pycreditId);

	/**
	 * @Title:
	 * @Description: 根据申请编号查询鹏元一览
	 * @param applyNo
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:21
	 */
	List<PycreditListVo> findPycreditListByApplyNo(String applyNo);
}
