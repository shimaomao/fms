package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.postbiz.service.CollectionPersonService;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.*;
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
 * @ClassName: CollectionPersonController
 * @Description: 催收组员相关接口
 */
@RestController
@RequestMapping("collection_person")
public class CollectionPersonController {

    /**
     * @Fields  : 催收组员service
     */
    @Autowired
    private CollectionPersonService collectionPersonService;

    /**
     * @Title:
     * @Description: 分页查询催收组员信息
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "findCollectionPersonVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionPersonVosByPage(CollectionPersonVo collectionPersonVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(collectionPersonService.findCollectionPersonVosByPage(collectionPersonVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存催收组员
     * @param collectionPersonSaveVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "saveCollectionPerson",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCollectionPerson(@Valid @RequestBody CollectionPersonSaveVo collectionPersonSaveVo){
        collectionPersonService.saveCollectionPerson(collectionPersonSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改催收组员
     * @param collectionPersonModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "modifyCollectionPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCollectionPerson(@Valid @RequestBody CollectionPersonModifyVo collectionPersonModifyVo){
        collectionPersonService.modifyCollectionPerson(collectionPersonModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除催收组员
     * @param collectionPersonDeleteVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "deleteCollectionPerson",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCollectionPerson(@Valid @RequestBody CollectionPersonDeleteVo collectionPersonDeleteVo){
        collectionPersonService.deleteCollectionPerson(collectionPersonDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据collectionPersonId集合删除催收组员
     * @param collectionPersonDeleteListVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "deleteCollectionPersonsByCollectionPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCollectionPersonsByCollectionPersonIds(@Valid @RequestBody CollectionPersonDeleteListVo collectionPersonDeleteListVo){
        collectionPersonService.deleteCollectionPersonsByCollectionPersonIds(collectionPersonDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:
     * @param collectionPersonId
     * @return根据collectionPersonId获取催收组员
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:12
     */
    @RequestMapping(value = "findCollectionPersonVoByCollectionPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionPersonVoByCollectionPersonId(String collectionPersonId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(collectionPersonService.findCollectionPersonVoByCollectionPersonId(collectionPersonId)), HttpStatus.OK);
    }

}
