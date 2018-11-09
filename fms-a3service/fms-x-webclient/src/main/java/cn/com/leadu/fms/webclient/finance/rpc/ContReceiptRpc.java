package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptPostVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContReceiptController
 * @Description: 黑名单rpc
 * @date 2018-05-07
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContReceiptRpc {

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contReceiptVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/findContReceiptsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptsByPage(@RequestParam Map<String, Object> contReceiptVoMap);

    /**
     * @Title:
     * @Description: 分页查询收款导入明细信息
     * @param contReceiptVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/findContReceiptsImport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptsImport(@RequestParam Map<String, Object> contReceiptVoMap);

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/saveContReceipt",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContReceipt(@RequestBody ContReceiptVo contReceiptVo);

    /**
    * @Description: 手动勾稽
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/6 21:42
    */
    @RequestMapping(value = "api/finance/cont_receipt/manualReceipt",method = RequestMethod.POST)
    ResponseEntity<RestResponse> manualReceipt(@RequestBody ContReceiptPostVo contReceiptPostVo);

    /**
     * @Title:
     * @Description: 勾稽
     * @param contReceiptPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/receipt",method = RequestMethod.POST)
    ResponseEntity<RestResponse> receipt(@RequestBody ContReceiptPostVo contReceiptPostVo);

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/modifyContReceipt",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContReceipt(@RequestBody ContReceiptVo contReceiptVo);

    /**
     * @Title:
     * @Description:   根据contReceiptId集合删除黑名单
     * @param contReceiptVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/system/cont_receipt/deleteContReceiptsByContReceiptIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContReceiptsByContReceiptIds(@RequestBody ContReceiptVo contReceiptVo);

    /**
     * @Title:
     * @Description:  根据contReceiptId获取黑名单
     * @param contReceiptId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @RequestMapping(value = "api/finance/cont_receipt/findContReceiptByContReceiptId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptByContReceiptId(@RequestParam("contReceiptId") String contReceiptId);

    /**
     * @Title:
     * @Description:   导入收款明细
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "api/finance/cont_receipt/importContReceipts", method = RequestMethod.POST)
    ResponseEntity<RestResponse> importContReceipts(@RequestParam("filePath") String filePath);

    /**
     * @Title:
     * @Description:   收款明细导入模板下载
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/27 11:12:06
     */
    @RequestMapping(value = "api/finance/cont_receipt/exportContReceiptModalExcel", method = RequestMethod.GET)
    Response exportContReceiptModalExcel();


}
