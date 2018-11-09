package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.finance.service.FinBackfillService;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: FinBackfillController
 * @Description: 融资回填相关接口
 * @date 2018-05-11
 */
@RestController
@RequestMapping("fin_backfill")
public class FinBackfillController {

    /**
     * @Fields  : 融资回填service
     */
    @Autowired
    private FinBackfillService finBackfillService;

    /**
     * @Title:
     * @Description: 分页查询融资回填信息
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "findFinBackfillsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillsByPage(FinBackfillVo finBackfillVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(finBackfillService.findFinBackfillsByPage(finBackfillVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存融资回填
     * @param finBackfillSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "saveFinBackfill",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinBackfill(@Valid @RequestBody FinBackfillSaveVo finBackfillSaveVo){
        finBackfillService.saveFinBackfill(finBackfillSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "finBackfill",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> finBackfill(@Valid @RequestBody FinBackfillVo finBackfillVo){
        finBackfillService.finBackfill(finBackfillVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改融资回填
     * @param finBackfillModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "modifyFinBackfill",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinBackfill(@Valid @RequestBody FinBackfillModifyVo finBackfillModifyVo){
        finBackfillService.modifyFinBackfill(finBackfillModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除融资回填
     * @param finBackfillDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "deleteFinBackfill",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfill(@Valid @RequestBody FinBackfillDeleteVo finBackfillDeleteVo){
        finBackfillService.deleteFinBackfill(finBackfillDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据filBackfillId集合删除融资回填
     * @param finBackfillDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "deleteFinBackfillsByFilBackfillIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfillsByFilBackfillIds(@Valid @RequestBody FinBackfillDeleteListVo finBackfillDeleteListVo){
        finBackfillService.deleteFinBackfillsByFilBackfillIds(finBackfillDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据filBackfillId获取融资回填
     * @param filBackfillId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:18
     */
    @RequestMapping(value = "findFinBackfillByFilBackfillId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillByFilBackfillId(String filBackfillId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(finBackfillService.findFinBackfillByFilBackfillId(filBackfillId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVo
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "findFinBackfillsForExportExcel" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillsForExportExcel(FinBackfillVo finBackfillVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(finBackfillService.findFinBackfillsForExportExcel(finBackfillVo)),
                HttpStatus.OK);
    }

}
