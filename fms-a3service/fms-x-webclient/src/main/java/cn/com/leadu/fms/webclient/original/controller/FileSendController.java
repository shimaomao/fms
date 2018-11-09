package cn.com.leadu.fms.webclient.original.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.filesend.FileSendVo;
import cn.com.leadu.fms.webclient.original.rpc.FileSendRpc;
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
 * @author ningyangyang
 * @ClassName: FileSendController
 * @Description: 资料邮寄controller
 * @date 2018-05-04
 */
@RestController
@RequestMapping("file_send")
public class FileSendController {

    /**
     * @Fields  : 资料邮寄rpc
     */
    @Autowired
    private FileSendRpc fileSendRpc;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄信息
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "findFileSendsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileSendsByPage(FileSendVo fileSendVo){
        Map fileSendVoMap = fileSendVo == null?null:(Map) JSON.toJSON(fileSendVo);
        return fileSendRpc.findFileSendsByPage(fileSendVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "saveFileSend",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFileSend(@RequestBody FileSendVo fileSendVo){
        return fileSendRpc.saveFileSend(fileSendVo);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄
     * @param fileSendVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "modifyFileSend",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFileSend(@RequestBody FileSendVo fileSendVo){
        return fileSendRpc.modifyFileSend(fileSendVo);
    }

    /**
     * @Title:
     * @Description:   根据filePostId集合删除资料邮寄
     * @param filePostIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "deleteFileSendsByFilePostIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFileSendsByFilePostIds(@RequestBody List<String> filePostIds){
        FileSendVo fileSendVo = new FileSendVo();
        fileSendVo.setFilePostIds(filePostIds);
        return fileSendRpc.deleteFileSendsByFilePostIds(fileSendVo);
    }

    /**
     * @Title:
     * @Description:  根据filePostId获取资料邮寄
     * @param filePostId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:02
     */
    @RequestMapping(value = "findFileSendByFilePostId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileSendByFilePostId(String filePostId){
        return fileSendRpc.findFileSendByFilePostId(filePostId);
    }

}
