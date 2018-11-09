package cn.com.leadu.fms.original.validator.filesend.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: FileSendVo
 * @Description: 资料邮寄删除时载体及验证
 * @date 2018-05-04
 */
@Data
public class FileSendDeleteVo extends BaseVo<FileSend> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资料邮寄ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String filePostId;

}