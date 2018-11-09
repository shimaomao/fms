package cn.com.leadu.fms.webclient.activiti.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actremodel.ActReModelVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActModelRpc
 * @Description:
 * @date 2018/3/12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ActReModelRpc {

    /**
     * @Title:
     * @Description:  分页查询模型
     * @param modelVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:37:29
     */
    @RequestMapping(value = "api/activiti/act_re_model/findActReModelsByPage" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActReModelsByPage(@RequestParam Map<String,Object> modelVoMap);

    /**
     * @Title:
     * @Description:   添加模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:40:00
     */
    @RequestMapping(value = "api/activiti/act_re_model/saveActReModel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveActReModel(@RequestBody ActReModelVo actReModelVo);

    /**
     * @Title:
     * @Description:   部署模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:43:03
     */
    @RequestMapping(value = "api/activiti/act_re_model/deployActReModel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> deployActReModel(@RequestParam("modelId") String modelId);

    /**
     * @Title:
     * @Description:   根据modelId删除模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 11:25:58
     */
    @RequestMapping(value = "api/activiti/act_re_model/deleteActReModelByModelId",method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteActReModelByModelId(@RequestParam("modelId") String modelId);

    /**
     * @Title:
     * @Description:  根据modelId获取模型xml
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/15 11:55:24
     */
    @RequestMapping(value = "api/activiti/act_re_model/findActReModelXmlByModelId",method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> findActReModelXmlByModelId(@RequestParam("modelId") String modelId);

}



