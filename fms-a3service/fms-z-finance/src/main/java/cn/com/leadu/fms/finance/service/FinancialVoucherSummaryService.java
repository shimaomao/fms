package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary.FinancialVoucherSummaryVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryService
 * @Description: 财务凭证管理service
 * @date 2018/7/23
 */
public interface FinancialVoucherSummaryService {

    /**
     * @Title:
     * @Description:   查询财务凭证管理列表
     * @param finVouSummaryVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 02:48:33
     */
    PageInfoExtend<FinancialVoucherSummaryVo> findFinancialVoucherSummaryVosByPage(FinancialVoucherSummaryVo finVouSummaryVo);

    /**
     * @Title:
     * @Description:   根据id集合获取财务凭证管理
     * @param voucherSummaryIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 05:15:14
     */
    List<FinancialVoucherSummary> findFinancialVoucherSummaryListByIds(List<String> voucherSummaryIds);

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
    void modifyFinVouSummaryStatus(List<String> voucherSummaryIds, String sendStatus,String sendBatchNo);

}
