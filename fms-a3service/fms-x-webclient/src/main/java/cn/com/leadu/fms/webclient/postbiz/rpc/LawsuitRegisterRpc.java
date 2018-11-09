package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterController
 * @Description: 诉讼登记信息rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface LawsuitRegisterRpc {

    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息信息
     * @param lawsuitRegisterVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "api/postbiz/lawsuit_register/findLawsuitRegistersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitRegistersByPage(@RequestParam Map<String, Object> lawsuitRegisterVoMap);

    /**
     * @Title:
     * @Description: 保存诉讼登记信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "api/postbiz/lawsuit_register/saveLawsuitRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveLawsuitRegister(@RequestBody LawsuitRegisterVo lawsuitRegisterVo);

    /**
     * @Title:
     * @Description:  修改诉讼登记信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "api/postbiz/lawsuit_register/modifyLawsuitRegister",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyLawsuitRegister(@RequestBody LawsuitRegisterVo lawsuitRegisterVo);

    /**
     * @Title:
     * @Description:   根据lawsuitRegisterId集合删除诉讼登记信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "api/postbiz/lawsuit_register/deleteLawsuitRegistersByLawsuitRegisterIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteLawsuitRegistersByLawsuitRegisterIds(@RequestBody LawsuitRegisterVo lawsuitRegisterVo);

    /**
     * @Title:
     * @Description:  根据lawsuitRegisterId获取诉讼登记信息
     * @param lawsuitRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "api/postbiz/lawsuit_register/findLawsuitRegisterByLawsuitRegisterId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findLawsuitRegisterByLawsuitRegisterId(@RequestParam("lawsuitRegisterId") String lawsuitRegisterId);

}
