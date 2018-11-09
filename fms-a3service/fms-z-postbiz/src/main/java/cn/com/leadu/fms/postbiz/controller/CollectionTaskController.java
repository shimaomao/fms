package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CollectionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskController
 * @Description: 催收任务相关接口
 */
@RestController
@RequestMapping("collection_task")
public class CollectionTaskController {

    /**
     * @Fields  : 催收任务service
     */
    @Autowired
    private CollectionTaskService collectionTaskService;

    /**
     * @Title:
     * @Description: 分页查询催收任务信息
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "findCollectionTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionTasksByPage(CollectionTaskVo collectionTaskVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(collectionTaskService.findCollectionTasksByPage(collectionTaskVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存催收任务
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "saveCollectionTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCollectionTask(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.saveCollectionTask(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取客户地址信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "findCstmAddrInfosByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmAddrInfosByOverdueCstmId(String overdueCstmId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionTaskService.findCstmAddrInfosByOverdueCstmId(overdueCstmId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据collectionTaskNo获取上门催收任务信息
     * @param collectionTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "findCollectionTasksByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionTasksByTaskNo(String collectionTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionTaskService.findCollectionTasksByTaskNo(collectionTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取承租人逾期信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "findCstmInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmInfosByPage(OverdueCstmVo overdueCstmVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(collectionTaskService.findCstmInfosByPage(overdueCstmVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收同意
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionApprovalAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionApprovalAgree(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionApprovalAgree(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收派单提交
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionDispatchAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionDispatchAgree(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionDispatchAgree(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收拒绝
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionRefuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionRefuse(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionRefuse(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收审核通过
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionAgree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionAgree(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionAgree(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收审核退回
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionBack(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionBack(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 上门催收登记暂存
     * @param collectionTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionRegisterTemporary",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionRegisterTemporary(@Valid @RequestBody CollectionTaskVo collectionTaskVo, @AuthUserInfo SysUser sysUser){
        collectionTaskService.collectionRegisterTemporary(collectionTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 校验是否存在未完成的任务
     * @param collectionTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "isCollectionTaskExit",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isCollectionTaskExit(@Valid @RequestBody CollectionTaskVo collectionTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                collectionTaskService.isCollectionTaskExit(collectionTaskVo.getOverdueCstmId())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 催收函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "collectionLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionTaskService.collectionLetterDownload(collectionTaskLetterVo.getCollectionTaskNo())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 委托书下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "proxyDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> proxyDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionTaskService.proxyDownload(collectionTaskLetterVo.getCollectionTaskNo())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 律师函下载
     * @param collectionTaskLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "lawyerLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawyerLetterDownload(@RequestBody CollectionTaskLetterVo collectionTaskLetterVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionTaskService.lawyerLetterDownload(collectionTaskLetterVo.getCollectionTaskNo())), HttpStatus.OK);
    }
}
