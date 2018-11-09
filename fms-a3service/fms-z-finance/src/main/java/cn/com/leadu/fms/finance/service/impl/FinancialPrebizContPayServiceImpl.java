package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.constant.enums.finance.ContPayEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.finance.service.FinancialPrebizContPayDetailService;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author yebangqiang
 * @ClassName: FinancialPrebizContPayService
 * @Description: 贷前财务付款清单一览查询
 * @date 2018-07-19
 */
@Service
public class FinancialPrebizContPayServiceImpl implements FinancialPrebizContPayDetailService {

    @Autowired
    private ContPayRepository contPayRepository;
    /**
     * 财务待收款Repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;
    /**
     * 销售还款计划Repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
	/**
	 * @Title:
	 * @Description: 贷前财务付款清单明细查询
	 * @param contPayVo
	 * @return java.lang.String
	 * @throws
	 * @author yebangqiang
	 * @date 2018-7-20
	 */
	public PageInfoExtend<ContPay> findFinancialPrebizContPayDetailServiceByPage(ContPayVo contPayVo){
        //合同号
        if(StringUtils.isTrimBlank(contPayVo.getContractNo()))
            contPayVo.setContractNo(null);
        else
            contPayVo.setContractNo(SqlUtil.likePattern(contPayVo.getContractNo()));

        //申请编号
        if (StringUtils.isTrimBlank(contPayVo.getApplyNo()))
            contPayVo.setApplyNo(null);
        else
            contPayVo.setApplyNo(SqlUtil.likePattern(contPayVo.getApplyNo()));

        //承租人
        if(StringUtils.isTrimBlank(contPayVo.getUserName()))
            contPayVo.setUserName(null);
        else
            contPayVo.setUserName(SqlUtil.likePattern(contPayVo.getUserName()));

        //设置付款类型为贷前付款
        contPayVo.setPaymentTypeFlag(ContPayEnums.PAY_FUND.getType());
        return contPayRepository.selectListVoByPage("selectFinancialPrebizContPayDetailListByPage", contPayVo, contPayVo.getPageQuery());
	}

    /**
     * @Title:
     * @Description: 贷前财务付款清单汇总查询
     * @param contPayVo
     * @return java.lang.String
     * @throws
     * @author yebangqiang
     * @date
     */
    @Override
    public PageInfoExtend<ContPayVo> findContPayInfoByPage(ContPayVo contPayVo) {
        //合同号
        if(StringUtils.isTrimBlank(contPayVo.getContractNo()))
            contPayVo.setContractNo(null);
        else{
            contPayVo.setContractNo(SqlUtil.likePattern(contPayVo.getContractNo()));
        }
        //申请编号
        if (StringUtils.isTrimBlank(contPayVo.getApplyNo()))
            contPayVo.setApplyNo(null);
        else{
            contPayVo.setApplyNo(SqlUtil.likePattern(contPayVo.getApplyNo()));
        }
        //承租人
        if(StringUtils.isTrimBlank(contPayVo.getUserName()))
            contPayVo.setUserName(null);
        else{
            contPayVo.setUserName(SqlUtil.likePattern(contPayVo.getUserName()));
        }
        //设置付款类型为贷前付款
        contPayVo.setPaymentTypeFlag(ContPayEnums.PAY_FUND.getType());
        //设置扣款状态为"扣款成功"
        contPayVo.setRepayStatus(PayStatusEnums.WITHDRAWING_SUCCESS.getType());
        Map<String, BigDecimal> map ;
        PageInfoExtend<ContPayVo> contPayPageInfoExtend = contPayRepository.selectListVosByPage("selectContPayListByPage", contPayVo, contPayVo.getPageQuery());
        if (contPayPageInfoExtend != null && contPayPageInfoExtend.getData() != null){
            for (ContPayVo contPayVoEntity : contPayPageInfoExtend.getData()){
                Example example = SqlUtil.newExample(ContCharge.class);
                example.createCriteria().andEqualTo("chargeBizId", contPayVoEntity.getContractNo())
                        .andEqualTo("chargeFund", PayFundNameEnums.INIT_AMOUNT.getType())
                        .andEqualTo("chargeStatus", PayStatusEnums.WITHDRAWING_SUCCESS.getType());
                ContCharge contCharge = contChargeRepository.selectOneByExample(example);
                contPayVoEntity.setAccInitAmount(contCharge == null? BigDecimal.ZERO : contCharge.getChargeActualAmount());//已收首付
                map = getAmount(contPayVoEntity);
                contPayVoEntity.setNeedfFinalAmount(map.get("needfFinalAmount"));//应收尾付
                contPayVoEntity.setAccFinalAmount(map.get("accFinalAmount"));//实收尾付
            }
        }
        return contPayPageInfoExtend;
    }

    private Map<String, BigDecimal> getAmount(ContPayVo contPayVoEntity){

        Map<String, BigDecimal> map = new HashedMap();
        Example example = SqlUtil.newExample(ContRepaySked.class);
        example.createCriteria().andEqualTo("contNo", contPayVoEntity.getContractNo());
        example.setOrderByClause("period desc");
        List<ContRepaySked> contRepaySkedList = contRepaySkedRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)){
            map.put("needfFinalAmount", contRepaySkedList.get(0).getRentActual() == null
                    ?BigDecimal.ZERO:contRepaySkedList.get(0).getRentActual());//应收尾付
        }

        example = SqlUtil.newExample(ContRepaySked.class);
        example.createCriteria().andEqualTo("contNo", contPayVoEntity.getContractNo()).andEqualTo("repayStatus", PayStatusEnums.WITHDRAWING_SUCCESS.getType());
        example.setOrderByClause("period desc");
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedList)){
            map.put("accFinalAmount", contRepaySkedList.get(0).getRentActual() == null
                    ?BigDecimal.ZERO:contRepaySkedList.get(0).getRentActual());//实收尾付
        }else{
            map.put("accFinalAmount",BigDecimal.ZERO);//实收尾付
        }
        return map;
    }
}