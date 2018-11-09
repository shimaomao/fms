package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author niehaibing
 * @ClassName: BizActStatus
 * @Description: 业务状态管理实体
 * @date 2018-03-27
 */
@Data
public class BizActStatus extends BaseEntity<BizActStatus> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String actStsId;

	/**
	 * @Fields  : 
	 */
	private String actStsType;

	/**
	 * @Fields  : 
	 */
	private String actWidgetId;

	/**
	 * @Fields  : 
	 */
	private String befStatus;

	/**
	 * @Fields  : 
	 */
	private String aftStatus;

}