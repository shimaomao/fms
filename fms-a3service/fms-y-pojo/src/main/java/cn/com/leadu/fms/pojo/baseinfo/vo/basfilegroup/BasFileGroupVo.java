package cn.com.leadu.fms.pojo.baseinfo.vo.basfilegroup;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupVo
 * @Description: 附件组载体
 */
@Data
public class BasFileGroupVo extends PageQuery<BasFileGroup> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 附件组id
	 * @author ningyangyang
	 */
	private String basFileGroupId;

	/**
	 * @Fields  : 附件类型上级
	 * @author ningyangyang
	 */
	private String fileTypePar;

	/**
	 * @Fields  : 附件类型下级
	 * @author ningyangyang
	 */
	private String fileTypeChi;

	/**
	 * @Fields  : 附件组id
	 * @author ningyangyang
	 */
	private List<String> basFileGroupIds;

}