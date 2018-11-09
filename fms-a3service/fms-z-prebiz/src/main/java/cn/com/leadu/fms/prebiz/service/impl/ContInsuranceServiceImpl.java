package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContInsuranceRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.prebiz.service.ContInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description:  车辆保险serviceimpl
 * @author:ningyangyang
 * @since:2018/5/14
 */
@Service
public class ContInsuranceServiceImpl  implements ContInsuranceService{
    /**
     * @Fields  : 车辆保险Repository
     */
    @Autowired
    private ContInsuranceRepository contInsuranceRepository;

    /**
     * @Title:
     * @Description: 查询车辆保险信息
     * @param
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 18:48:00
     */
    @Override
    public List<ContInsurance> findContInsurance(ContInsurance contInsurance) {
        Example example  = SqlUtil.newExample(ContInsurance.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(contInsurance.getContNo())){
            criteria.andEqualTo("contNo",contInsurance.getContNo());
        }
        if(StringUtils.isNotTrimBlank(contInsurance.getInsuranceStatus())){
            criteria.andEqualTo("insuranceStatus",contInsurance.getInsuranceStatus());
        }
        return contInsuranceRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过contVehinsId查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContInsurance findContInsuranceByPrimaryKey(String contVehinsId){
        return contInsuranceRepository.selectByPrimaryKey(contVehinsId);
    }

    /**
     * @Title:
     * @Description: 根据状态查询车辆保险信息
     * @param
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-11 18:48:00
     */
    @Override
    public List<ContInsuranceVo> findContInsuranceByStatus(ContInsuranceVo contInsurance) {
        contInsurance.setFinItem(FinItemEnums.INSURANCE.getCode());
        //还款状态为未结清
        contInsurance.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());
        return contInsuranceRepository.selectContInsuranceByStatus(contInsurance);
    }

}
