package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueContController
 * @Description: 逾期合同信息rpc
 * @date 2018-05-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueContRpc {

    /**
     * @Title:
     * @Description: 分页查询逾期合同信息信息
     * @param overdueContVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/findOverdueContsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueContsByPage(@RequestParam Map<String, Object> overdueContVoMap);

    /**
     * @Title:
     * @Description: 保存逾期合同信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/saveOverdueCont",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueCont(@RequestBody OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description:  修改逾期合同信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/modifyOverdueCont",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueCont(@RequestBody OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description:   根据overdueContId集合删除逾期合同信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/deleteOverdueContsByOverdueContIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueContsByOverdueContIds(@RequestBody OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description: 分页查询逾期合同vo数据
     * @param overdueContVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/findOverdueContVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueContVosByPage(@RequestParam Map<String, Object> overdueContVoMap);

    /**
     * @Title:
     * @Description:
     * @param contNo 根据合同号获取逾期合同号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    @RequestMapping(value = "api/postbiz/overdue_cont/findOverdueContVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueContVoByContNo(@RequestParam("contNo") String contNo);


}
