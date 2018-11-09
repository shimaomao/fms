package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisService
 * @Description: 财务凭证核算数据service
 * @date 2018/7/11
 */
public interface FinancialVoucherAssisService {

    /**
     * @Title:  
     * @Description:   根据财务凭证id获取财务凭证核算数据
     * @param voucherDataId
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/11 03:01:10
     */
    List<FinancialVoucherAssisVo> findFinVouAssisVosByVouDataId(String voucherDataId);

    /**
     * @Title:
     * @Description:   根据财务凭证id获取金蝶用户列表
     * @param vouDataIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 10:35:44
     */
    List<KingDeeCusVo> findKingDeeCusVosByVouDataIds(List<String> vouDataIds);

    /**
     * @Title:
     * @Description: 根据凭证id查询凭证辅助核算
     * @param voucherDataIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 11:28:27
     */
   List<FinancialVoucherAssis> findFinVouAssisListByVouDataIds(List<String> voucherDataIds);

}
