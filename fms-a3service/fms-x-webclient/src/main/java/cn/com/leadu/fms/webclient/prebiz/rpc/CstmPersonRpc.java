package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonController
 * @Description: 客户个人基本信息rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmPersonRpc {

    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息信息
     * @param cstmPersonVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "api/prebiz/cstm_person/findCstmPersonsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersonsByPage(@RequestParam Map<String, Object> cstmPersonVoMap);

    /**
     * @Title:
     * @Description: 保存客户个人基本信息
     * @param cstmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "api/prebiz/cstm_person/saveCstmPerson",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmPerson(@RequestBody CstmPersonVo cstmPersonVo);

    /**
     * @Title:
     * @Description:  修改客户个人基本信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "api/prebiz/cstm_person/modifyCstmPerson",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmPerson(@RequestBody CstmPersonVo cstmPersonVo);

    /**
     * @Title:
     * @Description:   根据cstmPersonId集合删除客户个人基本信息
     * @param cstmPersonIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "api/system/cstm_person/deleteCstmPersonsByCstmPersonIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmPersonsByCstmPersonIds(@RequestBody CstmPersonVo cstmPersonVo);

    /**
     * @Title:
     * @Description:  根据cstmPersonId获取客户个人基本信息
     * @param cstmPersonId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "api/prebiz/cstm_person/findCstmPersonByCstmPersonId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersonByCstmPersonId(@RequestParam("cstmPersonId") String cstmPersonId);

}
