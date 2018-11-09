package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyRpc;
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
 * @author liujinge
 * @ClassName: ApplyController
 * @Description: 申请信息controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("apply")
public class ApplyController {

    /**
     * @Fields  : 申请信息rpc
     */
    @Autowired
    private ApplyRpc applyRpc;

    /**
     * @Title:
     * @Description: 分页查询申请信息信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "findApplysByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplysByPage(ApplyVo applyVo){
        Map applyVoMap = applyVo == null?null:(Map) JSON.toJSON(applyVo);
        return applyRpc.findApplysByPage(applyVoMap);
    }

    /** 
    * @Description: 分页查询申请一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/3 17:49
    */ 
    @RequestMapping(value="findApplyListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyListByPage(ApplyListVo applyListVo){
        Map applyListVoMap = applyListVo == null ? null : (Map)JSON.toJSON(applyListVo);
        return applyRpc.findApplyListByPage(applyListVoMap);
    }

    /**
     * @Title:
     * @Description: 保存申请信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "saveApply",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApply(@RequestBody ApplyVo applyVo){
        return applyRpc.saveApply(applyVo);
    }

    /**
     * @Title:
     * @Description:  修改申请信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "modifyApply",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyApply(@RequestBody ApplyVo applyVo){
        return applyRpc.modifyApply(applyVo);
    }

    /**
     * @Title:
     * @Description:   根据applyId集合删除申请信息
     * @param applyIds
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "deleteApplysByApplyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteApplysByApplyIds(@RequestBody List<String> applyIds){
        ApplyVo applyVo = new ApplyVo();
        applyVo.setApplyIds(applyIds);
        return applyRpc.deleteApplysByApplyIds(applyVo);
    }

    /**
     * @Title:
     * @Description:  根据applyId获取申请信息
     * @param applyId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "findApplyByApplyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyByApplyId(String applyId){
        return applyRpc.findApplyByApplyId(applyId);
    }
    /**
     * @Title:
     * @Description:  根据applyNo获取申请详情顶部信息
     * @param applyNo
     * @return
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findApplyBaseInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyBaseInfo(String applyNo){
        return applyRpc.findApplyBaseInfo(applyNo);
    }


    /** 
    * @Description: 计算风险融资额
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 15:24
    */ 
    @RequestMapping(value = "riskAmount", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> riskAmount(String applyNo,String applyType,String certifNo){
        return applyRpc.riskAmount(applyNo,applyType,certifNo);
    }

    /**
     * @Description: 分页查找待派单订单
     * @param:
     * @return:
     * @Author: qiaomengnan
     * @Date: 2018/6/22 11:46
     */
    @RequestMapping(value = "findDispatchApplyVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDispatchApplyVosByPage(ApplyVo applyVo){
        Map applyVoMap = applyVo == null?null:(Map) JSON.toJSON(applyVo);
        return applyRpc.findDispatchApplyVosByPage(applyVoMap);
    }

    /**
     * @Description: 派单指定
     * @param:
     * @return:
     * @Author: qiaomengnan
     * @Date: 2018/6/22 11:46
     */
    @RequestMapping(value = "dispatchApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> dispatchApply(@RequestBody ApplyVo applyVo){
        return applyRpc.dispatchApply(applyVo);
    }

}
