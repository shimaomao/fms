package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contreceiptexam.ContReceiptExamVo;
import cn.com.leadu.fms.webclient.finance.rpc.ContReceiptExamRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamController
 * @Description: 财务勾稽controller
 * @date 2018-05-09
 */
@RestController
@RequestMapping("cont_receipt_exam")
public class ContReceiptExamController {

    /**
     * @Fields  : 财务勾稽rpc
     */
    @Autowired
    private ContReceiptExamRpc contReceiptExamRpc;

    /**
     * @Title:
     * @Description: 分页查询财务勾稽信息
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "findContReceiptExamsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptExamsByPage(ContReceiptExamVo contReceiptExamVo){
        Map contReceiptExamVoMap = contReceiptExamVo == null?null:(Map) JSON.toJSON(contReceiptExamVo);
        return contReceiptExamRpc.findContReceiptExamsByPage(contReceiptExamVoMap);
    }

    /**
     * @Title:
     * @Description: 保存财务勾稽
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "saveContReceiptExam",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContReceiptExam(@RequestBody ContReceiptExamVo contReceiptExamVo){
        return contReceiptExamRpc.saveContReceiptExam(contReceiptExamVo);
    }

    /**
     * @Title:
     * @Description:  修改财务勾稽
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "modifyContReceiptExam",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContReceiptExam(@RequestBody ContReceiptExamVo contReceiptExamVo){
        return contReceiptExamRpc.modifyContReceiptExam(contReceiptExamVo);
    }

    /**
     * @Title:
     * @Description:   根据contReceiptExamId集合删除财务勾稽
     * @param contReceiptExamIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "deleteContReceiptExamsByContReceiptExamIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceiptExamsByContReceiptExamIds(@RequestBody List<String> contReceiptExamIds){
        ContReceiptExamVo contReceiptExamVo = new ContReceiptExamVo();
        contReceiptExamVo.setContReceiptExamIds(contReceiptExamIds);
        return contReceiptExamRpc.deleteContReceiptExamsByContReceiptExamIds(contReceiptExamVo);
    }

    /**
     * @Title:
     * @Description:  根据contReceiptExamId获取财务勾稽
     * @param contReceiptExamId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "findContReceiptExamByContReceiptExamId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptExamByContReceiptExamId(String contReceiptExamId){
        return contReceiptExamRpc.findContReceiptExamByContReceiptExamId(contReceiptExamId);
    }

}
