package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceController
 * @Description: 盗抢险信息rpc
 * @date 2018-05-31
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface PilferInsuranceRpc {

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息信息
     * @param pilferInsuranceVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/findPilferInsurancesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findPilferInsurancesByPage(@RequestParam Map<String,Object> pilferInsuranceVoMap);

    /**
     * @Title:
     * @Description: 保存盗抢险信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/savePilferInsurance",method = RequestMethod.POST)
    ResponseEntity<RestResponse> savePilferInsurance(@RequestBody PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description:  修改盗抢险信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/modifyPilferInsurance",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyPilferInsurance(@RequestBody PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description:   根据pilferInsuranceId集合删除盗抢险信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/deletePilferInsurancesByPilferInsuranceIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deletePilferInsurancesByPilferInsuranceIds(@RequestBody PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description:  根据pilferInsuranceId获取盗抢险信息
     * @param pilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/findPilferInsuranceByPilferInsuranceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findPilferInsuranceByPilferInsuranceId(@RequestParam("pilferInsuranceId") String pilferInsuranceId);

    /** 
    * @Description: 查询盗抢险月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 18:35
    */ 
    @RequestMapping(value = "api/cost/pilfer_insurance/findPilferInsuranceMonthlysVosListByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findPilferInsuranceMonthlysVosListByPage(@RequestParam Map<String, Object> pilferInsuranceVoMap);

   /** 
   * @Description: 查询盗抢险月结信息 ,不分页 ,POST请求
   * @param:  
   * @return:  
   * @Author: yangyiquan
   * @Date: 2018/5/31 18:35
   */ 
    @RequestMapping(value = "api/cost/pilfer_insurance/findPilferInsuranceMonthlysVos" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> findPilferInsuranceMonthlysVos(@RequestBody PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description: 根据合同号获取盗抢险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/pilfer_insurance/findPilferInsuranceVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findPilferInsuranceVoByContNo(@RequestParam("contNo") String contNo);
}
