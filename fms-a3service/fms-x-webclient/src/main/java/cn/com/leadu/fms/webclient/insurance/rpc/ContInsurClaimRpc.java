package cn.com.leadu.fms.webclient.insurance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimController
 * @Description: 保险理赔rpc
 * @date 2018-05-14
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContInsurClaimRpc {

    /**
     * @Title:
     * @Description: 分页查询保险理赔信息一览
     * @param contInsurClaimVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findContInsurClaimsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContInsurClaimsByPage(@RequestParam Map<String,Object> contInsurClaimVoMap);

    /**
     * @Title:
     * @Description: 分页查询保险理赔查询页面
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findContInsurClaimsByPageSelect" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContInsurClaimsByPageSelect(@RequestParam Map<String,Object> contInsurClaimVoMap);

    /**
     * @Title:
     * @Description: 保存保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/saveContInsurClaim",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description:  修改保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/modifyContInsurClaim",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description:   根据contInsurClaimId集合删除保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/deleteContInsurClaimsByContInsurClaimIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContInsurClaimsByContInsurClaimIds(@RequestBody ContInsurClaimVo contInsurClaimVo);

    /**
     * @Title:
     * @Description:  根据contInsurClaimId获取保险理赔
     * @param contInsurClaimId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findContInsurClaimByContInsurClaimId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContInsurClaimByContInsurClaimId(@RequestParam("contInsurClaimId") String contInsurClaimId);

    /**
     * @Title:
     * @Description: 根据合同编号查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findDetailedByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDetailedByContNo(@RequestParam("contVehinsId")String contVehinsId,@RequestParam("contInsurClaimId")String contInsurClaimId,@RequestParam("serviceId")String serviceId);

    /**
     * @Title:
     * @Description: 取保险理赔详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findDetailContInsurClaim", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDetailContInsurClaim(@RequestParam("serviceId")String serviceId);

    /**
     * @Title:
     * @Description: 保险理赔excel导出
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/insurance/cont_insur_claim/findContInsurClaimsByPageSelect2" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContInsurClaimsByPageSelect2(@RequestParam Map<String,Object> contInsurClaimVoMap);
}
