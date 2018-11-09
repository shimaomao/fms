package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.prebiz.service.ApplyAutoCancelService;
import cn.com.leadu.fms.prebiz.service.ApplyCancelService;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author yanfengbo
 * @ClassName: ApplyAutoCancelService
 * @Description: 申请订单自动取消
 * @date
 */
@Service
public class ApplyAutoCancelServiceImpl implements ApplyAutoCancelService {

    /**
     * @Fields  : 系统常量调用rpc
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 订单实体调用service
     */
    @Autowired
    private ApplyService applyService;

    /**
     * @Fields  : 融资申请取消调用service
     */
    @Autowired
    private ApplyCancelService applyCancelService;

    /**
     * @Title:
     * @Description: 申请订单自动取消
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void applyAutoCancel(SysUser sysUser){
        //取"当前日期-订单提交限制天数"值
        Date date = new Date();
        String  ApplyAutoCancelDay;
        try {
            ApplyAutoCancelDay =   ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey("ApplyAutoCancelDay"));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("订单提交限制天数获取失败");
        }
        long ApplyAutoCancelDayLong = Long.parseLong(ApplyAutoCancelDay);
        long timeDif = (date.getTime() - 86400000 * ApplyAutoCancelDayLong);

        //取订单状态为"待合同生成确认"的订单
        List<Apply> applys = applyService.findApplysByBizStatus(BizStatusEnums.WAIT_CONTRACT_CONF1.getType(),BizStatusEnums.WAIT_CONTRACT_CONF2.getType());

        //如果订单审批通过日期 < 当前日期 - 系统常量.合同提交限制天数 则取消该订单
        for (Apply apply : applys){
            if (apply.getApplyPassDate()!=null){
                if(apply.getApplyPassDate().getTime()<timeDif){
                    ApplyCancelVo applyCancelVo = new ApplyCancelVo();
                    applyCancelVo.setApplyNo(apply.getApplyNo());
                    applyCancelService.modifyApplyCancel(applyCancelVo,sysUser);
                }
            }
        }
    }
}
