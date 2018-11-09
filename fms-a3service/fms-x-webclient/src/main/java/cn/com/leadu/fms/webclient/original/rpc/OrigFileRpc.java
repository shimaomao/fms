package cn.com.leadu.fms.webclient.original.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileMailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: OrigFileController
 * @Description: 资料邮寄附件rpc
 * @date 2018-05-03
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OrigFileRpc {

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFilesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFilesByPage(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileListByPage(@RequestParam Map<String, Object> origFileVoMap);



    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileInsListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileInsListByPage(@RequestParam Map<String, Object> origFileVoMap);
    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileInfoByBizCodeAndBizCodeType" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileInfoByBizCodeAndBizCodeType(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息(原件归档)
     * @param origFileVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFilesByOrigFileStatus(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息(原件借阅)
     * @param origFileVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findBorrowOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowOrigFilesByOrigFileStatus(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息(续保归档)
     * @param origFileVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findRenewalOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRenewalOrigFilesByOrigFileStatus(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息(贷前归档邮寄与上传)
     * @param origFileVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findPreOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findPreOrigFilesByOrigFileStatus(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileSortDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileSortDetailsByPage(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据（资管复核）
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileSortDetailsExamineByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileSortDetailsExamineByPage(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/selectOrigFileRenewalSortDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> selectOrigFileRenewalSortDetailsByPage(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Title:
     * @Description: 保存资料邮寄附件
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/saveOrigFile",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOrigFile(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 文件归档暂存
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/temporarySave",method = RequestMethod.POST)
    ResponseEntity<RestResponse> temporarySave(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description: 确认收到
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/ReceivedConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> ReceivedConfirm(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description: 归档
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/origFileSort",method = RequestMethod.POST)
    ResponseEntity<RestResponse> origFileSort(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description: 归档审核
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/origFileSortExamine",method = RequestMethod.POST)
    ResponseEntity<RestResponse> origFileSortExamine(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description: 归档审核退回
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/origFileSortExamineBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> origFileSortExamineBack(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileMailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/mailConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> mailConfirm(@RequestBody OrigFileMailVo origFileMailVo);

    /**
     * @Title:
     * @Description: 资料上传
     * @param origFileMailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/origFileUpload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> origFileUpload(@RequestBody OrigFileMailVo origFileMailVo);

    /**
     * @Title:
     * @Description: 保单归档确认
     * @param origFileSortVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/renewalSortConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> renewalSortConfirm(@RequestBody OrigFileSortVo origFileSortVo);

    /**
     * @Title:
     * @Description:  修改资料邮寄附件
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/modifyOrigFile",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOrigFile(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description:   根据origFileId集合删除资料邮寄附件
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/deleteOrigFilesByOrigFileIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOrigFilesByOrigFileIds(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description:  根据origFileId获取资料邮寄附件
     * @param origFileId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileByOrigFileId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileByOrigFileId(@RequestParam("origFileId") String origFileId);

    /**
     * @Title:
     * @Description: 获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigFileMailList" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileMailList(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description:  确认归档
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/confirmFile", method = RequestMethod.POST)
    ResponseEntity<RestResponse> confirmFile(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description:  退回
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/cancelFile", method = RequestMethod.POST)
    ResponseEntity<RestResponse> cancelFile(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description:  归档完成确认
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/fileFinishedConfirm", method = RequestMethod.POST)
    ResponseEntity<RestResponse> fileFinishedConfirm(@RequestBody OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 归档明细
     * @param origFileVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/findOrigArchiveDetailByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigArchiveDetailByPage(@RequestParam Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 续保归档附件上传
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-3 14:16:47
     */
    @RequestMapping(value = "api/original/orig_file/uploadRenewalFile",method = RequestMethod.POST)
    ResponseEntity<RestResponse> uploadRenewalFile(@RequestBody OrigFileSortVo origFileSortVo);




    @RequestMapping(value = "api/original/orig_file/startFilePost", method = RequestMethod.GET)
    ResponseEntity<RestResponse> startFilePost();

    @RequestMapping(value = "api/original/orig_file/completeFilePost", method = RequestMethod.GET)
    ResponseEntity<RestResponse> completeFilePost(@RequestParam("taskId") String taskId);

    @RequestMapping(value = "api/original/orig_file/completeFilePostReceive", method = RequestMethod.GET)
    ResponseEntity<RestResponse> completeFilePostReceive(@RequestParam("taskId") String taskId);

}
