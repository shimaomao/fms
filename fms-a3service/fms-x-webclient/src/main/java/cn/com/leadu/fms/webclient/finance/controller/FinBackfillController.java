package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinBackfillRpc;
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
 * @ClassName: FinBackfillController
 * @Description: 融资回填controller
 * @date 2018-05-11
 */
@RestController
@RequestMapping("fin_backfill")
public class FinBackfillController {

    /**
     * @Fields  : 融资回填rpc
     */
    @Autowired
    private FinBackfillRpc finBackfillRpc;

    /**
     * @Title:
     * @Description: 分页查询融资回填信息
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "findFinBackfillsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillsByPage(FinBackfillVo finBackfillVo){
        Map finBackfillVoMap = finBackfillVo == null?null:(Map) JSON.toJSON(finBackfillVo);
        return finBackfillRpc.findFinBackfillsByPage(finBackfillVoMap);
    }

    /**
     * @Title:
     * @Description: 保存融资回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "saveFinBackfill",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinBackfill(@RequestBody FinBackfillVo finBackfillVo){
        return finBackfillRpc.saveFinBackfill(finBackfillVo);
    }

    /**
     * @Title:
     * @Description: 财务回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "finBackfill",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> finBackfill(@RequestBody FinBackfillVo finBackfillVo){
        return finBackfillRpc.finBackfill(finBackfillVo);
    }

    /**
     * @Title:
     * @Description:  修改融资回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "modifyFinBackfill",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinBackfill(@RequestBody FinBackfillVo finBackfillVo){
        return finBackfillRpc.modifyFinBackfill(finBackfillVo);
    }

    /**
     * @Title:
     * @Description:   根据filBackfillId集合删除融资回填
     * @param filBackfillIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "deleteFinBackfillsByFilBackfillIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfillsByFilBackfillIds(@RequestBody List<String> filBackfillIds){
        FinBackfillVo finBackfillVo = new FinBackfillVo();
        finBackfillVo.setFilBackfillIds(filBackfillIds);
        return finBackfillRpc.deleteFinBackfillsByFilBackfillIds(finBackfillVo);
    }

    /**
     * @Title:
     * @Description:  根据filBackfillId获取融资回填
     * @param filBackfillId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "findFinBackfillByFilBackfillId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillByFilBackfillId(String filBackfillId){
        return finBackfillRpc.findFinBackfillByFilBackfillId(filBackfillId);
    }

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVo
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "findFinBackfillsForExportExcel" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillsForExportExcel(FinBackfillVo finBackfillVo){
        Map finBackfillVoMap = finBackfillVo == null?null:(Map) JSON.toJSON(finBackfillVo);
        return finBackfillRpc.findFinBackfillsForExportExcel(finBackfillVoMap);
    }

}
