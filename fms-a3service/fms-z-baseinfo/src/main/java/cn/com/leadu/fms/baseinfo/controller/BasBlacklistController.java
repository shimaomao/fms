package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist.BasBlacklistVo;
import cn.com.leadu.fms.baseinfo.service.BasBlacklistService;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistController
 * @Description: 黑名单相关接口
 * @date 2018-05-04
 */
@RestController
@RequestMapping("bas_blacklist")
public class BasBlacklistController {

    /**
     * @Fields  : 黑名单service
     */
    @Autowired
    private BasBlacklistService basBlacklistService;

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "findBasBlacklistsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistsByPage(BasBlacklistVo basBlacklistVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basBlacklistService.findBasBlacklistsByPage(basBlacklistVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param basBlacklistSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "saveBasBlacklist",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBlacklist(@Valid @RequestBody BasBlacklistSaveVo basBlacklistSaveVo){
        basBlacklistService.saveBasBlacklist(basBlacklistSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param basBlacklistModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "modifyBasBlacklist",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasBlacklist(@Valid @RequestBody BasBlacklistModifyVo basBlacklistModifyVo){
        basBlacklistService.modifyBasBlacklist(basBlacklistModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除黑名单
     * @param basBlacklistDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "deleteBasBlacklist",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBlacklist(@Valid @RequestBody BasBlacklistDeleteVo basBlacklistDeleteVo){
        basBlacklistService.deleteBasBlacklist(basBlacklistDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据blacklistId集合删除黑名单
     * @param basBlacklistDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "deleteBasBlacklistsByBlacklistIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBlacklistsByBlacklistIds(@Valid @RequestBody BasBlacklistDeleteListVo basBlacklistDeleteListVo){
        basBlacklistService.deleteBasBlacklistsByBlacklistIds(basBlacklistDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据blacklistId获取黑名单
     * @param blacklistId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:28
     */
    @RequestMapping(value = "findBasBlacklistByBlacklistId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistByBlacklistId(String blacklistId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basBlacklistService.findBasBlacklistByBlacklistId(blacklistId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据订单编号，获取该订单中全部的黑名单中的人员
     * @param basBlacklistVo 参数
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "findBasBlacklistVosByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistVosByApplyNo(BasBlacklistVo basBlacklistVo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basBlacklistService.findBasBlacklistVosByApplyNo(basBlacklistVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存订单中全部热人员信息到黑名单中
     * @param basBlacklistVo 参数
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "saveBasBlacklistByApplyNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBlacklistByApplyNo(@RequestBody BasBlacklistVo basBlacklistVo){
        basBlacklistService.saveBasBlacklistByApplyNo(basBlacklistVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
