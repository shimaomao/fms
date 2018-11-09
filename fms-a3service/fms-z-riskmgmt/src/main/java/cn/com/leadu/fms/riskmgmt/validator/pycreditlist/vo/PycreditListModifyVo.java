package cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditListVo
 * @Description: 鹏元查询一览修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditListModifyVo extends BaseVo<PycreditList> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 鹏元查询id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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