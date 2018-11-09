package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersController
 * @Description: 担保个人信息rpc
 * @date 2018-03-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface GuaranteePersRpc {

    /**
     * @Title:
     * @Description: 分页查询担保个人信息信息
     * @param guaranteePersVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    @RequestMapping(value = "api/prebiz/guarantee_pers/findGuaranteePerssByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGuaranteePerssByPage(@RequestParam Map<String, Object> guaranteePersVoMap);

    /**
     * @Title:
     * @Description: 保存担保个人信息
     * @param guaranteePersVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    @RequestMapping(value = "api/prebiz/guarantee_pers/saveGuaranteePers",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveGuaranteePers(@RequestBody GuaranteePersVo guaranteePersVo);

    /**
     * @Title:
     * @Description:  修改担保个人信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    @RequestMapping(value = "api/prebiz/guarantee_pers/modifyGuaranteePers",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyGuaranteePers(@RequestBody GuaranteePersVo guaranteePersVo);

    /**
     * @Title:
     * @Description:   根据guarPersId集合删除担保个人信息
     * @param guarPersIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    @RequestMapping(value = "api/system/guarantee_pers/deleteGuaranteePerssByGuarPersIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteGuaranteePerssByGuarPersIds(@RequestBody GuaranteePersVo guaranteePersVo);

    /**
     * @Title:
     * @Description:  根据guarPersId获取担保个人信息
     * @param guarPersId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    @RequestMapping(value = "api/prebiz/guarantee_pers/findGuaranteePersByGuarPersId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGuaranteePersByGuarPersId(@RequestParam("guarPersId") String guarPersId);

}
