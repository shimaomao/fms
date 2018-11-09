package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.vo.equreltask.EquRelTaskVo;
import cn.com.leadu.fms.asset.service.EquRelTaskService;
import cn.com.leadu.fms.asset.validator.equreltask.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskController
 * @Description: 资方解押任务相关接口
 * @date 2018-05-30
 */
@RestController
@RequestMapping("equ_rel_task")
public class EquRelTaskController {

    /**
     * @Fields  : 资方解押任务service
     */
    @Autowired
    private EquRelTaskService equRelTaskService;

    /**
     * @Title:
     * @Description: 分页查询资方解押任务信息
     * @param equRelTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "findEquRelTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquRelTasksByPage(EquRelTaskVo equRelTaskVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(equRelTaskService.findEquRelTasksByPage(equRelTaskVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存资方解押任务
     * @param equRelTaskSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "saveEquRelTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquRelTask(@Valid @RequestBody EquRelTaskSaveVo equRelTaskSaveVo){
        equRelTaskService.saveEquRelTask(equRelTaskSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改资方解押任务
     * @param equRelTaskModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "modifyEquRelTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquRelTask(@Valid @RequestBody EquRelTaskModifyVo equRelTaskModifyVo){
        equRelTaskService.modifyEquRelTask(equRelTaskModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除资方解押任务
     * @param equRelTaskDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "deleteEquRelTask",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquRelTask(@Valid @RequestBody EquRelTaskDeleteVo equRelTaskDeleteVo){
        equRelTaskService.deleteEquRelTask(equRelTaskDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据equRelTaskId集合删除资方解押任务
     * @param equRelTaskDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "deleteEquRelTasksByEquRelTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquRelTasksByEquRelTaskIds(@Valid @RequestBody EquRelTaskDeleteListVo equRelTaskDeleteListVo){
        equRelTaskService.deleteEquRelTasksByEquRelTaskIds(equRelTaskDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据equRelTaskId获取资方解押任务
     * @param equRelTaskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:54
     */
    @RequestMapping(value = "findEquRelTaskByEquRelTaskId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquRelTaskByEquRelTaskId(String equRelTaskId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equRelTaskService.findEquRelTaskByEquRelTaskId(equRelTaskId)), HttpStatus.OK);
    }

}
