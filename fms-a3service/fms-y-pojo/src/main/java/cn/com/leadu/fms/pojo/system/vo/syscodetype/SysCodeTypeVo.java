package cn.com.leadu.fms.pojo.system.vo.syscodetype;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import lombok.Data;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeVo
 * @Description: 字典数据类型载体
 * @date 2018-03-08
 */
@Data
public class SysCodeTypeVo extends PageQuery<SysCodeType> {

	private static final long serialVersionUID = 1L;

	private String codeTypeId;

	private String codeType;

	private String codeTypeName;

	private String enableFlag;

	private String memo;

	private List<String> codeTypeIds;

}