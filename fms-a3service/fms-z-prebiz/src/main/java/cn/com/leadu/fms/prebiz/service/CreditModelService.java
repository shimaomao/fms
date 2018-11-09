package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;

/**
 * @author qiaomengnan
 * @ClassName: CreditModelService
 * @Description:
 * @date 2018/5/15
 */
public interface CreditModelService {

    /**
     * @Title:
     * @Description:   生成贷前模型
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/14 04:32:36
     */
    void generatePreBizCreditModel(String applyNo);

    /**
     * @Title:
     * @Description:   获取用户报告基础信息
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 11:05:56
     */
    ApplyInputVo findCustomerByApplyNo(String applyNo);

}
