package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equreltask.EquRelTaskVo;
import cn.com.leadu.fms.webclient.asset.rpc.EquRelTaskRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskController
 * @Description: 资方解押任务controller
 * @date 2018-05-30
 */
@RestController
@RequestMapping("equ_rel_task")
public class EquRelTaskController {

    /**
     * @Fields  : 资方解押任务rpc
     */
    @Autowired
    private EquRelTaskRpc equRelTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询资方解押任务信息
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "findEquRelTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquRelTasksByPage(EquRelTaskVo equRelTaskVo){
        Map equRelTaskVoMap = equRelTaskVo == null?null:(Map) JSON.toJSON(equRelTaskVo);
        return equRelTaskRpc.findEquRelTasksByPage(equRelTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资方解押任务
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "saveEquRelTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquRelTask(@RequestBody EquRelTaskVo equRelTaskVo){
        return equRelTaskRpc.saveEquRelTask(equRelTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改资方解押任务
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "modifyEquRelTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquRelTask(@RequestBody EquRelTaskVo equRelTaskVo){
        return equRelTaskRpc.modifyEquRelTask(equRelTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据equRelTaskId集合删除资方解押任务
     * @param equRelTaskIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "deleteEquRelTasksByEquRelTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquRelTasksByEquRelTaskIds(@RequestBody List<String> equRelTaskIds){
        EquRelTaskVo equRelTaskVo = new EquRelTaskVo();
        equRelTaskVo.setEquRelTaskIds(equRelTaskIds);
        return equRelTaskRpc.deleteEquRelTasksByEquRelTaskIds(equRelTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据equRelTaskId获取资方解押任务
     * @param equRelTaskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @RequestMapping(value = "findEquRelTaskByEquRelTaskId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquRelTaskByEquRelTaskId(String equRelTaskId){
        return equRelTaskRpc.findEquRelTaskByEquRelTaskId(equRelTaskId);
    }

}
