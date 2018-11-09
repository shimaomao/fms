package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.finance.service.FinRepaySkedService;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedController
 * @Description: 财务还款计划相关接口
 * @date 2018-05-12
 */
@RestController
@RequestMapping("fin_repay_sked")
public class FinRepaySkedController {

    /**
     * @Fields  : 财务还款计划service
     */
    @Autowired
    private FinRepaySkedService finRepaySkedService;

    /**
     * @Title:
     * @Description: 分页查询财务还款计划信息
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "findFinRepaySkedsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinRepaySkedsByPage(FinRepaySkedVo finRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(finRepaySkedService.findFinRepaySkedsByPage(finRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存财务还款计划
     * @param finRepaySkedSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "saveFinRepaySked",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinRepaySked(@Valid @RequestBody FinRepaySkedSaveVo finRepaySkedSaveVo){
        finRepaySkedService.saveFinRepaySked(finRepaySkedSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改财务还款计划
     * @param finRepaySkedModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "modifyFinRepaySked",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinRepaySked(@Valid @RequestBody FinRepaySkedModifyVo finRepaySkedModifyVo){
        finRepaySkedService.modifyFinRepaySked(finRepaySkedModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除财务还款计划
     * @param finRepaySkedDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "deleteFinRepaySked",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinRepaySked(@Valid @RequestBody FinRepaySkedDeleteVo finRepaySkedDeleteVo){
        finRepaySkedService.deleteFinRepaySked(finRepaySkedDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据finRepaySkedId集合删除财务还款计划
     * @param finRepaySkedDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "deleteFinRepaySkedsByFinRepaySkedIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinRepaySkedsByFinRepaySkedIds(@Valid @RequestBody FinRepaySkedDeleteListVo finRepaySkedDeleteListVo){
        finRepaySkedService.deleteFinRepaySkedsByFinRepaySkedIds(finRepaySkedDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据finRepaySkedId获取财务还款计划
     * @param finRepaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "findFinRepaySkedByFinRepaySkedId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinRepaySkedByFinRepaySkedId(String finRepaySkedId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(finRepaySkedService.findFinRepaySkedByFinRepaySkedId(finRepaySkedId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 开具发票
     * @param contRepaySkedVos
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-21 16:40:57
     */
    @RequestMapping(value = "finRepaySkedInvoice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> finRepaySkedInvoice(@Valid @RequestBody List<ContRepaySkedVo> contRepaySkedVos){
        finRepaySkedService.finRepaySkedInvoice(contRepaySkedVos);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 批量修改开票属性
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/25 11:49
    */
    @RequestMapping(value = "editInvoiceProp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> editInvoiceProp(@Valid @RequestBody FinRepaySkedVo finRepaySkedVo){
        finRepaySkedService.editInvoiceProp(finRepaySkedVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
