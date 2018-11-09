package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.finance.service.ContRepaySkedService;
import cn.com.leadu.fms.finance.validator.contrepaysked.vo.*;
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
 * @ClassName: ContRepaySkedController
 * @Description: 黑名单相关接口
 * @date 2018-05-08
 */
@RestController
@RequestMapping("cont_repay_sked")
public class ContRepaySkedController {

    /**
     * @Fields  : 黑名单service
     */
    @Autowired
    private ContRepaySkedService contRepaySkedService;

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedsByPage(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedsByPage(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContReceiptDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptDetailsByPage(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContReceiptDetailsByPage(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedClaimeByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedClaimeByPage(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedClaimeByPage(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param contRepaySkedSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "saveContRepaySked",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContRepaySked(@Valid @RequestBody ContRepaySkedSaveVo contRepaySkedSaveVo){
        contRepaySkedService.saveContRepaySked(contRepaySkedSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 取消认领
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "cancelClaime",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelClaime(@Valid @RequestBody ContRepaySkedVo contRepaySkedVo){
        contRepaySkedService.cancelClaime(contRepaySkedVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param contRepaySkedModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "modifyContRepaySked",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContRepaySked(@Valid @RequestBody ContRepaySkedModifyVo contRepaySkedModifyVo){
        contRepaySkedService.modifyContRepaySked(contRepaySkedModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除黑名单
     * @param contRepaySkedDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "deleteContRepaySked",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContRepaySked(@Valid @RequestBody ContRepaySkedDeleteVo contRepaySkedDeleteVo){
        contRepaySkedService.deleteContRepaySked(contRepaySkedDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据repaySkedId集合删除黑名单
     * @param contRepaySkedDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "deleteContRepaySkedsByRepaySkedIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContRepaySkedsByRepaySkedIds(@Valid @RequestBody ContRepaySkedDeleteListVo contRepaySkedDeleteListVo){
        contRepaySkedService.deleteContRepaySkedsByRepaySkedIds(contRepaySkedDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据repaySkedId获取黑名单
     * @param repaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedByRepaySkedId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedByRepaySkedId(String repaySkedId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedByRepaySkedId(repaySkedId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  检查是否有合同还款逾期
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 15:46:43
     */
    @RequestMapping(value = "checkContRepaySked",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> checkContRepaySked(){
        contRepaySkedService.checkContRepaySked();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);

    }

    /** 
    * @Description: 根据合同编号查询融资合同还款信息 ，还款时间小于当前时间且倒序排序的第一个
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 17:16
    */ 
    @RequestMapping(value = "findContRepaySkedByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedByContNo(contNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 根据合同号查询所有还款计划表，按期数由小到大排序
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/28 20:42
    */ 
    @RequestMapping(value = "findAllContRepaySkedByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAllContRepaySkedByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findAllContRepaySkedByContNo(contNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 查询逾期租金合计
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 10:45
    */ 
    @RequestMapping(value = "findContRepaySkedOverdueRentSum", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedOverdueRentSum(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedOverdueRentSum(contNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 计算剩余租金，如果未生成还款计划表，返回-1
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 14:46
    */ 
    @RequestMapping(value = "findContRepaySkedRentSum", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedRentSum(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedRentSum(contNo)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 查找即将到期的数据
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findOnceOverdueSked" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOnceOverdueSked(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findOnceOverdueSked(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询合同还款日信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedDetailByPage(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedDetailByPage(contRepaySkedVo)),
                HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 分页查询合同还款日信息(导出专用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-16 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedDetailExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedDetailExport(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedDetailExport(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 未结清车辆租金明细表(导出专用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-16 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedSettleExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedSettleExport(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedSettleExport(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 结清车辆租金明细表(导出专用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-16 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedSettleEndExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedSettleEndExport(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedSettleEndExport(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 未收租金明细表(导出专用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-16 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedUnpaidRentExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedUnpaidRentExport(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedUnpaidRentExport(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 实收租金明细表(导出专用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-16 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedPaidRentExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedPaidRentExport(ContRepaySkedVo contRepaySkedVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContRepaySkedPaidRentExport(contRepaySkedVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContReceiptDetailByContReceiptExamId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptDetailByContReceiptExamId(String contReceiptExamId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRepaySkedService.findContReceiptDetailByContReceiptExamId(contReceiptExamId)), HttpStatus.OK);
    }

    /**
     * @Description: 勾稽页面手动生成凭证
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/11/2 15:39
     */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> makeVoucher(@Valid @RequestBody List<String> contReceiptExamIdList) {
        contRepaySkedService.makeVoucher(contReceiptExamIdList);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 开具发票
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "contReceiptDetailInvoice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> contReceiptDetailInvoice(@Valid @RequestBody ContRepaySkedVo contRepaySkedVo){
        contRepaySkedService.contReceiptDetailInvoice(contRepaySkedVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
