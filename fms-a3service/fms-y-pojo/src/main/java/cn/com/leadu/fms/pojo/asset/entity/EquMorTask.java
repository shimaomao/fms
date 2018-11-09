package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTask
 * @Description: 资方抵押任务实体
 * @date 2018-05-30
 */
@Data
public class EquMorTask extends BaseEntity<EquMorTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押任务id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String equMorTaskId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 资方
	 * @author qiaomengnan
	 */
	private String management;

	/**
	 * @Fields  : 抵押流程
	 * @author qiaomengnan
	 */
	private String mortgageProcess;

	/**
	 * @Fields  : 抵押任务状态
	 * @author qiaomengnan
	 */
	private String mortgageServStatus;

	/** 
	 * @Fields  : 当前节点用户
	 * @author qiaomengnan
	 */ 
	private String presentUser;

}