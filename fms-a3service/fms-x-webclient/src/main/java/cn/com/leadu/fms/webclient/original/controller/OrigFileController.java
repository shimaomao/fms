package cn.com.leadu.fms.webclient.original.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileMailVo;
import cn.com.leadu.fms.webclient.original.rpc.OrigFileRpc;
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
 * @ClassName: OrigFileController
 * @Description: 资料邮寄附件controller
 * @date 2018-05-03
 */
@RestController
@RequestMapping("orig_file")
public class OrigFileController {

    /**
     * @Fields  : 资料邮寄附件rpc
     */
    @Autowired
    private OrigFileRpc origFileRpc;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFilesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFilesByPage(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFilesByPage(origFileVoMap);
    }
    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileListByPage(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFileListByPage(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileInsListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileInsListByPage(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFileInsListByPage(origFileVoMap);
    }
    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileInfoByBizCodeAndBizCodeType" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFileInfoByBizCodeAndBizCodeType(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息【原件归档】
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFilesByOrigFileStatus(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（原件借阅）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findBorrowOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findBorrowOrigFilesByOrigFileStatus(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（续保归档）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findRenewalOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findRenewalOrigFilesByOrigFileStatus(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（贷前归档邮寄与上传）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findPreOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPreOrigFilesByOrigFileStatus(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findPreOrigFilesByOrigFileStatus(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileSortDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo){
        Map origFileDetailVoMap = origFileDetailVo == null?null:(Map) JSON.toJSON(origFileDetailVo);
        return origFileRpc.findOrigFileSortDetailsByPage(origFileDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据（资管复核）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileSortDetailsExamineByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileSortDetailsExamineByPage(OrigFileDetailVo origFileDetailVo){
        Map origFileDetailVoMap = origFileDetailVo == null?null:(Map) JSON.toJSON(origFileDetailVo);
        return origFileRpc.findOrigFileSortDetailsExamineByPage(origFileDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "selectOrigFileRenewalSortDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo){
        Map origFileDetailVoMap = origFileDetailVo == null?null:(Map) JSON.toJSON(origFileDetailVo);
        return origFileRpc.selectOrigFileRenewalSortDetailsByPage(origFileDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "saveOrigFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOrigFile(@RequestBody OrigFileVo origFileVo){
        return origFileRpc.saveOrigFile(origFileVo);
    }

    /**
     * @Title:
     * @Description: 文件归档暂存
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "temporarySave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> temporarySave(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.temporarySave(origFileSortVo);
    }

    /**
     * @Title:
     * @Description: 确认收到
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "ReceivedConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> ReceivedConfirm(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.ReceivedConfirm(origFileSortVo);
    }

    /**
     * @Title:
     * @Description: 归档
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "origFileSort",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSort(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.origFileSort(origFileSortVo);
    }

    /**
     * @Title:
     * @Description: 归档审核
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "origFileSortExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSortExamine(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.origFileSortExamine(origFileSortVo);
    }

    /**
     * @Title:
     * @Description: 归档审核退回
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "origFileSortExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSortExamineBack(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.origFileSortExamineBack(origFileSortVo);
    }

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileMailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "mailConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> mailConfirm(@RequestBody OrigFileMailVo origFileMailVo){
        return origFileRpc.mailConfirm(origFileMailVo);
    }

    /**
     * @Title:
     * @Description: 资料上传
     * @param origFileMailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "origFileUpload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileUpload(@RequestBody OrigFileMailVo origFileMailVo){
        return origFileRpc.origFileUpload(origFileMailVo);
    }

    /**
     * @Title:
     * @Description: 保单归档确认
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "renewalSortConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalSortConfirm(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.renewalSortConfirm(origFileSortVo);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄附件
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "modifyOrigFile",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOrigFile(@RequestBody OrigFileVo origFileVo){
        return origFileRpc.modifyOrigFile(origFileVo);
    }

    /**
     * @Title:
     * @Description:   根据origFileId集合删除资料邮寄附件
     * @param origFileIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "deleteOrigFilesByOrigFileIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFilesByOrigFileIds(@RequestBody List<String> origFileIds){
        OrigFileVo origFileVo = new OrigFileVo();
        origFileVo.setOrigFileIds(origFileIds);
        return origFileRpc.deleteOrigFilesByOrigFileIds(origFileVo);
    }

    /**
     * @Title:
     * @Description:  根据origFileId获取资料邮寄附件
     * @param origFileId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileByOrigFileId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileByOrigFileId(String origFileId){
        return origFileRpc.findOrigFileByOrigFileId(origFileId);
    }

    /**
     * @Title:
     * @Description:  获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigFileMailList", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileMailList(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigFileMailList(origFileVoMap);
    }

    /**
     * @Title:
     * @Description:  确认归档
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "confirmFile", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> confirmFile(@RequestBody OrigFileVo origFileVo){
        return origFileRpc.confirmFile(origFileVo);
    }

    /**
     * @Title:
     * @Description:  退回
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "cancelFile", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelFile(@RequestBody OrigFileVo origFileVo){
        return origFileRpc.cancelFile(origFileVo);
    }

    /**
     * @Title:
     * @Description:  归档完成确认
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "fileFinishedConfirm", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> fileFinishedConfirm(@RequestBody OrigFileVo origFileVo){
        return origFileRpc.fileFinishedConfirm(origFileVo);
    }


    /**
     * @Title:
     * @Description: 归档明细
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "findOrigArchiveDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigArchiveDetailByPage(OrigFileVo origFileVo){
        Map origFileVoMap = origFileVo == null?null:(Map) JSON.toJSON(origFileVo);
        return origFileRpc.findOrigArchiveDetailByPage(origFileVoMap);
    }

    @RequestMapping(value = "startFilePost", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> startFilePost(){
        return origFileRpc.startFilePost();
    }

    @RequestMapping(value = "completeFilePost", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> completeFilePost(String taskId){
        return origFileRpc.completeFilePost(taskId);
    }

    @RequestMapping(value = "completeFilePostReceive", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> completeFilePostReceive(String taskId){
        return origFileRpc.completeFilePostReceive(taskId);
    }

    /**
     * @Title:
     * @Description: 保单归档附件上传
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-3 14:16:47
     */
    @RequestMapping(value = "uploadRenewalFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> uploadRenewalFile(@RequestBody OrigFileSortVo origFileSortVo){
        return origFileRpc.uploadRenewalFile(origFileSortVo);
    }

}
