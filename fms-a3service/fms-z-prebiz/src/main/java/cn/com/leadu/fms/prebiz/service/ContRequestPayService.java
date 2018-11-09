package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContInsuranceService
 * @Description: 合同车辆保险信息业务层
 * @date 2018-03-23
 */
public interface ContRequestPayService {
	/**
	 * @Title:
	 * @Description:  提交
	 * @param contRequestPayVo
	 * @return ContInsurance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:30:19
	 */
	void submitContRequestPay(ContRequestPayVo contRequestPayVo);

	/**
	 * @Title:
	 * @Description:  退回
	 * @param contRequestPayVo
	 * @return ContInsurance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:30:19
	 */
	void sendBack(ContRequestPayVo contRequestPayVo);

	/**
	 * @Title:
	 * @Description:  暂存
	 * @param contRequestPayVo
	 * @return ContInsurance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:30:19
	 */
	void saveContRequestPay(ContRequestPayVo contRequestPayVo);


	/**
	 * @Title:
	 * @Description: 根据合同号查询
	 * @param contNo
	 * @return ContInsurance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:30:19
	 */
	ContRequestPayVo findContRequestPayByContNo(String contNo);

	/**
	 * @Description: 查询合同请款融资项目费用明细
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/25 14:03
	 */
    List<ContFinPayVo> findRequestContFinDetail(String contNo,ContRequestPayVo contRequestPayVo);

}
