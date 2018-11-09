package cn.com.leadu.fms.prebiz.validator.crmcompany.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyVo
 * @Description: CRM企业信息删除时载体及验证
 * @date 2018-05-23
 */
@Data
public class CrmCompanyDeleteListVo extends BaseVo<CrmCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业ID
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> companyIds;

}