package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.CollectionTaskRpc;
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
 * @ClassName: CollectionTaskController
 * @Description: 催收任务controller
 */
@RestController
@RequestMapping("collection_task")
public class CollectionTaskController {

    /**
     * @Fields  : 催收任务rpc
     */
    @Autowired
    private CollectionTaskRpc collectionTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询催收任务信息
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "findCollectionTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionTasksByPage(CollectionTaskVo collectionTaskVo){
        Map collectionTaskVoMap = collectionTaskVo == null?null:(Map) JSON.toJSON(collectionTaskVo);
        return collectionTaskRpc.findCollectionTasksByPage(collectionTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存催收任务
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "saveCollectionTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCollectionTask(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.saveCollectionTask(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取客户地址信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "findCstmAddrInfosByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmAddrInfosByOverdueCstmId(String overdueCstmId){
        return collectionTaskRpc.findCstmAddrInfosByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description:  根据collectionTaskNo获取上门催收任务信息
     * @param collectionTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "findCollectionTasksByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionTasksByTaskNo(String collectionTaskNo){
        return collectionTaskRpc.findCollectionTasksByTaskNo(collectionTaskNo);
    }

    /**
     * @Title:
     * @Description:  获取承租人逾期信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "findCstmInfosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmInfosByPage(OverdueCstmVo overdueCstmVo){
        Map overdueCstmVoMap = overdueCstmVo == null?null:(Map) JSON.toJSON(overdueCstmVo);
        return collectionTaskRpc.findCstmInfosByPage(overdueCstmVoMap);
    }

    /**
     * @Title:
     * @Description: 上门催收同意提交
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionApprovalAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionApprovalAgree(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionApprovalAgree(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 上门催收派单
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionDispatchAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionDispatchAgree(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionDispatchAgree(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 上门催收拒绝
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionRefuse(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionRefuse(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 上门催收审核通过
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionAgree(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionAgree(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 上门催收审核退回
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionBack(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionBack(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 上门催收登记暂存
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionRegisterTemporary",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionRegisterTemporary(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.collectionRegisterTemporary(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 校验是否存在未完成的任务
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "isCollectionTaskExit",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isCollectionTaskExit(@RequestBody CollectionTaskVo collectionTaskVo){
        return collectionTaskRpc.isCollectionTaskExit(collectionTaskVo);
    }

    /**
     * @Title:
     * @Description: 催收函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "collectionLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return collectionTaskRpc.collectionLetterDownload(collectionTaskLetterVo);
    }

    /**
     * @Title:
     * @Description: 委托书下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "proxyDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> proxyDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return collectionTaskRpc.proxyDownload(collectionTaskLetterVo);
    }

    /**
     * @Title:
     * @Description: 律师函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "lawyerLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawyerLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return collectionTaskRpc.lawyerLetterDownload(collectionTaskLetterVo);
    }

}
