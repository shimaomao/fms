package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huchenghao
 * @ClassName: ContCreateController
 * @Description: 合同生成
 * @date 2018-03-30 14点22分
 */
@RestController
@RequestMapping("cont_create")
public class ContCreateController {

    /**
     * @Fields  : 合同生成前确认service
     */
    @Autowired
    private ContCreateService contCreateService;

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "findContCreateByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContCreateByContNo(String contNo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contCreateService.findContCreateByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "findContCreateDetailByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContCreateDetailByContNo(String contNo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contCreateService.findContCreateDetailByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 合同生成保存
     * @param contCreateVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "saveContCreate",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContCreate(@Valid @RequestBody ContCreateVo contCreateVo, @AuthUserInfo SysUser sysUser){
        contCreateVo.setUser(sysUser.getUser());
        contCreateService.saveContCreate(contCreateVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 取消合同
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 18:27
    */
    @RequestMapping(value = "cancelContCreate",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelContCreate(@RequestBody ContCreateVo contCreateVo, @AuthUserInfo SysUser sysUser){
        contCreateVo.setUser(sysUser.getUser());
        contCreateService.cancelContCreate(contCreateVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
