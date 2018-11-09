package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinBackfillDetailRpc;
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
 * @ClassName: FinBackfillDetailController
 * @Description: 融资回填明细controller
 * @date 2018-05-12
 */
@RestController
@RequestMapping("fin_backfill_detail")
public class FinBackfillDetailController {

    /**
     * @Fields  : 融资回填明细rpc
     */
    @Autowired
    private FinBackfillDetailRpc finBackfillDetailRpc;

    /**
     * @Title:
     * @Description: 分页查询融资回填明细信息
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "findFinBackfillDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillDetailsByPage(FinBackfillDetailVo finBackfillDetailVo){
        Map finBackfillDetailVoMap = finBackfillDetailVo == null?null:(Map) JSON.toJSON(finBackfillDetailVo);
        return finBackfillDetailRpc.findFinBackfillDetailsByPage(finBackfillDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存融资回填明细
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "saveFinBackfillDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinBackfillDetail(@RequestBody FinBackfillDetailVo finBackfillDetailVo){
        return finBackfillDetailRpc.saveFinBackfillDetail(finBackfillDetailVo);
    }

    /**
     * @Title:
     * @Description:  修改融资回填明细
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "modifyFinBackfillDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinBackfillDetail(@RequestBody FinBackfillDetailVo finBackfillDetailVo){
        return finBackfillDetailRpc.modifyFinBackfillDetail(finBackfillDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据finBackfillDetailId集合删除融资回填明细
     * @param finBackfillDetailIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "deleteFinBackfillDetailsByFinBackfillDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinBackfillDetailsByFinBackfillDetailIds(@RequestBody List<String> finBackfillDetailIds){
        FinBackfillDetailVo finBackfillDetailVo = new FinBackfillDetailVo();
        finBackfillDetailVo.setFinBackfillDetailIds(finBackfillDetailIds);
        return finBackfillDetailRpc.deleteFinBackfillDetailsByFinBackfillDetailIds(finBackfillDetailVo);
    }

    /**
     * @Title:
     * @Description:  根据finBackfillDetailId获取融资回填明细
     * @param finBackfillDetailId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "findFinBackfillDetailByFinBackfillDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinBackfillDetailByFinBackfillDetailId(String finBackfillDetailId){
        return finBackfillDetailRpc.findFinBackfillDetailByFinBackfillDetailId(finBackfillDetailId);
    }

}
