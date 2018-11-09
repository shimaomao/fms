package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskCancelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskVo;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskController
 * @Description: 基本信息变更任务rpc
 * @date 2018-09-01
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasicChangeTaskRpc {

    /**
     * @Description:  分页查询合同一览信息
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018-04-28 11:43
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findContractListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractListByPage(@RequestParam Map<String, Object> validContractChangeVoMap);

    /**
     * @Description: 生效合同变更查询
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018-04-28 11:43
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findBasicChangeTaskListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasicChangeTaskListByPage(@RequestParam Map<String, Object> basicChangeTaskVoMap);

    /**
     * @Title:
     * @Description: check该客户是否存在未结束的基本信息变更任务
     * @param basicChangeTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/checkBasicChangeTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> checkBasicChangeTask(@RequestBody BasicChangeTaskVo basicChangeTaskVo);

    /**
     * @Title:
     * @Description: check该任务是否能被取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/isTaskCanBeCancel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> isTaskCanBeCancel(@RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo);

    /**
     * @Title:
     * @Description: 基本信息变更取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/basicChangeTaskCancel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> basicChangeTaskCancel(@RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo);

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的企业基本信息变更历史任务
     * @param basicChangeTaskVoMap 参数
     * @return PageInfoExtend<BasicChangeCompHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findBasicCompChangeHistory",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasicCompChangeHistory(@RequestParam Map<String, Object> basicChangeTaskVoMap);

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的个人基本信息变更历史任务
     * @param basicChangeTaskVoMap 参数
     * @return PageInfoExtend<BasicChangePersHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findBasicPersChangeHistory",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasicPersChangeHistory(@RequestParam Map<String, Object> basicChangeTaskVoMap);

    /**
     * 获取展期、增加保证金、变更承租人变更任务号
     * @param contNo 合同号
     * @return
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findChangeInfo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findChangeInfo(@RequestParam("contNo") String contNo);

    /**
     * 获取基本信息变更取消内容
     * @param basicTaskNo 基本信息变更任务号
     * @return
     */
    @RequestMapping(value = "api/postbiz/basic_change_task/findBasicChangeCancelVo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasicChangeCancelVo(@RequestParam("basicTaskNo") String basicTaskNo);

}
