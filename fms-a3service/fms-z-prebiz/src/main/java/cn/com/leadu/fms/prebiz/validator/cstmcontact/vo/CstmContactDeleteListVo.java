package cn.com.leadu.fms.prebiz.validator.cstmcontact.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactVo
 * @Description: 客户联系人信息删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class CstmContactDeleteListVo extends BaseVo<CstmContact> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 联系人信息ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> contactIds;

}