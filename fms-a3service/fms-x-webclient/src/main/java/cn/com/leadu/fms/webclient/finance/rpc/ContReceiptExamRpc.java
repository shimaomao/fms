package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contreceiptexam.ContReceiptExamVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamController
 * @Description: 财务勾稽rpc
 * @date 2018-05-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContReceiptExamRpc {

    /**
     * @Title:
     * @Description: 分页查询财务勾稽信息
     * @param contReceiptExamVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "api/finance/cont_receipt_exam/findContReceiptExamsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptExamsByPage(@RequestParam Map<String, Object> contReceiptExamVoMap);

    /**
     * @Title:
     * @Description: 保存财务勾稽
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "api/finance/cont_receipt_exam/saveContReceiptExam",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContReceiptExam(@RequestBody ContReceiptExamVo contReceiptExamVo);

    /**
     * @Title:
     * @Description:  修改财务勾稽
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "api/finance/cont_receipt_exam/modifyContReceiptExam",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContReceiptExam(@RequestBody ContReceiptExamVo contReceiptExamVo);

    /**
     * @Title:
     * @Description:   根据contReceiptExamId集合删除财务勾稽
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "api/system/cont_receipt_exam/deleteContReceiptExamsByContReceiptExamIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContReceiptExamsByContReceiptExamIds(@RequestBody ContReceiptExamVo contReceiptExamVo);

    /**
     * @Title:
     * @Description:  根据contReceiptExamId获取财务勾稽
     * @param contReceiptExamId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "api/finance/cont_receipt_exam/findContReceiptExamByContReceiptExamId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptExamByContReceiptExamId(@RequestParam("contReceiptExamId") String contReceiptExamId);

}
