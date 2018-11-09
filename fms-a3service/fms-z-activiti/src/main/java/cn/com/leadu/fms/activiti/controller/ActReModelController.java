package cn.com.leadu.fms.activiti.controller;

import cn.com.leadu.fms.activiti.service.ActReModelService;
import cn.com.leadu.fms.common.exception.FmsRuntimeException;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actremodel.ActReModelVo;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author qiaomengnan
 * @ClassName: ActReModelController
 * @Description: 工作流模型相关接口
 * @date 2018/3/12
 */
@RestController
@RequestMapping("act_re_model")
public class ActReModelController {

    /**
     * @Fields  : 模型service
     */
    @Autowired
    private ActReModelService actReModelService;

    /**
     * @Title:
     * @Description:  分页查询模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:37:29
     */
    @RequestMapping(value = "findActReModelsByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReModelsByPage(ActReModelVo actReModelVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReModelService.findActReModelsByPage(actReModelVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   添加模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:40:00
     */
    @RequestMapping(value = "saveActReModel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveActReModel(@RequestBody ActReModelVo actReModelVo){
        Model model = null;
        try {
            model = actReModelService.saveActReModel(actReModelVo);
        }catch (Exception ex){
            throw new FmsRuntimeException("添加模型异常,请重试或联系管理员");
        }
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(model),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   部署模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:43:03
     */
    @RequestMapping(value = "deployActReModel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> deployActReModel(String modelId){
        try {
            actReModelService.deployActReModel(modelId);
        }catch (IOException ex){
            throw new FmsRuntimeException("部署模型异常,请重试或联系管理员");
        }
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据modelId删除模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 11:25:58
     */
    @RequestMapping(value = "deleteActReModelByModelId",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteActReModelByModelId(String modelId){
        actReModelService.deleteActReModelByModelId(modelId);
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据modelId获取模型xml
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/15 11:55:24
     */
    @RequestMapping(value = "findActReModelXmlByModelId",method = RequestMethod.GET )
    public ResponseEntity<RestResponse> findActReModelXmlByModelId(String modelId) throws IOException {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReModelService.findActReModelXmlByModelId(modelId)),
                HttpStatus.OK);
    }

}
