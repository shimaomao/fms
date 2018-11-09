package cn.com.leadu.fms.baseinfo.validator.basarea.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: BasAreaVo
 * @Description: 省市县信息维护修改时载体及验证
 * @date 2018-03-15
 */
@Data
public class BasAreaModifyVo extends BaseVo<BasArea> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 区域ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String areaId;

	/**
	 * @Fields  : 区域代码
	 */
	private String areaCode;

	/**
	 * @Fields  : 区域名称
	 */
	private String areaName;

	/**
	 * @Fields  : 区域级别
	 */
	private String areaLevel;

	/**
	 * @Fields  : 父区域代码
	 */
	private String parentAreaCode;
	/**
	 * @Fields  : 上级区名称
	 */
	private String   parentAreaName;

}