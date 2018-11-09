package cn.com.leadu.fms.webclient.activiti.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import cn.com.leadu.fms.webclient.activiti.rpc.ActReProcdefRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentController
 * @Description: 流程定义信息相关接口
 * @date 2018/3/13
 */
@RestController
@RequestMapping("act_re_procdef")
public class ActReProcdefController {

    @Autowired
    private ActReProcdefRpc actReProcdefRpc;

    /**
     * @Title:
     * @Description:   分页查询流程定义vos
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 05:00:50
     */
    @RequestMapping(value = "findActReProcdefVosByPage" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReProcdefVosByPage(ActReProcdefVo actReProcdefVo){
        Map actReProcdefVoMap = actReProcdefVo == null?null:(Map) JSON.toJSON(actReProcdefVo);
        return actReProcdefRpc.findActReProcdefVosByPage(actReProcdefVoMap);
    }

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    @RequestMapping(value = "findActReProcdefVosByUserOrGroup" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReProcdefVosByUserOrGroup(){
        return actReProcdefRpc.findActReProcdefVosByUserOrGroup();
    }

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型，并得到树形
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/12 11:15:14
     */
    @RequestMapping(value = "findProcdefTree" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProcdefTree(){
        return actReProcdefRpc.findProcdefTree();
    }

}
