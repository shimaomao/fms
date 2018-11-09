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
 * @ClassName: PycreditList
 * @Description: 鹏元查询一览实体
 * @date 2018-06-04
 */
@Data
public class PycreditList extends BaseEntity<PycreditList> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 鹏元查询id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String pycreditId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 鹏元接口类型
	 * @author liujinge
	 */
	private String pycreditType;

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
	 * @Fields  : 证件号码
	 * @author liujinge
	 */
	private String documentNo;

	/**
	 * @Fields  : 手机号码
	 * @author liujinge
	 */
	private String phone;

	/**
	 * @Fields  : 单位地址
	 * @author liujinge
	 */
	private String compAddr;

	/**
	 * @Fields  : 户籍地址
	 * @author liujinge
	 */
	private String censusAddr;

	/**
	 * @Fields  : 居住地址
	 * @author liujinge
	 */
	private String resideAddr;

	/**
	 * @Fields  : 房产地址
	 * @author liujinge
	 */
	private String propertyAddr;

	/**
	 * @Fields  : 准驾车型
	 * @author liujinge
	 */
	private String carModels;

	/**
	 * @Fields  : 初次领证日期
	 * @author liujinge
	 */
	private String firstGetDate;

	/**
	 * @Fields  : 驾驶证档案编号
	 * @author liujinge
	 */
	private String archviesNo;

	/**
	 * @Fields  : 银行账号
	 * @author liujinge
	 */
	private String accountNo;

	/**
	 * @Fields  : 开户行号
	 * @author liujinge
	 */
	private String openBankNo;

	/**
	 * @Fields  : 是否调用接口
	 * @author liujinge
	 */
	private String queryFlag;

	/**
	 * @Fields  : 鹏元信息id
	 * @author liujinge
	 */
	private String pycreditResultId;

}