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
 * @ClassName: RiskTelchkItem
 * @Description: 风控电核项目表实体
 * @date 2018-06-04
 */
@Data
public class RiskTelchkItem extends BaseEntity<RiskTelchkItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控电核项目id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String telchkItemId;

	/**
	 * @Fields  : 核实项目
	 * @author liujinge
	 */
	private String telchkItem;

	/**
	 * @Fields  : 核实项目名
	 * @author liujinge
	 */
	private String telchkItemName;

	/**
	 * @Fields  : 核实项目选项
	 * @author liujinge
	 */
	private String codeType;

	/**
	 * @Fields  : 排序
	 * @author liujinge
	 */
	private Integer orderNo;

}