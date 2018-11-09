package cn.com.leadu.fms.prebiz.validator.cstmcompany.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyVo
 * @Description: 客户企业基本信息删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class CstmCompanyDeleteListVo extends BaseVo<CstmCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业基本信息id
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> cstmCompanyIds;

}