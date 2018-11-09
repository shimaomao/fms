package cn.com.leadu.fms.asset.validator.mortgageremind.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindVo
 * @Description: 抵押提醒保存时载体及验证
 * @date 2018-07-27
 */
@Data
public class MortgageRemindSaveVo extends BaseVo<MortgageRemind> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 抵押提醒id
	 * @author ningyangyang
	 */
	private String morRemindId;

	/**
	 * @Fields  : 承租人
	 * @author ningyangyang
	 */
	private String lessee;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
	private String lessor;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 融资额
	 * @author ningyangyang
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 融资期限
	 * @author ningyangyang
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 抵押状态
	 * @author ningyangyang
	 */
	private String mortgageStatus;

	/**
	 * @Fields : 读取上传后的附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields : 需要上传的附件信息
	 * @author yanfengbo
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 抵押提醒实体集合
	 * @author ningyangyang
	 */
	private List<MortgageRemind> mortgageRemindList;

	/**
	 * @Fields  : 抵押日期
	 * @author ningyangyang
	 */
	private Date mortgageDate;

}