package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskController
 * @Description: 催收任务rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CollectionTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询催收任务信息
     * @param collectionTaskVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/findCollectionTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCollectionTasksByPage(@RequestParam Map<String, Object> collectionTaskVoMap);

    /**
     * @Title:
     * @Description: 保存催收任务
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/saveCollectionTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCollectionTask(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取客户地址信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/findCstmAddrInfosByOverdueCstmId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmAddrInfosByOverdueCstmId(@RequestParam("overdueCstmId") String overdueCstmId);

    /**
     * @Title:
     * @Description: 根据collectionTaskNo获取上门催收任务信息
     * @param collectionTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/findCollectionTasksByTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCollectionTasksByTaskNo(@RequestParam("collectionTaskNo") String collectionTaskNo);

    /**
     * @Title:
     * @Description:  获取承租人逾期信息
     * @param overdueCstmVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/findCstmInfosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmInfosByPage(@RequestParam Map<String, Object> overdueCstmVoMap);

    /**
     * @Title:
     * @Description: 上门催收派单提交
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionApprovalAgree",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionApprovalAgree(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 上门催收派单
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionDispatchAgree",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionDispatchAgree(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 上门催收拒绝
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionRefuse",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionRefuse(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 上门催收审核通过
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionAgree",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionAgree(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 上门催收审核退回
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionBack(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 上门催收登记暂存
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionRegisterTemporary",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionRegisterTemporary(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 校验是否存在未完成的任务
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/isCollectionTaskExit",method = RequestMethod.POST)
    ResponseEntity<RestResponse> isCollectionTaskExit(@RequestBody CollectionTaskVo collectionTaskVo);

    /**
     * @Title:
     * @Description: 催收函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/collectionLetterDownload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo);

    /**
     * @Title:
     * @Description: 委托书下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/proxyDownload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> proxyDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo);

    /**
     * @Title:
     * @Description: 律师函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/collection_task/lawyerLetterDownload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> lawyerLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo);

}
