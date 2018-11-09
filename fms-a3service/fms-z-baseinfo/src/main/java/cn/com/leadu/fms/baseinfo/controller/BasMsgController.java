package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import cn.com.leadu.fms.baseinfo.service.BasMsgService;
import cn.com.leadu.fms.baseinfo.validator.basmsg.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName: BasMsgController
 * @Description: 短信发送管理表相关接口
 * @date 2018-03-15
 */
@RestController
@RequestMapping("bas_msg")
public class BasMsgController {

    /**
     * @Fields  : 短信发送管理表service
     */
    @Autowired
    private BasMsgService basMsgService;

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表信息
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "findBasMsgByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgByPage(BasMsgVo basMsgVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basMsgService.findBasMsgByPage(basMsgVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存短信发送管理表
     * @param basMsgSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "saveBasMsg",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasMsg(@Valid @RequestBody BasMsgSaveVo basMsgSaveVo){
        basMsgService.saveBasMsg(basMsgSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改短信发送管理表
     * @param basMsgModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "modifyBasMsg",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasMsg(@Valid @RequestBody BasMsgModifyVo basMsgModifyVo){
        basMsgService.modifyBasMsg(basMsgModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除短信发送管理表
     * @param basMsgDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "deleteBasMsg",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasMsg(@Valid @RequestBody BasMsgDeleteVo basMsgDeleteVo){
        basMsgService.deleteBasMsg(basMsgDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据msgId集合删除短信发送管理表
     * @param basMsgDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "deleteBasMsgsByMsgIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasMsgsByMsgIds(@Valid @RequestBody BasMsgDeleteListVo basMsgDeleteListVo){
        basMsgService.deleteBasMsgsByMsgIds(basMsgDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据msgId获取短信发送管理表
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "findBasMsgByMsgId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgByMsgId(String msgId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basMsgService.findBasMsgByMsgId(msgId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:26
     */
    @RequestMapping(value = "findBasMsgVoFromSysTplTypeVoByMsgId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgVoFromSysTplTypeVoByMsgId(String msgId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basMsgService.findBasMsgVoFromSysTplTypeVoByMsgId(msgId)), HttpStatus.OK);
    }

}
