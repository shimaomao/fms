package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import cn.com.leadu.fms.pojo.prebiz.vo.commonborrower.CommonBorrowerVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerDeleteVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerModifyVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerSaveVo;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerService
 * @Description: 共同借款人业务层
 * @date 2018-05-25
 */
public interface CommonBorrowerService {

	/**
	 * @Title:
	 * @Description: 分页查询共同借款人
	 * @param commonBorrowerVo
	 * @return PageInfoExtend<CommonBorrower>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	PageInfoExtend<CommonBorrower> findCommonBorrowersByPage(CommonBorrowerVo commonBorrowerVo);

	/**
	 * @Title:
	 * @Description: 保存共同借款人
	 * @param commonBorrowerSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
    void saveCommonBorrower(CommonBorrowerSaveVo commonBorrowerSaveVo);


	/**
	 * @Title:
	 * @Description: 修改共同借款人
	 * @param commonBorrowerModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	void modifyCommonBorrower(CommonBorrowerModifyVo commonBorrowerModifyVo);

	/**
	 * @Title:
	 * @Description:  通过comBorrowerId删除共同借款人
	 * @param commonBorrowerDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	void deleteCommonBorrower(CommonBorrowerDeleteVo commonBorrowerDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过comBorrowerId集合删除共同借款人
	 * @param commonBorrowerDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	void deleteCommonBorrowersByComBorrowerIds(CommonBorrowerDeleteListVo commonBorrowerDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据comBorrowerId获取共同借款人
	 * @param comBorrowerId
	 * @return CommonBorrower
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	CommonBorrower findCommonBorrowerByComBorrowerId(String comBorrowerId);

	/**
	 * @Title:
	 * @Description:  批量保存共同借款人
	 * @param CommonBorrowerList
	 * @param applyNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	void saveCommonBorrowerList(List<CommonBorrower> CommonBorrowerList,String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取共同借款人
	 * @param applyNo
	 * @return List<CommonBorrower>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	 List<CommonBorrower> findCommonBorrowersByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo更新共同借款人
	 * @param applyNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:15
	 */
	 void updateCommonBorrowersByApplyNo(List<CommonBorrower> CommonBorrowerList,String applyNo);

}
