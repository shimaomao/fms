package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyCancelRpc {
    @RequestMapping(value = "api/prebiz/apply_cancel/findApplyCancelsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyCancelsByPage(@RequestParam Map<String, Object> applyCancelVoMap);


    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/prebiz/apply_cancel/findApplyCancelVoByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyCancelVoByApplyNo(@RequestParam("applyNo") String applyNo);


    /**
     * @Title:
     * @Description:  修改银行账号维护
     * @param applyCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/prebiz/apply_cancel/modifyApplyCancel",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyApplyCancel(@RequestBody ApplyCancelVo applyCancelVo);
}
