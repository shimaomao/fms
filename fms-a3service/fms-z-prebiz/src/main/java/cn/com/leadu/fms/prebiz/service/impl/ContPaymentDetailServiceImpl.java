package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;
import cn.com.leadu.fms.common.constant.enums.finance.PaymentTypeEnums;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liujinge
 * @ClassName: ContractService
 * @Description: 合同生成前确认业务实现层
 * @date 2018-03-23
 */
@Service
public class ContPaymentDetailServiceImpl implements ContPaymentDetailService {

    /**
     * @Fields  :
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  :
     */
    @Autowired
    private BizActStatusService bizActStatusService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContractFinanceService contractFinanceService;
    /**
     * @Fields  :
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  :
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  :
     */
    @Autowired
    private ContPayService contPayService;


    /**
     * @Fields  :
     */
    @Autowired
    private CstmPersonService cstmPersonService;

    /**
     * @Fields  :
     */
    @Autowired
    private CstmCompanyService cstmCompanyService;


    /**
     * @Fields  :
     */
    @Autowired
    private ContRepayAccountService contRepayAccountService;
    /**
     * @Fields  :资料邮寄附件Repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  :合同附件rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;
    /**
     * @Fields  :资料邮寄附件详情Repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  :合同Repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  :系统常量rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Title:
     * @Description: 通过合同编号和订单编号获取ContPaymentVo
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    public ContPaymentVo findContPaymentVo(String contNo,String applyNo){

        ContPaymentVo contPaymentVo = new ContPaymentVo();

        //个人名
        if(StringUtils.isNotTrimBlank(applyNo)){
            CstmPerson cstmPerson = cstmPersonService.findCstmPersonByApplyNo(applyNo);
            if(StringUtils.isNotTrimBlank(cstmPerson)){
                contPaymentVo.setUser(cstmPerson.getName());
            }
        }
        //企业名
        if(StringUtils.isNotTrimBlank(applyNo)){
            CstmCompany cstmCompany = cstmCompanyService.findCstmCompanyByApplyNo(applyNo);
            if(StringUtils.isNotTrimBlank(cstmCompany)){
                contPaymentVo.setUser(cstmCompany.getName());
            }
        }

        if(StringUtils.isNotTrimBlank(contNo)){
            ContPay contPay = contPayService.findContPayByBizCodeAndPaymentType(PaymentTypeEnums.CONTREQUEST.getType(), contNo);
            //付款金额
            if(StringUtils.isNotTrimBlank(contPay.getPayAmount())){
                contPaymentVo.setPayAmount(contPay.getPayAmount());
            }

            //收款银行
            if(StringUtils.isNotTrimBlank()){
                contPaymentVo.setRecAccBank(contPay.getRecAccBank());
            }

            //收款银行户名
            if(StringUtils.isNotTrimBlank(contPay.getRecAccountName())){
                contPaymentVo.setRecAccountName(contPay.getRecAccountName());
            }

            //收款银行账号
            if(StringUtils.isNotTrimBlank(contPay.getRecAccountNo())){
                contPaymentVo.setRecAccountNo(contPay.getRecAccountNo());
            }
        }

        return contPaymentVo;
    }
}