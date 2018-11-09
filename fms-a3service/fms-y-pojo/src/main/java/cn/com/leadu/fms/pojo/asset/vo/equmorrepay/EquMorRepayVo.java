package cn.com.leadu.fms.pojo.asset.vo.equmorrepay;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayVo
 * @Description: 资方抵押还款计划载体
 * @date 2018-05-30
 */
@Data
public class EquMorRepayVo extends PageQuery<EquMorRepay> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表id
	 * @author qiaomengnan
	 */
	private String equMorRepayId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qiaomengnan
	 */
	private String clientContNo;

	/**
	 * @Fields  : 客户姓名
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("客户姓名")
	private String clientName;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("融资期限")
	private String leasePeriod;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("车架号")
	private String vinNo;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("还款日")
	private String repayDate;

	/**
	 * @Fields  : 租金
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("租金")
	private BigDecimal rent;

	/**
	 * @Fields  : 资方抵押还款计划表id
	 * @author qiaomengnan
	 */
	private List<String> equMorRepayIds;


	@ExcelTitle(value = "客户姓名" , sort = 1)
	public String getClientName(){
		return clientName;
	}

	@ExcelTitle(value = "融资期限" , sort = 2)
	public String getLeasePeriod(){
		return leasePeriod;
	}

	@ExcelTitle(value = "车架号" , sort = 3)
	public String getVinNo(){
		return vinNo;
	}

	@ExcelTitle(value = "还款日" , sort = 4)
	public String getRepayDate(){
		return repayDate;
	}

	@ExcelTitle(value = "租金" , sort = 5)
	public BigDecimal getRent(){
		return rent;
	}

}