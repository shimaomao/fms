package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.postbiz.service.OverdueCstmTelService;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.*;
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
 * @ClassName: OverdueCstmTelController
 * @Description: 逾期客户电话信息相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_cstm_tel")
public class OverdueCstmTelController {

    /**
     * @Fields  : 逾期客户电话信息service
     */
    @Autowired
    private OverdueCstmTelService overdueCstmTelService;

    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "findOverdueCstmTelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmTelsByPage(OverdueCstmTelVo overdueCstmTelVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueCstmTelService.findOverdueCstmTelsByPage(overdueCstmTelVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存逾期客户电话信息
     * @param overdueCstmTelSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "saveOverdueCstmTel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmTel(@Valid @RequestBody OverdueCstmTelSaveVo overdueCstmTelSaveVo){
        overdueCstmTelService.saveOverdueCstmTel(overdueCstmTelSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改逾期客户电话信息
     * @param overdueCstmTelModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "modifyOverdueCstmTel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCstmTel(@Valid @RequestBody OverdueCstmTelModifyVo overdueCstmTelModifyVo){
        overdueCstmTelService.modifyOverdueCstmTel(overdueCstmTelModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除逾期客户电话信息
     * @param overdueCstmTelDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "deleteOverdueCstmTel",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmTel(@Valid @RequestBody OverdueCstmTelDeleteVo overdueCstmTelDeleteVo){
        overdueCstmTelService.deleteOverdueCstmTel(overdueCstmTelDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueCstmTelId集合删除逾期客户电话信息
     * @param overdueCstmTelDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "deleteOverdueCstmTelsByOverdueCstmTelIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmTelsByOverdueCstmTelIds(@Valid @RequestBody OverdueCstmTelDeleteListVo overdueCstmTelDeleteListVo){
        overdueCstmTelService.deleteOverdueCstmTelsByOverdueCstmTelIds(overdueCstmTelDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmTelId获取逾期客户电话信息
     * @param overdueCstmTelId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:52
     */
    @RequestMapping(value = "findOverdueCstmTelByOverdueCstmTelId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmTelByOverdueCstmTelId(String overdueCstmTelId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmTelService.findOverdueCstmTelByOverdueCstmTelId(overdueCstmTelId)), HttpStatus.OK);
    }

}
