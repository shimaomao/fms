package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerModifyVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerSaveVo;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.baseinfo.service.BasPartnerService;
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
 * @ClassName: BasPartnerController
 * @Description: 经销商信息维护相关接口
 * @date 2018-03-17
 */
@RestController
@RequestMapping("bas_partner")
public class BasPartnerController {

    /**
     * @Fields  : 经销商信息维护service
     */
    @Autowired
    private BasPartnerService basPartnerService;

    /**
     * @Title:
     * @Description: 分页查询经销商信息维护信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "findBasPartnersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnersByPage(BasPartnerVo basPartnerVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basPartnerService.findBasPartnersByPage(basPartnerVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存经销商信息维护
     * @param basPartnerSaveVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "saveBasPartner",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasPartner(@Valid @RequestBody BasPartnerSaveVo basPartnerSaveVo){
        //flag=1 覆盖用户组信息 flag=2新增用户组信息
        String flag=basPartnerService.saveBasPartner(basPartnerSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(flag), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改经销商信息维护
     * @param basPartnerModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "modifyBasPartner",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasPartner(@Valid @RequestBody BasPartnerModifyVo basPartnerModifyVo){
        //flag=1 覆盖用户组信息 flag=2新增用户组信息
        String flag=basPartnerService.modifyBasPartner(basPartnerModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(flag), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除经销商信息维护
     * @param basPartnerDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "deleteBasPartner",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasPartner(@Valid @RequestBody BasPartnerDeleteVo basPartnerDeleteVo){
        basPartnerService.deleteBasPartner(basPartnerDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据partnerId集合删除经销商信息维护
     * @param basPartnerDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "deleteBasPartnersByPartnerIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasPartnersByPartnerIds(@Valid @RequestBody BasPartnerDeleteListVo basPartnerDeleteListVo){
        basPartnerService.deleteBasPartnersByPartnerIds(basPartnerDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据partnerId获取经销商信息维护
     * @param partnerId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:32
     */
    @RequestMapping(value = "findBasPartnerByPartnerId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnerByPartnerId(String partnerId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basPartnerService.findBasPartnerByPartnerId(partnerId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取d当前登录用户的经销商信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-22 19:35:32
     */
    @RequestMapping(value = "findBasPartnerByLoginUser", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnerByLoginUser(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basPartnerService.findBasPartnerByPartnerCode(sysUser.getGroupCode())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据经销商代码，获取经销商信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "findBasPartnerByPartnerCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnerByPartnerCode(String partnerCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basPartnerService.findBasPartnerByPartnerCode(partnerCode)), HttpStatus.OK);
    }

}
