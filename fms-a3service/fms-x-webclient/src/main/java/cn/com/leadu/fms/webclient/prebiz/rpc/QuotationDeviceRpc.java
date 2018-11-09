package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceController
 * @Description: 报价器信息rpc
 * @date 2018-05-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface QuotationDeviceRpc {

    /**
     * @Title:
     * @Description: 分页查询报价器信息信息
     * @param quotationDeviceVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/findQuotationDevicesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findQuotationDevicesByPage(@RequestParam Map<String, Object> quotationDeviceVoMap);

    /**
     * @Title:
     * @Description: 打印报价器信息信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/printQuotationDevice" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> printQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo);

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/saveQuotationDevice",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo);

    /**
     * @Title:
     * @Description:  修改报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/modifyQuotationDevice",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo);

    /**
     * @Title:
     * @Description:   根据quotationDeviceId集合删除报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/deleteQuotationDevicesByQuotationDeviceIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteQuotationDevicesByQuotationDeviceIds(@RequestBody QuotationDeviceVo quotationDeviceVo);

    /**
     * @Title:
     * @Description:  根据quotationDeviceId获取报价器信息
     * @param quotationDeviceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/findQuotationDeviceByQuotationDeviceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findQuotationDeviceByQuotationDeviceId(@RequestParam("quotationDeviceId") String quotationDeviceId);

    /**
     * @Title:
     * @Description:  获取计算所需参数
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/findSysParam", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysParam();

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/saveQuotationDeviceInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveQuotationDeviceInfo(@RequestBody QuotationDeviceVo quotationDeviceVo);

    /**
     * @Title:
     * @Description: 计算报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-7 17:02:03
     */
    @RequestMapping(value = "api/prebiz/quotation_device/calculateQuotationDeviceInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> calculateQuotationDeviceInfo(@RequestBody QuotationDeviceVo quotationDeviceVo);

}
