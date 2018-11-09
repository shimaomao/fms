package cn.com.leadu.fms.pojo.prebiz.vo.contcreate;

import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: ContCreateVo
 * @Description: 合同生成
 * @date 2018-03-23
 */
@Data
public class ContCreateVo{

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = "合同号不能为空！")
	private String contNo;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields : 还款日
	 */
	private String repayDay;
    /**
     * @Fields  :
     */
    private BigDecimal initPerc;

    /**
     * @Fields  :
     */
    private BigDecimal initAmount;
    /**
     * @Fields  :
     */
    private BigDecimal investTotal;

    /**
     * @Fields  :
     */
    private BigDecimal finTotal;


    /**
     * @Fields  :
     */
    private BigDecimal depositPerc;

    /**
     * @Fields  :
     */
    private BigDecimal deposit;

    /**
     * @Fields  :
     */
    private String saleGroupCode;

    /**
     * @Fields  :
     */
    private String saleGroupName;

    /**
	 * @Fields  : 
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 
	 */
	private String accountName;

	/**
	 * @Fields  : 
	 */
	private String certifNo;

	/**
	 * @Fields  : 
	 */
	private String accMobileNo;

	/**
	 * @Fields  : 
	 */
	private String accBank;

	/**
	 * @Fields  : 
	 */
	private String accountNo;

	/**
	 * @Fields  : 定金金额
	 */
	private BigDecimal vehDeposit;

	/**
	 * @Fields  : 定金是否抵扣车款
	 */
	private String deductibleFees;

	/**
	 * @Fields  :发动机号
	 */
	@NotBlank(message = "发动机号不能为空！")
	private String engineNo;
	/**
	 * @Fields  :车架号
	 */
	@NotBlank(message = "车架号不能为空！")
	private String vinNo;

	/**
	 * @Fields  :车辆颜色
	 */
	@NotBlank(message = "车辆颜色不能为空！")
	private String color;

	/**
	 * @Fields  : 备注
	 */
	private String memo;

	/**
	 * @Fields  : 操作用户
	 */
	private String user;

	/**
	 * @Fields  : 任务id
	 */
	private String taskId;
	/**
	 * @Fields  : 经销商收款银行
	 */
//	@NotBlank(message = "经销商收款银行不能为空！")
	private String recAccBank;

	/**
	 * @Fields  : 经销商收款支行
	 */
	private String recAccBranchBank;

	/**
	 * @Fields  : 经销商收款银行户名
	 */
	private String recAccountName;

	/**
	 * @Fields  : 经销商收款账号
	 */
	private String recAccountNo;
	/**
	 * @Fields  : 银行机构代码
	 */
	private String groupCode;

	/**
	 * @Fields  : 银行账户序号
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 附件
	 * @author liujinge
	 */
	private CommonBizFilesVo bizFilesVo;
	/**
	 * @Fields  :
	 */
	private String applyType;
	/**
	 * @Fields  : 附件类型
	 */
	private String fileType;

	/**
	 * @Fields  : 附件集合用于返回详情使用
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 指标编号
	 * @author license_idx_no
	 */
	private String licenseIdxNo;

	/**
	 * @Fields  : 牌照使用费
	 */
	private BigDecimal licenseFee;

	/**
	 * @Fields  : 用户代码
	 * @author belon_group
	 */
	private String belonGroup;

	/**
	 * @Fields  : 为系统常量维护的用户代码
	 * @author belon_group
	 */
	private String syspambelonGroup;

}