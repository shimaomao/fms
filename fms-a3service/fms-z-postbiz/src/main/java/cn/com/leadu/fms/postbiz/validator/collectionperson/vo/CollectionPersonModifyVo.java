package cn.com.leadu.fms.postbiz.validator.collectionperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonVo
 * @Description: 催收组员修改时载体及验证
 */
@Data
public class CollectionPersonModifyVo extends BaseVo<CollectionPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 催收人员id

	 * @author qinmuqiao
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String collectionPersonId;

	/**
	 * @Fields  : 0-电催，1-上门，2-收车，3-诉讼
	 * @author qinmuqiao
	 */
	@NotBlank(message = "催收类型不能为空")
	private String collectionType;

	/**
	 * @Fields  : 催收人员账号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "账号不能为空")
	private String collectionPersonNum;

	/**
	 * @Fields  : 备注
	 * @author qinmuqiao
	 */
	@NotBlank(message = "备注不能为空")
	private String remark;

	/**
	 * @Fields  : 启用标识
	 * @author qinmuqiao
	 */
	@NotBlank(message = "启用不能为空")
	private String enableFlag;

}