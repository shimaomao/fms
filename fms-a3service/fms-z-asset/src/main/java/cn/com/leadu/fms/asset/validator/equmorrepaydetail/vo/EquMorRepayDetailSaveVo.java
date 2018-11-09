package cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailVo
 * @Description: 资方抵押还款计划保存时载体及验证
 */
@Data
public class EquMorRepayDetailSaveVo extends BaseVo<EquMorRepayDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表明细id
	 * @author qinmuqiao
	 */
	private String equMorRepayDetailId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qinmuqiao
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qinmuqiao
	 */
	private String clientContNo;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String vinNo;

	/**
	 * @Fields  : 期数
	 * @author qinmuqiao
	 */
	private Integer period;

	/**
	 * @Fields  : 应还日期
	 * @author qinmuqiao
	 */
	private Date repayDate;

	/**
	 * @Fields  : 租金
	 * @author qinmuqiao
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 还款状态
	 * @author qinmuqiao
	 */
	private String equRepayStatus;

	/**
	 * @Fields  : 还款日期
	 * @author qinmuqiao
	 */
	private Date payUpdateDate;

}