package cn.com.leadu.fms.pojo.product.vo.prodfile;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileVo
 * @Description: 产品附件管理载体
 * @date 2018-04-05
 */
@Data
public class ProdFileVo extends PageQuery<ProdFile> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String prodFileId;

	/**
	 * @Fields  : 
	 */
	private String product;
	/**
	 * @Fields  :
	 */
	private String fileTypeId;
	/**
	 * @Fields  :
	 */
	private String fileType;

	/**
	 * @Fields  :
	 */
	private String fileTypeName;
	/**
	 * @Fields  :
	 */
	private String showType;

	/**
	 * @Fields  : 
	 */
	private List<String> prodFileIds;

}