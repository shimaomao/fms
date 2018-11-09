package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobController
 * @Description: 客户个人职业信息rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CstmPersJobRpc {

    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息信息
     * @param cstmPersJobVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_job/findCstmPersJobsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersJobsByPage(@RequestParam Map<String, Object> cstmPersJobVoMap);

    /**
     * @Title:
     * @Description: 保存客户个人职业信息
     * @param cstmPersJobVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_job/saveCstmPersJob",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCstmPersJob(@RequestBody CstmPersJobVo cstmPersJobVo);

    /**
     * @Title:
     * @Description:  修改客户个人职业信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_job/modifyCstmPersJob",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCstmPersJob(@RequestBody CstmPersJobVo cstmPersJobVo);

    /**
     * @Title:
     * @Description:   根据persJobId集合删除客户个人职业信息
     * @param persJobIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "api/system/cstm_pers_job/deleteCstmPersJobsByPersJobIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCstmPersJobsByPersJobIds(@RequestBody CstmPersJobVo cstmPersJobVo);

    /**
     * @Title:
     * @Description:  根据persJobId获取客户个人职业信息
     * @param persJobId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "api/prebiz/cstm_pers_job/findCstmPersJobByPersJobId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersJobByPersJobId(@RequestParam("persJobId") String persJobId);

}
