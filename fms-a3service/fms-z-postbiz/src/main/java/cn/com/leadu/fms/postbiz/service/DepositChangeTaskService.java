package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskService
 * @Description: 保证金变更任务业务层
 */
public interface DepositChangeTaskService {

    /**
     * @param vo 参数实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo或者depositTaskNo获取申请页需要展示的基本信息
     * @author huzongcheng
     * @date
     */
    DepositChangeApplyVo findApplyInfoByContNo(DepositChangeApplyVo vo);

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金申请提交
     * @author huzongcheng
     */
    void saveDepositChange(DepositChangeApplyVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审通过操作
     * @author huzongcheng
     * @date
     */
    void approval(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     * @date
     */
    void sendBack(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     * @date
     */
    void refuse(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同生成
     * @author huzongcheng
     * @date
     */
    void contractCreate(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 退回到申请
     * @author huzongcheng
     * @date
     */
    void sendToApply(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param depositTaskNo 任务变更号
     * @param bizCodeType   业务类型
     * @return CommonBizFilesVo 附件信息
     * @throws
     * @Title:
     * @Description: 获取合同附件
     * @author hu'zong'cheng
     */
    CommonBizFilesVo findBizFileByDepositTaskNo(String depositTaskNo, String bizCodeType);

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金签订合同
     * @author huzongcheng
     */
    void suppleUpload(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 签订合同页面退回
     * @author huzongcheng
     * @date
     */
    void suppleSendBack(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同复核通过操作
     * @author huzongcheng
     * @date
     */
    void contractApproval(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同复核退回操作
     * @author huzongcheng
     * @date
     */
    void contractSendBack(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 财务确认收款通过操作
     * @author huzongcheng
     * @date
     */
    void financeReceipt(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 财务收款退回操作
     * @author huzongcheng
     */
    void financeSendBack(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 出库操作
     * @author huzongcheng
     * @date
     */
    void export(DepositApproveVo vo, SysUser sysUser);

    /**
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 申请取消操作，任意流程节点
     * @param taskNo 任务号
     * @param cancelReson 取消原因
     * @author huzongcheng
     * @date
     */
    void applyCancel(String taskNo, String cancelReson, SysUser sysUser);

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo查询是否有正在进行中的保证金变更申请
     * @author huzongcheng
     */
    boolean findDepositChangeTaskByContNo(String contNo);

    /**
     * @param certifNo 证件号或者社会信用号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据证件号或者社会信用号查询逾期客户id
     * @author huzongcheng
     * @date
     */
    public String findOverdueCstmId(String certifNo);

    /**
     * @Title:
     * @Description: 根据增加保证金任务号，获取增加保证金任务信息
     * @param depositTaskNo 增加保证金任务号
     * @return DepositChangeTask
     * @author wangxue
     * @date
     */
    DepositChangeTask findDepositChangeTaskByDepositTaskNo(String depositTaskNo);

}
