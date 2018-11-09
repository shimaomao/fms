package cn.com.leadu.fms.webclient.activiti.controller;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actremodel.ActReModelVo;
import cn.com.leadu.fms.webclient.activiti.rpc.ActReModelRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActReModelController
 * @Description:    工作流模型相关接口
 * @date 2018/3/12
 */
@RestController
@RequestMapping("act_re_model")
public class ActReModelController {

    @Autowired
    private ActReModelRpc actReModelRpc;

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
        Map modelVoMap = actReModelVo == null?null:(Map) JSON.toJSON(actReModelVo);
        return actReModelRpc.findActReModelsByPage(modelVoMap);
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
        return actReModelRpc.saveActReModel(actReModelVo);
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
        return actReModelRpc.deployActReModel(modelId);
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
    public ResponseEntity<RestResponse> deleteActReModelByModelId(@RequestBody String modelId){
        return actReModelRpc.deleteActReModelByModelId(modelId);
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
    @RequestMapping(value = "findActReModelXmlByModelId",method = RequestMethod.GET,produces= "application/xml;charset=UTF-8")
    public String findActReModelXmlByModelId(String modelId) throws FmsRpcException {
        return ResponseEntityUtils.getRestResponseData(actReModelRpc.findActReModelXmlByModelId(modelId));
    }

}
