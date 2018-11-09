package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.ChangeLesseeTaskRpc;
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
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskController
 * @Description: 承租人变更controller
 */
@RestController
@RequestMapping("change_lessee_task")
public class ChangeLesseeTaskController {

    /**
     * @Fields  : 承租人变更rpc
     */
    @Autowired
    private ChangeLesseeTaskRpc changeLesseeTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询承租人变更信息
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "findChangeLesseeTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findChangeLesseeTasksByPage(ChangeLesseeTaskVo changeLesseeTaskVo){
        Map changeLesseeTaskVoMap = changeLesseeTaskVo == null?null:(Map) JSON.toJSON(changeLesseeTaskVo);
        return changeLesseeTaskRpc.findChangeLesseeTasksByPage(changeLesseeTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存承租人变更
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "saveChangeLesseeTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveChangeLesseeTask(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.saveChangeLesseeTask(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改承租人变更
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "modifyChangeLesseeTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyChangeLesseeTask(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.modifyChangeLesseeTask(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据taskId集合删除承租人变更
     * @param taskIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @RequestMapping(value = "deleteChangeLesseeTasksByTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteChangeLesseeTasksByTaskIds(@RequestBody List<String> taskIds){
        ChangeLesseeTaskVo changeLesseeTaskVo = new ChangeLesseeTaskVo();
        changeLesseeTaskVo.setTaskIds(taskIds);
        return changeLesseeTaskRpc.deleteChangeLesseeTasksByTaskIds(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取承租人变更信息
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 15:14:54
     */
    @RequestMapping(value = "findChangeLesseeTaskByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findChangeLesseeTaskByTaskId(String contNo){
        return changeLesseeTaskRpc.findChangeLesseeTaskByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:  暂存变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 15:14:54
     */
    @RequestMapping(value = "saveApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo){
        return changeLesseeTaskRpc.saveApplyInputVo(applyInputVo);
    }

    /**
     * @Title:
     * @Description:  提交变更承租人信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 15:14:54
     */
    @RequestMapping(value = "submitApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitApplyInputVo(@RequestBody ApplyInputVo applyInputVo){
        return changeLesseeTaskRpc.submitApplyInputVo(applyInputVo);
    }

    /**
     * @Title:
     * @Description:  根据任务号，获取客户的所有基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-11 15:14:54
     */
    @RequestMapping(value = "findApplyInputVoByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputVoByApplyNo(String applyNo){
        return changeLesseeTaskRpc.findApplyInputVoByApplyNo(applyNo);
    }

    /**
     * @Title:
     * @Description:  承租人变更风控复审
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "submitRiskApprove", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitRiskApprove(@RequestBody ApplyRiskVo applyRiskVo){
        return changeLesseeTaskRpc.submitRiskApprove(applyRiskVo);
    }

    /**
     * @Title:
     * @Description:  承租人变更合同生成
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "changeContGenerate", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContGenerate(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.changeContGenerate(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  承租人变更合同打印
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "changeContPrint", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContPrint(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.changeContPrint(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  承租人变更合同审核
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @RequestMapping(value = "changeContApprove", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> changeContApprove(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.changeContApprove(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  承租人变更退回上一级
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-15 15:14:54
     */
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.sendBack(changeLesseeTaskVo);
    }

    /**
     * @Title:
     * @Description:  承租人变更拒绝
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 15:14:54
     */
    @RequestMapping(value = "goRefuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> goRefuse(@RequestBody ChangeLesseeTaskVo changeLesseeTaskVo){
        return changeLesseeTaskRpc.goRefuse(changeLesseeTaskVo);
    }

}
