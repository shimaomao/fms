package cn.com.leadu.fms.prebiz.validator.bizfiles.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: BizFilesVo
 * @Description: 附件信息删除时载体及验证
 * @date 2018-04-09
 */
@Data
public class BizFilesDeleteVo extends BaseVo<BizFiles> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 附件ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String fileId;

}