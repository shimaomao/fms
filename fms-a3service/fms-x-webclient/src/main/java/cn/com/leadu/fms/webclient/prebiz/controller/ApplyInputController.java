package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyInputRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxue
 * @ClassName: ApplyInputController
 * @Description: 申请录入管理Controller
 * @date 2018-03-24
 */
@RestController
@RequestMapping("apply_input")
public class ApplyInputController {

    @Autowired
    private ApplyInputRpc applyInputRpc;

    /**
     * @Title:
     * @Description: 保存申请录入信息(暂存)
     * @param applyInputVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "saveApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo) {
        return applyInputRpc.saveApplyInputVo(applyInputVo);
    }
    /**
     * @Title:
     * @Description: 提交申请录入信息(保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "submitApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitApplyInputVo(@RequestBody ApplyInputVo applyInputVo) {
        return applyInputRpc.submitApplyInputVo(applyInputVo);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyInputVoByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputVoByApplyNo(String applyNo, String contNo){
        return applyInputRpc.findApplyInputVoByApplyNo(applyNo, contNo);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(暂存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "modifyApplyInputVoByApplyNo", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyApplyInputVoByApplyNo(@RequestBody ApplyInputVo applyInputVo){
        return applyInputRpc.modifyApplyInputVoByApplyNo(applyInputVo);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(提交并保存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "subModifyApplyInputVoByApplyNo", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> subModifyApplyInputVoByApplyNo(@RequestBody ApplyInputVo applyInputVo){
        return applyInputRpc.subModifyApplyInputVoByApplyNo(applyInputVo);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取订单的融资信息
     * @param applyNo 订单编号
     * @param contNo 合同编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-4-13 18:18:12
     */
    @RequestMapping(value = "findApplyFinanceVehicleByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyFinanceVehicleByApplyNo(String applyNo, String contNo){
        return applyInputRpc.findApplyFinanceVehicleByApplyNo(applyNo, contNo);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取客户基本的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo){
        return applyInputRpc.findApplyCstmPersonByApplyNo(applyNo);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取担保人(公司)的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyGuaranteeByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyGuaranteeByApplyNo(String applyNo){
        return applyInputRpc.findApplyGuaranteeByApplyNo(applyNo);
    }


    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @RequestMapping(value = "findBizFileByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByApplyNo(String applyNo){
        return applyInputRpc.findBizFileByApplyNo(applyNo);
    }

    /**
     * @Title:
     * @Description: 报价器计算
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @RequestMapping(value = "saveQuotationDeviceInfo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDeviceInfo(@RequestBody ApplyInputVo applyInputVo){
        return applyInputRpc.saveQuotationDeviceInfo(applyInputVo);
    }

    /**
     * @Title:
     * @Description: 报价器计算
     * @param applyInputVo
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @RequestMapping(value = "printQuotationDeviceInfo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printQuotationDeviceInfo(@RequestBody ApplyInputVo applyInputVo){
        return applyInputRpc.printQuotationDeviceInfo(applyInputVo);
    }
}
