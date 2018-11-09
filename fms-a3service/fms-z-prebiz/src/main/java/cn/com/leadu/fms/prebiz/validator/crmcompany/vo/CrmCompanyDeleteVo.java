package cn.com.leadu.fms.prebiz.validator.crmcompany.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyVo
 * @Description: CRM企业信息删除时载体及验证
 * @date 2018-05-23
 */
@Data
public class CrmCompanyDeleteVo extends BaseVo<CrmCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String companyId;

}