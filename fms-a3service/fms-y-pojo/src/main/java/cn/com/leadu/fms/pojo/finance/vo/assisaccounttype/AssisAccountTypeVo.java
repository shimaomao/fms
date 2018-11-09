package cn.com.leadu.fms.pojo.finance.vo.assisaccounttype;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeVo
 * @Description: 辅助核算类型管理载体
 * @date 2018-06-23
 */
@Data
public class AssisAccountTypeVo extends PageQuery<AssisAccountType> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 辅助核算类型id
	 * @author ningyangyang
	 */
	private String assisAccountTypeId;

	/**
	 * @Fields  : 辅助核算类型
	 * @author ningyangyang
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算类型名称
	 * @author ningyangyang
	 */
	private String assisAccountTypeName;

	/**
	 * @Fields  : 核算项目值设值
	 * @author ningyangyang
	 */
	private String assisAccountValue;

	/**
	 * @Fields  : 辅助核算类型id
	 * @author ningyangyang
	 */
	private List<String> assisAccountTypeIds;

	/**
	 * @Fields  : 序号
	 * @author yanfengbo
	 */
	private int assisAccountIndex;

	/**
	 * @Fields  : 辅助核算序号
	 * @author yanfengbo
	 */
	private int assisAccountOrder;

}