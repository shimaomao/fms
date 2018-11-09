package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.QuotationDeviceRpc;
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
 * @ClassName: QuotationDeviceController
 * @Description: 报价器信息controller
 * @date 2018-05-23
 */
@RestController
@RequestMapping("quotation_device")
public class QuotationDeviceController {

    /**
     * @Fields  : 报价器信息rpc
     */
    @Autowired
    private QuotationDeviceRpc quotationDeviceRpc;

    /**
     * @Title:
     * @Description: 分页查询报价器信息信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findQuotationDevicesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findQuotationDevicesByPage(QuotationDeviceVo quotationDeviceVo){
        Map quotationDeviceVoMap = quotationDeviceVo == null?null:(Map) JSON.toJSON(quotationDeviceVo);
        return quotationDeviceRpc.findQuotationDevicesByPage(quotationDeviceVoMap);
    }

    /**
     * @Title:
     * @Description: 打印报价器单信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "printQuotationDevice" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo){
        return quotationDeviceRpc.printQuotationDevice(quotationDeviceVo);
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "saveQuotationDevice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo){
        return quotationDeviceRpc.saveQuotationDevice(quotationDeviceVo);
    }

    /**
     * @Title:
     * @Description:  修改报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "modifyQuotationDevice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyQuotationDevice(@RequestBody QuotationDeviceVo quotationDeviceVo){
        return quotationDeviceRpc.modifyQuotationDevice(quotationDeviceVo);
    }

    /**
     * @Title:
     * @Description:   根据quotationDeviceId集合删除报价器信息
     * @param quotationDeviceIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "deleteQuotationDevicesByQuotationDeviceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteQuotationDevicesByQuotationDeviceIds(@RequestBody List<String> quotationDeviceIds){
        QuotationDeviceVo quotationDeviceVo = new QuotationDeviceVo();
        quotationDeviceVo.setQuotationDeviceIds(quotationDeviceIds);
        return quotationDeviceRpc.deleteQuotationDevicesByQuotationDeviceIds(quotationDeviceVo);
    }

    /**
     * @Title:
     * @Description:  根据quotationDeviceId获取报价器信息
     * @param quotationDeviceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findQuotationDeviceByQuotationDeviceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findQuotationDeviceByQuotationDeviceId(String quotationDeviceId){
        return quotationDeviceRpc.findQuotationDeviceByQuotationDeviceId(quotationDeviceId);
    }

    /**
     * @Title:
     * @Description:  获取计算所需参数
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findSysParam", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParam(){
        return quotationDeviceRpc.findSysParam();
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "saveQuotationDeviceInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDeviceInfo(@RequestBody QuotationDeviceVo quotationDeviceVo){
        return quotationDeviceRpc.saveQuotationDeviceInfo(quotationDeviceVo);
    }

    /**
     * @Title:
     * @Description: 计算报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-7 17:02:03
     */
    @RequestMapping(value = "calculateQuotationDeviceInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> calculateQuotationDeviceInfo(@RequestBody QuotationDeviceVo quotationDeviceVo){
        return quotationDeviceRpc.calculateQuotationDeviceInfo(quotationDeviceVo);
    }

}
