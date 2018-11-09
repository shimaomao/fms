package cn.com.leadu.fms.prebiz.controller;/**
 * Created by ningyangyang on 2018/11/1.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.DeferContCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Title: fms
 * @Description: 展期合同生成
 * @author: ningyangyang
 * @date 2018/11/1 16:11
 */
@RestController
@RequestMapping("defer_cont_create")
public class DeferContCreateController {

    /**
     * @Fields  : 担保企业信息service
     */
    @Autowired
    private DeferContCreateService deferContCreateService;


    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-11-1 14:35:16
     */
    @RequestMapping(value = "findDeferTaskVoByContNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findDeferTaskVoByContNo(@Valid @RequestBody DeferTaskVo deferTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(deferContCreateService.findDeferTaskVoByContNo(deferTaskVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  展期合同生成
     * @param deferTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-11-1 14:35:15
     */
    @RequestMapping(value = "generateDeferContract",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> generateDeferContract(@Valid @RequestBody DeferTaskVo deferTaskVo, @AuthUserInfo SysUser sysUser){
        deferContCreateService.generateDeferContract(deferTaskVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
