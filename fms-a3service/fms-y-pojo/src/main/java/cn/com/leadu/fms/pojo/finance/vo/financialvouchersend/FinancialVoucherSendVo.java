package cn.com.leadu.fms.pojo.finance.vo.financialvouchersend;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSend;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendVo
 * @Description: 财务发送管理载体
 * @date 2018-07-21
 */
@Data
public class FinancialVoucherSendVo extends PageQuery<FinancialVoucherSend> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务发送管理id
	 * @author qiaomengnan
	 */
	private String voucherSendId;

	/**
	 * @Fields  : 发送批次号
	 * @author qiaomengnan
	 */
	private String sendBatchNo;

	/**
	 * @Fields  : 财务凭证号
	 * @author qiaomengnan
	 */
	private String voucherNo;

	/**
	 * @Fields  : 发送时间
	 * @author qiaomengnan
	 */
	private Date sendTime;

	/**
	 * @Fields  : 发送人员
	 * @author qiaomengnan
	 */
	private String sendUser;

	/**
	 * @Fields  : 发送状态
	 * @author qiaomengnan
	 */
	private String sendStatus;

	/**
	 * @Fields  : 发送文件
	 * @author qiaomengnan
	 */
	private String sendFile;

	/**
	 * @Fields  : 返回文件
	 * @author qiaomengnan
	 */
	private String returnFile;

	/**
	 * @Fields  : 财务发送管理id
	 * @author qiaomengnan
	 */
	private List<String> voucherSendIds;

}