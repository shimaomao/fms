package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.LawsuitTaskRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskController
 * @Description: 诉讼任务信息controller
 */
@RestController
@RequestMapping("lawsuit_task")
public class LawsuitTaskController {

    /**
     * @Fields  : 诉讼任务信息rpc
     */
    @Autowired
    private LawsuitTaskRpc lawsuitTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息信息
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "findLawsuitTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByPage(LawsuitTaskSearchVo lawsuitTaskSearchVo){
        Map lawsuitTaskSearchVoMap = lawsuitTaskSearchVo == null?null:(Map) JSON.toJSON(lawsuitTaskSearchVo);
        return lawsuitTaskRpc.findLawsuitTasksByPage(lawsuitTaskSearchVoMap);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼任务信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "findLawsuitTasksByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByTaskNo(String lawsuitTaskNo){
        return lawsuitTaskRpc.findLawsuitTasksByTaskNo(lawsuitTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼登记信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "findLawsuitRegistersByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegistersByTaskNo(String lawsuitTaskNo){
        return lawsuitTaskRpc.findLawsuitRegistersByTaskNo(lawsuitTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据overdueContIdo获取诉讼基本信息
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "findLawsuitTasksByOverdueContId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitTasksByOverdueContId(String overdueContId){
        return lawsuitTaskRpc.findLawsuitTasksByOverdueContId(overdueContId);
    }

    /**
     * @Title:
     * @Description: 根据overdueContIdo获取逾期客户Id
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "findOverdueCstmIdByOverdueContId" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmIdByOverdueContId(String overdueContId){
        return lawsuitTaskRpc.findOverdueCstmIdByOverdueContId(overdueContId);
    }

    /**
     * @Title:
     * @Description: 保存诉讼任务信息
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "saveLawsuitTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLawsuitTask(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo){
        return lawsuitTaskRpc.saveLawsuitTask(lawsuitTaskSearchVo);
    }

    /**
     * @Title:
     * @Description: 校验合同是否存在未结束的任务
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "isLawsuitTaskExit",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isLawsuitTaskExit(@RequestBody String overdueContId){
        return lawsuitTaskRpc.isLawsuitTaskExit(overdueContId);
    }

    /**
     * @Title:
     * @Description: 风控经理审核通过
     * @param LawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "lawsuitApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitApproval(@RequestBody LawsuitTaskSearchVo LawsuitTaskSearchVo){
        return lawsuitTaskRpc.lawsuitApproval(LawsuitTaskSearchVo);
    }

    /**
     * @Title:
     * @Description: 退回
     * @param LawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "lawsuitBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitBack(@RequestBody LawsuitTaskSearchVo LawsuitTaskSearchVo){
        return lawsuitTaskRpc.lawsuitBack(LawsuitTaskSearchVo);
    }

    /**
     * @Title:
     * @Description: 拒绝
     * @param LawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "lawsuitRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawsuitRefuse(@RequestBody LawsuitTaskSearchVo LawsuitTaskSearchVo){
        return lawsuitTaskRpc.lawsuitRefuse(LawsuitTaskSearchVo);
    }

    /**
     * @Title:
     * @Description: 诉讼任务登记暂存
     * @param LawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "registerTemporary",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> registerTemporary(@RequestBody LawsuitTaskSearchVo LawsuitTaskSearchVo){
        return lawsuitTaskRpc.registerTemporary(LawsuitTaskSearchVo);
    }

    /**
     * @Title:
     * @Description: 诉讼任务登记提交
     * @param LawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "registerSave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> registerSave(@RequestBody LawsuitTaskSearchVo LawsuitTaskSearchVo){
        return lawsuitTaskRpc.registerSave(LawsuitTaskSearchVo);
    }

}
