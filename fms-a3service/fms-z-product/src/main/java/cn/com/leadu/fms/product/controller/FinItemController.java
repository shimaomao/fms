package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.product.service.FinItemService;
import cn.com.leadu.fms.product.validator.finitem.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author niehaibing
 * @ClassName: FinItemController
 * @Description: 融资项目管理相关接口
 * @date 2018-03-19
 */
@RestController
@RequestMapping("fin_item")
public class FinItemController {

    /**
     * @Fields  : 融资项目管理service
     */
    @Autowired
    private FinItemService finItemService;

    /**
     * @Title:
     * @Description: 分页查询融资项目管理信息
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findFinItemsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinItemsByPage(FinItemVo finItemVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(finItemService.findFinItemsByPage(finItemVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存融资项目管理
     * @param finItemSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "saveFinItem",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinItem(@Valid @RequestBody FinItemSaveVo finItemSaveVo){
        finItemService.saveFinItem(finItemSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改融资项目管理
     * @param finItemModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "modifyFinItem",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinItem(@Valid @RequestBody FinItemModifyVo finItemModifyVo){
        finItemService.modifyFinItem(finItemModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除融资项目管理
     * @param finItemDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "deleteFinItem",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinItem(@Valid @RequestBody FinItemDeleteVo finItemDeleteVo){
        finItemService.deleteFinItem(finItemDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据finItemId集合删除融资项目管理
     * @param finItemDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "deleteFinItemsByFinItemIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinItemsByFinItemIds(@Valid @RequestBody FinItemDeleteListVo finItemDeleteListVo){
        finItemService.deleteFinItemsByFinItemIds(finItemDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @param finItemId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findFinItemByFinItemId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinItemByFinItemId(String finItemId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(finItemService.findFinItemByFinItemId(finItemId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  取得所有的融资项目
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findAllFinItemList", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAllFinItemList(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(finItemService.findAllFinItemList()), HttpStatus.OK);
    }

}
