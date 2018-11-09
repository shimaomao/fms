package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterController
 * @Description: 电话催收登记信息rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueTelRegisterRpc {

    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息信息
     * @param overdueTelRegisterVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "api/postBiz/overdue_tel_register/findOverdueTelRegistersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueTelRegistersByPage(@RequestParam Map<String, Object> overdueTelRegisterVoMap);

    /**
     * @Title:
     * @Description: 保存电话催收登记信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "api/postBiz/overdue_tel_register/saveOverdueTelRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueTelRegister(@RequestBody OverdueTelRegisterVo overdueTelRegisterVo);

    /**
     * @Title:
     * @Description:  修改电话催收登记信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "api/postBiz/overdue_tel_register/modifyOverdueTelRegister",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueTelRegister(@RequestBody OverdueTelRegisterVo overdueTelRegisterVo);

    /**
     * @Title:
     * @Description:   根据overdueTelRegisterId集合删除电话催收登记信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "api/system/overdue_tel_register/deleteOverdueTelRegistersByOverdueTelRegisterIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueTelRegistersByOverdueTelRegisterIds(@RequestBody OverdueTelRegisterVo overdueTelRegisterVo);

    /**
     * @Title:
     * @Description:  根据overdueTelRegisterId获取电话催收登记信息
     * @param overdueTelRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "api/postBiz/overdue_tel_register/findOverdueTelRegisterByOverdueTelRegisterId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueTelRegisterByOverdueTelRegisterId(@RequestParam("overdueTelRegisterId") String overdueTelRegisterId);

}
