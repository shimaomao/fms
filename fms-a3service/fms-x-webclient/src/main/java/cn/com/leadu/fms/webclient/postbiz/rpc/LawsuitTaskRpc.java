package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskController
 * @Description: 诉讼任务信息rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface LawsuitTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息信息
     * @param lawsuitTaskSearchVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/findLawsuitTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitTasksByPage(@RequestParam Map<String, Object> lawsuitTaskSearchVoMap);

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼任务信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/findLawsuitTasksByTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitTasksByTaskNo(@RequestParam("lawsuitTaskNo") String lawsuitTaskNo);

    /**
     * @Title:
     * @Description: 根据lawsuitTaskNo获取诉讼登记信息
     * @param lawsuitTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/findLawsuitRegistersByTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitRegistersByTaskNo(@RequestParam("lawsuitTaskNo") String lawsuitTaskNo);

    /**
     * @Title:
     * @Description: 根据overdueContId获取诉讼基本信息
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/findLawsuitTasksByOverdueContId" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitTasksByOverdueContId(@RequestParam("overdueContId") String overdueContId);

    /**
     * @Title:
     * @Description: 根据overdueContId获取逾期客户Id
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/findOverdueCstmIdByOverdueContId" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmIdByOverdueContId(@RequestParam("overdueContId") String overdueContId);

    /**
     * @Title:
     * @Description: 保存诉讼任务信息
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/saveLawsuitTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveLawsuitTask(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * @Title:
     * @Description: 校验合同是否存在未结束的任务
     * @param overdueContId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/isLawsuitTaskExit",method = RequestMethod.POST)
    ResponseEntity<RestResponse> isLawsuitTaskExit(@RequestParam("overdueContId") String overdueContId);

    /**
     * @Title:
     * @Description: 风控经理审核通过
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/lawsuitApproval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> lawsuitApproval(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * @Title:
     * @Description: 退回
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/lawsuitBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> lawsuitBack(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * @Title:
     * @Description: 拒绝
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/lawsuitRefuse",method = RequestMethod.POST)
    ResponseEntity<RestResponse> lawsuitRefuse(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * @Title:
     * @Description: 诉讼任务登记暂存
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/registerTemporary",method = RequestMethod.POST)
    ResponseEntity<RestResponse> registerTemporary(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * @Title:
     * @Description: 诉讼任务登记提交
     * @param lawsuitTaskSearchVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:48
     */
    @RequestMapping(value = "api/postbiz/lawsuit_task/registerSave",method = RequestMethod.POST)
    ResponseEntity<RestResponse> registerSave(@RequestBody LawsuitTaskSearchVo lawsuitTaskSearchVo);


}
