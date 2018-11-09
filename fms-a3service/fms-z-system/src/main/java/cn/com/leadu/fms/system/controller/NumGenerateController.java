package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchenghao
 * @ClassName: SysCodeController
 * @Description: 字典数数值相关接口
 * @date 2018-03-09
 */
@RestController
@RequestMapping("num_generate")
public class NumGenerateController {

    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Title:
     * @Description:  取得自动生成的代码
     * @param codeType
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "getCodeByType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getCodeByType(String codeType){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(numGenerateService.getNumGenerateByNumType(codeType)), HttpStatus.OK);
    }

}
