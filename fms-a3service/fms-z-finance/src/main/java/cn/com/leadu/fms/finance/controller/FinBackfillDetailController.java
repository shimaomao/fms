package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import cn.com.leadu.fms.finance.service.FinBackfillDetailService;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.*;
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
 * @ClassName: FinBackfillDetailController
 * @Description: 融资回填明细相关接口
 * @date 2018-05-12
 */
@RestController
@RequestMapping("fin_backfill_detail")
public class FinBackfillDetailController {

    /**
     * @Fields  : 融资回填明细service
     */
    @Autowired
    private FinBackfillDetailService finBackfillDetailService;

    /**
     * @Title:
     * @Description: 分页查询融资回填明细信息
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "findFinBackfillDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillDetailsByPage(FinBackfillDetailVo finBackfillDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(finBackfillDetailService.findFinBackfillDetailsByPage(finBackfillDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存融资回填明细
     * @param finBackfillDetailSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "saveFinBackfillDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinBackfillDetail(@Valid @RequestBody FinBackfillDetailSaveVo finBackfillDetailSaveVo){
        finBackfillDetailService.saveFinBackfillDetail(finBackfillDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改融资回填明细
     * @param finBackfillDetailModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "modifyFinBackfillDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinBackfillDetail(@Valid @RequestBody FinBackfillDetailModifyVo finBackfillDetailModifyVo){
        finBackfillDetailService.modifyFinBackfillDetail(finBackfillDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除融资回填明细
     * @param finBackfillDetailDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "deleteFinBackfillDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfillDetail(@Valid @RequestBody FinBackfillDetailDeleteVo finBackfillDetailDeleteVo){
        finBackfillDetailService.deleteFinBackfillDetail(finBackfillDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据finBackfillDetailId集合删除融资回填明细
     * @param finBackfillDetailDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "deleteFinBackfillDetailsByFinBackfillDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfillDetailsByFinBackfillDetailIds(@Valid @RequestBody FinBackfillDetailDeleteListVo finBackfillDetailDeleteListVo){
        finBackfillDetailService.deleteFinBackfillDetailsByFinBackfillDetailIds(finBackfillDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据finBackfillDetailId获取融资回填明细
     * @param finBackfillDetailId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "findFinBackfillDetailByFinBackfillDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillDetailByFinBackfillDetailId(String finBackfillDetailId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(finBackfillDetailService.findFinBackfillDetailByFinBackfillDetailId(finBackfillDetailId)), HttpStatus.OK);
    }

}
