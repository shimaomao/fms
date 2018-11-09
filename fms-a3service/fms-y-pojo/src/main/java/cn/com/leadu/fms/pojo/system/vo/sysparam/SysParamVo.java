package cn.com.leadu.fms.pojo.system.vo.sysparam;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: SysParamVo
 * @Description: 系统常量表载体
 * @date 2018-03-09
 */
@Data
public class SysParamVo extends PageQuery<SysParam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 参数主键id
	 */
	private String paramKeyId;

	/**
	 * @Fields  : 参数主键
	 */
	private String paramKey;

	/**
	 * @Fields  : 参数名称
	 */
	private String paramName;

	/**
	 * @Fields  : 参数描述
	 */
	private String paramDesc;

	/**
	 * @Fields  : 参数值
	 */
	private String paramValue;

	/**
	 * @Fields  : 开始日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDate;

	/**
	 * @Fields  : 结束日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDate;

	/**
	 * @Fields  : 参数主键id
	 */
	private List<String> paramKeyIds;



}