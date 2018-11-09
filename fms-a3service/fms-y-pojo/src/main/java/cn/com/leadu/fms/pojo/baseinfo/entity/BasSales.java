package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: BasSales
 * @Description: 实际销售方实体
 * @date 2018-05-03
 */
@Data
public class BasSales extends BaseEntity<BasSales> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 实际销售方id
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String salesId;

	/**
	 * @Fields  : 实际销售方代码
	 * @author yanfengbo
	 */
	private String salesCode;

	/**
	 * @Fields  : 实际销售方全称
	 * @author yanfengbo
	 */
	private String salesName;

	/**
	 * @Fields  : 实际销售方任务号
	 * @author yanfengbo
	 */
	private String salesTaskNo;

	/**
	 * @Fields  : 实际销售方状态
	 * @author yanfengbo
	 */
	private String salesTaskStatus;

	/**
	 * @Fields  : 所属集团
	 * @author yanfengbo
	 */
	private String withinGroup;

	/**
	 * @Fields  : 店面属性
	 * @author yanfengbo
	 */
	private String salesType;

	/**
	 * @Fields  : 所在省份
	 * @author yanfengbo
	 */
	private String addrProv;

	/**
	 * @Fields  : 所在城市
	 * @author yanfengbo
	 */
	private String addrCity;

	/**
	 * @Fields  : 所在区县
	 * @author yanfengbo
	 */
	private String addrCounty;

	/**
	 * @Fields  : 所在地址
	 * @author yanfengbo
	 */
	private String address;

	/**
	 * @Fields  : 注册省份
	 * @author yanfengbo
	 */
	private String registerProv;

	/**
	 * @Fields  : 注册城市
	 * @author yanfengbo
	 */
	private String registerCity;

	/**
	 * @Fields  : 注册区县
	 * @author yanfengbo
	 */
	private String registerCounty;

	/**
	 * @Fields  : 注册地址
	 * @author yanfengbo
	 */
	private String registerAddress;

	/**
	 * @Fields  : 担保期限
	 * @author yanfengbo
	 */
	private Date guaranteePeriod;

	/**
	 * @Fields  : 车辆类型
	 * @author yanfengbo
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 联系人员
	 * @author yanfengbo
	 */
	private String contact;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String contactTel1;

	/**
	 * @Fields  : 销售品牌
	 * @author yanfengbo
	 */
	private String saleBrand;

	/**
	 * @Fields  : 所属经销商代码
	 * @author yanfengbo
	 */
	private String parGroupCode;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassSalesCode;

}