package cn.com.leadu.fms.baseinfo.validator.basfiletype.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeVo
 * @Description: 附件类型管理表删除时载体及验证
 * @date 2018-03-19
 */
@Data
public class BasFileTypeDeleteVo extends BaseVo<BasFileType> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 附件类型ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String fileTypeId;

    private  String fileType;

    private String parentFileType;

}