package cn.com.leadu.fms.riskmgmt.validator.riskperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import lombok.Data;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: RiskPersonVo
 * @Description: 个人风险信息保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskPersonSaveVo extends BaseVo<RiskPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人风险信息id
	 * @author liujinge
	 */
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

}