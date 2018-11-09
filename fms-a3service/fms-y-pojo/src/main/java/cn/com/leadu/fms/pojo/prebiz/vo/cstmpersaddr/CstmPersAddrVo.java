package cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrVo
 * @Description: 客户个人地址信息载体
 * @date 2018-03-26
 */
@Data
public class CstmPersAddrVo extends PageQuery<CstmPersAddr> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人地址信息id
	 */
	private String persAddrId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 居住状况
	 */
	private String resideCond;

	/**
	 * @Fields  : 居住年份
	 */
	private String resideYear;

	/**
	 * @Fields  : 居住省份
	 */
	private String resideProv;

	/**
	 * @Fields  : 居住城市
	 */
	private String resideCity;

	/**
	 * @Fields  : 居住区县
	 */
	private String resideCounty;

	/**
	 * @Fields  : 居住详细地址
	 */
	private String resideAddr;

	/**
	 * @Fields  : 户籍省份
	 */
	private String censusProv;

	/**
	 * @Fields  : 户籍城市
	 */
	private String censusCity;

	/**
	 * @Fields  : 户籍区县
	 */
	private String censusCounty;

	/**
	 * @Fields  : 户籍详细地址
	 */
	private String censusAddr;

	/**
	 * @Fields  : 房产类型
	 */
	private String propertyType;

	/**
	 * @Fields  : 房产省份
	 */
	private String propertyProv;

	/**
	 * @Fields  : 房产城市
	 */
	private String propertyCity;

	/**
	 * @Fields  : 房产区县
	 */
	private String propertyCounty;

	/**
	 * @Fields  : 房产详细地址
	 */
	private String propertyAddr;
	/**
	 * @Fields  : 房产建筑面积
	 * @author ningyangyang
	 */
	private String propertySize;

	/**
	 * @Fields  : 房产购买时间
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date propertyGetDate;

	/**
	 * @Fields  : 房产评估值
	 * @author ningyangyang
	 */
	private BigDecimal propertyValue;

	/**
	 * @Fields  : 个人地址信息id
	 */
	private List<String> persAddrIds;

	/**
	 * @Fields  : 是否有房产
	 */
	private String isHaveProperty;

	/**
	 * @Fields  : 发票邮寄地址
	 */
	private String invoiceMailAddr;

}