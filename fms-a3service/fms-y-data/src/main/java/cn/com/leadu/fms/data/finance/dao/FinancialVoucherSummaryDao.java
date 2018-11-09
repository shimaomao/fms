package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary.FinancialVoucherSummaryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryDao
 * @Description: 财务凭证管理dao层
 * @date 2018-07-21
 */
public interface FinancialVoucherSummaryDao extends BaseDao<FinancialVoucherSummary> {

    /**
     * @Title:  
     * @Description:   查询财务凭证管理列表
     * @param finVouSummaryVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/23 02:51:32
     */
    List<FinancialVoucherSummaryVo> selectFinancialVoucherSummaryVosByPage(@Param("finVouSummaryVo") FinancialVoucherSummaryVo finVouSummaryVo);

}