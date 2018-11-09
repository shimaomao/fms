package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.system.rpc.NumGenerateRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchenghao
 * @ClassName: SysCodeController
 * @Description: 字典数数值controller
 * @date 2018-03-09
 */
@RestController
@RequestMapping("num_generate")
public class NumGenerateController {

    @Autowired
    private NumGenerateRpc numGenerateRpc;

    /**
     * @Title:
     * @Description: 取得自动生成的代码
     * @param codeType
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-11 13:46:54
     */
    @RequestMapping(value = "getCodeByType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getCodeByType(String codeType){
        return numGenerateRpc.getCodeByType(codeType);
    }


}
