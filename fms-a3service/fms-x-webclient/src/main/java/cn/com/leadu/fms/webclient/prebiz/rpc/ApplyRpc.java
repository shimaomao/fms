package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author liujinge
 * @ClassName: ApplyController
 * @Description: 申请信息rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyRpc {

    /**
     * @Title:
     * @Description: 分页查询申请信息信息
     * @param applyVoMap
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "api/prebiz/apply/findApplysByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplysByPage(@RequestParam Map<String, Object> applyVoMap);

    /** 
    * @Description: 分页查询申请一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/3 18:02
    */ 
    @RequestMapping(value = "api/prebiz/apply/findApplyListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyListByPage(@RequestParam Map<String, Object> applyListVoMap);

    /**
     * @Title:
     * @Description: 保存申请信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "api/prebiz/apply/saveApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveApply(@RequestBody ApplyVo applyVo);

    /**
     * @Title:
     * @Description:  修改申请信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "api/prebiz/apply/modifyApply",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyApply(@RequestBody ApplyVo applyVo);

    /**
     * @Title:
     * @Description:   根据applyId集合删除申请信息
     * @param applyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "api/system/apply/deleteApplysByApplyIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteApplysByApplyIds(@RequestBody ApplyVo applyVo);

    /**
     * @Title:
     * @Description:  根据applyId获取申请信息
     * @param applyId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "api/prebiz/apply/findApplyByApplyId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyByApplyId(@RequestParam("applyId") String applyId);

    /**
     * @Title:
     * @Description:  根据applyNo获取申请详情顶部信息
     * @param applyNo
     * @return
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "api/prebiz/apply/findApplyBaseInfo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyBaseInfo(@RequestParam("applyNo") String applyNo);

    /** 
    * @Description: 计算风险融资额
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 15:25
    */
    @RequestMapping(value = "api/prebiz/apply/riskAmount", method = RequestMethod.GET)
    ResponseEntity<RestResponse> riskAmount(@RequestParam("applyNo")String applyNo
            ,@RequestParam("applyType")String applyType,@RequestParam("certifNo")String certifNo);

    /**
     * @Description: 分页查找待派单订单
     * @param:
     * @return:
     * @Author: qiaomengnan
     * @Date: 2018/6/22 11:46
     */
    @RequestMapping(value = "api/prebiz/apply/findDispatchApplyVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDispatchApplyVosByPage(@RequestParam Map<String, Object> applyVoMap);

    /**
     * @Description: 派单指定
     * @param:
     * @return:
     * @Author: qiaomengnan
     * @Date: 2018/6/22 11:46
     */
    @RequestMapping(value = "api/prebiz/apply/dispatchApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> dispatchApply(@RequestBody ApplyVo applyVo);

}
