package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeCompHistoryVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangePersHistoryVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskCancelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.ValidContractChangeVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.BasicChangeTaskRpc;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskController
 * @Description: 基本信息变更任务controller
 * @date 2018-09-01
 */
@RestController
@RequestMapping("basic_change_task")
public class BasicChangeTaskController {

    /**
     * @Fields  : 基本信息变更任务rpc
     */
    @Autowired
    private BasicChangeTaskRpc basicChangeTaskRpc;

    /**
     * @Description: 合同一览信息查询
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/28 12:36
     */
    @RequestMapping(value = "findContractListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractListByPage(ValidContractChangeVo validContractChangeVo){
        Map<String, Object> validContractChangeVoMap = validContractChangeVo == null ? null : (Map) JSON.toJSON(validContractChangeVo);
        return basicChangeTaskRpc.findContractListByPage(validContractChangeVoMap);
    }

    /**
     * @Description: 生效合同变更查询
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/28 12:36
     */
    @RequestMapping(value = "findBasicChangeTaskListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicChangeTaskListByPage(BasicChangeTaskVo basicChangeTaskVo){
        Map<String, Object> basicChangeTaskVoMap = basicChangeTaskVo == null ? null : (Map) JSON.toJSON(basicChangeTaskVo);
        return basicChangeTaskRpc.findBasicChangeTaskListByPage(basicChangeTaskVoMap);
    }

    /**
     * @Title:
     * @Description: check该客户是否存在未结束的基本信息变更任务
     * @param basicChangeTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "checkBasicChangeTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> checkBasicChangeTask(@RequestBody BasicChangeTaskVo basicChangeTaskVo){
        return basicChangeTaskRpc.checkBasicChangeTask(basicChangeTaskVo);
    }

    /**
     * @Title:
     * @Description: check该任务是否能被取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "isTaskCanBeCancel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> isTaskCanBeCancel(@RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo){
        return basicChangeTaskRpc.isTaskCanBeCancel(basicChangeTaskCancelVo);
    }

    /**
     * @Title:
     * @Description: 基本信息变更取消
     * @param basicChangeTaskCancelVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:34:36
     */
    @RequestMapping(value = "basicChangeTaskCancel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> basicChangeTaskCancel(@RequestBody BasicChangeTaskCancelVo basicChangeTaskCancelVo){
        return basicChangeTaskRpc.basicChangeTaskCancel(basicChangeTaskCancelVo);
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的企业基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangeCompHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findBasicCompChangeHistory",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicCompChangeHistory(BasicChangeCompHistoryVo vo){
        Map<String, Object> map = vo == null ? null : (Map) JSON.toJSON(vo);
        return basicChangeTaskRpc.findBasicCompChangeHistory(map);
    }

    /**
     * @Title:
     * @Description: 分页查询指定申请编号的个人基本信息变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<BasicChangeCompHistoryVo>
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findBasicPersChangeHistory",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicPersChangeHistory(BasicChangePersHistoryVo vo){
        Map<String, Object> map = vo == null ? null : (Map) JSON.toJSON(vo);
        return basicChangeTaskRpc.findBasicPersChangeHistory(map);
    }

    /**
     * 获取展期、增加保证金、变更承租人变更任务号
     * @param contNo 合同号
     * @return
     */
    @RequestMapping(value = "findChangeInfo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findChangeInfo(String contNo) {
        return basicChangeTaskRpc.findChangeInfo(contNo);
    }

    /**
     * 获取基本信息变更取消内容
     * @param basicTaskNo 变更任务号
     * @return
     */
    @RequestMapping(value = "findBasicChangeCancelVo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasicChangeCancelVo(String basicTaskNo) {
        return basicChangeTaskRpc.findBasicChangeCancelVo(basicTaskNo);
    }

}
