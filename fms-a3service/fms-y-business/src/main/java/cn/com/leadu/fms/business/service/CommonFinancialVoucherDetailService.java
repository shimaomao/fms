package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonFinancialVoucherDetailService
 * @Description:
 * @date 2018/6/21
 */
public interface CommonFinancialVoucherDetailService {

    /**
     * @Title:
     * @Description:   根据凭证类型取得凭证类型明细列表
     * @param voucherType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:03:15
     */
    List<FinancialVoucherDetail> findFinancialVoucherDetailsByVoucherType(String voucherType);

}
