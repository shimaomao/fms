package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.CollectionPersonRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonController
 * @Description: 催收组员controller
 */
@RestController
@RequestMapping("collection_person")
public class CollectionPersonController {

    /**
     * @Fields  : 催收组员rpc
     */
    @Autowired
    private CollectionPersonRpc collectionPersonRpc;

    /**
     * @Title:
     * @Description: 分页查询催收组员信息
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "findCollectionPersonVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionPersonVosByPage(CollectionPersonVo collectionPersonVo){
        Map collectionPersonVoMap = collectionPersonVo == null?null:(Map) JSON.toJSON(collectionPersonVo);
        return collectionPersonRpc.findCollectionPersonVosByPage(collectionPersonVoMap);
    }

    /**
     * @Title:
     * @Description: 保存催收组员
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "saveCollectionPerson",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCollectionPerson(@RequestBody CollectionPersonVo collectionPersonVo){
        return collectionPersonRpc.saveCollectionPerson(collectionPersonVo);
    }

    /**
     * @Title:
     * @Description:  修改催收组员
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "modifyCollectionPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCollectionPerson(@RequestBody CollectionPersonVo collectionPersonVo){
        return collectionPersonRpc.modifyCollectionPerson(collectionPersonVo);
    }

    /**
     * @Title:
     * @Description:   根据collectionPersonId集合删除催收组员
     * @param collectionPersonIds
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "deleteCollectionPersonsByCollectionPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCollectionPersonsByCollectionPersonIds(@RequestBody List<String> collectionPersonIds){
        CollectionPersonVo collectionPersonVo = new CollectionPersonVo();
        collectionPersonVo.setCollectionPersonIds(collectionPersonIds);
        return collectionPersonRpc.deleteCollectionPersonsByCollectionPersonIds(collectionPersonVo);
    }

    /**
     * @Title:
     * @Description:  根据collectionPersonId获取催收组员
     * @param collectionPersonId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "findCollectionPersonVoByCollectionPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCollectionPersonVoByCollectionPersonId(String collectionPersonId){
        return collectionPersonRpc.findCollectionPersonVoByCollectionPersonId(collectionPersonId);
    }

}
