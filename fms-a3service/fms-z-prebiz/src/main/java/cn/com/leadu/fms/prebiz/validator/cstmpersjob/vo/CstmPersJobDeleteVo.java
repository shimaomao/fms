package cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobVo
 * @Description: 客户个人职业信息删除时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersJobDeleteVo extends BaseVo<CstmPersJob> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人职业信息ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String persJobId;

}