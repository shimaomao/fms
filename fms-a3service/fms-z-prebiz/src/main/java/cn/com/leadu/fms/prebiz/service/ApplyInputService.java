package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author wangxue
 * @ClassName: ApplyInputService
 * @Description: 申请录入管理
 * @date 2018-03-23
 */
public interface ApplyInputService {

    /**
     * @Title:
     * @Description: 保存申请录入信息(暂存)
     * @param applyInputVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-23 10:18:12
     */
    ApplyInputVo saveApplyInputVo(ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 提交申请录入信息(保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    void submitApplyInputVo(ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 根据订单编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    ApplyInputVo findApplyInputVoByApplyNo(String applyNo, String contNo);
    /**
     * @Title:
     * @Description: 根据订单号修改融资信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    void  modifyApplyInputVoByApplyNo(ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 根据订单号修改融资信息(提交并保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-23 10:18:12
     */
    void subModifyApplyInputVoByApplyNo(ApplyInputVo applyInputVo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取订单的融资车辆信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-4-13 17:18:12
     */
    ApplyInputVo findApplyFinanceVehicleByApplyNo(String applyNo, String contNo);


    /**
     * @Title:
     * @Description: 根据订单编号，获取个人客户基本的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    ApplyInputVo findApplyCstmPersonByApplyNo(String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取担保人(公司)的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    ApplyInputVo findApplyGuaranteeByApplyNo(String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    ApplyInputVo findBizFileByApplyNo(String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取客户的所有基本信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    void findCustomerByApplyNo(ApplyInputVo applyInputVo, String applyNo);

    /**
     * @Title:
     * @Description: 获取申请详细信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author qiaomengnan
     * @date 2018/5/15  15:04
     */
    ApplyInputVo findApplyDetailInfo(String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author liujinge
     * @date 2018-6-4 20:18:12
     */
    ApplyRiskVo findApplyInputRiskByApplyNo(String applyNo,String flag);
    /**
     * @Title:
     * @Description: 报价单计算
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-2 10:18:12
     */
    QuotationDeviceVo saveQuotationDeviceInfo(ApplyInputVo applyInputVo);

    QuotationDeviceVo printQuotationDeviceInfo(ApplyInputVo applyInputVo,SysUser sysUser);
}
