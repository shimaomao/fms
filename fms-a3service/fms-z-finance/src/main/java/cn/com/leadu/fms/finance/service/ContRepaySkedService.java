package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedSaveVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedModifyVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedDeleteVo;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.ContRepaySkedDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedService
 * @Description:  融资合同还款计划信息业务层
 * @date 2018-05-08
 */
public interface ContRepaySkedService {

	/**
	 * @Title:
	 * @Description: 分页查询 融资合同还款计划信息
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedsByPage(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 分页查询勾稽明细信息
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContReceiptDetailsByPage(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 分页查询已认领详情
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedClaimeByPage(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 保存 融资合同还款计划信息
	 * @param contRepaySkedSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
    void saveContRepaySked(ContRepaySkedSaveVo contRepaySkedSaveVo);

	/**
	 * @Title:
	 * @Description: 取消认领
	 * @param contRepaySkedVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	void cancelClaime(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 修改 融资合同还款计划信息
	 * @param contRepaySkedModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	void modifyContRepaySked(ContRepaySkedModifyVo contRepaySkedModifyVo);

	/**
	 * @Title:
	 * @Description:  通过repaySkedId删除 融资合同还款计划信息
	 * @param contRepaySkedDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	void deleteContRepaySked(ContRepaySkedDeleteVo contRepaySkedDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过repaySkedId集合删除 融资合同还款计划信息
	 * @param contRepaySkedDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	void deleteContRepaySkedsByRepaySkedIds(ContRepaySkedDeleteListVo contRepaySkedDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据repaySkedId获取 融资合同还款计划信息
	 * @param repaySkedId
	 * @return ContRepaySked
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 11:11:36
	 */
	ContRepaySked findContRepaySkedByRepaySkedId(String repaySkedId);

	/**
	 * @Title:
	 * @Description:  检查是否有合同还款逾期并做处理
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 15:46:43
	 */
	void checkContRepaySked();


	/** 
	* @Description: 根据合同编号查询融资合同还款信息 ，还款时间小于当前时间且倒序排序的第一个
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/11 17:18
	*/ 
	ContRepaySked findContRepaySkedByContNo(String contNo);

	/** 
	* @Description: 根据合同号查询所有还款计划表，按期数由小到大排序
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/28 20:40
	*/ 
	List<ContRepaySked> findAllContRepaySkedByContNo(String contNo);

	/** 
	* @Description:  查询逾期租金合计
	* @param:
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 10:46
	*/ 
	BigDecimal findContRepaySkedOverdueRentSum(String contNo);

	/** 
	* @Description: 计算剩余租金，如果未生成还款计划表，返回-1
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/15 14:30
	*/ 
	BigDecimal findContRepaySkedRentSum(String contNo);

	/**
	 * @Title:
	 * @Description: 查询即将到期融资合同还款计划信息
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	List<ContRepaySkedVo> findOnceOverdueSked(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 分页查询合同还款日信息
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedDetailByPage(ContRepaySkedVo contRepaySkedVo);


	/**
	 * @Title:
	 * @Description: 分页查询合同还款日信息(导出)
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedDetailExport(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 未结清车辆租金明细表(导出)
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedSettleExport(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 结清车辆租金明细表(导出)
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedSettleEndExport(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 未收租金明细表(导出)
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedUnpaidRentExport(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 实收租金明细表(导出)
	 * @param contRepaySkedVo
	 * @return PageInfoExtend<ContRepaySked>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-8 11:11:36
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedPaidRentExport(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 根据contReceiptExamId获取ContRepaySkedVo
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	ContRepaySkedVo findContReceiptDetailByContReceiptExamId(String contReceiptExamId);

	/**
	 * @Title:
	 * @Description: 开具发票
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	void contReceiptDetailInvoice(ContRepaySkedVo contRepaySkedVo);

	/**
	* @Description: 勾稽页面手动生成凭证
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/11/2 16:07
	*/
    void makeVoucher(List<String> contReceiptExamIdList);
}
