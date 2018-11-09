package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateController
 * @Description: 客户个人配偶信息rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmPersMateRpc {

    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息信息
     * @param cstmPersMateVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_mate/findCstmPersMatesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersMatesByPage(@RequestParam Map<String, Object> cstmPersMateVoMap);

    /**
     * @Title:
     * @Description: 保存客户个人配偶信息
     * @param cstmPersMateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_mate/saveCstmPersMate",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmPersMate(@RequestBody CstmPersMateVo cstmPersMateVo);

    /**
     * @Title:
     * @Description:  修改客户个人配偶信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_mate/modifyCstmPersMate",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmPersMate(@RequestBody CstmPersMateVo cstmPersMateVo);

    /**
     * @Title:
     * @Description:   根据persMateId集合删除客户个人配偶信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/system/cstm_pers_mate/deleteCstmPersMatesByPersMateIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmPersMatesByPersMateIds(@RequestBody CstmPersMateVo cstmPersMateVo);

    /**
     * @Title:
     * @Description:  根据persMateId获取客户个人配偶信息
     * @param persMateId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_mate/findCstmPersMateByPersMateId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersMateByPersMateId(@RequestParam("persMateId") String persMateId);

    /**
     * @Title:
     * @Description:  续保任务登记TEST
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "api/insurance/insurance_renewal/insuranceRenewalTask", method = RequestMethod.GET)
    ResponseEntity<RestResponse> insuranceRenewalTask();

}
