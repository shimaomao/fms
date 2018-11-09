package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.business.common.util.activiti.ActFilePostUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActUtils;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.original.service.OrigFileService;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteListVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileDeleteVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileModifyVo;
import cn.com.leadu.fms.original.validator.origfile.vo.OrigFileSaveVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileMailVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: OrigFileController
 * @Description: 资料邮寄附件相关接口
 * @date 2018-05-03
 */
@RestController
@RequestMapping("orig_file")
public class OrigFileController {

    /**
     * @Fields  : 资料邮寄附件service
     */
    @Autowired
    private OrigFileService origFileService;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFilesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFilesByPage(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFilesByPage(origFileVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileInfoByBizCodeAndBizCodeType" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileInfoByBizCodeAndBizCodeType(origFileVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（原件归档）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFilesByOrigFileStatus(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFilesByOrigFileStatus(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（原件借阅）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findBorrowOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowOrigFilesByOrigFileStatus(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findBorrowOrigFilesByOrigFileStatus(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（续保归档）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findRenewalOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalOrigFilesByOrigFileStatus(OrigFileVo origFileVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findRenewalOrigFilesByOrigFileStatus(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息（贷前归档邮寄与上传）
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findPreOrigFilesByOrigFileStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPreOrigFilesByOrigFileStatus(OrigFileVo origFileVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findPreOrigFilesByOrigFileStatus(origFileVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileMailList" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileMailList(OrigFileVo origFileVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileMailList(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileSortDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileSortDetailsByPage(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据（资管复核）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileSortDetailsExamineByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileSortDetailsExamineByPage(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileSortDetailsExamineByPage(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "selectOrigFileRenewalSortDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.selectOrigFileRenewalSortDetailsByPage(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件
     * @param origFileSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "saveOrigFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOrigFile(@Valid @RequestBody OrigFileSaveVo origFileSaveVo){
        origFileService.saveOrigFile(origFileSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 文件归档暂存
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "temporarySave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> temporarySave(@Valid @RequestBody OrigFileSortVo origFileSortVo){
        origFileService.temporarySave(origFileSortVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 确认收到
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "ReceivedConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> ReceivedConfirm(@Valid @RequestBody OrigFileSortVo origFileSortVo){
        origFileService.ReceivedConfirm(origFileSortVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 归档
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "origFileSort",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSort(@Valid @RequestBody OrigFileSortVo origFileSortVo, @AuthUserInfo SysUser sysUser){
        origFileService.origFileSort(origFileSortVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 归档审核退回
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "origFileSortExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSortExamineBack(@Valid @RequestBody OrigFileSortVo origFileSortVo, @AuthUserInfo SysUser sysUser){
        origFileService.origFileSortExamineBack(origFileSortVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 归档审核
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "origFileSortExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileSortExamine(@Valid @RequestBody OrigFileSortVo origFileSortVo, @AuthUserInfo SysUser sysUser){
        origFileService.origFileSortExamine(origFileSortVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileMailVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "mailConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> mailConfirm(@Valid @RequestBody OrigFileMailVo origFileMailVo, @AuthUserInfo SysUser sysUser){
        origFileService.mailConfirm(origFileMailVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资料上传
     * @param origFileMailVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "origFileUpload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> origFileUpload(@Valid @RequestBody OrigFileMailVo origFileMailVo, @AuthUserInfo SysUser sysUser){
        origFileService.origFileUpload(origFileMailVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保单归档确认
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "renewalSortConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalSortConfirm(@Valid @RequestBody OrigFileSortVo origFileSortVo, @AuthUserInfo SysUser sysUser){
        origFileService.renewalSortConfirm(origFileSortVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄附件
     * @param origFileModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "modifyOrigFile",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOrigFile(@Valid @RequestBody OrigFileModifyVo origFileModifyVo){
        origFileService.modifyOrigFile(origFileModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除资料邮寄附件
     * @param origFileDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "deleteOrigFile",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFile(@Valid @RequestBody OrigFileDeleteVo origFileDeleteVo){
        origFileService.deleteOrigFile(origFileDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据origFileId集合删除资料邮寄附件
     * @param origFileDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "deleteOrigFilesByOrigFileIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFilesByOrigFileIds(@Valid @RequestBody OrigFileDeleteListVo origFileDeleteListVo){
        origFileService.deleteOrigFilesByOrigFileIds(origFileDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据origFileId获取资料邮寄附件
     * @param origFileId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileByOrigFileId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileByOrigFileId(String origFileId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileByOrigFileId(origFileId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  确认归档
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "confirmFile", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> confirmFile(@Valid @RequestBody OrigFileVo origFileVo){
        origFileService.confirmFile(origFileVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  退回
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "cancelFile", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelFile(@Valid @RequestBody OrigFileVo origFileVo){
        origFileService.cancelFile(origFileVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  归档完成确认
     * @param origFileVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 14:16:46
     */

    @RequestMapping(value = "fileFinishedConfirm", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> fileFinishedConfirm(@Valid @RequestBody OrigFileVo origFileVo){
        origFileService.fileFinishedConfirm(origFileVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 归档明细
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigArchiveDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigArchiveDetailByPage(OrigFileVo origFileVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigArchiveDetailByPage(origFileVo)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "startFilePost", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> startFilePost(){
        String taskId = ActFilePostUtils.startFilePost("1","1","1").getId();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(taskId), HttpStatus.OK);
    }

    @RequestMapping(value = "completeFilePost", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> completeFilePost(String taskId){
        ActFilePostUtils.completeFilePost(taskId).getId();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    @RequestMapping(value = "completeFilePostReceive", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> completeFilePostReceive(String taskId){
        ActUtils.complete(taskId);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询融保险资料邮寄附件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileVos" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileVos(){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileVos()),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询邮寄附件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-27 14:16:46
     */
    @RequestMapping(value = "findOrigFileByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileByContNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileByContNo(contNo)),
                HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileListByPage(OrigFileVo origFileVo,@AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileListByPage(origFileVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件信息
     * @param origFileVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    @RequestMapping(value = "findOrigFileInsListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileInsListByPage(OrigFileVo origFileVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileService.findOrigFileInsListByPage(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保单归档附件上传
     * @param origFileSortVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-3 14:16:46
     */
    @RequestMapping(value = "uploadRenewalFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalSortConfirm(@Valid @RequestBody OrigFileSortVo origFileSortVo){
        origFileService.uploadRenewalFile(origFileSortVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
