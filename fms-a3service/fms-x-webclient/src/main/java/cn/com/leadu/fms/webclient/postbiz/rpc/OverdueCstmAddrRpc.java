package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmaddr.OverdueCstmAddrVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrController
 * @Description: 逾期客户地址信息rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueCstmAddrRpc {

    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息信息
     * @param overdueCstmAddrVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm_addr/findOverdueCstmAddrsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmAddrsByPage(@RequestParam Map<String, Object> overdueCstmAddrVoMap);

    /**
     * @Title:
     * @Description: 保存逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm_addr/saveOverdueCstmAddr",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueCstmAddr(@RequestBody OverdueCstmAddrVo overdueCstmAddrVo);

    /**
     * @Title:
     * @Description:  修改逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm_addr/modifyOverdueCstmAddr",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueCstmAddr(@RequestBody OverdueCstmAddrVo overdueCstmAddrVo);

    /**
     * @Title:
     * @Description:   根据overdueCstmAddrId集合删除逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "api/system/overdue_cstm_addr/deleteOverdueCstmAddrsByOverdueCstmAddrIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueCstmAddrsByOverdueCstmAddrIds(@RequestBody OverdueCstmAddrVo overdueCstmAddrVo);

    /**
     * @Title:
     * @Description:  根据overdueCstmAddrId获取逾期客户地址信息
     * @param overdueCstmAddrId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm_addr/findOverdueCstmAddrByOverdueCstmAddrId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmAddrByOverdueCstmAddrId(@RequestParam("overdueCstmAddrId") String overdueCstmAddrId);

}
