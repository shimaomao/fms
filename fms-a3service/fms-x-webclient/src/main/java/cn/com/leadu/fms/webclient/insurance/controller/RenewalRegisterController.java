package cn.com.leadu.fms.webclient.insurance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.webclient.insurance.rpc.RenewalRegisterRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterController
 * @Description: 续保任务一览controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("renewal_register")
public class RenewalRegisterController {

    /**
     * @Fields  : 续保任务一览rpc
     */
    @Autowired
    private RenewalRegisterRpc renewalRegisterRpc;

    /**
     * @Title:
     * @Description: 分页查询续保任务一览信息
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "findRenewalRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalRegistersByPage(RenewalRegisterVo renewalRegisterVo){
        Map renewalRegisterVoMap = renewalRegisterVo == null?null:(Map) JSON.toJSON(renewalRegisterVo);
        return renewalRegisterRpc.findRenewalRegistersByPage(renewalRegisterVoMap);
    }

    /**
     * @Title:
     * @Description: 根据taskNo获取一条续保任务明细
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "findRenewalRegistersByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalRegistersByTaskNo(RenewalRegisterVo renewalRegisterVo){
        Map renewalRegisterVoMap = renewalRegisterVo == null?null:(Map) JSON.toJSON(renewalRegisterVo);
        return renewalRegisterRpc.findRenewalRegistersByTaskNo(renewalRegisterVoMap);
    }

    /**
     * @Title:
     * @Description: 续保财务确认收款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterReceipt(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterReceipt(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 续保请款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterWithdraw",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterWithdraw(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterWithdraw(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 资管复审
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterReview",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterReview(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterReview(renewalRegisterVo);
    }
    /**
     * @Title:
     * @Description: 财务制单
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterVoucher(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterVoucher(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterPayment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterPayment(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterPayment(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterSendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterSendBack(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterSendBack(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description:  修改续保任务一览
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "modifyRenewalRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.modifyRenewalRegister(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description:   根据renewalRegisterId集合删除续保任务一览
     * @param renewalRegisterIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "deleteRenewalRegistersByRenewalRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRenewalRegistersByRenewalRegisterIds(@RequestBody List<String> renewalRegisterIds){
        RenewalRegisterVo renewalRegisterVo = new RenewalRegisterVo();
        renewalRegisterVo.setRenewalRegisterIds(renewalRegisterIds);
        return renewalRegisterRpc.deleteRenewalRegistersByRenewalRegisterIds(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description:  根据renewalRegisterId获取续保任务一览
     * @param renewalRegisterId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "findRenewalRegisterByRenewalRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalRegisterByRenewalRegisterId(String renewalRegisterId){
        return renewalRegisterRpc.findRenewalRegisterByRenewalRegisterId(renewalRegisterId);
    }

    /**
     * @Title:
     * @Description: 通过renewal_cont_vehins_id查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsuranceByRenewalContVehinsId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsuranceByRenewalContVehinsId(String renewalContVehinsId,String renewalRegisterId){
        return renewalRegisterRpc.findContInsuranceByRenewalContVehinsId(renewalContVehinsId,renewalRegisterId);
    }

    /**
     * @Title:
     * @Description: 更新续保任务登记表并启动流程
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @RequestMapping(value = "saveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContInsuranceFromRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.saveContInsuranceFromRenewalRegister(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 再次资管确认提交
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @RequestMapping(value = "reSaveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> reSaveContInsuranceFromRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.reSaveContInsuranceFromRenewalRegister(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 续保审核确定
     * @param renewalRegisterVo
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author lijunjun
     * @date
     */
    @RequestMapping(value = "renewalRegisterConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterConfirm(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterConfirm(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 续保审核取消
     * @param renewalRegisterVo
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author lijunjun
     * @date
     */
    @RequestMapping(value = "renewalRegisterCancel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterCancel(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.renewalRegisterCancel(renewalRegisterVo);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo){
        return renewalRegisterRpc.printRenewalRegister(renewalRegisterVo);
    }
}
