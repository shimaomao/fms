package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyCancelRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消相关接口
 */
@RestController
@RequestMapping("apply_cancel")
public class ApplyCancelController {
    /*
        融资申请取消rpc
     */

    @Autowired
    private ApplyCancelRpc applyCancelRpc;
    
    @RequestMapping(value="findApplyCancelsByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCancelsByPage(ApplyCancelVo applyCancelVo){
        Map applyCancelVoMap = applyCancelVo == null?null:(Map) JSON.toJSON(applyCancelVo);
        return applyCancelRpc.findApplyCancelsByPage(applyCancelVoMap);
    }


    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findApplyCancelVoByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCancelVoByApplyNo(String applyNo){
        return applyCancelRpc.findApplyCancelVoByApplyNo(applyNo);
    }

    /**
     * @Title:
     * @Description:  融资申请取消
     * @param applyCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyApplyCancel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyApplyCancel(@RequestBody ApplyCancelVo applyCancelVo){
        return applyCancelRpc.modifyApplyCancel(applyCancelVo);
    }


}
