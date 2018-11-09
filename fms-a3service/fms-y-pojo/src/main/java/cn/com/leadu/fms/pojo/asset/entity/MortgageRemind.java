package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemind
 * @Description: 抵押提醒实体
 * @date 2018-07-27
 */
@Data
public class MortgageRemind extends BaseEntity<MortgageRemind> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 抵押提醒id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String morRemindId;



	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;


	/**
	 * @Fields  : 抵押状态
	 * @author ningyangyang
	 */
	private String mortgageStatus;

	/**
	 * @Fields  : 抵押日期
	 * @author ningyangyang
	 */
	private Date mortgageDate;

}