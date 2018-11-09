package cn.com.leadu.fms.pojo.prebiz.vo.crmcompany;
/**
 * Created by ningyangyang on 2018/5/25.
 */

import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import lombok.Data;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/5/25 17:02
 */
@Data
public class CrmCompanyCarrierVo {

    /**
     * @Fields  : 主贷企业
     * @author ningyangyang
     */
    private CstmCompany cstmCompany;

    /**
     * @Fields  : 担保企业
     * @author ningyangyang
     */
    private GuaranteeComp guaranteeComp;
}
