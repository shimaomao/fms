package cn.com.leadu.fms.original.validator.origfile.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: OrigFileVo
 * @Description: 资料邮寄附件删除时载体及验证
 * @date 2018-05-03
 */
@Data
public class OrigFileDeleteVo extends BaseVo<OrigFile> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资料ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String origFileId;

}