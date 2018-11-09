package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.business.vo.CommonFinVouData;

/**
 * @author qiaomengnan
 * @ClassName: CommonFinVoucherService
 * @Description: 财务凭证共通处理
 * @date 2018/6/20
 */
public interface CommonFinancialVoucherDataService {

    /**
     * @Title:
     * @Description:  根据凭证类型，获取凭证数据
     * @param voucherType
     * @param parentData
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:27:33
     */
    CommonFinVouData getFinVoucherData(String voucherType, Object parentData,String voucherBizCode);

    /**
     * @Title:
     * @Description:   保存财务凭证数据
     * @param commonFinVouData
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/21 02:48:18
     */
    void saveCommonFinVouData(CommonFinVouData commonFinVouData);

    /**
     * @Title:
     * @Description:   设置凭证区域
     * @param commonFinVouData
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 09:52:00
     */
    CommonFinVouData setVoucherGroups(CommonFinVouData commonFinVouData,String voucherGroup);

}
