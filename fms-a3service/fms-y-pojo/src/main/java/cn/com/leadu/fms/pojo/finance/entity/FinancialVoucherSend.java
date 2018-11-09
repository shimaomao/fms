package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSend
 * @Description: 财务发送管理实体
 * @date 2018-07-21
 */
@Data
public class FinancialVoucherSend extends BaseEntity<FinancialVoucherSend> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务发送管理id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

}