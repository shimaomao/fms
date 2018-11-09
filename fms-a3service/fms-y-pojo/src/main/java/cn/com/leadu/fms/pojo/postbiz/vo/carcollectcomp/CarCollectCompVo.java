package cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompVo
 * @Description: 收车机构维护载体
 * @date 2018-05-22
 */
@Data
public class CarCollectCompVo extends PageQuery<CarCollectComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 收车机构ID
	 * @author yanfengbo
	 */
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
	 * @Fields  : 收车机构ID
	 * @author yanfengbo
	 */
	private List<String> carCollectCompIds;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

}