package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.pojo.cost.vo.contprepaydetail.ContPrepayDetailVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailSaveVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailModifyVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailService
 * @Description: 提前还款明细业务层
 * @date 2018-05-11
 */
public interface ContPrepayDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询提前还款明细
	 * @param contPrepayDetailVo
	 * @return PageInfoExtend<ContPrepayDetail>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	PageInfoExtend<ContPrepayDetail> findContPrepayDetailsByPage(ContPrepayDetailVo contPrepayDetailVo);

	/** 
	* @Description: 根据提前还款任务号查询提前还款明细
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 17:51
	*/ 
	List<ContPrepayDetail> findContPrepayDetailVoByContPrepaymentNo(String contPrepaymentNo);

	/**
	 * @Title:
	 * @Description: 保存提前还款明细
	 * @param contPrepayDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
    void saveContPrepayDetail(ContPrepayDetailSaveVo contPrepayDetailSaveVo);

	/** 
	* @Description:  批量保存提前还款明细
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 19:02
	*/ 
	void saveDataList(List<ContPrepayDetail> contPrepayDetailList);


	/**
	 * @Title:
	 * @Description: 修改提前还款明细
	 * @param contPrepayDetailModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	void modifyContPrepayDetail(ContPrepayDetailModifyVo contPrepayDetailModifyVo);

	/** 
	* @Description: 批量动态修改提前还款明细
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/15 15:48
	*/ 
	void modifyByPrimaryKeySelectiveDataList(List<ContPrepayDetail> contPrepayDetailList);

	/**
	 * @Title:
	 * @Description:  通过contPrepayDetailId删除提前还款明细
	 * @param contPrepayDetailDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	void deleteContPrepayDetail(ContPrepayDetailDeleteVo contPrepayDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contPrepayDetailId集合删除提前还款明细
	 * @param contPrepayDetailDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	void deleteContPrepayDetailsByContPrepayDetailIds(ContPrepayDetailDeleteListVo contPrepayDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contPrepayDetailId获取提前还款明细
	 * @param contPrepayDetailId
	 * @return ContPrepayDetail
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-11 18:02:32
	 */
	ContPrepayDetail findContPrepayDetailByContPrepayDetailId(String contPrepayDetailId);

}
