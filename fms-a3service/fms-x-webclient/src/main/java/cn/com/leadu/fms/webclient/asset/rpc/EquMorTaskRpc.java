package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmortask.EquMorTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskController
 * @Description: 资方抵押任务rpc
 * @date 2018-05-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquMorTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询资方抵押任务信息
     * @param equMorTaskVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @RequestMapping(value = "api/asset/equ_mor_task/findEquMorTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorTasksByPage(@RequestParam Map<String, Object> equMorTaskVoMap);

    /**
     * @Title:
     * @Description: 保存资方抵押任务
     * @param equMorTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @RequestMapping(value = "api/asset/equ_mor_task/saveEquMorTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorTask(@RequestBody EquMorTaskVo equMorTaskVo);

    /**
     * @Title:
     * @Description:  修改资方抵押任务
     * @param equMorTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @RequestMapping(value = "api/asset/equ_mor_task/modifyEquMorTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyEquMorTask(@RequestBody EquMorTaskVo equMorTaskVo);

    /**
     * @Title:
     * @Description:   根据equMorTaskId集合删除资方抵押任务
     * @param equMorTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @RequestMapping(value = "api/asset/equ_mor_task/deleteEquMorTasksByEquMorTaskIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteEquMorTasksByEquMorTaskIds(@RequestBody EquMorTaskVo equMorTaskVo);

    /**
     * @Title:
     * @Description:  根据equMorTaskId获取资方抵押任务
     * @param equMorTaskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @RequestMapping(value = "api/asset/equ_mor_task/findEquMorTaskByEquMorTaskId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorTaskByEquMorTaskId(@RequestParam("equMorTaskId") String equMorTaskId);

}
