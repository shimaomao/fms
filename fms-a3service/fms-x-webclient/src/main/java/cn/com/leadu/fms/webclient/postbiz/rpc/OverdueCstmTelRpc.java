package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelController
 * @Description: 逾期客户电话信息rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueCstmTelRpc {

    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息信息
     * @param overdueCstmTelVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "api/postBiz/overdue_cstm_tel/findOverdueCstmTelsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmTelsByPage(@RequestParam Map<String, Object> overdueCstmTelVoMap);

    /**
     * @Title:
     * @Description: 保存逾期客户电话信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "api/postBiz/overdue_cstm_tel/saveOverdueCstmTel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueCstmTel(@RequestBody OverdueCstmTelVo overdueCstmTelVo);

    /**
     * @Title:
     * @Description:  修改逾期客户电话信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "api/postBiz/overdue_cstm_tel/modifyOverdueCstmTel",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueCstmTel(@RequestBody OverdueCstmTelVo overdueCstmTelVo);

    /**
     * @Title:
     * @Description:   根据overdueCstmTelId集合删除逾期客户电话信息
     * @param overdueCstmTelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "api/system/overdue_cstm_tel/deleteOverdueCstmTelsByOverdueCstmTelIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueCstmTelsByOverdueCstmTelIds(@RequestBody OverdueCstmTelVo overdueCstmTelVo);

    /**
     * @Title:
     * @Description:  根据overdueCstmTelId获取逾期客户电话信息
     * @param overdueCstmTelId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    @RequestMapping(value = "api/postBiz/overdue_cstm_tel/findOverdueCstmTelByOverdueCstmTelId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmTelByOverdueCstmTelId(@RequestParam("overdueCstmTelId") String overdueCstmTelId);

}
