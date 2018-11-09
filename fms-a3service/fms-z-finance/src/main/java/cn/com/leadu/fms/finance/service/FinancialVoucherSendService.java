package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendService
 * @Description: 财务凭证发送service
 * @date 2018/7/23
 */
public interface FinancialVoucherSendService {

    /**
     * @Title:
     * @Description:  发送财务凭证数据
     * @param voucherSummaryIds 凭证管理id集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 04:21:03
     */
    KingDeeResultVo sendFinancialVoucher(List<String> voucherSummaryIds, SysUser sysUser);

}
