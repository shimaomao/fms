package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgagePostVo;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterController
 * @Description: 解抵押过户信息rpc
 * @date 2018-05-18
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MortgageRegisterRpc {

    /**
     * @Title:
     * @Description: 分页查询解抵押过户信息信息
     * @param mortgageRegisterVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "api/asset/mortgage_register/findMortgageRegistersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMortgageRegistersByPage(@RequestParam Map<String,Object> mortgageRegisterVoMap);

    /**
     * @Title:
     * @Description: 保存解抵押过户信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "api/asset/mortgage_register/saveMortgageRegister",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMortgageRegister(@RequestBody MortgageRegisterVo mortgageRegisterVo);

    /** 
    * @Description: 保存解抵押资料邮寄信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/22 16:53
    */ 
    @RequestMapping(value = "api/asset/mortgage_register/saveMortgagePost",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMortgagePost(@RequestBody MortgagePostVo mortgagePostVo);

    /**
     * @Title:
     * @Description:  修改解抵押过户信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "api/asset/mortgage_register/modifyMortgageRegister",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyMortgageRegister(@RequestBody MortgageRegisterVo mortgageRegisterVo);

    /**
     * @Title:
     * @Description:   根据mortgageRegisterId集合删除解抵押过户信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "api/system/mortgage_register/deleteMortgageRegistersByMortgageRegisterIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteMortgageRegistersByMortgageRegisterIds(@RequestBody MortgageRegisterVo mortgageRegisterVo);

    /**
     * @Title:
     * @Description:  根据mortgageRegisterId获取解抵押过户信息
     * @param mortgageRegisterId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "api/asset/mortgage_register/findMortgageRegisterByMortgageRegisterId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMortgageRegisterByMortgageRegisterId(@RequestParam("mortgageRegisterId") String mortgageRegisterId);

    /** 
    * @Description: 获取解抵押附件
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/23 11:41
    */ 
    @RequestMapping(value = "api/asset/mortgage_register/findBizFilesMortgageRegister", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFilesMortgageRegister(@RequestParam("bizCode") String bizCode);
}
