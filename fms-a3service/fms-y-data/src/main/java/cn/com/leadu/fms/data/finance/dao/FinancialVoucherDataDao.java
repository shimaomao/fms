package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataDao
 * @Description: 财务凭证数据dao层
 * @date 2018-06-21
 */
public interface FinancialVoucherDataDao extends BaseDao<FinancialVoucherData> {

    /**
     * @Title:
     * @Description:   查询财务凭证数据详情list
     * @param finVouDataVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 12:00:22
     */
    List<FinancialVoucherDataVo> selectFinancialVoucherDataVos(@Param("finVouDataVo")FinancialVoucherDataVo finVouDataVo);

    /**
     * @Title:
     * @Description: 根据凭证号 业务号 业务日期 凭证类型 查询对应的凭证数据
     * @param:  voucherNo 凭证号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/16 0016 19:37
     */
    List<FinancialVoucherDataVo> selectFinVouDataVoDetails(@Param("voucherNo") String voucherNo);

}