package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskController
 * @Description: 承租人变更rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ChangeLesseeTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询承租人变更信息
     * @param changeLesseeTaskVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/findChangeLesseeTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findChangeLesseeTasksByPage(@RequestParam Map<String, Object> changeLesseeTaskVoMap);

    /**
     * @Title:
     * @Description: 保存承租人变更
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/saveChangeLesseeTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveChangeLesseeTask(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:  修改承租人变更
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/modifyChangeLesseeTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyChangeLesseeTask(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:   根据taskId集合删除承租人变更
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/deleteChangeLesseeTasksByTaskIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteChangeLesseeTasksByTaskIds(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:  根据contNo获取承租人变更
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/findChangeLesseeTaskByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findChangeLesseeTaskByContNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description:   暂存变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/prebiz/change_lessee_task/saveApplyInputVo" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo);

    /**
     * @Title:
     * @Description:   提交变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/prebiz/change_lessee_task/submitApplyInputVo" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitApplyInputVo(@RequestBody ApplyInputVo applyInputVo);

    /**
     * @Title:
     * @Description:   根据任务号，获取客户的所有基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "api/prebiz/change_lessee_task/findApplyInputVoByApplyNo" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyInputVoByApplyNo(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description:   承租人变更风控复审
     * @param applyRiskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/submitRiskApprove" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitRiskApprove(@RequestBody ApplyRiskVo applyRiskVo);

    /**
     * @Title:
     * @Description:   承租人变更合同生成
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "api/prebiz/change_lessee_task/changeContGenerate" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> changeContGenerate(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:   承租人变更合同打印
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/changeContPrint" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> changeContPrint(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:   承租人变更合同审核
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/changeContApprove" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> changeContApprove(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:   承租人变更退回上一级
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/sendBack" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);

    /**
     * @Title:
     * @Description:   承租人变更拒绝
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 15:14:54
     */
    @RequestMapping(value = "api/postbiz/change_lessee_task/goRefuse" , method = RequestMethod.POST)
    ResponseEntity<RestResponse> goRefuse(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo);


}
