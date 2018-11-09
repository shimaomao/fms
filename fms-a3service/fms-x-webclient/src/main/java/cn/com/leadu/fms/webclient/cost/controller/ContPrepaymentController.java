package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.webclient.cost.rpc.ContPrepaymentRpc;
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
 * @author yangyiquan
 * @ClassName: ContPrepaymentController
 * @Description: 提前还款controller
 * @date 2018-05-10
 */
@RestController
@RequestMapping("cont_prepayment")
public class ContPrepaymentController {

    /**
     * @Fields  : 提前还款rpc
     */
    @Autowired
    private ContPrepaymentRpc contPrepaymentRpc;

    /**
     * @Title:
     * @Description: 分页查询提前还款信息entity
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "findContPrepaymentsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentsByPage(ContPrepaymentVo contPrepaymentVo){
        Map contPrepaymentVoMap = contPrepaymentVo == null?null:(Map) JSON.toJSON(contPrepaymentVo);
        return contPrepaymentRpc.findContPrepaymentsByPage(contPrepaymentVoMap);
    }

    /** 
    * @Description:  分页查询提前还款vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/10 20:22
    */ 
    @RequestMapping(value="findContPrepaymentListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentListByPage(ContPrepaymentVo contPrepaymentVo){
        Map contPrepaymentVoMap = contPrepaymentVo == null ? null : (Map)JSON.toJSON(contPrepaymentVo);
        return contPrepaymentRpc.findContPrepaymentListByPage(contPrepaymentVoMap);
    }

    /**
     * @Title:
     * @Description: 保存提前还款
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "saveContPrepayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo){
        return contPrepaymentRpc.saveContPrepayment(contPrepaymentVo);
    }

    /**
     * @Title:
     * @Description:  修改提前还款
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "modifyContPrepayment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo){
        return contPrepaymentRpc.modifyContPrepayment(contPrepaymentVo);
    }

    /**
     * @Title:
     * @Description:   根据contPrepaymentId集合删除提前还款
     * @param contPrepaymentIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "deleteContPrepaymentsByContPrepaymentIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepaymentsByContPrepaymentIds(@RequestBody List<String> contPrepaymentIds){
        ContPrepaymentVo contPrepaymentVo = new ContPrepaymentVo();
        contPrepaymentVo.setContPrepaymentIds(contPrepaymentIds);
        return contPrepaymentRpc.deleteContPrepaymentsByContPrepaymentIds(contPrepaymentVo);
    }

    /**
     * @Title:
     * @Description:  根据contPrepaymentId获取提前还款
     * @param contPrepaymentId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "findContPrepaymentByContPrepaymentId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentByContPrepaymentId(String contPrepaymentId){
        return contPrepaymentRpc.findContPrepaymentByContPrepaymentId(contPrepaymentId);
    }

    /** 
    * @Description: 根据合同编号获取提前还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 15:06
    */ 
    @RequestMapping(value = "findContPrepaymentByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentByContNo(String contNo){
        return contPrepaymentRpc.findContPrepaymentByContNo(contNo);
    }

    /** 
    * @Description: 根据合同编号构造提前还款和提前还款明细信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 15:55
    */ 
    @RequestMapping(value = "findContPrepaymentWithDetailByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentWithDetailByContNo(String contNo){
        return contPrepaymentRpc.findContPrepaymentWithDetailByContNo(contNo);
    }

    /**
     * @Description: 根据业务号查询提前还款和提前还款明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 15:55
     */
    @RequestMapping(value = "findContPrepaymentWithDetailByContPrepaymentNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentWithDetailByContPrepaymentNo(String contPrepaymentNo){
        return contPrepaymentRpc.findContPrepaymentWithDetailByContPrepaymentNo(contPrepaymentNo);
    }

    /** 
    * @Description: 保存提前还款和明细 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 18:55
    */ 
    @RequestMapping(value = "saveContPrepaymentWithDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepaymentWithDetail(@RequestBody ContPrepaymentVo contPrepaymentVo){
        return contPrepaymentRpc.saveContPrepaymentWithDetail(contPrepaymentVo);
    }

    /**
    * @Description: 财务确认
    * @param:
    * @return:
    * @Author: lijunjun
    * @Date: 2018/5/14 18:55
    */
    @RequestMapping(value = "financeConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeConfirm(@RequestBody ContReceiptVo contReceiptVo){
        return contPrepaymentRpc.financeConfirm(contReceiptVo);
    }

    /**
    * @Description: 打印提前还款测算单
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/6/29 15:08
    */
    @RequestMapping(value = "printPrepayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo){
        return contPrepaymentRpc.printPrepayment(contPrepaymentVo);
    }

    /** 
    * @Description: 打印提前还款结清证明
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 18:44
    */ 
    @RequestMapping(value = "printPrepaymentJQZM",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> printPrepaymentJQZM(String contPrepaymentNo){
        return contPrepaymentRpc.printPrepaymentJQZM(contPrepaymentNo);
    }

    /**
     * @Description: 打印付款单
     * @param: contPrepaymentApproveVo
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/27 18:44
     */
    @RequestMapping(value = "printPaymentOrder",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo){
        return contPrepaymentRpc.printPaymentOrder(contPrepaymentApproveVo);
    }

    /**
     * @Description: 车辆出库(赎回)
     * @param: vehicleDisposalVo 车辆出库信息
     * @param: sysUser 当前用户信息
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    @RequestMapping(value = "prePayVehicleShipment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> prePayVehicleShipment(@RequestBody VehicleDisposalVo vehicleDisposalVo){
         return contPrepaymentRpc.prePayVehicleShipment(vehicleDisposalVo);
    }

}
