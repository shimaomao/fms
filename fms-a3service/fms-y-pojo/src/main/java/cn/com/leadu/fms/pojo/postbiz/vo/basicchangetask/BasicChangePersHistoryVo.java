package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: BasicChangeTaskVo
 * @Description: 个人基本信息变更历史载体
 * @date 2018-08-31
 */
@Data
public class BasicChangePersHistoryVo extends PageQuery<BasicChangePersHistoryVo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务号
	 * @author huzongcheng
	 */
	private String taskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author huzongcheng
	 */
	private String basicTaskStatus;

	/**
	 * @Fields  : 任务提交人
	 * @author huzongcheng
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author huzongcheng
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 备注
	 * @author huzongcheng
	 */
	private String remark;

	/**
	 * @Fields  : 承租人
	 * @author huzongcheng
	 */
	private String name;

	/**
	 * @Fields  : 手机号码
	 * @author huzongcheng
	 */
	private String mobileNo;

	/**
	 * @Fields  : 居住省份
	 * @author huzongcheng
	 */
	private String resideProv;

	/**
	 * @Fields  : 居住城市
	 * @author huzongcheng
	 */
	private String resideCity;

	/**
	 * @Fields  : 居住区县
	 * @author huzongcheng
	 */
	private String resideCounty;

	/**
	 * @Fields  : 居住详细地址
	 * @author huzongcheng
	 */
	private String resideAddr;

	/**
	 * @Fields  : 联系人
	 * @author huzongcheng
	 */
	private String contacts;

	/**
	 * @Fields  : 变更前承租人
	 * @author huzongcheng
	 */
	private String nameOld;

	/**
	 * @Fields  : 变更前手机号码
	 * @author huzongcheng
	 */
	private String mobileNoOld;

	/**
	 * @Fields  : 变更前居住省份
	 * @author huzongcheng
	 */
	private String resideProvOld;

	/**
	 * @Fields  : 变更前居住城市
	 * @author huzongcheng
	 */
	private String resideCityOld;

	/**
	 * @Fields  : 变更前居住区县
	 * @author huzongcheng
	 */
	private String resideCountyOld;

	/**
	 * @Fields  : 变更前居住详细地址
	 * @author huzongcheng
	 */
	private String resideAddrOld;

	/**
	 * @Fields  : 变更前联系人
	 * @author huzongcheng
	 */
	private String contactsOld;

	/**
	 * @Fields  : 申请编号
	 * @author huzongcheng
	 */
	private String applyNo;

	/**
	 * @Fields  : 联系人集合
	 * @author huzongcheng
	 */
	private List<PersContactsVo> contactsList;

}