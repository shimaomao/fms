package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherSummaryRepository;
import cn.com.leadu.fms.finance.service.FinancialVoucherSummaryService;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary.FinancialVoucherSummaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryServiceImpl
 * @Description: 财务凭证管理service
 * @date 2018/7/23
 */
@Service
public class FinancialVoucherSummaryServiceImpl implements FinancialVoucherSummaryService {

    /**
     * @Fields  : 财务凭证管理repository
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSummaryRepository financialVoucherSummaryRepository;

    /**
     * @Title:
     * @Description:   查询财务凭证管理列表
     * @param finVouSummaryVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 02:48:33
     */
    public PageInfoExtend<FinancialVoucherSummaryVo> findFinancialVoucherSummaryVosByPage(FinancialVoucherSummaryVo finVouSummaryVo){
        if(StringUtils.isTrimBlank(finVouSummaryVo.getVoucherNo()))
            finVouSummaryVo.setVoucherNo(null);
        else
            finVouSummaryVo.setVoucherNo(SqlUtil.likePattern(finVouSummaryVo.getVoucherNo()));
        if(StringUtils.isTrimBlank(finVouSummaryVo.getVoucherBizCode()))
            finVouSummaryVo.setVoucherBizCode(null);
        else
            finVouSummaryVo.setVoucherBizCode(SqlUtil.likePattern(finVouSummaryVo.getVoucherBizCode()));

        //承租人
        if(StringUtils.isTrimBlank(finVouSummaryVo.getName()))
            finVouSummaryVo.setName(null);
        else
            finVouSummaryVo.setName(SqlUtil.likePattern(finVouSummaryVo.getName()));

        //凭证区域
        if(StringUtils.isTrimBlank(finVouSummaryVo.getVoucherGroup()))
            finVouSummaryVo.setVoucherGroup(null);
        else
            finVouSummaryVo.setVoucherGroup(SqlUtil.likePattern(finVouSummaryVo.getVoucherGroup()));

        //凭证类型
        if(StringUtils.isTrimBlank(finVouSummaryVo.getVoucherTypeName()))
            finVouSummaryVo.setVoucherTypeName(null);
        else
            finVouSummaryVo.setVoucherTypeName(SqlUtil.likePattern(finVouSummaryVo.getVoucherTypeName()));

        //发送状态
        if(StringUtils.isTrimBlank(finVouSummaryVo.getSendStatus()))
            finVouSummaryVo.setSendStatus(null);

        //业务日期开始日期
        if(StringUtils.isTrimBlank(finVouSummaryVo.getStartTime()))
            finVouSummaryVo.setStartTime(null);

        //业务日期结束日期
        if(StringUtils.isTrimBlank(finVouSummaryVo.getEndTime()))
            finVouSummaryVo.setEndTime(null);

        PageInfoExtend<FinancialVoucherSummaryVo> pageInfo
                = financialVoucherSummaryRepository.selectListVoByPage("selectFinancialVoucherSummaryVosByPage",finVouSummaryVo,finVouSummaryVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:   根据id集合获取财务凭证管理
     * @param voucherSummaryIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 05:15:14
     */
    public List<FinancialVoucherSummary> findFinancialVoucherSummaryListByIds(List<String> voucherSummaryIds){
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherSummaryIds)) {
            Example example = SqlUtil.newExample(FinancialVoucherSummary.class);
            example.createCriteria().andIn("voucherSummaryId", voucherSummaryIds);
            return financialVoucherSummaryRepository.selectListByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   更新最后一次的发送状态和发送时间
     * @param voucherSummaryIds
     * @param sendStatus
     * @param sendBatchNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 01:41:55
     */
    @Transactional
    public void modifyFinVouSummaryStatus(List<String> voucherSummaryIds, String sendStatus,String sendBatchNo){
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherSummaryIds) && StringUtils.isNotTrimBlank(sendStatus,sendBatchNo)){
            FinancialVoucherSummary finVouSummary = new FinancialVoucherSummary();
            finVouSummary.setSendStatus(sendStatus);
            finVouSummary.setSendBatchNo(sendBatchNo);
            Example example = SqlUtil.newExample(FinancialVoucherSummary.class);
            example.createCriteria().andIn("voucherSummaryId",voucherSummaryIds);
            financialVoucherSummaryRepository.updateByExampleSelectiveData(finVouSummary,example);
        }
    }

}
