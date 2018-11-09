package cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompVo
 * @Description: 收车机构维护修改时载体及验证
 * @date 2018-05-22
 */
@Data
public class CarCollectCompModifyVo extends BaseVo<CarCollectComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 收车机构ID
	 * @author yanfengbo
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String carCollectCompId;

	/**
	 * @Fields  : 收车机构代码
	 * @author yanfengbo
	 */
	private String carCollectCompCode;

	/**
	 * @Fields  : 收车机构名称
	 * @author yanfengbo
	 */
	private String carCollectCompName;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String contactTel;

	/**
	 * @Fields  : 联系地址
	 * @author yanfengbo
	 */
	private String address;

	/**
	 * @Fields  : 邮箱
	 * @author yanfengbo
	 */
	private String mailAddress;

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
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

}