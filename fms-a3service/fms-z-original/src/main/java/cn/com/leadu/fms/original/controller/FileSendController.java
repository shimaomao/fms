package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.original.service.FileSendService;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteListVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendModifyVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendSaveVo;
import cn.com.leadu.fms.pojo.original.vo.filesend.FileSendVo;
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
 * @ClassName: FileSendController
 * @Description: 资料邮寄相关接口
 * @date 2018-05-04
 */
@RestController
@RequestMapping("file_send")
public class FileSendController {

    /**
     * @Fields  : 资料邮寄service
     */
    @Autowired
    private FileSendService fileSendService;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄信息
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "findFileSendsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileSendsByPage(FileSendVo fileSendVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(fileSendService.findFileSendsByPage(fileSendVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄
     * @param fileSendSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "saveFileSend",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFileSend(@Valid @RequestBody FileSendSaveVo fileSendSaveVo){
        fileSendService.saveFileSend(fileSendSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄
     * @param fileSendModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "modifyFileSend",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFileSend(@Valid @RequestBody FileSendModifyVo fileSendModifyVo){
        fileSendService.modifyFileSend(fileSendModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除资料邮寄
     * @param fileSendDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "deleteFileSend",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFileSend(@Valid @RequestBody FileSendDeleteVo fileSendDeleteVo){
        fileSendService.deleteFileSend(fileSendDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据filePostId集合删除资料邮寄
     * @param fileSendDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "deleteFileSendsByFilePostIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFileSendsByFilePostIds(@Valid @RequestBody FileSendDeleteListVo fileSendDeleteListVo){
        fileSendService.deleteFileSendsByFilePostIds(fileSendDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据filePostId获取资料邮寄
     * @param filePostId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "findFileSendByFilePostId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileSendByFilePostId(String filePostId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(fileSendService.findFileSendByFilePostId(filePostId)), HttpStatus.OK);
    }

}
