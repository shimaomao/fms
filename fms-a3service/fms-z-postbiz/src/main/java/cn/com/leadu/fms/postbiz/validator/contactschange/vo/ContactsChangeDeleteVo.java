package cn.com.leadu.fms.postbiz.validator.contactschange.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeVo
 * @Description: 联系人信息变更删除时载体及验证
 * @date 2018-09-01
 */
@Data
public class ContactsChangeDeleteVo extends BaseVo<ContactsChange> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 联系人信息变更id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contactsChangeId;

}