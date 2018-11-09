package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.asset.service.EquMorApplyService;
import cn.com.leadu.fms.asset.service.EquMorChargeService;
import cn.com.leadu.fms.asset.service.EquMorDetailService;
import cn.com.leadu.fms.asset.service.EquMorRepayService;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorApplyFinReceiptVo;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorOtherApplyVo;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorSeaWingApplyVo;
import cn.com.leadu.fms.asset.validator.equmordetail.vo.EquMorDetailsInfoReviewVo;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageFlag;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyApproveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingPrintVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeImportVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
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
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyController
 * @Description: 资方抵押申请
 * @date 2018/5/31
 */
@RestController
@RequestMapping("equ_mor_apply")
public class EquMorApplyController {

    /**
     * @Fields  : 资方抵押申请service
     * @author qiaomengnan
     */
    @Autowired
    private EquMorApplyService equMorApplyService;

    /**
     * @Fields  : 资方抵押费用service
     */
    @Autowired
    private EquMorChargeService equMorChargeService;

    /**
     * @Fields  : 资方抵押还款计划service
     */
    @Autowired
    private EquMorRepayService equMorRepayService;

    /**
     * @Fields  : 资方抵押明细service
     */
    @Autowired
    private EquMorDetailService equMorDetailService;

    /**
     * @Title:
     * @Description: 分页查询海翼资方抵押合同列表
     * @param equMorApplyVo
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @RequestMapping(value = "findEquMorSeaWingApplyVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorSeaWingApplyVosByPage(EquMorApplyVo equMorApplyVo){
        equMorApplyVo.setMortgageFlag(MortgageFlag.APPROPRIATE.getFlag());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorApplyService.findEquMorApplyVosByPage(equMorApplyVo)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 分页查询其他资方抵押合同列表
     * @param equMorApplyVo
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @RequestMapping(value = "findEquMorOtherApplyVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorOtherApplyVosByPage(EquMorApplyVo equMorApplyVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorApplyService.findEquMorApplyVosByPage(equMorApplyVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   保存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "saveEquMorSeaWingApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorSeaWingApply(@Valid @RequestBody EquMorSeaWingApplyVo equMorSeaWingApplyVo){
        equMorApplyService.saveEquMorSeaWingApply(equMorSeaWingApplyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据任务号返回资方抵押申请列表
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 14:55
     */
    @RequestMapping(value = "findEquMorTaskVoByEquMorTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorTaskVoByEquMorTaskNo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.findEquMorTaskVoByEquMorTaskNo(equMorTaskNo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据合同号 查询资方抵押合同详细信息
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    @RequestMapping(value = "findEquMorApplyVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorApplyVoByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.findEquMorApplyVoByContNo(contNo)), HttpStatus.OK);
    }



    /**
     * @Title:
     * @Description:   海翼申请 二次提交
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "modifyEquMorSeaWingApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> modifyEquMorSeaWingApply(@Valid @RequestBody EquMorSeaWingApplyVo equMorSeaWingApplyVo){
        equMorApplyService.modifyEquMorSeaWingApply(equMorSeaWingApplyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   暂存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 05:49:03
     */
    @RequestMapping(value = "storageEquMorSeaWingApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> storageEquMorSeaWingApply(@RequestBody EquMorSeaWingApplyVo equMorSeaWingApplyVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.storageEquMorSeaWingApply(equMorSeaWingApplyVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   查询海翼申请明细
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "findEquMorApplyVoByEquMorTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorApplyVoByEquMorTaskNo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.findEquMorApplyVoByEquMorTaskNo(equMorTaskNo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   保存其他资方抵押申请
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "saveEquMorOtherApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorOtherApply(@Valid @RequestBody EquMorOtherApplyVo equMorOtherApplyVo){
        equMorApplyService.saveEquMorOtherApply(equMorOtherApplyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   修改其他资方抵押申请 (二次提交)
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "modifyEquMorOtherApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> modifyEquMorOtherApply(@Valid @RequestBody EquMorOtherApplyVo equMorOtherApplyVo){
        equMorApplyService.modifyEquMorOtherApply(equMorOtherApplyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   返回每期租金
     * @param equMorDetailVo 抵押明细
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 04:04:08
     */
    @RequestMapping(value = "findRent", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRent(EquMorDetailVo equMorDetailVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.findRent(equMorDetailVo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   退回操作
     * @param EquMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "equMorApplyReturn", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorApplyReturn(@Valid @RequestBody EquMorApplyTaskVo EquMorApplyTaskVo){
        equMorApplyService.equMorApplyReturn(EquMorApplyTaskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   通过操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "equMorApplyAgree", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorApplyAgree(@Valid @RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        equMorApplyService.equMorApplyAgree(equMorApplyTaskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   取消操作
     * @param EquMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "equMorApplyCancel", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorApplyCancel(@RequestBody EquMorApplyTaskVo EquMorApplyTaskVo){
        equMorApplyService.equMorApplyCancel(EquMorApplyTaskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   解析费用excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    @RequestMapping(value = "parseEquMorChargeExcel", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> parseEquMorChargeExcel(String filePath){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorChargeService.parseEquMorChargeVoExcel(filePath)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:   导入费用
     * @param equMorChargeImportVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 03:52:43
     */
    @RequestMapping(value = "equMorChargeImport", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorChargeImport(@Valid @RequestBody EquMorChargeImportVo equMorChargeImportVo){
        equMorChargeService.equMorChargeImport(equMorChargeImportVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   导入费用退回
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 03:52:43
     */
    @RequestMapping(value = "equMorChargeImportReturn", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorChargeImportReturn(@Valid @RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        equMorChargeService.equMorChargeImportReturn(equMorApplyTaskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:   抵押费用导入模板下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 11:12:06
     */
    @RequestMapping(value = "downloadEquMorChargeImportTemplate", method = RequestMethod.GET)
    public void downloadEquMorChargeImportTemplate(HttpServletResponse httpServletResponse){
        equMorChargeService.downloadEquMorChargeImportTemplate(httpServletResponse);
    }

    /**
     * @Title:
     * @Description:   还款计划表下载
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 03:23:28
     */
    @RequestMapping(value = "downloadEquMorRepayExcelTemplate", method = RequestMethod.GET)
    public void downloadEquMorRepayExcelTemplate(HttpServletResponse httpServletResponse){
        equMorRepayService.downloadEquMorRepayExcelTemplate(httpServletResponse);
    }

    /**
     * @Title:
     * @Description:   根据抵押任务号查询费用导入详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:15:25
     */
    @RequestMapping(value = "findEquMorChargeImportVo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorChargeImportVo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorChargeService.findEquMorChargeImportVo(equMorTaskNo)
        ), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:   查询制单详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:45:53
     */
    @RequestMapping(value = "findFinanceTouchingVo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinanceTouchingVo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorChargeService.findFinanceTouchingVo(equMorTaskNo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   财务制单
     * @param equMorChargeFinTouchingVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/07 02:39:02
     */
    @RequestMapping(value = "financeTouching", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeTouching(@Valid @RequestBody EquMorChargeFinTouchingVo equMorChargeFinTouchingVo){
        equMorChargeService.financeTouching(equMorChargeFinTouchingVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   财务付款
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 01:54:50
     */
    @RequestMapping(value = "financePay", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financePay(@Valid @RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        equMorChargeService.financePay(equMorApplyTaskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:   财务收款
     * @param equMorApplyFinReceiptVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 10:58:40
     */
    @RequestMapping(value = "financeReceipt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeReceipt(@Valid @RequestBody EquMorApplyFinReceiptVo equMorApplyFinReceiptVo){
        equMorChargeService.financeReceipt(equMorApplyFinReceiptVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   费用导入review
     * @param equMorApplyApproveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 10:58:40
     */
    @RequestMapping(value = "equMorChargeImportReview", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorChargeImportReview(@Valid @RequestBody EquMorApplyApproveVo equMorApplyApproveVo){
        equMorChargeService.equMorChargeImportReview(equMorApplyApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   解析还款计划excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    @RequestMapping(value = "parseEquMorRepayVoExcel", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> parseEquMorRepayVoExcel(String filePath){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorRepayService.parseEquMorRepayVoExcel(filePath)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 资方抵押资料归档
     * @param equMorArchiveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 05:45:39
     */
    @RequestMapping(value = "equMorArchive" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorArchive(@Valid @RequestBody EquMorArchiveVo equMorArchiveVo){
        equMorDetailService.equMorArchive(equMorArchiveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    @RequestMapping(value = "findEquMorDetailVosByEquMorTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVosByEquMorTaskNo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorDetailService.findEquMorDetailVosByEquMorTaskNo(equMorTaskNo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表 并且带出文件详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    @RequestMapping(value = "findEquMorDetailVosAndFileByEquMorTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVosAndFileByEquMorTaskNo(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorDetailService.findEquMorDetailVosAndFileByEquMorTaskNo(equMorTaskNo)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   资方抵押资料归档复核
     * @param equMorDetailsInfoReviewVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:19:09
     */
    @RequestMapping(value = "equMorArchiveReview" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorArchiveReview(@Valid @RequestBody EquMorDetailsInfoReviewVo equMorDetailsInfoReviewVo){
        equMorDetailService.equMorArchiveReview(equMorDetailsInfoReviewVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   打印海翼申请合同
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 01:48:00
     */
    @RequestMapping(value = "printEquMorChargeSeaWingApply" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> printEquMorChargeSeaWingApply(String equMorTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                equMorApplyService.printEquMorChargeSeaWingApply(equMorTaskNo)
        ), HttpStatus.OK);

    }

    /**
     * @Title:
     * @Description: 查询资方抵押申请模板下载详情
     * @return  List<EquMorOtherApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    @RequestMapping(value = "exportEquMorApplyVos", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> exportEquMorApplyVos(cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo equMorApplyVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorApplyService.exportEquMorApplyVos(equMorApplyVo.getContNos())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printEquMor",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printEquMor(@Valid @RequestBody EquMorChargeFinTouchingPrintVo equMorChargeFinTouchingPrintVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorApplyService.printEquMor(equMorChargeFinTouchingPrintVo)), HttpStatus.OK);
    }

}
