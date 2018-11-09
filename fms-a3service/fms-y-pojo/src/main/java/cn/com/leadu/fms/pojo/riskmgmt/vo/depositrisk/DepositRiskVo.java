package cn.com.leadu.fms.pojo.riskmgmt.vo.depositrisk;


import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: DepositRiskVo
 * @Description: 增加保证金风控审批载体
 * @date 2018-06-02
 */
@Data
public class DepositRiskVo {

    private static final long serialVersionUID = 1L;

    //申请信息
    private DepositChangeApplyVo depositChangeApplyVo;

    /**
     * 担保人信息
     */
    private List<GuaranteePers> guaranteePersList;
    /**
     * 担保企业信息
     */
    private List<GuaranteeComp> guaranteeCompList;

    //鹏元查询一览
    private List<PycreditListVo> pycreditListVoList;
    //担保人
    private List<RiskMgmtGuarantee> riskMgmtGuaranteeList;
    //担保人风险信息
    private List<RiskPersonVo> riskPersonVoGuarList;
    //担保人配偶风险信息
    private List<RiskPersonVo> riskPersonVoGuMateList;
    //担保企业风险信息
    private List<RiskCompanyVo> riskCompanyVoGuarList;
    //银行流水信息
    private List<AccountDetailVo> accountDetailVoList;

    /**
     * @Fields  : 备注
     * @author yangyiquan
     */
    private String remark;
    /**
     * @Fields  :  任务id
     */
    private String taskId;

    /**
     * @Fields  : 是否走工作流
     */
    private String saveFlag;

}