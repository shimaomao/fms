package cn.com.leadu.fms.pojo.asset.vo.equmordetail;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailArchiveVo
 * @Description: 资方抵押归档
 * @date 2018-05-30
 */
@Data
public class EquMorDetailArchiveVo extends PageQuery<EquMorDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押明细id
	 * @author qiaomengnan
	 */
	@NotBlank(message = "抵押明细ID不能为空")
	private String equMorDetailId;

	/**
	 * @Fields  : 抵押地(注册地)
	 * @author qiaomengnan
	 */
	@NotBlank(message = "抵押地不能为空")
	private String mortgageAddr;

	/**
	 * @Fields  : 抵押日期
	 * @author qiaomengnan
	 */
	@NotNull(message = "抵押日期不能为空")
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date mortgageDate;

	/**
	 * @Fields  : 抵押权人(出租人)
	 * @author qiaomengnan
	 */
	@NotBlank(message = "抵押权人不能为空")
	private String mortgagee;


	@NotNull(message = "请上传附件")
	@Size(min = 1 , message = "请上传附件")
	@Valid
	private List<BizFilesVo> bizFilesList;

}