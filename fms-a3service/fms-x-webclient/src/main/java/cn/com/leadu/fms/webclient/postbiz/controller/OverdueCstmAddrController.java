package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmaddr.OverdueCstmAddrVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueCstmAddrRpc;
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
 * @ClassName: OverdueCstmAddrController
 * @Description: 逾期客户地址信息controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_cstm_addr")
public class OverdueCstmAddrController {

    /**
     * @Fields  : 逾期客户地址信息rpc
     */
    @Autowired
    private OverdueCstmAddrRpc overdueCstmAddrRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "findOverdueCstmAddrsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmAddrsByPage(OverdueCstmAddrVo overdueCstmAddrVo){
        Map overdueCstmAddrVoMap = overdueCstmAddrVo == null?null:(Map) JSON.toJSON(overdueCstmAddrVo);
        return overdueCstmAddrRpc.findOverdueCstmAddrsByPage(overdueCstmAddrVoMap);
    }

    /**
     * @Title:
     * @Description: 保存逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "saveOverdueCstmAddr",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmAddr(@RequestBody OverdueCstmAddrVo overdueCstmAddrVo){
        return overdueCstmAddrRpc.saveOverdueCstmAddr(overdueCstmAddrVo);
    }

    /**
     * @Title:
     * @Description:  修改逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "modifyOverdueCstmAddr",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCstmAddr(@RequestBody OverdueCstmAddrVo overdueCstmAddrVo){
        return overdueCstmAddrRpc.modifyOverdueCstmAddr(overdueCstmAddrVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueCstmAddrId集合删除逾期客户地址信息
     * @param overdueCstmAddrIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "deleteOverdueCstmAddrsByOverdueCstmAddrIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCstmAddrsByOverdueCstmAddrIds(@RequestBody List<String> overdueCstmAddrIds){
        OverdueCstmAddrVo overdueCstmAddrVo = new OverdueCstmAddrVo();
        overdueCstmAddrVo.setOverdueCstmAddrIds(overdueCstmAddrIds);
        return overdueCstmAddrRpc.deleteOverdueCstmAddrsByOverdueCstmAddrIds(overdueCstmAddrVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmAddrId获取逾期客户地址信息
     * @param overdueCstmAddrId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "findOverdueCstmAddrByOverdueCstmAddrId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmAddrByOverdueCstmAddrId(String overdueCstmAddrId){
        return overdueCstmAddrRpc.findOverdueCstmAddrByOverdueCstmAddrId(overdueCstmAddrId);
    }

}
