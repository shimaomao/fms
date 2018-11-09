package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.apply.ApplyVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: ApplyController
 * @Description: 申请信息相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("apply")
public class ApplyController {

    /**
     * @Fields  : 申请信息service
     */
    @Autowired
    private ApplyService applyService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(applyService.findApplysByPage(applyVo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 分页查询申请一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/3 18:31
    */ 
    @RequestMapping(value = "findApplyListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyListByPage(ApplyListVo applyListVo, @AuthUserInfo SysUserVo sysUser) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(applyService.findApplyListByPage(applyListVo,sysUser)),
                HttpStatus.OK );
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyService.findApplyByApplyId(applyId)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyService.findApplyBaseInfo(applyNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 计算风险融资额 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 15:23
    */ 
    @RequestMapping(value = "riskAmount", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> riskAmount(String applyNo,String applyType,String certifNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyService.riskAmount(applyNo,applyType,certifNo)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyService.findDispatchApplyVosByPage(applyVo)), HttpStatus.OK);
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
        applyService.dispatchApply(applyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

}
