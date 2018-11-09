package cn.com.leadu.fms.prebiz.validator.cstmrelation.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import lombok.Data;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationVo
 * @Description: 融资申请客户关系保存时载体及验证
 * @date 2018-05-16
 */
@Data
public class CstmRelationSaveVo extends BaseVo<CstmRelation> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户关系主键
	 * @author qiaomengnan
	 */
	private String relationId;

	/**
	 * @Fields  : 身份证号
	 * @author qiaomengnan
	 */
	private String certifNo;

	/**
	 * @Fields  : 手机号
	 * @author qiaomengnan
	 */
	private String mobileNo;

	/**
	 * @Fields  : 姓名
	 * @author qiaomengnan
	 */
	private String name;

	/**
	 * @Fields  : 关系类型名称
	 * @author qiaomengnan
	 */
	private String identityTypeName;

	/**
	 * @Fields  : 关系类型code
	 * @author qiaomengnan
	 */
	private String identityTypeCode;

	/**
	 * @Fields  : 申请编号
	 * @author qiaomengnan
	 */
	private String applyNo;

	/**
	 * @Fields  : 主贷人id
	 * @author qiaomengnan
	 */
	private String relationLenderId;

}