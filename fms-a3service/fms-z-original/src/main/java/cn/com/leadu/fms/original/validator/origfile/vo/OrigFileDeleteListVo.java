package cn.com.leadu.fms.original.validator.origfile.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileVo
 * @Description: 资料邮寄附件删除时载体及验证
 * @date 2018-05-03
 */
@Data
public class OrigFileDeleteListVo extends BaseVo<OrigFile> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资料ID
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> origFileIds;

}