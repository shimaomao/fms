package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrController
 * @Description: 客户个人地址信息rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmPersAddrRpc {

    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息信息
     * @param cstmPersAddrVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_addr/findCstmPersAddrsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersAddrsByPage(@RequestParam Map<String, Object> cstmPersAddrVoMap);

    /**
     * @Title:
     * @Description: 保存客户个人地址信息
     * @param cstmPersAddrVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_addr/saveCstmPersAddr",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmPersAddr(@RequestBody CstmPersAddrVo cstmPersAddrVo);

    /**
     * @Title:
     * @Description:  修改客户个人地址信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_addr/modifyCstmPersAddr",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmPersAddr(@RequestBody CstmPersAddrVo cstmPersAddrVo);

    /**
     * @Title:
     * @Description:   根据persAddrId集合删除客户个人地址信息
     * @param persAddrIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "api/system/cstm_pers_addr/deleteCstmPersAddrsByPersAddrIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmPersAddrsByPersAddrIds(@RequestBody CstmPersAddrVo cstmPersAddrVo);

    /**
     * @Title:
     * @Description:  根据persAddrId获取客户个人地址信息
     * @param persAddrId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_addr/findCstmPersAddrByPersAddrId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersAddrByPersAddrId(@RequestParam("persAddrId") String persAddrId);

}
