package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaydetail.ContPrepayDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailController
 * @Description: 提前还款明细rpc
 * @date 2018-05-11
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPrepayDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询提前还款明细信息
     * @param contPrepayDetailVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "api/cost/cont_prepay_detail/findContPrepayDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepayDetailsByPage(@RequestParam Map<String,Object> contPrepayDetailVoMap);

    /**
     * @Title:
     * @Description: 保存提前还款明细
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "api/cost/cont_prepay_detail/saveContPrepayDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContPrepayDetail(@RequestBody ContPrepayDetailVo contPrepayDetailVo);

    /**
     * @Title:
     * @Description:  修改提前还款明细
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "api/cost/cont_prepay_detail/modifyContPrepayDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContPrepayDetail(@RequestBody ContPrepayDetailVo contPrepayDetailVo);

    /**
     * @Title:
     * @Description:   根据contPrepayDetailId集合删除提前还款明细
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "api/system/cont_prepay_detail/deleteContPrepayDetailsByContPrepayDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContPrepayDetailsByContPrepayDetailIds(@RequestBody ContPrepayDetailVo contPrepayDetailVo);

    /**
     * @Title:
     * @Description:  根据contPrepayDetailId获取提前还款明细
     * @param contPrepayDetailId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "api/cost/cont_prepay_detail/findContPrepayDetailByContPrepayDetailId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPrepayDetailByContPrepayDetailId(@RequestParam("contPrepayDetailId") String contPrepayDetailId);

}
