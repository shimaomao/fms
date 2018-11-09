package cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk;


import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyRiskVo
 * @Description: 贷前风控审批载体
 * @date 2018-06-02
 */
@Data
public class ApplyRiskVo {

    private static final long serialVersionUID = 1L;

    //申请融资信息
    private ApplyFinanceVo applyFinanceVo;

    //申请信息
    private Apply apply;
    //个人基本信息
    private CstmPerson cstmPerson;

    //个人职业信息
    private CstmPersJob cstmPersJob;

    //个人地址信息
    private CstmPersAddr cstmPersAddr;

    //企业基本信息
    private CstmCompany cstmCompany;

    //购车合理性
    private RationalityPurchase rationalityPurchase;

    /**
     * 担保人信息
     */
    private List<GuaranteePers> guaranteePersList;
    /**
     * 担保企业信息
     */
    private List<GuaranteeComp> guaranteeCompList;

    /**
     *  共同借款人
     */
    List<CommonBorrower> commonBorrowerList;
    //电核信息
    private List<RiskTelchkVo> riskTelchkVoList;

    //鹏元查询一览
    private List<PycreditListVo> pycreditListVoList;

    //收入负债比测算
    //承租人
    private RiskMgmtPerson riskMgmtPerson;
    private RiskMgmtComp riskMgmtComp;

    //担保人
    private List<RiskMgmtGuarantee> riskMgmtGuaranteeList;

    //承租人风险信息
    private RiskPersonVo riskPersonVoMain;
    private RiskCompanyVo riskCompanyVoMain;

    //共同借款人风险信息
    private List<RiskPersonVo> riskPersonVoBorrList;
    //担保人风险信息
    private List<RiskPersonVo> riskPersonVoGuarList;
    //担保人配偶风险信息
    private List<RiskPersonVo> riskPersonVoGuMateList;
    //担保企业风险信息
    private List<RiskCompanyVo> riskCompanyVoGuarList;
    //银行流水信息
    private List<AccountDetailVo> accountDetailVoList;

    /**
     * @Fields  : 附件
     * @author yangyiquan
     */
    private CommonBizFilesVo bizFilesVo;

    /**
     * @Fields  : 附件集合用于返回详情使用
     * @author qiaomengnan
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 风险融资额
     * @author yangyiquan
     */
    private BigDecimal riskAmount;

    /**
     * @Fields  : 备注
     * @author yangyiquan
     */
    private String memo;
    /**
     * @Fields  :  任务id
     */
    private String taskId;
    /**
     * @Fields  : 当前用户
     */
    private String user;

    /**
     * @Fields  : 是否走工作流
     */
    private String saveFlag;

    /**
     * @Fields  : 承租人变更信息
     */
    private ChangeLesseeTask changeLesseeTask;

    /**
     * @Fields  : 承租人信息变更判断
     */
    private String isChangeLessee;

    /**
     * @Fields  : 任务号
     */
    private String taskNo;

}