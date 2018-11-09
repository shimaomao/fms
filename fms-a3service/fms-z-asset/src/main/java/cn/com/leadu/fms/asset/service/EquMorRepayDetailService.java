package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailSaveVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailModifyVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailDeleteVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailService
 * @Description: 资方抵押还款计划业务层
 */
public interface EquMorRepayDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划
	 * @param equMorRepayDetailVo
	 * @return PageInfoExtend<EquMorRepayDetail>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	PageInfoExtend<EquMorRepayDetailVo> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo);

	/**
	 * @Title:
	 * @Description: 保存资方抵押还款计划
	 * @param equMorRepayDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
    void saveEquMorRepayDetail(EquMorRepayDetailSaveVo equMorRepayDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepayDetailModifyVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	void modifyEquMorRepayDetail(EquMorRepayDetailModifyVo equMorRepayDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过equMorRepayDetailId删除资方抵押还款计划
	 * @param equMorRepayDetailDeleteVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	void deleteEquMorRepayDetail(EquMorRepayDetailDeleteVo equMorRepayDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过equMorRepayDetailId集合删除资方抵押还款计划
	 * @param equMorRepayDetailDeleteListVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	void deleteEquMorRepayDetailsByEquMorRepayDetailIds(EquMorRepayDetailDeleteListVo equMorRepayDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据equMorRepayDetailId获取资方抵押还款计划
	 * @param equMorRepayDetailId
	 * @return EquMorRepayDetail
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	EquMorRepayDetail findEquMorRepayDetailByEquMorRepayDetailId(String equMorRepayDetailId);

	/**
	 * @Title:
	 * @Description:  更新还款状态
	 * @param equMorRepayDetails
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-10-26 14:06:47
	 */
	void updateEquMorRepayDetailPayStatus(List<EquMorRepayDetail> equMorRepayDetails);

}
