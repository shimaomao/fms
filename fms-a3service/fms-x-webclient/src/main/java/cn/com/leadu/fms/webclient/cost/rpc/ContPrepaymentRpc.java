package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentController
 * @Description: 提前还款rpc
 * @date 2018-05-10
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPrepaymentRpc {

    /**
     * @Title:
     * @Description: 分页查询提前还款信息entity
     * @param contPrepaymentVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentsByPage(@RequestParam Map<String,Object> contPrepaymentVoMap);

    /** 
    * @Description: 分页查询提前还款vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/10 20:21
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentListByPage(@RequestParam Map<String, Object> contPrepaymentVoMap);

    /**
     * @Title:
     * @Description: 保存提前还款
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "api/cost/cont_prepayment/saveContPrepayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo);

    /**
     * @Title:
     * @Description:  修改提前还款
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "api/cost/cont_prepayment/modifyContPrepayment",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo);

    /**
     * @Title:
     * @Description:   根据contPrepaymentId集合删除提前还款
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "api/system/cont_prepayment/deleteContPrepaymentsByContPrepaymentIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContPrepaymentsByContPrepaymentIds(@RequestBody ContPrepaymentVo contPrepaymentVo);

    /**
     * @Title:
     * @Description:  根据contPrepaymentId获取提前还款
     * @param contPrepaymentId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentByContPrepaymentId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentByContPrepaymentId(@RequestParam("contPrepaymentId") String contPrepaymentId);

    /** 
    * @Description: 根据合同编号获取提前还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 14:55
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentByContNo(@RequestParam("contNo") String contNo);

    /** 
    * @Description: 根据合同编号构造提前还款和提前还款明细信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 15:57
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentWithDetailByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentWithDetailByContNo(@RequestParam("contNo") String contNo);

    /** 
    * @Description: 根据业务号查询提前还款和提前还款明细信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/20 19:53
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/findContPrepaymentWithDetailByContPrepaymentNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepaymentWithDetailByContPrepaymentNo(@RequestParam("contPrepaymentNo") String contPrepaymentNo);

    /** 
    * @Description: 保存提前还款和明细
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 18:53
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/saveContPrepaymentWithDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContPrepaymentWithDetail(@RequestBody ContPrepaymentVo contPrepaymentVo);

    /**
    * @Description: 财务确认
    * @param:
    * @return:
    * @Author: lijunjun
    * @Date: 2018/5/14 18:53
    */
    @RequestMapping(value = "api/cost/cont_prepayment/financeConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> financeConfirm(@RequestBody ContReceiptVo contReceiptVo);

    /** 
    * @Description: 打印提前还款测算单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 15:43
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/printPrepayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo);

    /** 
    * @Description: 打印提前还款结清证明
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 18:41
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment/printPrepaymentJQZM",method = RequestMethod.GET)
    ResponseEntity<RestResponse> printPrepaymentJQZM(@RequestParam("contPrepaymentNo") String contPrepaymentNo);

    /**
     * @Description: 打印付款单
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/27 18:41
     */
    @RequestMapping(value = "api/cost/cont_prepayment/printPaymentOrder",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPaymentOrder(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo);

    /**
     * @Description: 车辆出库(赎回)
     * @param: vehicleDisposalVo 车辆出库信息
     * @param: sysUser 当前用户信息
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    @RequestMapping(value = "api/cost/cont_prepayment/prePayVehicleShipment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> prePayVehicleShipment(@RequestBody VehicleDisposalVo vehicleDisposalVo);
}
