package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailController
 * @Description: 融资回填明细rpc
 * @date 2018-05-12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinBackfillDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询融资回填明细信息
     * @param finBackfillDetailVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "api/finance/fin_backfill_detail/findFinBackfillDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinBackfillDetailsByPage(@RequestParam Map<String, Object> finBackfillDetailVoMap);

    /**
     * @Title:
     * @Description: 保存融资回填明细
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "api/finance/fin_backfill_detail/saveFinBackfillDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinBackfillDetail(@RequestBody FinBackfillDetailVo finBackfillDetailVo);

    /**
     * @Title:
     * @Description:  修改融资回填明细
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "api/finance/fin_backfill_detail/modifyFinBackfillDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinBackfillDetail(@RequestBody FinBackfillDetailVo finBackfillDetailVo);

    /**
     * @Title:
     * @Description:   根据finBackfillDetailId集合删除融资回填明细
     * @param finBackfillDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "api/system/fin_backfill_detail/deleteFinBackfillDetailsByFinBackfillDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinBackfillDetailsByFinBackfillDetailIds(@RequestBody FinBackfillDetailVo finBackfillDetailVo);

    /**
     * @Title:
     * @Description:  根据finBackfillDetailId获取融资回填明细
     * @param finBackfillDetailId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @RequestMapping(value = "api/finance/fin_backfill_detail/findFinBackfillDetailByFinBackfillDetailId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinBackfillDetailByFinBackfillDetailId(@RequestParam("finBackfillDetailId") String finBackfillDetailId);

}
