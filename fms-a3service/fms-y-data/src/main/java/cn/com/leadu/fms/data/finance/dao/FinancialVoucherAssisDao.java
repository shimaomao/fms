package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisDao
 * @Description: 财务凭证核算数据dao层
 * @date 2018-06-26
 */
public interface FinancialVoucherAssisDao extends BaseDao<FinancialVoucherAssis> {

    /**
     * @Title:  
     * @Description:   根据财务凭证id获取核算数据
     * @param voucherDataId
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/11 03:13:03
     */
    List<FinancialVoucherAssisVo> selectFinancialVoucherAssisVosByVouDataId(@Param("voucherDataId") String voucherDataId);

    /**
     * @Title:
     * @Description:   根据财务凭证id获取金蝶用户列表
     * @param finVouAssisVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 10:35:44
     */
    List<KingDeeCusVo> selectKingDeeCusVosByVouDataIds(@Param("finVouAssisVo") FinancialVoucherAssisVo finVouAssisVo);

}