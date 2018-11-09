package cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import lombok.Data;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrVo
 * @Description: 逾期客户地址信息保存时载体及验证
 * @date 2018-05-17
 */
@Data
public class OverdueCstmAddrSaveVo extends BaseVo<OverdueCstmAddr> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户地址信息ID
	 * @author lijunjun
	 */
	private String overdueCstmAddrId;

	/**
	 * @Fields  : 主贷人证件号码
	 * @author lijunjun
	 */
	private String certifNo;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 关系类型
	 * @author lijunjun
	 */
	private String relationType;

	/**
	 * @Fields  : 地址类型
	 * @author lijunjun
	 */
	private String addrType;

	/**
	 * @Fields  : 地址
	 * @author lijunjun
	 */
	private String address;

	/**
	 * @Fields  : 是否有效
	 * @author lijunjun
	 */
	private String validFlag;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String meno;

}