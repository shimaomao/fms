package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueCstmTelRpc;
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
 * @author lijunjun
 * @ClassName: OverdueCstmTelController
 * @Description: 逾期客户电话信息controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_cstm_tel")
public class OverdueCstmTelController {

    /**
     * @Fields  : 逾期客户电话信息rpc
     */
    @Autowired
    private OverdueCstmTelRpc overdueCstmTelRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "findOverdueCstmTelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmTelsByPage(OverdueCstmTelVo overdueCstmTelVo){
        Map overdueCstmTelVoMap = overdueCstmTelVo == null?null:(Map) JSON.toJSON(overdueCstmTelVo);
        return overdueCstmTelRpc.findOverdueCstmTelsByPage(overdueCstmTelVoMap);
    }

    /**
     * @Title:
     * @Description: 保存逾期客户电话信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "saveOverdueCstmTel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmTel(@RequestBody OverdueCstmTelVo overdueCstmTelVo){
        return overdueCstmTelRpc.saveOverdueCstmTel(overdueCstmTelVo);
    }

    /**
     * @Title:
     * @Description:  修改逾期客户电话信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "modifyOverdueCstmTel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCstmTel(@RequestBody OverdueCstmTelVo overdueCstmTelVo){
        return overdueCstmTelRpc.modifyOverdueCstmTel(overdueCstmTelVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueCstmTelId集合删除逾期客户电话信息
     * @param overdueCstmTelIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "deleteOverdueCstmTelsByOverdueCstmTelIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmTelsByOverdueCstmTelIds(@RequestBody List<String> overdueCstmTelIds){
        OverdueCstmTelVo overdueCstmTelVo = new OverdueCstmTelVo();
        overdueCstmTelVo.setOverdueCstmTelIds(overdueCstmTelIds);
        return overdueCstmTelRpc.deleteOverdueCstmTelsByOverdueCstmTelIds(overdueCstmTelVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmTelId获取逾期客户电话信息
     * @param overdueCstmTelId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "findOverdueCstmTelByOverdueCstmTelId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmTelByOverdueCstmTelId(String overdueCstmTelId){
        return overdueCstmTelRpc.findOverdueCstmTelByOverdueCstmTelId(overdueCstmTelId);
    }

}
