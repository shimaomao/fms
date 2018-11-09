package cn.com.leadu.fms.business.service.impl;/**
 * Created by ningyangyang on 2018/9/3.
 */

import cn.com.leadu.fms.business.service.CommonGetRepayInfoService;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedAlreadyPayInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/9/3 9:49
 */
@Slf4j
@Service
public class CommonGetRepayInfoServiceImpl implements CommonGetRepayInfoService{


    /**
     * @Fields  :  融资合同还款计划信息repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;


        /**
         * @Title:
         * @Description:  查看还款计划表已还金额和期数
         * @param contNo
         * @throws
         * @author ningyangyang
         * @date 2018-9-3 16:12:19
         */
        public ContRepaySkedAlreadyPayInfoVo commonGetRepayInfo(String contNo) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        SqlUtil.setOrderByColumnAsc(example,"period");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example); //根据合同号获取还款计划表明细
        if(contRepaySkedList == null || contRepaySkedList.size()==0){
            throw new FmsServiceException("获取融资合同还款计划信息失败");
        }
        BigDecimal alreadyRepayAmount = BigDecimal.ZERO;//已还金额
        //BigDecimal residueAmount = BigDecimal.ZERO;//剩余未还租金
        int alreadyRepayNper = 0;//已还期数
        //还款计划表已还信息载体
        ContRepaySkedAlreadyPayInfoVo contRepaySkedAlreadyPayInfoVo = new ContRepaySkedAlreadyPayInfoVo();
        for(ContRepaySked contRepaySked : contRepaySkedList){
            if(RepayStatusEnums.WITHDRAWING_SUCCESS.getType().equals(contRepaySked.getRepayStatus())//成功
             ){
                if(0 != contRepaySked.getPeriod()){//去掉首付那一期
                    alreadyRepayNper++;
                    alreadyRepayAmount = alreadyRepayAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
                }
            }
//            else{
//                residueAmount = residueAmount.add(BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()));
//            }
        }
            //已还金额
            contRepaySkedAlreadyPayInfoVo.setAlreadyRepayAmount(alreadyRepayAmount);
           // contPrepaymentVo.setResidueAmount(residueAmount);
            //已还期数
            contRepaySkedAlreadyPayInfoVo.setAlreadyRepayNper(alreadyRepayNper);
            //最近未还的期数
            ContRepaySkedVo contRepaySkedVo = contRepaySkedRepository.selectContRepaySkedToBePay(contNo);
            contRepaySkedAlreadyPayInfoVo.setStartValiDate(contRepaySkedVo.getRepayDate());
            return contRepaySkedAlreadyPayInfoVo;
    }
}
