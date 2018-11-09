package cn.com.leadu.fms.pojo.system.vo.numgenerate;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: NumGenerateVo
 * @Description: 业务编号管理载体
 * @date 2018-03-26
 */
@Data
public class NumGenerateVo extends PageQuery<NumGenerate> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String numGenerateId;

	/**
	 * @Fields  : 
	 */
	private String numType;

	/**
	 * @Fields  : 
	 */
	private Integer numSeq;

	/**
	 * @Fields  : 
	 */
	private Integer numLength;

	/**
	 * @Fields  : 
	 */
	private String prefix;

	/**
	 * @Fields  : 
	 */
	private String suffix;

	/**
	 * @Fields  :
	 */
	private String generateDate;

	/**
	 * @Fields  : 
	 */
	private List<String> numGenerateIds;

}