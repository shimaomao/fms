package cn.com.leadu.fms.thirdinterface.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.thirdinterface.service.PyInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanggang
 * @ClassName: PyInterfaceController
 * @Description: 调用接口
 * @date 2018-6-13 9:18:12
 */
@RestController
@RequestMapping("py_interface")
public class PyInterfaceController {
    /**
     * @Fields  : 接口service
     */
    @Autowired
    private PyInterfaceService pyInterfaceService;
    /**
     * @Title:
     * @Description: 调用接口
     * @param obj 接口所需要的实体类
     * @return ApplyInputVo
     * @throws
     * @author yanggang
     * @date 2018-6-13 9:18:12
     */
    @RequestMapping(value = "requestUnzipApi", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> requestUnzipApi(@RequestBody Object obj) throws Exception{
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pyInterfaceService.requestUnzipApi(obj)), HttpStatus.OK);
    }
}
