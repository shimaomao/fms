package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.system.service.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: SysClientController
 * @Description: 系统客户端标识相关接口
 * @date 2018/3/6
 */
@RestController
@RequestMapping("sys_client")
public class SysClientController {

    @Autowired
    private SysClientService sysClientService;

    /**
     * @Title:
     * @Description:   通过clientId获取客户端标识对象
     * @param clientId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/06 08:56:58
     */
    @RequestMapping(value = "findSysClientByClientId" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysClientByClientId(String clientId){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysClientService.findSysClientByClientId(clientId)),
                HttpStatus.OK);
    }

}
