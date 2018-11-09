package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianshuai
 * @ClassName: KeepSessionAliveController
 * @Description: 更新session误操作 controller
 * @date 2018-08-29
 */
@RestController
@RequestMapping("keep_session")
public class KeepSessionAliveController {

    /**
     * @return response成功
     * @throws
     * @Title:
     * @Description: 保持会话
     * @author lijunjun
     * @date 2018-08-29 14:08:37
     */
    @RequestMapping(value = "alive", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> keepSessionAlive() {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
