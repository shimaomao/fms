package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinRepaySkedRpc;
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
 * @ClassName: FinRepaySkedController
 * @Description: 财务还款计划controller
 * @date 2018-05-12
 */
@RestController
@RequestMapping("fin_repay_sked")
public class FinRepaySkedController {

    /**
     * @Fields  : 财务还款计划rpc
     */
    @Autowired
    private FinRepaySkedRpc finRepaySkedRpc;

    /**
     * @Title:
     * @Description: 分页查询财务还款计划信息
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "findFinRepaySkedsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinRepaySkedsByPage(FinRepaySkedVo finRepaySkedVo){
        Map finRepaySkedVoMap = finRepaySkedVo == null?null:(Map) JSON.toJSON(finRepaySkedVo);
        return finRepaySkedRpc.findFinRepaySkedsByPage(finRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 保存财务还款计划
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "saveFinRepaySked",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinRepaySked(@RequestBody FinRepaySkedVo finRepaySkedVo){
        return finRepaySkedRpc.saveFinRepaySked(finRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:  修改财务还款计划
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "modifyFinRepaySked",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinRepaySked(@RequestBody FinRepaySkedVo finRepaySkedVo){
        return finRepaySkedRpc.modifyFinRepaySked(finRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:   根据finRepaySkedId集合删除财务还款计划
     * @param finRepaySkedIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "deleteFinRepaySkedsByFinRepaySkedIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinRepaySkedsByFinRepaySkedIds(@RequestBody List<String> finRepaySkedIds){
        FinRepaySkedVo finRepaySkedVo = new FinRepaySkedVo();
        finRepaySkedVo.setFinRepaySkedIds(finRepaySkedIds);
        return finRepaySkedRpc.deleteFinRepaySkedsByFinRepaySkedIds(finRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:  根据finRepaySkedId获取财务还款计划
     * @param finRepaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "findFinRepaySkedByFinRepaySkedId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinRepaySkedByFinRepaySkedId(String finRepaySkedId){
        return finRepaySkedRpc.findFinRepaySkedByFinRepaySkedId(finRepaySkedId);
    }


    /**
     * @Title:
     * @Description: 开具发票
     * @param contRepaySkedVos
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-21 16:40:57
     */
    @RequestMapping(value = "finRepaySkedInvoice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> finRepaySkedInvoice(@RequestBody List<ContRepaySkedVo> contRepaySkedVos){
        return finRepaySkedRpc.finRepaySkedInvoice(contRepaySkedVos);
    }

    /**
    * @Description: 批量修改开票属性
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/25 11:46
    */
    @RequestMapping(value = "editInvoiceProp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> editInvoiceProp(@RequestBody FinRepaySkedVo finRepaySkedVo){
        return finRepaySkedRpc.editInvoiceProp(finRepaySkedVo);
    }

}
