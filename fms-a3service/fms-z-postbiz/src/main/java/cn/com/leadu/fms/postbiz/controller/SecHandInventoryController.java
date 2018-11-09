package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import cn.com.leadu.fms.postbiz.service.SecHandInventoryService;
import cn.com.leadu.fms.postbiz.validator.sechandinventory.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryController
 * @Description: 库存管理相关接口
 */
@RestController
@RequestMapping("sec_hand_inventory")
public class SecHandInventoryController {

    /**
     * @Fields  : 库存管理service
     */
    @Autowired
    private SecHandInventoryService secHandInventoryService;

    /**
     * @Title:
     * @Description: 分页查询库存管理信息
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "findSecHandInventoryVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSecHandInventoryVosByPage(SecHandInventoryVo secHandInventoryVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(secHandInventoryService.findSecHandInventoryVosByPage(secHandInventoryVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存库存管理
     * @param secHandInventorySaveVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "saveSecHandInventory",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSecHandInventory(@Valid @RequestBody SecHandInventorySaveVo secHandInventorySaveVo){
        secHandInventoryService.saveSecHandInventory(secHandInventorySaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改库存管理
     * @param secHandInventoryModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "modifySecHandInventory",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySecHandInventory(@Valid @RequestBody SecHandInventoryModifyVo secHandInventoryModifyVo){
        secHandInventoryService.modifySecHandInventory(secHandInventoryModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据secHandId获取库存管理
     * @param secHandId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "findSecHandInventoryVoBySecHandId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSecHandInventoryVoBySecHandId(String secHandId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(secHandInventoryService.findSecHandInventoryVoBySecHandId(secHandId)), HttpStatus.OK);
    }

}
