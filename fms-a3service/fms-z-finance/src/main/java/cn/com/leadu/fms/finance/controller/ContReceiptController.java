package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptPostVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.finance.service.ContReceiptService;
import cn.com.leadu.fms.finance.validator.contreceipt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: ContReceiptController
 * @Description: 黑名单相关接口
 * @date 2018-05-07
 */
@RestController
@RequestMapping("cont_receipt")
public class ContReceiptController {

    /**
     * @Fields  : 黑名单service
     */
    @Autowired
    private ContReceiptService contReceiptService;

    /**
     * @Title:
     * @Description: 分页查询收款明细信息
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "findContReceiptsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptsByPage(ContReceiptVo contReceiptVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contReceiptService.findContReceiptsByPage(contReceiptVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询收款导入明细信息
     * @param contReceiptVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "findContReceiptsImport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptsImport(ContReceiptVo contReceiptVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contReceiptService.findContReceiptsImport(contReceiptVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param contReceiptSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "saveContReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContReceipt(@Valid @RequestBody ContReceiptSaveVo contReceiptSaveVo){
        contReceiptService.saveContReceipt(contReceiptSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 手动勾稽
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/6 21:39
    */
    @RequestMapping(value = "manualReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> manualReceipt(@Valid @RequestBody ContReceiptPostVo contReceiptPostVo){
        contReceiptService.manualReceipt(contReceiptPostVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 勾稽
     * @param contReceiptPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "receipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> receipt(@Valid @RequestBody ContReceiptPostVo contReceiptPostVo){
        contReceiptService.receipt(contReceiptPostVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param contReceiptModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "modifyContReceipt",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContReceipt(@Valid @RequestBody ContReceiptModifyVo contReceiptModifyVo){
        contReceiptService.modifyContReceipt(contReceiptModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除黑名单
     * @param contReceiptDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "deleteContReceipt",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceipt(@Valid @RequestBody ContReceiptDeleteVo contReceiptDeleteVo){
        contReceiptService.deleteContReceipt(contReceiptDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contReceiptId集合删除黑名单
     * @param contReceiptDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "deleteContReceiptsByContReceiptIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceiptsByContReceiptIds(@Valid @RequestBody ContReceiptDeleteListVo contReceiptDeleteListVo){
        contReceiptService.deleteContReceiptsByContReceiptIds(contReceiptDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contReceiptId获取黑名单
     * @param contReceiptId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "findContReceiptByContReceiptId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptByContReceiptId(String contReceiptId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contReceiptService.findContReceiptByContReceiptId(contReceiptId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   导入收款明细
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "importContReceipts", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> importContReceipts(String filePath){
        contReceiptService.importContReceipts(filePath);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   收款明细导入模板下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/27 11:12:06
     */
    @RequestMapping(value = "exportContReceiptModalExcel", method = RequestMethod.GET)
    public void exportContReceiptModalExcel(HttpServletResponse httpServletResponse){
        contReceiptService.exportContReceiptModalExcel(httpServletResponse);
    }

}
