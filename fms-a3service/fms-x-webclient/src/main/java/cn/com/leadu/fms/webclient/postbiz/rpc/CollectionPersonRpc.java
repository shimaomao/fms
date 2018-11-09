package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonController
 * @Description: 催收组员rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CollectionPersonRpc {

    /**
     * @Title:
     * @Description: 分页查询催收组员信息
     * @param collectionPersonVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "api/postbiz/collection_person/findCollectionPersonVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCollectionPersonVosByPage(@RequestParam Map<String, Object> collectionPersonVoMap);

    /**
     * @Title:
     * @Description: 保存催收组员
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "api/postbiz/collection_person/saveCollectionPerson",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCollectionPerson(@RequestBody CollectionPersonVo collectionPersonVo);

    /**
     * @Title:
     * @Description:  修改催收组员
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "api/postbiz/collection_person/modifyCollectionPerson",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCollectionPerson(@RequestBody CollectionPersonVo collectionPersonVo);

    /**
     * @Title:
     * @Description:   根据collectionPersonId集合删除催收组员
     * @param collectionPersonVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "api/postbiz/collection_person/deleteCollectionPersonsByCollectionPersonIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCollectionPersonsByCollectionPersonIds(@RequestBody CollectionPersonVo collectionPersonVo);

    /**
     * @Title:
     * @Description:  根据collectionPersonId获取催收组员
     * @param collectionPersonId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @RequestMapping(value = "api/postbiz/collection_person/findCollectionPersonVoByCollectionPersonId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCollectionPersonVoByCollectionPersonId(@RequestParam("collectionPersonId") String collectionPersonId);

}
