package cn.com.leadu.fms.prebiz.validator.crmperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonVo
 * @Description: CRM个人信息删除时载体及验证
 * @date 2018-05-23
 */
@Data
public class CrmPersonDeleteVo extends BaseVo<CrmPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 客户id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String personId;

}