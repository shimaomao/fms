package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmaddr.OverdueCstmAddrVo;
import cn.com.leadu.fms.postbiz.service.OverdueCstmAddrService;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.*;
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
 * @ClassName: OverdueCstmAddrController
 * @Description: 逾期客户地址信息相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_cstm_addr")
public class OverdueCstmAddrController {

    /**
     * @Fields  : 逾期客户地址信息service
     */
    @Autowired
    private OverdueCstmAddrService overdueCstmAddrService;

    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "findOverdueCstmAddrsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmAddrsByPage(OverdueCstmAddrVo overdueCstmAddrVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueCstmAddrService.findOverdueCstmAddrsByPage(overdueCstmAddrVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存逾期客户地址信息
     * @param overdueCstmAddrSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "saveOverdueCstmAddr",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmAddr(@Valid @RequestBody OverdueCstmAddrSaveVo overdueCstmAddrSaveVo){
        overdueCstmAddrService.saveOverdueCstmAddr(overdueCstmAddrSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改逾期客户地址信息
     * @param overdueCstmAddrModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "modifyOverdueCstmAddr",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCstmAddr(@Valid @RequestBody OverdueCstmAddrModifyVo overdueCstmAddrModifyVo){
        overdueCstmAddrService.modifyOverdueCstmAddr(overdueCstmAddrModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除逾期客户地址信息
     * @param overdueCstmAddrDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "deleteOverdueCstmAddr",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmAddr(@Valid @RequestBody OverdueCstmAddrDeleteVo overdueCstmAddrDeleteVo){
        overdueCstmAddrService.deleteOverdueCstmAddr(overdueCstmAddrDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueCstmAddrId集合删除逾期客户地址信息
     * @param overdueCstmAddrDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "deleteOverdueCstmAddrsByOverdueCstmAddrIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmAddrsByOverdueCstmAddrIds(@Valid @RequestBody OverdueCstmAddrDeleteListVo overdueCstmAddrDeleteListVo){
        overdueCstmAddrService.deleteOverdueCstmAddrsByOverdueCstmAddrIds(overdueCstmAddrDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmAddrId获取逾期客户地址信息
     * @param overdueCstmAddrId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:56
     */
    @RequestMapping(value = "findOverdueCstmAddrByOverdueCstmAddrId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmAddrByOverdueCstmAddrId(String overdueCstmAddrId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmAddrService.findOverdueCstmAddrByOverdueCstmAddrId(overdueCstmAddrId)), HttpStatus.OK);
    }

}
