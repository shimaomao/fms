package cn.com.leadu.fms.baseinfo.validator.bassales.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasSalesVo
 * @Description: 实际销售方修改时载体及验证
 * @date 2018-05-03
 */
@Data
public class BasSalesModifyVo extends BaseVo<BasSales> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 实际销售方id
	 * @author yanfengbo
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : TaskId
	 */
	private String taskId;

	/**
	 * @Fields  : 操作分类
	 */
	private String actType;

	/**
	 * @Fields  : 备注
	 */
	private String remark1;

	/**
	 * @Fields  : serviceId
	 */
	private String serviceId;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 财务辅助核算代码
	 */
	private String finassSalesCode;

	/**
	 * @Fields  : 展示附件
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;
}