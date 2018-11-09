package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: RiskPerson
 * @Description: 个人风险信息实体
 * @date 2018-06-04
 */
@Data
public class RiskPerson extends BaseEntity<RiskPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人风险信息id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String riskPersonId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 关系类型
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 反欺诈风险评分
	 * @author liujinge
	 */
	private String antiResult;

	/**
	 * @Fields  : 地址核验居住地
	 * @author liujinge
	 */
	private String resideAddrCheck;

	/**
	 * @Fields  : 地址核验单位地址
	 * @author liujinge
	 */
	private String compAddrCheck;

	/**
	 * @Fields  : 手机归属地省市
	 * @author liujinge
	 */
	private String phoneAddr;

	/**
	 * @Fields  : 与户籍地址匹配
	 * @author liujinge
	 */
	private String censusAddrMatch;

	/**
	 * @Fields  : 与居住地址匹配
	 * @author liujinge
	 */
	private String resideAddrMatch;

	/**
	 * @Fields  : 与房产地址匹配
	 * @author liujinge
	 */
	private String propertyAddrMatch;

	/**
	 * @Fields  : 驾照核查
	 * @author liujinge
	 */
	private String driverResult;

	/**
	 * @Fields  : 出租人城市和承租人居住地城市匹配
	 * @author liujinge
	 */
	private String applyAddrMatch;

	/**
	 * @Fields  : 风险信息确认
	 * @author liujinge
	 */
	private String riskConfirm;

	/**
	 * @Fields  : 人行征信信息提示
	 * @author liujinge
	 */
	private String pbcCreditMemo;


	/**
	 * @Fields  : 担保人与承租人关系
	 * @author liujinge
	 */
	private String guaranteeRelation;

	/**
	 * @Fields  : 手机号码在网时长
	 * @author yanggang
	 */
	private String timeLength;


}