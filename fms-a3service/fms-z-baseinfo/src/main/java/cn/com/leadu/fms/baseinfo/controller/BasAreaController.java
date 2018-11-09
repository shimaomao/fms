package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import cn.com.leadu.fms.baseinfo.service.BasAreaService;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.*;
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
 * @ClassName: BasAreaController
 * @Description: 省市县信息维护相关接口
 * @date 2018-03-15
 */
@RestController
@RequestMapping("bas_area")
public class BasAreaController {

    /**
     * @Fields  : 省市县信息维护service
     */
    @Autowired
    private BasAreaService basAreaService;

    /**
     * @Title:
     * @Description: 分页查询省市县信息维护信息
     * @param basAreaVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "findBasAreasByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreasByPage(BasAreaVo basAreaVo){

        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreasByPage(basAreaVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存省市县信息维护
     * @param basAreaSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "saveBasArea",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasArea(@Valid @RequestBody BasAreaSaveVo basAreaSaveVo){
        basAreaService.saveBasArea(basAreaSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改省市县信息维护
     * @param basAreaModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "modifyBasArea",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasArea(@Valid @RequestBody BasAreaModifyVo basAreaModifyVo){
        basAreaService.modifyBasArea(basAreaModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除省市县信息维护
     * @param basAreaDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "deleteBasArea",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasArea(@Valid @RequestBody BasAreaDeleteVo basAreaDeleteVo){
        basAreaService.deleteBasArea(basAreaDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据areaId集合删除省市县信息维护
     * @param basAreaDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "deleteBasAreasByAreaIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasAreasByAreaIds(@Valid @RequestBody BasAreaDeleteListVo basAreaDeleteListVo){
        basAreaService.deleteBasAreasByAreaIds(basAreaDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据areaId获取省市县信息维护
     * @param areaId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "findBasAreaByAreaId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByAreaId(String areaId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreaByAreaId(areaId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 返回省市树状 提供给前台页面使用
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:44
     */
    @RequestMapping(value = "findBasAreas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreas(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreas()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询省市版本值
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "findBasAreaValuesVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaValuesVersion(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreaValuesVersion()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 初始化省市到redis中
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "initBasAreas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initBasAreas(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.initBasAreas()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取所有省市县
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:26
     */
    @RequestMapping(value = "findBasAreaByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByTree(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreaByTree()), HttpStatus.OK);
    }
    /**
     *
     */
    @RequestMapping(value = "findBasAreaByAreaCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByAreaCode(String areaCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basAreaService.findBasAreaByAreaCode(areaCode)), HttpStatus.OK);
    }
}
