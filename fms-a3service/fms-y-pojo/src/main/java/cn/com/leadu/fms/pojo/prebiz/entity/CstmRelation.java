package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelation
 * @Description: 融资申请客户关系实体
 * @date 2018-05-16
 */
@Data
public class CstmRelation extends BaseEntity<CstmRelation> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户关系主键
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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