package cn.com.leadu.fms.webclient.original.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.filesend.FileSendVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: FileSendController
 * @Description: 资料邮寄rpc
 * @date 2018-05-04
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FileSendRpc {

    /**
     * @Title:
     * @Description: 分页查询资料邮寄信息
     * @param fileSendVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @RequestMapping(value = "api/original/file_send/findFileSendsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFileSendsByPage(@RequestParam Map<String, Object> fileSendVoMap);

    /**
     * @Title:
     * @Description: 保存资料邮寄
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @RequestMapping(value = "api/original/file_send/saveFileSend",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFileSend(@RequestBody FileSendVo fileSendVo);

    /**
     * @Title:
     * @Description:  修改资料邮寄
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @RequestMapping(value = "api/original/file_send/modifyFileSend",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFileSend(@RequestBody FileSendVo fileSendVo);

    /**
     * @Title:
     * @Description:   根据filePostId集合删除资料邮寄
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @RequestMapping(value = "api/original/file_send/deleteFileSendsByFilePostIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFileSendsByFilePostIds(@RequestBody FileSendVo fileSendVo);

    /**
     * @Title:
     * @Description:  根据filePostId获取资料邮寄
     * @param filePostId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @RequestMapping(value = "api/original/file_send/findFileSendByFilePostId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFileSendByFilePostId(@RequestParam("filePostId") String filePostId);

}
