package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailDao
 * @Description: 凭证类型明细管理dao层
 * @date 2018-06-20
 */
public interface FinancialVoucherDetailDao extends BaseDao<FinancialVoucherDetail> {

    /**
     * @Title:
     * @Description:  分页获取凭证类型明细
     * @param financialVoucherDetailVo
     * @return List<ContReceiptVo>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 13:51:12
     */
    List<FinancialVoucherDetailVo> selectFinancialVoucherDetailVosByPage(@Param("financialVoucherDetailVo") FinancialVoucherDetailVo financialVoucherDetailVo);
}