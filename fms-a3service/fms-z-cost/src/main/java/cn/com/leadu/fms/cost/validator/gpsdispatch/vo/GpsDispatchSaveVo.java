package cn.com.leadu.fms.cost.validator.gpsdispatch.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchVo
 * @Description: 派单信息保存时载体及验证
 * @date 2018-05-25
 */
@Data
public class GpsDispatchSaveVo extends BaseVo<GpsDispatch> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 派单信息id
	 * @author qiaomengnan
	 */
	private String dispatchId;

	/**
	 * @Fields  : 合同编号
	 * @author qiaomengnan
	 */
	private String contNo;

	/**
	 * @Fields  : 申请编号
	 * @author qiaomengnan
	 */
	private String applyNo;

	/**
	 * @Fields  : gps厂商 从数据字典中取值 gpsSeller key
	 * @author qiaomengnan
	 */
	private String gpsSeller;

	/**
	 * @Fields  : 安装日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date installDate;

	/**
	 * @Fields  : 安装省份
	 * @author qiaomengnan
	 */
	private String installProvince;

	/**
	 * @Fields  : 安装城市
	 * @author qiaomengnan
	 */
	private String installCity;

	/**
	 * @Fields  : 安装区县
	 * @author qiaomengnan
	 */
	private String installCounty;

	/**
	 * @Fields  : 安装地址
	 * @author qiaomengnan
	 */
	private String installAddress;

	/**
	 * @Fields  : 预计安装时间 第三方接口取得
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date expectInstallDate;

	/**
	 * @Fields  : 对接人员
	 * @author qiaomengnan
	 */
	private String abutmentUser;

	/**
	 * @Fields  : 对接人员电话
	 * @author qiaomengnan
	 */
	private String abutmentUserMobileNo;

	/**
	 * @Fields  : 是否派单 0.不派单 1.派单
	 * @author qiaomengnan
	 */
	private String dispatchFlag;

	/**
	 * @Fields  : 派工人 第三方接口取得
	 * @author qiaomengnan
	 */
	private String dispatchWorkerUser;

	/**
	 * @Fields  : 派工人电话 第三方接口取得
	 * @author qiaomengnan
	 */
	private String dispatchWorkerUserMobileNo;

	/**
	 * @Fields  : gps有线数量
	 * @author qiaomengnan
	 */
	private Integer gpsWiredNum;

	/**
	 * @Fields  : 有线设备年限
	 * @author qiaomengnan
	 */
	private Integer gpsWiredYears;

	/**
	 * @Fields  : 有线设备费用
	 * @author qiaomengnan
	 */
	private BigDecimal gpsWiredCost;

	/**
	 * @Fields  : gps无线数量
	 * @author qiaomengnan
	 */
	private Integer gpsWirelessNum;

	/**
	 * @Fields  : 无线设备年限
	 * @author qiaomengnan
	 */
	private Integer gpsWirelessYears;

	/**
	 * @Fields  : 无线设备费用
	 * @author qiaomengnan
	 */
	private BigDecimal gpsWirelessCost;

	/**
	 * @Fields  : 安装费用
	 * @author qiaomengnan
	 */
	private BigDecimal installCost;

	/**
	 * @Fields  : 拆改费
	 * @author qiaomengnan
	 */
	private BigDecimal reformCost;

	/**
	 * @Fields  : 费用合计
	 * @author qiaomengnan
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 有线设备号
	 * @author qiaomengnan
	 */
	private String wiredDeviceNo;

	/**
	 * @Fields  : 无线设备号
	 * @author qiaomengnan
	 */
	private String wirelessDeviceNo;

	/**
	 * @Fields  : 安装师傅
	 * @author qiaomengnan
	 */
	private String installUser;

	/**
	 * @Fields  : 安装师傅电话
	 * @author qiaomengnan
	 */
	private String installUserMobileNo;

	/**
	 * @Fields  : 安装状态
	 * @author qiaomengnan
	 */
	private String installStatus;

	/**
	 * @Fields  : 结算状态
	 * @author qiaomengnan
	 */
	private String settleStatus;

	/**
	 * @Fields  : 天易工单号
	 * @author qiaomengnan
	 */
	private String tyOrderNo;

	/**
	 * @Fields  : 账单月
	 * @author ningyangyang
	 */
	private String billMonth;

}