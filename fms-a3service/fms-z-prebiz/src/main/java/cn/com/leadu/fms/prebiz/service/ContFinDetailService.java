package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailService
 * @Description: 合同融资费用明细业务层
 * @date 2018-03-23
 */
public interface ContFinDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询合同融资费用明细
	 * @param contFinDetailVo
	 * @return PageInfoExtend<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:11
	 */
	PageInfoExtend<ContFinDetail> findContFinDetailsByPage(ContFinDetailVo contFinDetailVo);

	/**
	 * @Title:
	 * @Description:  根据contFinDetailId获取合同融资费用明细
	 * @param contFinDetailId
	 * @return ContFinDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:11
	 */
	ContFinDetail findContFinDetailByContFinDetailId(String contFinDetailId);

	/**
	 * @Title:
	 * @Description:  批量插入合同融资费用明细信息
	 * @param contFinDetailList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:11
	 */
	int insertContFinDetails(List<ContFinDetail> contFinDetailList);

	/**
	 * @Title:
	 * @Description:
	 * @param contNo
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:11
	 */
	List<ContFinDetailVo> findContFinDetailVosByContNo(String contNo);

	/**
	 * @Title:
	 * @Description:   根据合同号查询合同融资费用明细
	 * @param contNo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/06/01 10:20:05
	 */
	List<ContFinDetail> findContFinDetailsByContNo(String contNo);

	/**
	 * @Description: 根据合同编号查询融资费用明细（附带付款表）
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/25 14:28
	 */
    List<ContFinPayVo> findContFinDetailsWithContPay(String contNo);
}
