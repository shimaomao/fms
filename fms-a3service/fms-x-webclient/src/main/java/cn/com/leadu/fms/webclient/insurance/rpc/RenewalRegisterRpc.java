package cn.com.leadu.fms.webclient.insurance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterController
 * @Description: 续保任务一览rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RenewalRegisterRpc {

    /**
     * @Title:
     * @Description: 分页查询续保任务一览信息
     * @param renewalRegisterVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/findRenewalRegistersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRenewalRegistersByPage(@RequestParam Map<String,Object> renewalRegisterVoMap);

    /**
     * @Title:
     * @Description: 根据taskNo获取一条续保任务明细
     * @param renewalRegisterVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/findRenewalRegistersByTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRenewalRegistersByTaskNo(@RequestParam Map<String,Object> renewalRegisterVoMap);

    /**
     * @Title:
     * @Description: 续保财务确认收款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterReceipt",method = RequestMethod.POST)
    ResponseEntity<RestResponse> renewalRegisterReceipt(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 续保请款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterWithdraw",method = RequestMethod.POST)
    ResponseEntity<RestResponse> renewalRegisterWithdraw(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 资管复核
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterReview",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> renewalRegisterReview(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 财务制单
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterVoucher",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> renewalRegisterVoucher(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 财务付款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterPayment",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> renewalRegisterPayment(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 退回上一级
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterSendBack",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> renewalRegisterSendBack(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description:  修改续保任务一览
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/modifyRenewalRegister",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description:   根据renewalRegisterId集合删除续保任务一览
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/deleteRenewalRegistersByRenewalRegisterIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRenewalRegistersByRenewalRegisterIds(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description:  根据renewalRegisterId获取续保任务一览
     * @param renewalRegisterId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "api/insurance/renewal_register/findRenewalRegisterByRenewalRegisterId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRenewalRegisterByRenewalRegisterId(@RequestParam("renewalRegisterId") String renewalRegisterId);

    /**
     * @Title:
     * @Description: 通过renewal_cont_vehins_id查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/findContInsuranceByRenewalContVehinsId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContInsuranceByRenewalContVehinsId(@RequestParam("renewalContVehinsId") String renewalContVehinsId,@RequestParam("renewalRegisterId")String renewalRegisterId);

    /**
     * @Title:
     * @Description: 更新续保任务登记表并启动流程
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/saveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContInsuranceFromRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 再次资管确认提交
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/reSaveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> reSaveContInsuranceFromRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 续保审核确定
     * @param renewalRegisterVo
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author lijunjun
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> renewalRegisterConfirm(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 续保审核取消
     * @param renewalRegisterVo
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author lijunjun
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/renewalRegisterCancel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> renewalRegisterCancel(@RequestBody RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/renewal_register/printRenewalRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printRenewalRegister(RenewalRegisterVo renewalRegisterVo);
}
