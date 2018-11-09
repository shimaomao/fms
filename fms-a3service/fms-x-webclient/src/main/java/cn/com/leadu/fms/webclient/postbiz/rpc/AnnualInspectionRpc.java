package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 年检提醒rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface AnnualInspectionRpc {

    /**
     * @Title:
     * @Description: 分页查询年检提醒信息
     * @param annualInspectionVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "api/postbiz/annual_inspection/findAnnualInspectionVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAnnualInspectionVosByPage(@RequestParam Map<String,Object> annualInspectionVoMap);


    /**
     * @Title:
     * @Description:  修改年检提醒
     * @param annualInspectionVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "api/postbiz/annual_inspection/modifyAnnualInspection",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyAnnualInspection(@RequestBody AnnualInspectionVo annualInspectionVo);


    /**
     * @Title:
     * @Description:  根据annualInspectionId获取年检提醒
     * @param annualInspectionId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "api/postbiz/annual_inspection/findAnnualInspectionVoByAnnualInspectionId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAnnualInspectionVoByAnnualInspectionId(@RequestParam("annualInspectionId") String annualInspectionId);



}
