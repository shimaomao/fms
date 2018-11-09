package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import cn.com.leadu.fms.prebiz.service.ContPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContPayService
 * @Description: 财务付款表业务实现层
 * @date 2018-04-11
 */
@Service
public class ContPayServiceImpl implements ContPayService {

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Title:
     * @Description: 分页查询财务付款表
     * @param contPayVo
     * @return PageInfoExtend<ContPay>
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:17
     */
    public PageInfoExtend<ContPay> findContPaysByPage(ContPayVo contPayVo){
        Example example = SqlUtil.newExample(ContPay.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContPay> pageInfo = contPayRepository.selectListByExamplePage(example,contPayVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据contPayId获取财务付款表
     * @param contPayId
     * @return ContPay
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:17
     */
    public ContPay findContPayByContPayId(String contPayId){
        return contPayRepository.selectByPrimaryKey(contPayId);
    }

    /**
     * @Title:
     * @Description:  根据contPayId获取财务付款表
     * @param contPayList
     * @return ContPay
     * @throws
     * @author liujinge
     * @date 2018-4-11 10:10:17
     */
    public int insertContPayList(List<ContPay> contPayList){
        return contPayRepository.insertDataList(contPayList);
    };

    /**
     * @Title:
     * @Description: 通过付款类型和业务关联号(合同编号)查询财务付款表
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */


    public ContPay findContPayByBizCodeAndPaymentType(String paymentType,String bizCode){
        Example example = SqlUtil.newExample(ContPay.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paymentType",paymentType);
        criteria.andEqualTo("bizCode",bizCode);

        return contPayRepository.selectOneByExample(example);
    }
    /**
     * @Title:
     * @Description: 通过付款类型和业务关联号(合同编号)更新财务付款表
     * @return
     * @throws
     * @author liujinge
     * @date
     */
    @Override
    public int updateContPayByBizCodeAndPaymentType(ContPay contPay) {
        Example example = SqlUtil.newExample(ContPay.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",contPay.getBizCode());
        criteria.andEqualTo("paymentType",contPay.getPaymentType());
        return contPayRepository.updateByExampleSelectiveData(contPay, example);
    }

    /**
     * @Description: 查询财务付款表（业务类型，业务关联号，付款款项）
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/25 17:29
     */
    @Override
    public ContPay findContPayListByBizCodeAndPayFundAndPaymentType(String paymentType,String bizCode,String payFund) {
        Example example = SqlUtil.newExample(ContPay.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(paymentType))
            criteria.andEqualTo("paymentType",paymentType);
        if(StringUtils.isNotTrimBlank(payFund))
            criteria.andEqualTo("payFund",payFund);
        if(StringUtils.isNotTrimBlank(bizCode))
            criteria.andEqualTo("bizCode",bizCode);
        return contPayRepository.selectOneByExample(example);
    }
}
