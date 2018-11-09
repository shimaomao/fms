package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp.CarCollectCompVo;
import cn.com.leadu.fms.postbiz.service.CarCollectCompService;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.*;
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
 * @ClassName: CarCollectCompController
 * @Description: 收车机构维护相关接口
 * @date 2018-05-22
 */
@RestController
@RequestMapping("car_collect_comp")
public class CarCollectCompController {

    /**
     * @Fields  : 收车机构维护service
     */
    @Autowired
    private CarCollectCompService carCollectCompService;

    /**
     * @Title:
     * @Description: 分页查询收车机构维护信息
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "findCarCollectCompsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCarCollectCompsByPage(CarCollectCompVo carCollectCompVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(carCollectCompService.findCarCollectCompsByPage(carCollectCompVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存收车机构维护
     * @param carCollectCompSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "saveCarCollectComp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCarCollectComp(@Valid @RequestBody CarCollectCompSaveVo carCollectCompSaveVo){
        carCollectCompService.saveCarCollectComp(carCollectCompSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改收车机构维护
     * @param carCollectCompModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "modifyCarCollectComp",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCarCollectComp(@Valid @RequestBody CarCollectCompModifyVo carCollectCompModifyVo){
        carCollectCompService.modifyCarCollectComp(carCollectCompModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除收车机构维护
     * @param carCollectCompDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "deleteCarCollectComp",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCarCollectComp(@Valid @RequestBody CarCollectCompDeleteVo carCollectCompDeleteVo){
        carCollectCompService.deleteCarCollectComp(carCollectCompDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据carCollectCompId集合删除收车机构维护
     * @param carCollectCompDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "deleteCarCollectCompsByCarCollectCompIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCarCollectCompsByCarCollectCompIds(@Valid @RequestBody CarCollectCompDeleteListVo carCollectCompDeleteListVo){
        carCollectCompService.deleteCarCollectCompsByCarCollectCompIds(carCollectCompDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据carCollectCompId获取收车机构维护
     * @param carCollectCompId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:11
     */
    @RequestMapping(value = "findCarCollectCompByCarCollectCompId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCarCollectCompByCarCollectCompId(String carCollectCompId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(carCollectCompService.findCarCollectCompByCarCollectCompId(carCollectCompId)), HttpStatus.OK);
    }

}
