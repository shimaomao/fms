package cn.com.leadu.fms.business.vo;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonFinVouData
 * @Description:
 * @date 2018/6/26
 */
@Data
public class CommonFinVouData {

    private List<FinancialVoucherData> finVouDatas;

    private List<FinancialVoucherAssis> finVouAssList;

    private List<FinancialVoucherSummary> finVouSummarys;

}
