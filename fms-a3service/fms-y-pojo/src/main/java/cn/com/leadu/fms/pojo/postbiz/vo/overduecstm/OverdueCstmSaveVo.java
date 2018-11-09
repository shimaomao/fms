package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 逾期客户催收分配载体
 * @date 2018-05-16
 */
@Data
public class OverdueCstmSaveVo{

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 催收类型
	 * @author lijunjun
	 */
	private String assignmentType;

	/**
	 * @Fields  : 分配账号
	 * @author lijunjun
	 */
	private String assignUser;


}