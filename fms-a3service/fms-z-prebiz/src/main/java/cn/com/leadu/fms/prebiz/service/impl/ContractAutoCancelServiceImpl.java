package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.service.ContractAutoCancelService;
import cn.com.leadu.fms.prebiz.service.ContractCancelService;
import cn.com.leadu.fms.prebiz.service.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.BizStatusEnums.WAIT_CONTRACT_GENERATE;
import static cn.com.leadu.fms.common.constant.enums.BizStatusEnums.WAIT_CONTRACT_PRINT;
import static cn.com.leadu.fms.common.constant.enums.BizStatusEnums.WAIT_CONTRACT_REQUEST_FUNDS;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelServiceImpl
 * @Description: 未生效合同自动取消
 * @date
 */
@Slf4j
@Service
public class ContractAutoCancelServiceImpl implements ContractAutoCancelService {
    /**
     * @Fields  : 系统常量调用rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 合同实体调用service
     */
    @Autowired
    private ContractService contractService;

    /**
     * @Fields  : 融资合同取消调用service
     */
    @Autowired
    private ContractCancelService contractCancelService;

    /**
     * @Title:
     * @Description: 未生效合同自动取消
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void contractAutoCancel(SysUser sysUser){

        //取"当前日期-订单提交限制天数"值
        Date date = new Date();
        String  ContractAutoCancelDay;
        try {
            ContractAutoCancelDay =   ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey("ContractAutoCancelDay"));
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new FmsServiceException("合同提交限制天数获取失败");
        }
        long ApplyAutoCancelDayLong = Long.parseLong(ContractAutoCancelDay);
        long timeDif = (date.getTime() - 86400000 * ApplyAutoCancelDayLong);

        //取合同状态为"待生成合同，待合同打印，待请款"的合同
        List<String> bizStatusList = new ArrayList<String>();
        bizStatusList.add(WAIT_CONTRACT_GENERATE.getType());
        bizStatusList.add(WAIT_CONTRACT_PRINT.getType());
        bizStatusList.add(WAIT_CONTRACT_REQUEST_FUNDS.getType());
        List<Contract> contracts = contractService.findContractsBybizStatusList(bizStatusList);

        //如果审核通过日期 < 当前日期 - 系统常量.合同提交限制天数 则取消该合同
        for (Contract contract : contracts){
            if(contract.getPassDate()!=null){
                if (contract.getPassDate().getTime()<timeDif){
                    ContractCancelVo contractCancelVo = new ContractCancelVo();
                    contractCancelVo.setContNo(contract.getContNo());
                    contractCancelVo.setApplyNo(contract.getApplyNo());
                    contractCancelService.modifyContractCancel(contractCancelVo,sysUser);
                }
            }
        }
    }

}
