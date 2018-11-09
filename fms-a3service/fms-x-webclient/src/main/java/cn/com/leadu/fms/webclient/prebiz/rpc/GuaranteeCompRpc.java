package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompController
 * @Description: 担保企业信息rpc
 * @date 2018-03-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface GuaranteeCompRpc {

    /**
     * @Title:
     * @Description: 分页查询担保企业信息信息
     * @param guaranteeCompVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "api/prebiz/guarantee_comp/findGuaranteeCompsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGuaranteeCompsByPage(@RequestParam Map<String, Object> guaranteeCompVoMap);

    /**
     * @Title:
     * @Description: 保存担保企业信息
     * @param guaranteeCompVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "api/prebiz/guarantee_comp/saveGuaranteeComp",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveGuaranteeComp(@RequestBody GuaranteeCompVo guaranteeCompVo);

    /**
     * @Title:
     * @Description:  修改担保企业信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "api/prebiz/guarantee_comp/modifyGuaranteeComp",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyGuaranteeComp(@RequestBody GuaranteeCompVo guaranteeCompVo);

    /**
     * @Title:
     * @Description:   根据guarCompId集合删除担保企业信息
     * @param guarCompIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "api/system/guarantee_comp/deleteGuaranteeCompsByGuarCompIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteGuaranteeCompsByGuarCompIds(@RequestBody GuaranteeCompVo guaranteeCompVo);

    /**
     * @Title:
     * @Description:  根据guarCompId获取担保企业信息
     * @param guarCompId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "api/prebiz/guarantee_comp/findGuaranteeCompByGuarCompId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findGuaranteeCompByGuarCompId(@RequestParam("guarCompId") String guarCompId);

}
