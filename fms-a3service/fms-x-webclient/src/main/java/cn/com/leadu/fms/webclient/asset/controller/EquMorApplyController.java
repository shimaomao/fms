package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyApproveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.*;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailsInfoReviewVo;
import cn.com.leadu.fms.webclient.asset.rpc.EquMorApplyRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyController
 * @Description: 资方抵押申请
 * @date 2018/5/31
 */
@RestController
@RequestMapping("equ_mor_apply")
public class EquMorApplyController {

    @Autowired
    private EquMorApplyRpc equMorApplyRpc;

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
        Map equMorChargeVoMap = equMorApplyVo == null?null:(Map) JSON.toJSON(equMorApplyVo);
        return equMorApplyRpc.findEquMorSeaWingApplyVosByPage(equMorChargeVoMap);
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
        Map equMorChargeVoMap = equMorApplyVo == null?null:(Map) JSON.toJSON(equMorApplyVo);
        return equMorApplyRpc.findEquMorOtherApplyVosByPage(equMorChargeVoMap);
    }

    /**
     * @Title:
     * @Description:   保存海翼申请
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "saveEquMorSeaWingApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorApplyVo){
        return equMorApplyRpc.saveEquMorSeaWingApply(equMorApplyVo);
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
        return equMorApplyRpc.findEquMorTaskVoByEquMorTaskNo(equMorTaskNo);
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
        return equMorApplyRpc.findEquMorApplyVoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:   海翼申请 二次提交
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "modifyEquMorSeaWingApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> modifyEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorApplyVo){
        return equMorApplyRpc.modifyEquMorSeaWingApply(equMorApplyVo);
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
    public ResponseEntity<RestResponse> storageEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorSeaWingApplyVo){
        return equMorApplyRpc.storageEquMorSeaWingApply(equMorSeaWingApplyVo);
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
        return equMorApplyRpc.findEquMorApplyVoByEquMorTaskNo(equMorTaskNo);
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
        Map equMorDetailVoMap = equMorDetailVo == null?null:(Map) JSON.toJSON(equMorDetailVo);
        return equMorApplyRpc.findRent(equMorDetailVoMap);
    }

    /**
     * @Title:
     * @Description:   保存其他资方抵押申请
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "saveEquMorOtherApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorOtherApply(@RequestBody EquMorApplyVo equMorApplyVo){
        return equMorApplyRpc.saveEquMorOtherApply(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description:   修改其他资方抵押申请 (二次提交)
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "modifyEquMorOtherApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> modifyEquMorOtherApply(@RequestBody EquMorApplyVo equMorApplyVo){
        return equMorApplyRpc.modifyEquMorOtherApply(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description:   退回操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "equMorApplyReturn", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorApplyReturn(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        return equMorApplyRpc.equMorApplyReturn(equMorApplyTaskVo);
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
    public ResponseEntity<RestResponse> equMorApplyAgree(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        return equMorApplyRpc.equMorApplyAgree(equMorApplyTaskVo);
    }

    /**
     * @Title:
     * @Description:   取消操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "equMorApplyCancel", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorApplyCancel(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        return equMorApplyRpc.equMorApplyCancel(equMorApplyTaskVo);
    }

    /**
     * @Title:
     * @Description:   解析excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    @RequestMapping(value = "parseEquMorChargeExcel", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> parseEquMorChargeExcel(String filePath){
        return equMorApplyRpc.parseEquMorChargeExcel(filePath);
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
    public ResponseEntity<RestResponse> equMorChargeImport(@RequestBody EquMorChargeImportVo equMorChargeImportVo){
        return equMorApplyRpc.equMorChargeImport(equMorChargeImportVo);
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
    public ResponseEntity<RestResponse> equMorChargeImportReturn(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo){
        return equMorApplyRpc.equMorChargeImportReturn(equMorApplyTaskVo);
    }

    /**
     * @Title:
     * @Description:   抵押费用导入模板下载
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 11:12:06
     */
    @RequestMapping(value = "downloadEquMorChargeImportTemplate", method = RequestMethod.GET)
    public ResponseEntity downloadEquMorChargeImportTemplate(){
        return CommonFeignUtils.getResponseEntity(equMorApplyRpc.downloadEquMorChargeImportTemplate());
    }

    /**
     * @Title:
     * @Description:   还款计划表下载
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 03:23:28
     */
    @RequestMapping(value = "downloadEquMorRepayExcelTemplate", method = RequestMethod.GET)
    public ResponseEntity downloadEquMorRepayExcelTemplate(){
        return CommonFeignUtils.getResponseEntity(equMorApplyRpc.downloadEquMorRepayExcelTemplate());
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
        return equMorApplyRpc.findEquMorChargeImportVo(equMorTaskNo);
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
        return equMorApplyRpc.findFinanceTouchingVo(equMorTaskNo);
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
    public ResponseEntity<RestResponse> financeTouching(@RequestBody EquMorChargeFinTouchingVo equMorChargeFinTouchingVo){
        return equMorApplyRpc.financeTouching(equMorChargeFinTouchingVo);
    }

    /**
     * @Title:
     * @Description:   财务付款
     * @param equMorChargeFinPayVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 01:54:50
     */
    @RequestMapping(value = "financePay", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financePay(@RequestBody EquMorChargeFinPayVo equMorChargeFinPayVo){
        return equMorApplyRpc.financePay(equMorChargeFinPayVo);
    }


    /**
     * @Title:
     * @Description:   财务收款
     * @param equMorChargeFinReceiptVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 10:58:40
     */
    @RequestMapping(value = "financeReceipt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeReceipt(@RequestBody EquMorChargeFinReceiptVo equMorChargeFinReceiptVo){
        return equMorApplyRpc.financeReceipt(equMorChargeFinReceiptVo);
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
    public ResponseEntity<RestResponse> equMorChargeImportReview(@RequestBody EquMorApplyApproveVo equMorApplyApproveVo){
        return equMorApplyRpc.equMorChargeImportReview(equMorApplyApproveVo);
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
        return equMorApplyRpc.parseEquMorRepayVoExcel(filePath);
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
    public ResponseEntity<RestResponse> equMorArchive(@RequestBody EquMorArchiveVo equMorArchiveVo){
        return equMorApplyRpc.equMorArchive(equMorArchiveVo);
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
        return equMorApplyRpc.findEquMorDetailVosByEquMorTaskNo(equMorTaskNo);
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
        return equMorApplyRpc.findEquMorDetailVosAndFileByEquMorTaskNo(equMorTaskNo);
    }

    /**
     * @Title:
     * @Description:   资方抵押归档复核
     * @param equMorDetailsInfoReviewVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:19:09
     */
    @RequestMapping(value = "equMorArchiveReview" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> equMorArchiveReview(@RequestBody EquMorDetailsInfoReviewVo equMorDetailsInfoReviewVo){
        return equMorApplyRpc.equMorArchiveReview(equMorDetailsInfoReviewVo);
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
    public ResponseEntity printEquMorChargeSeaWingApply(String equMorTaskNo){
        return equMorApplyRpc.printEquMorChargeSeaWingApply(equMorTaskNo);
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
    public ResponseEntity<RestResponse> printEquMor(@RequestBody EquMorChargeFinTouchingPrintVo equMorChargeFinTouchingPrintVo){
        return equMorApplyRpc.printEquMor(equMorChargeFinTouchingPrintVo);
    }

}
