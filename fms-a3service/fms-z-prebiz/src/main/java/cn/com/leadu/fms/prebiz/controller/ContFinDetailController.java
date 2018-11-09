package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.prebiz.service.ContFinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ContFinDetailController
 * @Description: 合同明细
 * @date 2018/6/1
 */
@RestController
@RequestMapping("cont_fin_detail")
public class ContFinDetailController {


    @Autowired
    private ContFinDetailService contFinDetailService;

    /**
     * @Title:
     * @Description:   根据合同号 查询合同明细
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    @RequestMapping(value = "findContFinDetailVosByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContFinDetailVosByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                contFinDetailService.findContFinDetailVosByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据合同号 查询合同融资费用明细
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/01 10:20:05
     */
    @RequestMapping(value = "findContFinDetailsByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContFinDetailsByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                contFinDetailService.findContFinDetailsByContNo(contNo)), HttpStatus.OK);
    }
}
