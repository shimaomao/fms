package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueTelRegisterRpc;
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
 * @author lijunjun
 * @ClassName: OverdueTelRegisterController
 * @Description: 电话催收登记信息controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_tel_register")
public class OverdueTelRegisterController {

    /**
     * @Fields  : 电话催收登记信息rpc
     */
    @Autowired
    private OverdueTelRegisterRpc overdueTelRegisterRpc;

    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "findOverdueTelRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueTelRegistersByPage(OverdueTelRegisterVo overdueTelRegisterVo){
        Map overdueTelRegisterVoMap = overdueTelRegisterVo == null?null:(Map) JSON.toJSON(overdueTelRegisterVo);
        return overdueTelRegisterRpc.findOverdueTelRegistersByPage(overdueTelRegisterVoMap);
    }

    /**
     * @Title:
     * @Description: 保存电话催收登记信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "saveOverdueTelRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueTelRegister(@RequestBody OverdueTelRegisterVo overdueTelRegisterVo){
        return overdueTelRegisterRpc.saveOverdueTelRegister(overdueTelRegisterVo);
    }

    /**
     * @Title:
     * @Description:  修改电话催收登记信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "modifyOverdueTelRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueTelRegister(@RequestBody OverdueTelRegisterVo overdueTelRegisterVo){
        return overdueTelRegisterRpc.modifyOverdueTelRegister(overdueTelRegisterVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueTelRegisterId集合删除电话催收登记信息
     * @param overdueTelRegisterIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "deleteOverdueTelRegistersByOverdueTelRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueTelRegistersByOverdueTelRegisterIds(@RequestBody List<String> overdueTelRegisterIds){
        OverdueTelRegisterVo overdueTelRegisterVo = new OverdueTelRegisterVo();
        overdueTelRegisterVo.setOverdueTelRegisterIds(overdueTelRegisterIds);
        return overdueTelRegisterRpc.deleteOverdueTelRegistersByOverdueTelRegisterIds(overdueTelRegisterVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueTelRegisterId获取电话催收登记信息
     * @param overdueTelRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "findOverdueTelRegisterByOverdueTelRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueTelRegisterByOverdueTelRegisterId(String overdueTelRegisterId){
        return overdueTelRegisterRpc.findOverdueTelRegisterByOverdueTelRegisterId(overdueTelRegisterId);
    }

}
