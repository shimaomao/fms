package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equreltask.EquRelTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskController
 * @Description: 资方解押任务rpc
 * @date 2018-05-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquRelTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询资方解押任务信息
     * @param equRelTaskVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "api/asset/equ_rel_task/findEquRelTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquRelTasksByPage(@RequestParam Map<String, Object> equRelTaskVoMap);

    /**
     * @Title:
     * @Description: 保存资方解押任务
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "api/asset/equ_rel_task/saveEquRelTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquRelTask(@RequestBody EquRelTaskVo equRelTaskVo);

    /**
     * @Title:
     * @Description:  修改资方解押任务
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "api/asset/equ_rel_task/modifyEquRelTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyEquRelTask(@RequestBody EquRelTaskVo equRelTaskVo);

    /**
     * @Title:
     * @Description:   根据equRelTaskId集合删除资方解押任务
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "api/asset/equ_rel_task/deleteEquRelTasksByEquRelTaskIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteEquRelTasksByEquRelTaskIds(@RequestBody EquRelTaskVo equRelTaskVo);

    /**
     * @Title:
     * @Description:  根据equRelTaskId获取资方解押任务
     * @param equRelTaskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "api/asset/equ_rel_task/findEquRelTaskByEquRelTaskId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquRelTaskByEquRelTaskId(@RequestParam("equRelTaskId") String equRelTaskId);

}
