package cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import lombok.Data;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelVo
 * @Description: 逾期客户电话信息载体
 * @date 2018-05-17
 */
@Data
public class OverdueCstmTelVo extends PageQuery<OverdueCstmTel> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户电话信息ID
	 * @author lijunjun
	 */
	private String overdueCstmTelId;

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
	 * @Fields  : 联系人
	 * @author lijunjun
	 */
	private String relationer;

	/**
	 * @Fields  : 关系类型
	 * @author lijunjun
	 */
	private String relationType;

	/**
	 * @Fields  : 电话号码
	 * @author lijunjun
	 */
	private String telNo;

	/**
	 * @Fields  : 逾期客户电话信息ID
	 * @author lijunjun
	 */
	private List<String> overdueCstmTelIds;

}