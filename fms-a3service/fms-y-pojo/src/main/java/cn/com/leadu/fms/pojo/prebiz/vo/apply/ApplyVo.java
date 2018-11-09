package cn.com.leadu.fms.pojo.prebiz.vo.apply;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: ApplyVo
 * @Description: 申请信息载体
 * @date 2018-03-26
 */
@Data
public class ApplyVo extends PageQuery<Apply> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String applyId;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields  :
	 */
	private String applyType;


	/**
	 * @Fields  : 
	 */
	private String bizStatus;

	/**
	 * @Fields  : 
	 */
	private String applyUser;

	/**
	 * @Fields  : 
	 */
	private String applyGroup;

	/**
	 * @Fields  : 
	 */
	private Date applyCreatDate;

	/**
	 * @Fields  : 
	 *//*
	private Date applyFirsbtDate;*/

	/**
	 * @Fields  : 
	 */
	private Date applySubmitDate;

	/**
	 * @Fields  : 
	 */
	private Date applyPassDate;

	/**
	 * @Fields  : 
	 */
	private String presentUser;

	/**
	 * @Fields  : 
	 */
	private List<String> applyIds;

	/**
	 * @Fields  : 企业类型1
	 * @author ningyangyang
	 */
	private String companyType1;

	/**
	 * @Fields  : 企业类型2
	 * @author ningyangyang
	 */
	private String companyType2;

	/**
	 * @Fields  : 是否适合抵押
	 * @author liujinge
	 */
	private String mortgageFlag;

	/**
	 * @Fields  : 是否有条件同意
	 * @author liujinge
	 */
	private String approveFlag;

	/**
	 * @Fields  : 有条件同意人,1-主管，2-总经理
	 * @author liujinge
	 */
	private String approveFlagPerson;

	/**
	 * @Fields  : 是否家访
	 * @author ningyangyang
	 */
	private String visitFlag;

	/**
	 * @Fields  : 不家访理由
	 * @author ningyangyang
	 */
	private String novisitReason;

	/**
	 * @Fields  : 个人申请类型
	 * @author qiaomengnan
	 */
	private String applyTypePerson;

	/**
	 * @Fields  : 客户名称
	 * @author qiaomengnan
	 */
	private String lessee;

	/**
	 * @Fields  : 订单编号结合
	 * @author qiaomengnan
	 */
	private List<String> applyNos;

	/**
	 * @Fields  : 风控初审派单指派处理人
	 * @author qiaomengnan
	 */
	private String approveUser;

	/** 
	 * @Fields  : 个人申请信息
	 * @author qiaomengnan
	 */ 
	private CstmPersonVo cstmPersonVo;

	/** 
	 * @Fields  : 企业申请信息
	 * @author qiaomengnan
	 */ 
	private CstmCompanyVo cstmCompanyVo;

	/** 
	 * @Fields  : 申请人财务核算代码
	 * @author qiaomengnan
	 */ 
	private String finassCstmCode;
	
	/** 
	 * @Fields  : 出租人财务核算代码
	 * @author qiaomengnan
	 */ 
	private String finassGroupCode;
	
	/** 
	 * @Fields  : 实际销售方财务核算代码
	 * @author qiaomengnan
	 */ 
	private String finassSalesCode;

	/**
	 * @Fields  : 合同编号
	 * @author qiaomengnan
	 */
	private String contNo;

	/**
	 * @Fields  : 订单首次提交日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date applyFirsbtDate;

	/**
	 * @Fields  : 派单状态
	 * @author yanfengbo
	 */
	private String applyDispatchStatus;

}