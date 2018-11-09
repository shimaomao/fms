package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: BasMsgController
 * @Description: 短信发送管理表rpc
 * @date 2018-03-15
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasMsgRpc {

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表信息
     * @param basMsgVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/findBasMsgByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasMsgByPage(@RequestParam Map<String, Object> basMsgVoMap);

    /**
     * @Title:
     * @Description: 保存短信发送管理表
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/saveBasMsg",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasMsg(@RequestBody BasMsgVo basMsgVo);

    /**
     * @Title:
     * @Description:  修改短信发送管理表
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/modifyBasMsg",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasMsg(@RequestBody BasMsgVo basMsgVo);

    /**
     * @Title:
     * @Description:   根据msgId集合删除短信发送管理表
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/deleteBasMsgsByMsgIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasMsgsByMsgIds(@RequestBody BasMsgVo basMsgVo);

    /**
     * @Title:
     * @Description:  根据msgId获取短信发送管理表
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/findBasMsgByMsgId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasMsgByMsgId(@RequestParam("msgId") String msgId);


    /**
     * @Title:
     * @Description:  通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "api/baseinfo/bas_msg/findBasMsgVoFromSysTplTypeVoByMsgId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasMsgVoFromSysTplTypeVoByMsgId(@RequestParam("msgId") String msgId);

}
