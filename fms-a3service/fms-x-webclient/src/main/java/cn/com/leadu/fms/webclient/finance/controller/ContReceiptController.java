package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptPostVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.webclient.finance.rpc.ContReceiptRpc;
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
 * @ClassName: ContReceiptController
 * @Description: 财务收款信息controller
 * @date 2018-05-07
 */
@RestController
@RequestMapping("cont_receipt")
public class ContReceiptController {

    /**
     * @Fields  : 财务收款信息rpc
     */
    @Autowired
    private ContReceiptRpc contReceiptRpc;

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
        Map contReceiptVoMap = contReceiptVo == null?null:(Map) JSON.toJSON(contReceiptVo);
        return contReceiptRpc.findContReceiptsByPage(contReceiptVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询收款导入明细
     * @param contReceiptVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "findContReceiptsImport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptsImport(ContReceiptVo contReceiptVo){
        Map contReceiptVoMap = contReceiptVo == null?null:(Map) JSON.toJSON(contReceiptVo);
        return contReceiptRpc.findContReceiptsImport(contReceiptVoMap);
    }

    /**
     * @Title:
     * @Description: 保存财务收款信息
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "saveContReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContReceipt(@RequestBody ContReceiptVo contReceiptVo){
        return contReceiptRpc.saveContReceipt(contReceiptVo);
    }

    /**
    * @Description: 手动勾稽
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/6 21:40
    */
    @RequestMapping(value = "manualReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> manualReceipt(@RequestBody ContReceiptPostVo contReceiptPostVo){
        return contReceiptRpc.manualReceipt(contReceiptPostVo);
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
    public ResponseEntity<RestResponse> receipt(@RequestBody ContReceiptPostVo contReceiptPostVo){
        return contReceiptRpc.receipt(contReceiptPostVo);
    }

    /**
     * @Title:
     * @Description:  修改财务收款信息
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "modifyContReceipt",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContReceipt(@RequestBody ContReceiptVo contReceiptVo){
        return contReceiptRpc.modifyContReceipt(contReceiptVo);
    }

    /**
     * @Title:
     * @Description:   根据contReceiptId集合删除财务收款信息
     * @param contReceiptIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "deleteContReceiptsByContReceiptIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceiptsByContReceiptIds(@RequestBody List<String> contReceiptIds){
        ContReceiptVo contReceiptVo = new ContReceiptVo();
        contReceiptVo.setContReceiptIds(contReceiptIds);
        return contReceiptRpc.deleteContReceiptsByContReceiptIds(contReceiptVo);
    }

    /**
     * @Title:
     * @Description:  根据contReceiptId获取财务收款信息
     * @param contReceiptId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "findContReceiptByContReceiptId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptByContReceiptId(String contReceiptId){
        return contReceiptRpc.findContReceiptByContReceiptId(contReceiptId);
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
        return contReceiptRpc.importContReceipts(filePath);
    }

    /**
     * @Title:
     * @Description:   收款明细导入模板下载
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/27 11:12:06
     */
    @RequestMapping(value = "exportContReceiptModalExcel", method = RequestMethod.GET)
    public ResponseEntity exportContReceiptModalExcel(){
        return CommonFeignUtils.getResponseEntity(contReceiptRpc.exportContReceiptModalExcel());
    }

}
