package cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import lombok.Data;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeVo
 * @Description: 个人基本信息变更表载体
 * @date 2018-08-31
 */
@Data
public class PersonBasicChangePostVo extends PageQuery<PersonBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * 变更前
	 */
	private PersonBasicChangeVo oldPersonBasicChangeVo;

	/**
	 * 变更后
	 */
	private PersonBasicChangeVo newPersonBasicChangeVo;

	/**
	 * 任务id
	 */
	private String taskId;

	/**
	 * 任务号
	 */
	private String personTaskNo;
}