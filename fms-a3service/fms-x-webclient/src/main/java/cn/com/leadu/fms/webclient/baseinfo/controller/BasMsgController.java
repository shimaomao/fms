package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basmsg.BasMsgVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasMsgRpc;
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
 * @author yanfengbo
 * @ClassName: BasMsgController
 * @Description: 短信发送管理表controller
 * @date 2018-03-15
 */
@RestController
@RequestMapping("bas_msg")
public class BasMsgController {

    /**
     * @Fields  : 短信发送管理表rpc
     */
    @Autowired
    private BasMsgRpc basMsgRpc;

    /**
     * @Title:
     * @Description: 分页查询短信发送管理表信息
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "findBasMsgByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgByPage(BasMsgVo basMsgVo){
        Map basMsgVoMap = basMsgVo == null?null:(Map) JSON.toJSON(basMsgVo);
        return basMsgRpc.findBasMsgByPage(basMsgVoMap);
    }

    /**
     * @Title:
     * @Description: 保存短信发送管理表
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "saveBasMsg",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasMsg(@RequestBody BasMsgVo basMsgVo){
        return basMsgRpc.saveBasMsg(basMsgVo);
    }

    /**
     * @Title:
     * @Description:  修改短信发送管理表
     * @param basMsgVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "modifyBasMsg",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasMsg(@RequestBody BasMsgVo basMsgVo){
        return basMsgRpc.modifyBasMsg(basMsgVo);
    }

    /**
     * @Title:
     * @Description:   根据msgId集合删除短信发送管理表
     * @param msgIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "deleteBasMsgsByMsgIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasMsgsByMsgIds(@RequestBody List<String> msgIds){
        BasMsgVo basMsgVo = new BasMsgVo();
        basMsgVo.setMsgIds(msgIds);
        return basMsgRpc.deleteBasMsgsByMsgIds(basMsgVo);
    }

    /**
     * @Title:
     * @Description:  根据msgId获取短信发送管理表
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "findBasMsgByMsgId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgByMsgId(String msgId){
        return basMsgRpc.findBasMsgByMsgId(msgId);
    }

    /**
     * @Title:
     * @Description:  通过msg_id关联sys_tpl_type表查询bas_msg表（详情界面）
     * @param msgId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-15 16:35:27
     */
    @RequestMapping(value = "findBasMsgVoFromSysTplTypeVoByMsgId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasMsgVoFromSysTplTypeVoByMsgId(String msgId){
        return basMsgRpc.findBasMsgVoFromSysTplTypeVoByMsgId(msgId);
    }


}
