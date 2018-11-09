package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: RiskTelchk
 * @Description: 风控电核信息实体
 * @date 2018-06-04
 */
@Data
public class RiskTelchk extends BaseEntity<RiskTelchk> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控电核id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String riskTelchkId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 核实项目
	 * @author liujinge
	 */
	private String telchkItem;

	/**
	 * @Fields  : 核实值
	 * @author liujinge
	 */
	private String telchkResult;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String memo;

}