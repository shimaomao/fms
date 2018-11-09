package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.postbiz.rpc.prebiz.ContractRpc;
import cn.com.leadu.fms.postbiz.service.AutomaticSettleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

import static cn.com.leadu.fms.common.constant.enums.postbiz.InsuranceStatusEnums.INSURANCE_INVALID;

/**
 * @description:
 * @author:ningyangyang
 * @since:2018/5/15
 */
@Service
public class AutomaticSettleServiceImpl implements AutomaticSettleService{


    /**
     * @Fields  : 合同信息rpc
     */
    @Autowired
    private ContractRpc contractRpc;

    /**
     * @Fields  : 合同还款Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 罚息Repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepositor;

    /**
     * @Fields  : 合同信息Repository
     */
    @Autowired
    private ContractRepository contractRepository;
    /**
     * @Fields  :车辆保险Repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;
    /**
     * @Title:
     * @Description: 合同还款自动结清
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-15 18:02:32
     */
    @Override
    @Transactional
    public void automaticSettle() {

        contractRepository.updateAutomaticClearing(PaymentStsEnums.UNCLEARED.getType(),BizStatusEnums.CONTRACT_EFFECT.getType()
            , RepayStatusEnums.WITHDRAWING_SUCCESS.getType(),PaymentStsEnums.AUTOMATIC_CLEARING.getType());

       /* Contract contract  = new Contract();
        contract.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());
        contract.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());
        Map<String,Object> contractMap = contract == null?null:(Map) JSON.toJSON(contract);
        try {
         List<Contract> contractList =   ResponseEntityUtils.getRestResponseData(contractRpc.findContractsByContractStatus(contractMap));
            if(ArrayUtils.isNotNullAndLengthNotZero(contractList)){
                for(Contract cont:contractList){
                    int count =  contRepaySkedRepository.selectContRepaySkeCountByContNo(cont.getContNo());
                    if(count == 0){
                        int cout =  contOverdueRepositor.selectCountOverDueByContNo(cont.getContNo());
                        if(cout == 0){
                            Example ex1 = SqlUtil.newExample(Contract.class);
                            ex1.createCriteria().andEqualTo("contNo",cont.getContNo());
                            cont.setPaymentSts(PaymentStsEnums.AUTOMATIC_CLEARING.getType());
                            contractRepository.updateByExampleSelectiveData(cont,ex1);
//                            Example ex2 = SqlUtil.newExample(ContInsurance.class);
//                            ex2.createCriteria().andEqualTo("contNo",cont.getContNo());
//                            ContInsurance contInsurance  = new ContInsurance();
//                            contInsurance.setInsuranceStatus(INSURANCE_INVALID.getType());
//                            contInsuranceRepository.updateByExampleSelectiveData(contInsurance,ex2);
                        }
                    }
                }
            }
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取合同信息失败");
        }*/
    }
}
