package cn.com.leadu.fms.prebiz.validator.cstmcontact.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CstmContactVo
 * @Description: 客户联系人信息删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class CstmContactDeleteVo extends BaseVo<CstmContact> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 联系人信息ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contactId;

}