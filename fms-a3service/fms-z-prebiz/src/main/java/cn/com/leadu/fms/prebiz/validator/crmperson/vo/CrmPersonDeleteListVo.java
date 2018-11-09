package cn.com.leadu.fms.prebiz.validator.crmperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonVo
 * @Description: CRM个人信息删除时载体及验证
 * @date 2018-05-23
 */
@Data
public class CrmPersonDeleteListVo extends BaseVo<CrmPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 客户id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> personIds;

}