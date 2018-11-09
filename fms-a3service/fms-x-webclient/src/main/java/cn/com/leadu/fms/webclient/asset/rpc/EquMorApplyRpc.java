package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyApproveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.*;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorArchiveVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailsInfoReviewVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyController
 * @Description: 资方抵押申请
 * @date 2018/5/31
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquMorApplyRpc {

    /**
     * @Title:
     * @Description: 分页查询海翼资方抵押合同列表
     * @param equMorChargeApplyVoMap
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorSeaWingApplyVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorSeaWingApplyVosByPage(@RequestParam Map<String, Object> equMorChargeApplyVoMap);

    /**
     * @Title:
     * @Description: 分页查询其他资方抵押合同列表
     * @param equMorChargeApplyVoMap
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorOtherApplyVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorOtherApplyVosByPage(@RequestParam Map<String, Object> equMorChargeApplyVoMap);

    /**
     * @Title:
     * @Description: 根据任务号返回资方抵押申请列表
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 14:55
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorTaskVoByEquMorTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorTaskVoByEquMorTaskNo(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description:   根据合同号 查询资方抵押合同详细信息
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorApplyVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorApplyVoByContNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description:   保存海翼申请
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/saveEquMorSeaWingApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description:   海翼申请 二次提交
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/modifyEquMorSeaWingApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> modifyEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description:   暂存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 05:49:03
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/storageEquMorSeaWingApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> storageEquMorSeaWingApply(@RequestBody EquMorApplyVo equMorSeaWingApplyVo);

    /**
     * @Title:
     * @Description:   查询海翼申请明细
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorApplyVoByEquMorTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorApplyVoByEquMorTaskNo(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description:   返回每期租金
     * @param equMorChargeApplyVoMap 抵押明细
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 04:04:08
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findRent", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRent(@RequestParam Map<String, Object> equMorChargeApplyVoMap);

    /**
     * @Title:
     * @Description:   保存其他资方抵押申请
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/saveEquMorOtherApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorOtherApply(@RequestBody EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description:   修改其他资方抵押申请 (二次提交)
     * @param equMorApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/modifyEquMorOtherApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> modifyEquMorOtherApply(@RequestBody EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description:   退回操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorApplyReturn", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorApplyReturn(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   通过操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorApplyAgree", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorApplyAgree(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   取消操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorApplyCancel", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorApplyCancel(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   解析excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/parseEquMorChargeExcel", method = RequestMethod.GET)
    ResponseEntity<RestResponse> parseEquMorChargeExcel(@RequestParam("filePath") String filePath);

    /**
     * @Title:
     * @Description:   导入费用
     * @param equMorChargeImportVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 03:52:43
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorChargeImport", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorChargeImport(@RequestBody EquMorChargeImportVo equMorChargeImportVo);

    /**
     * @Title:
     * @Description:   导入费用退回
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 03:52:43
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorChargeImportReturn", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorChargeImportReturn(@RequestBody EquMorApplyTaskVo equMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   抵押费用导入模板下载
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 11:12:06
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/downloadEquMorChargeImportTemplate", method = RequestMethod.GET)
    Response downloadEquMorChargeImportTemplate();

    /**
     * @Title:
     * @Description:   抵押费用导入模板下载
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 11:12:06
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/downloadEquMorRepayExcelTemplate", method = RequestMethod.GET)
    Response downloadEquMorRepayExcelTemplate();

    /**
     * @Title:
     * @Description:   根据抵押任务号查询费用导入详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 04:15:25
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorChargeImportVo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorChargeImportVo(@RequestParam("equMorTaskNo") String equMorTaskNo);


    /**
     * @Title:
     * @Description:   查询制单详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:45:53
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findFinanceTouchingVo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinanceTouchingVo(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description:   财务制单
     * @param equMorChargeFinTouchingVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/07 02:39:02
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/financeTouching", method = RequestMethod.POST)
    ResponseEntity<RestResponse> financeTouching(@RequestBody EquMorChargeFinTouchingVo equMorChargeFinTouchingVo);


    /**
     * @Title:
     * @Description:   财务付款
     * @param equMorChargeFinPayVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 01:54:50
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/financePay", method = RequestMethod.POST)
    ResponseEntity<RestResponse> financePay(@RequestBody EquMorChargeFinPayVo equMorChargeFinPayVo);

    /**
     * @Title:
     * @Description:   财务收款
     * @param equMorChargeFinReceiptVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 10:58:40
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/financeReceipt", method = RequestMethod.POST)
    ResponseEntity<RestResponse> financeReceipt(@RequestBody EquMorChargeFinReceiptVo equMorChargeFinReceiptVo);

    /**
     * @Title:
     * @Description:   费用导入review
     * @param equMorApplyApproveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 10:58:40
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorChargeImportReview", method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorChargeImportReview(@RequestBody EquMorApplyApproveVo equMorApplyApproveVo);

    /**
     * @Title:
     * @Description:   解析还款计划excel中的数据
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 02:46:55
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/parseEquMorRepayVoExcel", method = RequestMethod.GET)
    ResponseEntity<RestResponse> parseEquMorRepayVoExcel(@RequestParam("filePath") String filePath);

    /**
     * @Title:
     * @Description: 资方抵押资料归档
     * @param equMorArchiveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 05:45:39
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorArchive" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorArchive(@RequestBody EquMorArchiveVo equMorArchiveVo);

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorDetailVosByEquMorTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorDetailVosByEquMorTaskNo(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description:   根据抵押任务编号 查询抵押明细列表 并且带出文件详情
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:13:30
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/findEquMorDetailVosAndFileByEquMorTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorDetailVosAndFileByEquMorTaskNo(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description:   资方抵押资料复核
     * @param equMorDetailsInfoReviewVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:19:09
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/equMorArchiveReview" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> equMorArchiveReview(@RequestBody EquMorDetailsInfoReviewVo equMorDetailsInfoReviewVo);

    /**
     * @Title:
     * @Description:   打印海翼申请合同
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 01:48:00
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/printEquMorChargeSeaWingApply" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> printEquMorChargeSeaWingApply(@RequestParam("equMorTaskNo") String equMorTaskNo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/asset/equ_mor_apply/printEquMor",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printEquMor(EquMorChargeFinTouchingPrintVo equMorChargeFinTouchingPrintVo);

}
