package cn.com.leadu.fms.webclient.riskmgmt.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.webclient.riskmgmt.rpc.ApplyRiskRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: ApplyRiskController
 * @Description: 风控审批Controller
 * @date 2018-06-4
 */
@RestController
@RequestMapping("apply_risk")
public class ApplyRiskController {

    @Autowired
    private ApplyRiskRpc applyRiskRpc;

    /**
     * @Title:
     * @Description: 根据订单编号，取得风控初期数据
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author liujinge
     * @date 2018-6-4 20:18:12
     */
    @RequestMapping(value = "findApplyRiskInit", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyRiskInit(String applyNo,String flag){
        return applyRiskRpc.findApplyRiskInit(applyNo,flag);
    }

    /** 
    * @Description: 保存风控数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/7 20:16
    */ 
    @RequestMapping(value = "saveApplyRisk", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRisk(@RequestBody ApplyRiskVo applyRiskVo){
        return applyRiskRpc.saveApplyRisk(applyRiskVo);
    }

    /** 
    * @Description: 风控退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/23 14:19
    */ 
    @RequestMapping(value = "backApplyRisk", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backApplyRisk(@RequestBody ApplyRiskVo applyRiskVo){
        return applyRiskRpc.backApplyRisk(applyRiskVo);
    }

    /**
    * @Description: 退回到业务员
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/24 10:52
    */
    @RequestMapping(value = "backToApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backToApply(@RequestBody ApplyRiskVo applyRiskVo){
        return applyRiskRpc.backToApply(applyRiskVo);
    }

    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 15:33
     */
    @RequestMapping(value = "saveApplyRiskPyCredit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRiskPyCredit(@RequestBody PycreditListVo pycreditListVo){
        return applyRiskRpc.saveApplyRiskPyCredit(pycreditListVo);
    }
}
