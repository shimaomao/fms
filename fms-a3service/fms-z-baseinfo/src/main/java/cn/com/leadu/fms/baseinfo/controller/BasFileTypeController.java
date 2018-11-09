package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.baseinfo.service.BasFileTypeService;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeSaveVo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
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
 * @ClassName: BasFileTypeController
 * @Description: 附件类型管理表相关接口
 * @date 2018-03-19
 */
@RestController
@RequestMapping("bas_file_type")
public class BasFileTypeController {

    /**
     * @Fields  : 附件类型管理表service
     */
    @Autowired
    private BasFileTypeService basFileTypeService;

    /**
     * @Title:
     * @Description: 分页查询附件类型管理表信息
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByPage(BasFileTypeVo basFileTypeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basFileTypeService.findBasFileTypeByPage(basFileTypeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存附件类型管理表
     * @param basFileTypeSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "saveBasFileType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasFileType(@Valid @RequestBody BasFileTypeSaveVo basFileTypeSaveVo){
        basFileTypeService.saveBasFileType(basFileTypeSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改附件类型管理表
     * @param basFileTypeModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "modifyBasFileType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasFileType(@Valid @RequestBody BasFileTypeModifyVo basFileTypeModifyVo){
        basFileTypeService.modifyBasFileType(basFileTypeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除附件类型管理表
     * @param basFileTypeDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "deleteBasFileType",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasFileType(@Valid @RequestBody BasFileTypeDeleteVo basFileTypeDeleteVo){
        basFileTypeService.deleteBasFileType(basFileTypeDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据fileTypeId集合删除附件类型管理表
     * @param basFileTypeDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "deleteBasFileTypesByFileTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasFileTypesByFileTypeIds(@Valid @RequestBody BasFileTypeDeleteListVo basFileTypeDeleteListVo){
        basFileTypeService.deleteBasFileTypesByFileTypeIds(basFileTypeDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param fileTypeId
     * @return
     * @throws
     * @Title:
     * @Description: 根据fileTypeId获取附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeByFileTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByFileTypeId(String fileTypeId) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.findBasFileTypeByFileTypeId(fileTypeId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询附件类型管理树
     * @param
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByTree() {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.findBasFileTypeByTree()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据fileTypeId获取BasFileTypeVo
     * @param fileTypeId
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeVoByFileTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeVoByFileTypeId(String fileTypeId) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.findBasFileTypeVoByFileTypeId(fileTypeId)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findFileTypeTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileTypeTree(String fileType, String product, String subType) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.findFileTypeTree(fileType, product, subType)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author huchenghao
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "getChildFileTypes", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getChildFileTypes(String fileType) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.getChildFileTypes(fileType)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据product获取附件类型Vo
     * @param product 产品方案代码
     * @return ResponseEntity<RestResponse>
     * @throws
     * @author wangxue
     * @date 2018-4-26 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeVosByProduct", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeVosByProduct(String product) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basFileTypeService.findBasFileTypeVosByProduct(product)), HttpStatus.OK);
    }

}
