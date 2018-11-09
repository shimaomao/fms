package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: FinBackfillController
 * @Description: 融资回填rpc
 * @date 2018-05-11
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinBackfillRpc {

    /**
     * @Title:
     * @Description: 分页查询融资回填信息
     * @param finBackfillVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/finance/fin_backfill/findFinBackfillsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinBackfillsByPage(@RequestParam Map<String, Object> finBackfillVoMap);

    /**
     * @Title:
     * @Description: 保存融资回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/finance/fin_backfill/saveFinBackfill",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinBackfill(@RequestBody FinBackfillVo finBackfillVo);

    /**
     * @Title:
     * @Description: 财务回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/finance/fin_backfill/finBackfill",method = RequestMethod.POST)
    ResponseEntity<RestResponse> finBackfill(@RequestBody FinBackfillVo finBackfillVo);

    /**
     * @Title:
     * @Description:  修改融资回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/finance/fin_backfill/modifyFinBackfill",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinBackfill(@RequestBody FinBackfillVo finBackfillVo);

    /**
     * @Title:
     * @Description:   根据filBackfillId集合删除融资回填
     * @param finBackfillVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/system/fin_backfill/deleteFinBackfillsByFilBackfillIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinBackfillsByFilBackfillIds(@RequestBody FinBackfillVo finBackfillVo);

    /**
     * @Title:
     * @Description:  根据filBackfillId获取融资回填
     * @param filBackfillId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @RequestMapping(value = "api/finance/fin_backfill/findFinBackfillByFilBackfillId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinBackfillByFilBackfillId(@RequestParam("filBackfillId") String filBackfillId);

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVoMap
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "api/finance/fin_backfill/findFinBackfillsForExportExcel" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinBackfillsForExportExcel(@RequestParam Map<String, Object> finBackfillVoMap);

}
