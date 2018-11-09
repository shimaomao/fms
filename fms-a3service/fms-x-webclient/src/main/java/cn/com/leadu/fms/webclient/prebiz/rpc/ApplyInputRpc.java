package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wnagxue
 * @ClassName: ApplyInputRpc
 * @Description: 申请录入管理rpc
 * @date 2018-03-24
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyInputRpc {

    /**
     * @Title:
     * @Description: 保存申请录入信息(暂存)
     * @param applyInputVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/saveApplyInputVo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 提交申请录入信息(保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/submitApplyInputVo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitApplyInputVo(@RequestBody ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 根据订单编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/findApplyInputVoByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyInputVoByApplyNo(@RequestParam("applyNo") String applyNo, @RequestParam("contNo") String contNo);
    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(暂存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/modifyApplyInputVoByApplyNo",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyApplyInputVoByApplyNo(@RequestBody ApplyInputVo applyInputVo);
    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(提交并保存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/subModifyApplyInputVoByApplyNo",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> subModifyApplyInputVoByApplyNo(@RequestBody ApplyInputVo applyInputVo);

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
    @RequestMapping(value = "api/prebiz/apply_input/findApplyFinanceVehicleByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyFinanceVehicleByApplyNo(@RequestParam("applyNo") String applyNo, @RequestParam("contNo") String contNo);
    /**
     * @Title:
     * @Description: 根据订单编号，获取客户基本的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/findApplyCstmPersonByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(@RequestParam("applyNo") String applyNo);
    /**
     * @Title:
     * @Description: 根据订单编号，获取担保人(公司)的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/findApplyGuaranteeByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyGuaranteeByApplyNo(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/findBizFileByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFileByApplyNo(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description: 报价单
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-4-16 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_input/saveQuotationDeviceInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveQuotationDeviceInfo(ApplyInputVo applyInputVo);


    @RequestMapping(value = "api/prebiz/apply_input/printQuotationDeviceInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printQuotationDeviceInfo(ApplyInputVo applyInputVo);
}
