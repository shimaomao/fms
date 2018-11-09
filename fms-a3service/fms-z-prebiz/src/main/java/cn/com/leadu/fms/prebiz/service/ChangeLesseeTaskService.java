package cn.com.leadu.fms.prebiz.service;/**
 * Created by ningyangyang on 2018/9/11.
 */

import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @Title: fms
 * @Description: 变更承租人任务
 * @author: ningyangyang
 * @date 2018/9/11 9:40
 */
public interface ChangeLesseeTaskService {

    /**
     * @Title:
     * @Description:  暂存申请录入信息
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    ApplyInputVo saveApplyInputVo(ApplyInputVo applyInputVo,SysUser sysUser);

    /**
     * @Title:
     * @Description:  提交申请录入信息
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void submitApplyInputVo(ApplyInputVo applyInputVo,SysUser sysUser);

    /**
     * @Title:
     * @Description: 根据任务编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 20:18:12
     */
     ApplyInputVo findApplyInputVoByApplyNo(String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 20:18:12
     */
    ApplyRiskVo findApplyInputRiskByTaskNo(String applyNo);

    /**
     * @Title:
     * @Description: 承租人变更合同生成
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    void changeContGenerate(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);
}
